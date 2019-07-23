package com.patanjali.pbri_new.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsRequest;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsResponse;
import com.patanjali.pbri_new.model1.CropsInfo;
import com.patanjali.pbri_new.model1.List;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CropsList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CropsList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CropsList extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CropsList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CropsList.
     */
    // TODO: Rename and change types and number of parameters
    public static CropsList newInstance(String param1, String param2) {
        CropsList fragment = new CropsList();
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

    Button btnAddNewCrop;
    public  static SharedPrefrenceUtil sharedPrefrenceUtil;
    public  static   StoreAdapter mAdapter;
    public  static   java.util.List<CropsInfo> getVoucher;
    public  static RecyclerView listLabs;
    public  static View view,itemView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view=    inflater.inflate(R.layout.fragment_crops_list, container, false);
        btnAddNewCrop=view.findViewById(R.id.btnAddNewCrop);

        sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
        buttonClick();
        listLabs=view.findViewById(R.id.listLabs);
        listLabs.setLayoutManager(new LinearLayoutManager(getActivity()));
        getVoucher = new ArrayList<>();
        mAdapter = new StoreAdapter(getActivity(), getVoucher);
        listLabs.setAdapter(mAdapter);
        GetCropInfoSize();

        return  view;
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



    static class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        public static Context context;
        private java.util.List<CropsInfo> getVoucher;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // CheckBox c1;
            public TextView txtCropName,txtLabID,txtLabIDShow,txtQuantity, txtNumber,txtCount,id,txtExpire,txtProduct;
            public ImageView Image;
            Button btnMinus,btnPlus;
            int amount=0;
            //public Button buttonInc,buttonDec,orderNow;
            public MyViewHolder(View view) {
                super(view);
                txtLabID = view.findViewById(R.id.txtLabID);
                txtCropName = view.findViewById(R.id.txtCropName);
                txtLabIDShow = view.findViewById(R.id.txtLabIDShow);

            }
        }

        public StoreAdapter(Context context, java.util.List<CropsInfo> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.crops_layout, parent, false);
            return new StoreAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StoreAdapter.MyViewHolder holder, final int position) {
            final com.patanjali.pbri_new.model1.CropsInfo movie = getVoucher.get(position);
            holder.txtLabIDShow.setText(movie.getCropInfoId());
            holder.txtCropName.setText(movie.getCropStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    String id=getVoucher.get(position).getFarmLabId();
                    Config.toast(context,movie.getCropInfoId());
                    sharedPrefrenceUtil.setCropInfoID(Integer.parseInt(holder.txtLabIDShow.getText().toString()));
                    Config.CallFragment2(context,new CropInfoFragment());
//                    Config.CallFragment(getActivity(),new CropInfoFragment());
                }
            });

        }

        @Override
        public int getItemCount() {
            return getVoucher.size();
        }
    }


    public  void buttonClick(){
//        btnAddNewCrop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Config.CallFragment2(getActivity(),new CropInfoFragment());
//            }
//        });
        btnAddNewCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefrenceUtil.setPlantHeight(null);
                sharedPrefrenceUtil.setNoProductivityTiller(null);
                sharedPrefrenceUtil.setPanicleSize(null);
                sharedPrefrenceUtil.setNoOfFruit(null);
                sharedPrefrenceUtil.setDateOfHarvesting(null);
                sharedPrefrenceUtil.setgrainweight(null);
//                sharedPrefrenceUtil.setlatLang(null);
//                sharedPrefrenceUtil.setLandMarkMark(null);
//                sharedPrefrenceUtil.setCropSeason(null);
//                sharedPrefrenceUtil.setCropPattern(null);
//                sharedPrefrenceUtil.setsoilselecteditem(null);
//                sharedPrefrenceUtil.setSoilSampleCollection(null);
//                sharedPrefrenceUtil.setNitrogen(null);
//                sharedPrefrenceUtil.setPhosphorous(null);
//                sharedPrefrenceUtil.setPotassium(null);
//                sharedPrefrenceUtil.setPH(null);
//                sharedPrefrenceUtil.setOrganicCarbon(null);
//                sharedPrefrenceUtil.setNitrogen(null);

                sharedPrefrenceUtil.setgrainYieldPlant(null);
                sharedPrefrenceUtil.setgrainYieldPlot(null);
                sharedPrefrenceUtil.setStraw(null);
                sharedPrefrenceUtil.setByproduct(null);
                sharedPrefrenceUtil.setNoOfRainyDays(null);
                sharedPrefrenceUtil.setAnnualRainfall(null);
                sharedPrefrenceUtil.setRelHumidity(null);
                sharedPrefrenceUtil.setMinTemp(null);
                sharedPrefrenceUtil.setMaxTemp(null);
                sharedPrefrenceUtil.setSunshineHours(null);

//                sharedPrefrenceUtil.setAttachment(null);
//                sharedPrefrenceUtil.setAttachedFile(null);
//
//                sharedPrefrenceUtil.setImageFile(null);
//                sharedPrefrenceUtil.setDateTime(null);

//
//                Fragment f = getFragmentManager().findFragmentById(R.id.container);
//
//                if (f instanceof FarmLabFragment) {
//                    getFragmentManager().beginTransaction().remove(f).commit();
                sharedPrefrenceUtil.setCropInfoID(0);
//                sharedPrefrenceUtil.setFarmLabID("");
                Config.CallFragment2(getActivity(),new CropInfoFragment());
//                }
            }
        });

    }



    public  void GetCropInfoSize(){
        final String crop_info_id,farmer_id,crop_status,crop_name,variety_name,crop_Area,land_preparation_Date;

//        crop_info_id=sharedPrefrenceUtil.getCropInfoID()+"";
        farmer_id=sharedPrefrenceUtil.getResponseId();


        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        CropInfoTotalCropsRequest cropInfoRequest=new CropInfoTotalCropsRequest(sharedPrefrenceUtil.getFarmLabID(),farmer_id)   ;


        Call<CropInfoTotalCropsResponse> call = mapiClinet.getTotalCrops(cropInfoRequest);
        call.enqueue(new Callback<CropInfoTotalCropsResponse>() {

            @Override
            public void onResponse(Call<CropInfoTotalCropsResponse> call, Response<CropInfoTotalCropsResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        try {
                            CropInfoTotalCropsResponse getCropInfoResponse = response.body();
                            java.util.List<CropsInfo> labList = getCropInfoResponse.getCropsInfo();
                            sharedPrefrenceUtil.setTotalCrops(labList.size());

                            getVoucher=getCropInfoResponse.getCropsInfo();
                            labList=getCropInfoResponse.getCropsInfo();
                            int labSize=labList.size();
                            sharedPrefrenceUtil.setTotalFarmlabs(labSize);
//                        Config.toast(getActivity(),"labsize "+labSize);

//                        new StoreAdapter(getActivity(),labList);
                            listLabs.setAdapter(new StoreAdapter(getActivity(),labList));



//                            Toast.makeText(getActivity(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//                            Toast.makeText(getActivity(), "get Total Crops Size: "+sharedPrefrenceUtil.getTotalCrops(), Toast.LENGTH_LONG).show();

                            //list.setAdapter(customAdatorr
                            // Toast.makeText(
                            //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                            Log.e("response", "" + response.body());
                        }catch(Exception e){}
                    } else {

                        Toast.makeText(getActivity(), "Something Went Wrong....", Toast.LENGTH_LONG).show();
                    }


                } else {
                    Toast.makeText(getActivity(), "Something Went Wrong....Try Again", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<CropInfoTotalCropsResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                if (getActivity()!=null)
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });




    }


    @Override
    public void onResume() {
        mAdapter = new StoreAdapter(getActivity(), getVoucher);
        listLabs.setAdapter(mAdapter);
        super.onResume();
    }
}
