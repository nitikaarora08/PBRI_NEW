package com.patanjali.pbri_new.fragments;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.FilePath;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.ResponseUpdateFarmBook;
import com.patanjali.pbri_new.model1.HelpResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.patanjali.pbri_new.activity.LoginActivity.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Help.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Help#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Help extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Help() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Help.
     */
    // TODO: Rename and change types and number of parameters
    public static Help newInstance(String param1, String param2) {
        Help fragment = new Help();
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
//    Button btnSendHelp;
    ProgressDialog mprogressDialog;
    File path;
//    EditText etContact,etComplain;
//    LinearLayout llActtachment;
    SharedPrefrenceUtil sharedPrefrenceUtil;
//    TextView txtfilePath;
//    TextView txt1,txt2;
    LinearLayout txt4,txt3,txt5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
      View view=   inflater.inflate(R.layout.fragment_help, container, false);
        txt4=view.findViewById(R.id.txt4);
        txt3=view.findViewById(R.id.txt3);
        txt5=view.findViewById(R.id.txt5);
//        txt1=view.findViewById(R.id.txt1);
//        txt2=view.findViewById(R.id.txt2);
//        btnSendHelp=view.findViewById(R.id.btnSendHelp);
//        txtfilePath=view.findViewById(R.id.txtfilePath);
//        etContact=view.findViewById(R.id.etContact);
//        etComplain=view.findViewById(R.id.etComplain);
//        llActtachment=view.findViewById(R.id.llAttchment);
        sharedPrefrenceUtil=new SharedPrefrenceUtil(getActivity());

//        txt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse("http://agritech.tnau.ac.in/"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//            }
//        });
//  txt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse("http://patanjalibio.com/"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//            }
//        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://1.6.145.44//farmers_project//uploads//help//1//7012a6738cb212d338f73a23e639acb5.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://1.6.145.44/farmers_project/uploads/help/1/a258c8e2c6d9919a85b8449672533bf4.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
  txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://1.6.145.44//farmers_project//uploads//help//1//178a8a966b373e6d2f37f48f4e5522e2.pdf"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

//        llActtachment.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (!checkCameraPermission()) {
//
//                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                    Manifest.permission.READ_EXTERNAL_STORAGE},
//                            REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
//                } else {
//
//                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                    intent.setType("*/*");
////                    Intent cameraIntent = new Intent(android.provider.MediaStore);
//                    startActivityForResult(intent, 1);
//
//                }
//            }
//        });



//        btnSendHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (path==null) {
//                    Config.toast(getActivity(), "please choose Attachment");
//                }
//else {
////                    String image = path.getAbsolutePath();
////                    if (image.equals("") || image == null
////                            || image.equals("null")) {
////                        Config.toast(getActivity(), "please choose Attachment");
////                    } else {
//                        PostHelp();
////                    }
//                }
//            }
//        });

        return view;
    }

//    @Override
//    public void onActivityResult(int requestCode,
//                                 int resultCode, Intent data) {
//
//
//        if (requestCode == 1) {
//
//            if (resultCode == RESULT_OK) {
//                try {
//                    Uri selectedFileUri = data.getData();
//                     path = new File(FilePath.getPath(getContext(), selectedFileUri));
////                    Log.i(TAG, "Selected File Path:" + path);
//
//                    if (path != null && !path.equals("")) {
//
//                        Toast.makeText(getContext(), "Selected File Successfully", Toast.LENGTH_SHORT).show();
////                        Toast.makeText(getContext(), "New" + path, Toast.LENGTH_SHORT).show();
//                        txtfilePath.setText(path.getAbsolutePath());
//
////                        sharedPrefrenceUtil.setAttachedFile(path);
//                    }
//
//
//                    else
//                    {
//                        Toast.makeText(getContext(), "Cannot upload file to server", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//    }
//
//
//                public boolean checkCameraPermission() {
//
//
//        int result1 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
//        int result2 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        int result3 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
//
//        return result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
//                && result3 == PackageManager.PERMISSION_GRANTED;
//
//    }


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



//    public  void PostHelp(){
//        try {
//            String comment,contact;
//            contact = etContact.getText().toString();
//            comment = etComplain.getText().toString();
//            RequestBody contact1 = RequestBody.create(MediaType.parse("text/plain"), contact);
//            RequestBody comment1 = RequestBody.create(MediaType.parse("text/plain"), comment);
//            RequestBody text = RequestBody.create(MediaType.parse("text/plain"), "hello");
//            RequestBody id1 = RequestBody.create(MediaType.parse("text/plain"), sharedPrefrenceUtil.getResponseId());
//
//            RequestBody requestBodyProfile = RequestBody.create(MediaType.parse("multipart/form-data"),path);
//            MultipartBody.Part profile_img = MultipartBody.Part.createFormData("image",
//                    path.getName(), requestBodyProfile);
////            Toast.makeText(getContext(), "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();
//
////            Log.e("id ", "" + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID());
//
//            showLoadingDialog(getActivity());
//            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//            mapiClinet.postHelp( id1,contact1, comment1,text, profile_img).enqueue(new Callback<HelpResponse>() {
//                @Override
//                public void onResponse(Call<HelpResponse> call, Response<HelpResponse> response) {
//
//                    hideLoading();
//                    Log.e("response", "" + response.body());
//                    if (response.body() != null) {
//                        Boolean errCode = response.body().getStatus();
//
//                        if (errCode.equals(true)) {
//                            Toast.makeText(getContext(), "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
//                            Log.e("response", "" + response.body());
//
//                        } else {
//
//                            Toast.makeText(getContext(), "Sucessfully Data Syc to Server", Toast.LENGTH_LONG).show();
//                        }
//                    } else {
//                        Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<HelpResponse> call, Throwable t) {
//                    hideLoading();
//                    Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//
//        }catch (Exception e){}
//    }


//    public void showLoadingDialog(Context context) {
//        mprogressDialog = new ProgressDialog(context);
//        mprogressDialog.show();
//        if (mprogressDialog.getWindow() != null) {
//            mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        mprogressDialog.setContentView(R.layout.progress_layout);
//        mprogressDialog.setIndeterminate(true);
//        mprogressDialog.setCancelable(false);
//
//        mprogressDialog.setCanceledOnTouchOutside(false);
//
//    }
//
//    public void hideLoading() {
//        if (mprogressDialog != null && mprogressDialog.isShowing()) {
//            mprogressDialog.cancel();
//        }
//    }

}




