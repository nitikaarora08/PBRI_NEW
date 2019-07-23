package com.patanjali.pbri_new.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.SaveMachineData;
import com.patanjali.pbri_new.model1.CropDiseasename;
import com.patanjali.pbri_new.model1.DiseaseRequest;
import com.patanjali.pbri_new.model1.DiseaseResponse;
import com.patanjali.pbri_new.model1.OtherDiseaseRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.CropInfoFragment.diseaseArray;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.diseaseobserverd;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CropDiseasesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CropDiseasesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CropDiseasesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CropDiseasesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CropDiseasesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CropDiseasesFragment newInstance(String param1, String param2) {
        CropDiseasesFragment fragment = new CropDiseasesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
View itemView;

    SharedPrefrenceUtil sharedPrefrenceUtil;
    RecyclerView recycler_view;
    Context context;
    Button btnAddNewCrop;
    public static RelativeLayout frame_layout_others;
    EditText edOthers;
    Button btnSaveOthers;
    ImageView imgClose;
    String id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        itemView=  inflater.inflate(R.layout.fragment_crop_diseases, container, false);
        recycler_view=itemView.findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        recycler_view.setLayoutManager(gridLayoutManager);
        context=getActivity();
        sharedPrefrenceUtil=new SharedPrefrenceUtil(context);
         id= sharedPrefrenceUtil.getResponseId();

        btnAddNewCrop=itemView.findViewById(R.id.btnAddNewCrop);
        btnSaveOthers=itemView.findViewById(R.id.btnSaveOthers);
        edOthers=itemView.findViewById(R.id.edOthers);
        frame_layout_others=itemView.findViewById(R.id.frame_layout_others);

        imgClose=itemView.findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame_layout_others.setVisibility(View.GONE);
            }
        });

        btnAddNewCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame_layout_others.setVisibility(View.VISIBLE);
            }
        });


        postFarmLabDataServer();

        ImageView  imgBack  =itemView.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
                if (diseaseArray.size() > 0) {
                    diseaseobserverd.setChecked(true);
                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(diseaseArray);
                    sharedPrefrenceUtil.setCheckMachineItem(dataModel);
                }
            }
        });

        btnSaveOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crop=edOthers.getText().toString();
                crop.replace(" ","");
                if (crop.equals(""))
                    Config.toast(getActivity(),"please enter disease name");
                else
                    SaveOtherMainCrop();
            }
        });
        return itemView;
        
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        private Context context;
        private java.util.List<CropDiseasename> getVoucher;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // CheckBox c1;
            public TextView txtCropName,txtQuantity, txtNumber,txtCount,id,txtExpire,txtProduct;
            public ImageView Image;
            CheckBox checkBox;
            Button btnMinus,btnPlus;
            int amount=0;
            //public Button buttonInc,buttonDec,orderNow;
            public MyViewHolder(View view) {
                super(view);
                checkBox = view.findViewById(R.id.checkbox);
                txtCropName = view.findViewById(R.id.txtCropName);
                Image = view.findViewById(R.id.imgCrop);

            }
        }

        public StoreAdapter(Context context, java.util.List<CropDiseasename> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.disease_layout, parent, false);



            return new StoreAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StoreAdapter.MyViewHolder holder, final int position) {
            final CropDiseasename movie = getVoucher.get(position);
            holder.txtCropName.setText(movie.getDiseasesName());
            try{
                Picasso.with(getActivity())
                        .load(movie.getDiseasesImage())
                        .into(holder.Image);
            }catch (Exception e){}
//            Config.toast(context,movie.getImage());
            if (!movie.getDiseasesImage().contains("jpg")&&!movie.getDiseasesImage().contains("png"))
                holder.Image.setImageResource(R.drawable.agriculture);


            final String diseaseArray1=diseaseArray+"";
            if(diseaseArray1.contains(movie.getCropDeseasesId()+"")){
                holder.checkBox.setChecked(true);

            }

            else {
                holder.checkBox.setChecked(false);

            }

            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                   if (b){

                        if(!(diseaseArray+"").contains(movie.getCropDeseasesId())) {
                            diseaseArray.add(movie.getCropDeseasesId());

//                             Toast.makeText(context,""+movie.getCropDeseasesId() ,Toast.LENGTH_SHORT).show();
                        }
                        //context.spinnerValueMap.put(position,arr.get(position));
                    }
                    else {
//                        Toast.makeText(context,""+movie.getCropDeseasesId() ,Toast.LENGTH_SHORT).show();
                        if((diseaseArray+"").contains(movie.getCropDeseasesId())) {
                            diseaseArray.remove(movie.getCropDeseasesId());
//                            Toast.makeText(context,""+movie.getCropDeseasesId() ,Toast.LENGTH_SHORT).show();

                        }
//                       Toast.makeText(context,""+diseaseArray ,Toast.LENGTH_SHORT).show();
                   }
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.checkBox.performClick();
                }
            });

        }

        @Override
        public int getItemCount() {
            return getVoucher.size();
        }
    }


    public void postFarmLabDataServer() {
        final   RelativeLayout gif1=itemView.findViewById(R.id.imgGif);

        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        DiseaseRequest cropinformation = new DiseaseRequest(sharedPrefrenceUtil.getSubCropID(),id);
        Call<DiseaseResponse> call = mapiClinet.getDiseases(cropinformation);
        call.enqueue(new Callback<DiseaseResponse>() {

            @Override
            public void onResponse(Call<DiseaseResponse> call, Response<DiseaseResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        DiseaseResponse labListResponse = response.body();
                        String s = labListResponse.getMessage();
                        java.util.List<CropDiseasename> labList = new ArrayList<>();
                        labList = labListResponse.getCropDiseasename();
                        StoreAdapter adapter = new StoreAdapter(getActivity(), labList);
                        recycler_view.setAdapter(adapter);

                        if (diseaseArray.size() > 0) {

                            diseaseobserverd.setChecked(true);

                            SaveMachineData dataModel = new SaveMachineData();
                            dataModel.setData(diseaseArray);

                            sharedPrefrenceUtil.setCheckMachineItem(dataModel);

                        } else {

                            diseaseobserverd.setChecked(false);
                            sharedPrefrenceUtil.setCheckMachineItem(null);

                        }
                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<DiseaseResponse> call, Throwable t) {
                gif1.setVisibility(View.GONE);
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void SaveOtherMainCrop() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OtherDiseaseRequest machineryrequest = new OtherDiseaseRequest(sharedPrefrenceUtil.getSubCropID()+"",edOthers.getText().toString(),id);
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherDisease(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Disease");
                        postFarmLabDataServer();
                        frame_layout_others.setVisibility(View.GONE);
                    }
                   }
            }

            @Override
            public void onFailure(Call<OthersFertilizerResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
