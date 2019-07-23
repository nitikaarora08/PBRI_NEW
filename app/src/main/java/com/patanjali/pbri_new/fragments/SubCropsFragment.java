package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model1.CropNameList;
import com.patanjali.pbri_new.model1.OtherRequestSubCrop;
import com.patanjali.pbri_new.model1.OthersFertilizerRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.model1.SubCropsRequest;
import com.patanjali.pbri_new.model1.SubCropsResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.CropInfoFragment.from;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.spinnerName;
import static com.patanjali.pbri_new.fragments.CropInfoFragment.txtCropStatus;
import static com.patanjali.pbri_new.fragments.MainCrops.f4;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubCropsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubCropsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubCropsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SubCropsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubCropsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubCropsFragment newInstance(String param1, String param2) {
        SubCropsFragment fragment = new SubCropsFragment();
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

    java.util.List<CropNameList> labList;
    View itemView;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    RecyclerView recycler_view;
    Button btnAddNewCrop;
    public static RelativeLayout frame_layout_others;
    public static AlertDialog alertDialog;
    EditText edOthers;
    Button btnSaveOthers;
    ImageView imgClose;
    Context context;   String getMainCropID,id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        itemView=  inflater.inflate(R.layout.fragment_sub_crops, container, false);
        recycler_view=itemView.findViewById(R.id.recycler);
        context=getActivity();
        sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
            recycler_view.setLayoutManager(gridLayoutManager);
            postFarmLabDataServer();

      ImageView  imgBack  =itemView.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });



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


    public void postFarmLabDataServer() {
        final   RelativeLayout gif1=itemView.findViewById(R.id.imgGif);
        getMainCropID= sharedPrefrenceUtil.getMainCropID();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SubCropsRequest cropinformation = new SubCropsRequest(getMainCropID,id);
//        Config.toast(context,"main crop id: "+getMainCropID);
        Call<SubCropsResponse> call = mapiClinet.getSubCrop(cropinformation);
        call.enqueue(new Callback<SubCropsResponse>() {
            @Override
            public void onResponse(Call<SubCropsResponse> call, Response<SubCropsResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        SubCropsResponse labListResponse = response.body();
                        labList = new ArrayList<>();
                        labList = labListResponse.getCropNameList();
                        if (getActivity() != null) {
                            StoreAdapter adapter = new StoreAdapter(getActivity(), labList);
                            recycler_view.setAdapter(adapter);
                        }
                        if (labList.size() == 0) {
                            Fragment f4 = getFragmentManager().findFragmentById(R.id.container4);
                            getFragmentManager().beginTransaction().remove(f4).commit();
                        }
                    }
                    gif1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<SubCropsResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                gif1.setVisibility(View.GONE);
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }





    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
        private Context context;
        private java.util.List<CropNameList> getVoucher;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // CheckBox c1;
            public TextView txtCropName,txSubCropID,txtQuantity, txtNumber,txtCount,id,txtExpire,txtProduct;
            public ImageView Image;
            Button btnMinus,btnPlus;
            int amount=0;
            //public Button buttonInc,buttonDec,orderNow;
            public MyViewHolder(View view) {
                super(view);
                txtCropName = view.findViewById(R.id.txtCropName);
                Image = view.findViewById(R.id.imgCrop);
                txSubCropID = view.findViewById(R.id.txSubCropID);

            }
        }

        public StoreAdapter(Context context, java.util.List<CropNameList> getVoucher) {
            this.context = context;
            this.getVoucher = getVoucher;
        }


        @NonNull
        @Override
        public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sub_crop_list, parent, false);



            return new StoreAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StoreAdapter.MyViewHolder holder, final int position) {
            final CropNameList movie = getVoucher.get(position);
            holder.txtCropName.setText(movie.getCropName());
            holder.txSubCropID.setText(movie.getId());
//            try{
//                Picasso.with(getActivity())
//                        .load(movie.getImage())
//                        .into(holder.Image);
//            }catch (Exception e){}
//            Config.toast(context,movie.getImage());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (from.equals("main")) {
                        txtCropStatus.setText(txtCropStatus.getText().toString() + "(" + holder.txtCropName.getText().toString() + ")");
                        sharedPrefrenceUtil.setSubCropID(holder.txSubCropID.getText().toString());
                    }    if (from.equals("sub")) {
                        spinnerName.setText(spinnerName.getText().toString() + "(" + holder.txtCropName.getText().toString() + ")");
                    }

                    Config.toast(context,holder.txSubCropID.getText().toString());
                    Fragment f5 = getFragmentManager().findFragmentById(R.id.container5);

                        getFragmentManager().beginTransaction().remove(f5).commit();

                    if (f4 != null)
                        getFragmentManager().beginTransaction().remove(f4).commit();

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
        OtherRequestSubCrop machineryrequest = new OtherRequestSubCrop(edOthers.getText().toString(),sharedPrefrenceUtil.getMainCropID(),id);
        Call<OthersFertilizerResponse> call = mapiClinet.PostSubCropOTHER(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Sub Crop");
                        frame_layout_others.setVisibility(View.GONE);
                        postFarmLabDataServer();
                    } else {
                    }
                }
//                else {
//                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
//                }
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
