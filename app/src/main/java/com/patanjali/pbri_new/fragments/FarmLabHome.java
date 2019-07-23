package com.patanjali.pbri_new.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.Home;
import com.patanjali.pbri_new.model.RequestGetFarmLab;
import com.patanjali.pbri_new.model.ResponseGetFarmLab;
import com.patanjali.pbri_new.model1.LabListGetResponse;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FarmLabHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FarmLabHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmLabHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FarmLabHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FarmLabHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FarmLabHome newInstance(String param1, String param2) {
        FarmLabHome fragment = new FarmLabHome();
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
  static  List<com.patanjali.pbri_new.model1.List> labList;
    public static   StoreAdapter mAdapter;
    public static List<com.patanjali.pbri_new.model1.List> getVoucher;
    public static SharedPrefrenceUtil sharedPrefrenceUtil;
    RelativeLayout btnFirstFarm,btnSecondFarm;
    Button btnAddNewFarmLab;
   public static RecyclerView listLabs;
    public static View view,itemView;
    public static String lab_type="no";
    public static String lab_type_pbri="no";
    public static String farm_lab_type="no";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_farm_lab_home, container, false);
       btnAddNewFarmLab=view.findViewById(R.id.btnAddNewFarmLab);
        btnSecondFarm=view.findViewById(R.id.btnSecondFarm);
        btnFirstFarm=view.findViewById(R.id.btnFirstFarm);
        sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
        buttonClick();
        listLabs=view.findViewById(R.id.listLabs);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        listLabs.setLayoutManager(mLayoutManager);
        getVoucher = new ArrayList<>();
        mAdapter = new StoreAdapter(getActivity(), getVoucher);
        listLabs.setAdapter(mAdapter);
        postFarmLabDataServer();


        return view;
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

    public  static class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        private Context context;
        private List<com.patanjali.pbri_new.model1.List> getVoucher;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // CheckBox c1;
            public TextView txtLabID,txtLabIDShow, txtNumber,txtCount,id,txtExpire,txtProduct;
            public ImageView imgDelete;
            Button btnMinus,btnPlus;
            int amount=0;
            //public Button buttonInc,buttonDec,orderNow;
            public MyViewHolder(View view) {
                super(view);
                txtLabID = view.findViewById(R.id.txtLabID);
                txtLabIDShow = view.findViewById(R.id.txtLabIDShow);
                imgDelete = view.findViewById(R.id.imgDelete);

            }
        }

        public StoreAdapter(Context context, List<com.patanjali.pbri_new.model1.List> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.lab_list_layout, parent, false);



            return new StoreAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StoreAdapter.MyViewHolder holder, final int position) {
            final com.patanjali.pbri_new.model1.List movie = getVoucher.get(position);
            holder.txtLabIDShow.setText(movie.getFarmLabId());
            holder.txtLabID.setText(movie.getLandmark());
            if (movie.getLandmark().equals(""))
                holder.txtLabID.setText(movie.getLatlong());
            if (movie.getfarm_lab_type().equals("farmer") || movie.getfarm_lab_type().equals("pbri")) {
                itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    String id=getVoucher.get(position).getFarmLabId();
                    farm_lab_type="no";
//                    Config.toast(context,holder.txtLabIDShow.getText().toString());
                    sharedPrefrenceUtil.setFarmLabID(holder.txtLabIDShow.getText().toString());
                    Config.CallFragment(context,new FarmLabFragment());
                }
            });

            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(R.string.app_name);
                    builder.setIcon(R.drawable.warning);
                    builder.setMessage("Are you sure you want to delete farmlab '"+ holder.txtLabID.getText().toString()+"' ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    deleteFarmLab(context,holder.txtLabIDShow.getText().toString());
                                }
                            })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                }
            });

        }

        @Override
        public int getItemCount() {
            return getVoucher.size();
        }
    }


    public  void buttonClick(){

        btnFirstFarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                if (labList!=null){
                for (int i=0;i<labList.size();i++){
              farm_lab_type=labList.get(i).getfarm_lab_type();

              if (farm_lab_type.equals("farmer")){
                  farm_lab_type="farmer";
                  sharedPrefrenceUtil.setFarmLabID(labList.get(i).getFarmLabId());
                  Config.CallFragment(getActivity(),new FarmLabFragment());
                  break;
              }

            } }

//                if (farm_lab_type.equals("farmer")){
//                    Config.CallFragment(getActivity(),new FarmLabFragment());
//                    Config.toast(getActivity(),"farm lab id: "+sharedPrefrenceUtil.getFarmLabID()+" farm_lab_type: "+farm_lab_type+labList.size());
//                }
                if(!farm_lab_type.equals("farmer")) {
                    farm_lab_type="farmer";
                    sharedPrefrenceUtil.setFarmLabID("");
                    Config.CallFragment(getActivity(),new FarmLabFragment());
                }
//                if (labList!=null)
//                    Config.toast(getActivity(),"farm lab id: "+sharedPrefrenceUtil.getFarmLabID()+" farm_lab_type: "+farm_lab_type+labList.size());

//            lab_type="farmer";
        }catch (Exception e){
//                if (getActivity()!=null)
//                    Config.toast(getActivity(),"pleasae check your internet connection");
            }
        }
    });
        btnSecondFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (labList!=null) {
                        for (int i = 0; i < labList.size(); i++) {
                            farm_lab_type = labList.get(i).getfarm_lab_type();
                            if (farm_lab_type.equals("pbri")) {
                                farm_lab_type = "pbri";
                                sharedPrefrenceUtil.setFarmLabID(labList.get(i).getFarmLabId());
                                Config.CallFragment(getActivity(), new FarmLabFragment());
                                break;
                            }
                        }
                    }

//                    } if (farm_lab_type.equals("pbri")){
//                        farm_lab_type="pbri";
//                        Config.CallFragment(getActivity(),new FarmLabFragment());
//                        Config.toast(getActivity(),"farm lab id: "+sharedPrefrenceUtil.getFarmLabID()+" farm_lab_type: "+farm_lab_type+labList.size());
//                    }

                    if(!farm_lab_type.equals("pbri")) {
                        farm_lab_type="pbri";
                        sharedPrefrenceUtil.setFarmLabID("");
                        Config.CallFragment(getActivity(),new FarmLabFragment());
                    }

            }catch (Exception e){
//                    Config.toast(getActivity(),"please check your internet connection");
                }

//                lab_type_pbri="pbri";
            }
        });


        btnAddNewFarmLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefrenceUtil.setFarmLabID("");
                farm_lab_type="no";
                Config.CallFragment(getActivity(),new FarmLabFragment());
            }
        });
    }

    public void postFarmLabDataServer() {
        final   RelativeLayout gif1=view.findViewById(R.id.imgGif);

        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest cropinformation = new SoilRequest(id);

        Call<LabListGetResponse> call = mapiClinet.getLabList(cropinformation);
        call.enqueue(new Callback<LabListGetResponse>() {

            @Override
            public void onResponse(Call<LabListGetResponse> call, Response<LabListGetResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        LabListGetResponse labListResponse=response.body();
                        String s=labListResponse.getMessage();
                         labList=new ArrayList<>();
                        labList=labListResponse.getList();
                        int labSize=labList.size();
                        sharedPrefrenceUtil.setTotalFarmlabs(labSize);
                        listLabs.setAdapter(new StoreAdapter(getActivity(),labList));
                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<LabListGetResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                gif1.setVisibility(View.GONE);
                if (getActivity()!=null)
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResume() {
//        listLabs.setAdapter(new StoreAdapter(getActivity(),getVoucher));
        super.onResume();
    }



    public static void deleteFarmLab(final Context context,String farmlab_id) {
       final ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.show();
        final String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        RequestGetFarmLab deletFarm = new RequestGetFarmLab(id,farmlab_id);

        Call<ResponseGetFarmLab> call = mapiClinet.deleteFarmLab(deletFarm);
        call.enqueue(new Callback<ResponseGetFarmLab>() {

            @Override
            public void onResponse(Call<ResponseGetFarmLab> call, Response<ResponseGetFarmLab> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        Config.toast(context,response.body().getMessage());
                        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
                        SoilRequest cropinformation = new SoilRequest(id);

                        Call<LabListGetResponse> call1 = mapiClinet.getLabList(cropinformation);
                        call1.enqueue(new Callback<LabListGetResponse>() {

                            @Override
                            public void onResponse(Call<LabListGetResponse> call, Response<LabListGetResponse> response) {
                                if (response.body() != null) {
                                    Boolean errCode = response.body().getStatus();

                                    if (errCode.equals(true)) {
                                        LabListGetResponse labListResponse=response.body();
                                        String s=labListResponse.getMessage();
                                        labList=new ArrayList<>();
                                        labList=labListResponse.getList();
                                        int labSize=labList.size();
                                        sharedPrefrenceUtil.setTotalFarmlabs(labSize);
                                        listLabs.setAdapter(new StoreAdapter(context,labList));
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<LabListGetResponse> call, Throwable t) {
                            }
                        });
                    }
                }
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<ResponseGetFarmLab> call, Throwable t) {
                  progressDialog.dismiss();
//                if (getActivity()!=null)
//                    Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
