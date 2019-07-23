package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.Home;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.LabList;
import com.patanjali.pbri_new.model.PatternList;
import com.patanjali.pbri_new.model.RequestGetFarmLab;
import com.patanjali.pbri_new.model.ResponseGetFarmLab;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model1.CropStatusList;
import com.patanjali.pbri_new.model1.CropStatusListResponse;
import com.patanjali.pbri_new.model1.LabListGetResponse;
import com.patanjali.pbri_new.model1.List;
import com.patanjali.pbri_new.model1.OthersFertilizerRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.CropInfoFragment.txtCropStatus;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainCrops.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainCrops#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainCrops extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainCrops() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainCrops.
     */
    // TODO: Rename and change types and number of parameters
    public static MainCrops newInstance(String param1, String param2) {
        MainCrops fragment = new MainCrops();
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
    ImageView imgBack;
    Button btnAddNewCrop;
    public static RelativeLayout frame_layout_others;
    public static AlertDialog alertDialog;
    EditText edOthers;
    Button btnSaveOthers;
    ImageView imgClose;
    Context context;
    public  static Fragment f4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       itemView=  inflater.inflate(R.layout.fragment_main_crops, container, false);
       recycler_view=itemView.findViewById(R.id.recycler);
       context=getActivity();

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
        btnAddNewCrop  =itemView.findViewById(R.id.btnAddNewCrop);

        if (getActivity()!=null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        }

        imgBack  =itemView.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity()!=null)
                    getActivity().onBackPressed();
            }
        });

            sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
            getMainCrop();


        btnAddNewCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame_layout_others.setVisibility(View.VISIBLE);
            }
        });
  btnSaveOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crop=edOthers.getText().toString();
                crop.replace(" ","");
                if (crop.equals(""))
                    Config.toast(getActivity(),"please enter crop name");
                else
                SaveOtherMainCrop();
            }
        });

        return itemView; }

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



    public void getMainCrop() {
        final   RelativeLayout gif1=itemView.findViewById(R.id.imgGif);
        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest cropinformation = new SoilRequest(id);


        Call<CropStatusListResponse> call = mapiClinet.getMainCrop(cropinformation);
        call.enqueue(new Callback<CropStatusListResponse>() {

            @Override
            public void onResponse(Call<CropStatusListResponse> call, Response<CropStatusListResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        CropStatusListResponse labListResponse=response.body();
                        String s=labListResponse.getMessage();
                        java.util.List<CropStatusList> labList=new ArrayList<>();
                        labList=labListResponse.getCropStatusList();
                        if (getActivity()!=null) {
                            StoreAdapter adapter = new StoreAdapter(getActivity(), labList);
                            recycler_view.setAdapter(adapter);
                        }

                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<CropStatusListResponse> call, Throwable t) {
                gif1.setVisibility(View.GONE);
                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        private Context context;
        private java.util.List<CropStatusList> getVoucher;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // CheckBox c1;
            public TextView txtCropName,txtQuantity, txtNumber,txtCount,id,txtExpire,txtProduct;
            public ImageView Image;
            Button btnMinus,btnPlus;
            int amount=0;
            //public Button buttonInc,buttonDec,orderNow;
            public MyViewHolder(View view) {
                super(view);
                txtCropName = view.findViewById(R.id.txtCropName);
                Image = view.findViewById(R.id.imgCrop);

            }
        }

        public StoreAdapter(Context context, java.util.List<CropStatusList> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_crop_list, parent, false);



            return new StoreAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StoreAdapter.MyViewHolder holder, final int position) {
            final CropStatusList movie = getVoucher.get(position);
            holder.txtCropName.setText(movie.getCropStatus());
            try{


                if (movie.getImage().length()<10){
                    holder.Image.setImageResource(R.drawable.crops);
                }else {
                    if (getActivity()!=null) {
                        Picasso.with(getActivity())
                                .load(movie.getImage())
                                .into(holder.Image);
                    }
                }

            }catch (Exception e){}
//            Config.toast(context,movie.getImage());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (CropInfoFragment.from.equals("main"))
                    txtCropStatus.setText(holder.txtCropName.getText().toString());
                    if (CropInfoFragment.from.equals("sub"))
                    CropInfoFragment.spinnerName.setText(holder.txtCropName.getText().toString());
//                    CropInfoFragment.spinnerName.setText("");
//                    sharedPrefrenceUtil.setSubCropID("");
                    sharedPrefrenceUtil.setMainCropID(movie.getId());
                    Config.toast(context,movie.getId());
                    f4 = getFragmentManager().findFragmentById(R.id.container4);


//            getFragmentManager().beginTransaction().remove(f4).commit();

                    FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.container5, new SubCropsFragment());
                    transaction.commit();
                }
            });


        }

        @Override
        public int getItemCount() {
            return getVoucher.size();
        }
    }




    public void SaveOtherMainCrop() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OthersFertilizerRequest machineryrequest = new OthersFertilizerRequest(sharedPrefrenceUtil.getResponseId(),"",edOthers.getText().toString());
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherMainCrop(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Main Crop");
                        getMainCrop();
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
