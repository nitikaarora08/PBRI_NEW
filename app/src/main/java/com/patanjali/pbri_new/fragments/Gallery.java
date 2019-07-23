package com.patanjali.pbri_new.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.GalleryList;
import com.patanjali.pbri_new.model.GalleryRequest;
import com.patanjali.pbri_new.model.GalleryResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Gallery.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Gallery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Gallery extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Gallery() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gallery.
     */
    // TODO: Rename and change types and number of parameters
    public static Gallery newInstance(String param1, String param2) {
        Gallery fragment = new Gallery();
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
    GalleryList messagess = new GalleryList();
    RecyclerView recycler_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view=    inflater.inflate(R.layout.fragment_gallery, container, false);
        recycler_view=view.findViewById(R.id.recycler);
        GetGallery();
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
    
    

    /**
     * Created by Lenovo on 15-10-2017.
     */

    public class HindiPersonalDeatilCustomAdpter extends RecyclerView.Adapter<HindiPersonalDeatilCustomAdpter.MyViewHolder> {
        Activity context;

        List<String>  messagess = new ArrayList<>();

        public HindiPersonalDeatilCustomAdpter(Activity activity, List<String>  messagess) {
            this.context = activity;
            this.messagess = messagess;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView imgGallary;

            public MyViewHolder(View view) {
                super(view);
                this.imgGallary =  view.findViewById(R.id.imgGallary);
            }
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gallary, parent, false);


            MyViewHolder mh = new MyViewHolder(itemView);
            return mh;

        }

        @Override
        public void onBindViewHolder(final HindiPersonalDeatilCustomAdpter.MyViewHolder holder, final int position) {
             final String machinename=messagess.get(position);

             try {
                 Picasso.with(context)
                         .load(machinename)
                         .into(holder.imgGallary);

                 if (machinename.contains("pdf")) {
                     holder.imgGallary.setImageResource(R.drawable.pdf);
                 }

            holder.imgGallary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(machinename); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
             }catch (Exception e){}

    }

        @Override
        public int getItemCount() {
            return (null != messagess ? messagess.size() : 0);
        }

    }

    public void GetGallery() {
        try {
            SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getActivity());
            String id = sharedPrefrenceUtil.getResponseId();

            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            final GalleryRequest cropinformation = new GalleryRequest(id);

            Call<GalleryResponse> call = mapiClinet.gallery(cropinformation);
            call.enqueue(new Callback<GalleryResponse>() {

                @Override
                public void onResponse(Call<GalleryResponse> call, Response<GalleryResponse> response) {
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();
                        if (errCode.equals(true)) {
                            GalleryResponse retailerBeatResponse = response.body();
                            messagess = retailerBeatResponse.getGalleryList();
                            if (messagess!=null) {
                                List<String> machinename = messagess.getImage();
                                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
                                recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                                recycler_view.setLayoutManager(gridLayoutManager);
                                HindiPersonalDeatilCustomAdpter adapter = new HindiPersonalDeatilCustomAdpter(getActivity(), machinename);
                                recycler_view.setAdapter(adapter);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GalleryResponse> call, Throwable t) {
                    if (getActivity() != null)
                        Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){}
    }






}
