package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.patanjali.pbri_new.model1.CropPestname;
import com.patanjali.pbri_new.model1.CropPestname;
import com.patanjali.pbri_new.model1.DiseaseRequest;
import com.patanjali.pbri_new.model1.DiseaseResponse;
import com.patanjali.pbri_new.model1.OtherPestRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.model1.PestNameResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.CropInfoFragment.diseaseArray;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.fertilizerArray;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.pest;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.pest_observed;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.pest_observed;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CropPestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CropPestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CropPestFragment() {
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
    public static CropPestFragment newInstance(String param1, String param2) {
        CropPestFragment fragment = new CropPestFragment();
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
    Button btnAddNewCrop;
    public static RelativeLayout frame_layout_others;
    EditText edOthers;
    Button btnSaveOthers;
    ImageView imgClose;
    Context context;
    String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        itemView=  inflater.inflate(R.layout.fragment_crop_pest, container, false);
        recycler_view=itemView.findViewById(R.id.recycler);
        btnAddNewCrop=itemView.findViewById(R.id.btnAddNewCrop);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        context=getActivity();
        recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        sharedPrefrenceUtil=new SharedPrefrenceUtil(context);
        id= sharedPrefrenceUtil.getResponseId();
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

        recycler_view.setLayoutManager(gridLayoutManager);

        ImageView  imgBack  =itemView.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
                if (pest.size() > 0) {

                    pest_observed.setChecked(true);

                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(pest);

                    SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getActivity());
                    sharedPrefrenceUtil.setCheckMachineItem(dataModel);

                }

            }
        });

        postFarmLabDataServer();

        btnSaveOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crop=edOthers.getText().toString();
                crop.replace(" ","");
                if (crop.equals(""))
                    Config.toast(getActivity(),"please enter pest name");
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
        private java.util.List<CropPestname> getVoucher;

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

        public StoreAdapter(Context context, java.util.List<CropPestname> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.disease_layout, parent, false);



            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final CropPestname movie = getVoucher.get(position);
            holder.txtCropName.setText(movie.getPestName());
            try{
                Picasso.with(getActivity())
                        .load(movie.getPestImage())
                        .into(holder.Image);
            }catch (Exception e){}

            if (!movie.getPestImage().contains("jpg")&&!movie.getPestImage().contains("png"))
                holder.Image.setImageResource(R.drawable.agriculture);



            for (int i=0;i<pest.size(); i++) {
                String s = pest.get(i);
                if (s.equalsIgnoreCase(movie.getCropPestId() + "")) {
                    holder.checkBox.setChecked(true);
                }
            }


            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if(b){


                        for (int i=0;i<pest.size(); i++) {
                            String s = pest.get(i);
                            if (!s.equalsIgnoreCase(movie.getCropPestId() + "")) {
                                pest.add(movie.getCropPestId());
                                break;
                            }
                        }

                    }
                    else {
                        // context.spinnerValueMap.remove(position);

                        for (int i=0;i<pest.size(); i++) {
                            String s = pest.get(i);
                            if (s.equalsIgnoreCase(movie.getCropPestId() + "")) {
                                pest.remove(movie.getCropPestId());
                                break;
                            }
                        }

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
        Call<PestNameResponse> call = mapiClinet.getPest(cropinformation);
        call.enqueue(new Callback<PestNameResponse>() {

            @Override
            public void onResponse(Call<PestNameResponse> call, Response<PestNameResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        PestNameResponse labListResponse=response.body();
                        String s=labListResponse.getMessage();
                        java.util.List<CropPestname> labList=new ArrayList<>();
                        labList=labListResponse.getCropPestname();
//                        Log.e("pest sub crop id ",sharedPrefrenceUtil.getSubCropID()+" id "+id);

                        if (labList!=null) {
                            StoreAdapter adapter = new StoreAdapter(getActivity(), labList);
                            recycler_view.setAdapter(adapter);
                        }
                        if (pest.size() > 0) {

                            pest_observed.setChecked(true);

                            SaveMachineData dataModel = new SaveMachineData();
                            dataModel.setData(pest);

                            sharedPrefrenceUtil.setCheckMachineItem(dataModel);

                        } else {

                            pest_observed.setChecked(false);
                            sharedPrefrenceUtil.setCheckMachineItem(null);

                        }
                    }
                }
          gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<PestNameResponse> call, Throwable t) {
                gif1.setVisibility(View.GONE);
            }
        });
    }


    public void SaveOtherMainCrop() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OtherPestRequest machineryrequest = new OtherPestRequest(sharedPrefrenceUtil.getSubCropID()+"",id,edOthers.getText().toString());
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherPest(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Pest");
                        postFarmLabDataServer();
                        frame_layout_others.setVisibility(View.GONE);
                    }
//                    else {
//                    }
//
//                }
//                else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<OthersFertilizerResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
