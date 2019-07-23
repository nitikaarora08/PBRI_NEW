package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.PagerFragmentListener;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.MainActivity;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.DistrictList;
import com.patanjali.pbri_new.model.EducationList;
import com.patanjali.pbri_new.model.StateList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.google.android.gms.internal.zzagz.runOnUiThread;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutFarmer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutFarmer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFarmer extends Fragment implements PagerFragmentListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    boolean isViewCreated = false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AboutFarmer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFarmer.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFarmer newInstance(String param1, String param2) {
        AboutFarmer fragment = new AboutFarmer();
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

    @Override
    public void setEmail(String setVillage) {
        if(isViewCreated){
//            Config.toast(getActivity());
            farmer_emailid.setText(setVillage);
    }}

    @Override
    public void setAddress(String setVillage) {
        if(isViewCreated)
            farmer_address.setText(setVillage);

    }

    @Override
    public void setPhone(String setVillage) {
        if(isViewCreated)
            farmer_mobileno.setText(setVillage);

    }
    public  static   String date_of_birth,farmerAddress,farmerPincode,mobile_no,farmer_state,farmer_district,farmer_email;
   public static TextView farmer_address,aadhaar_no,farmer_mobileno,farmer_emailid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about_farmer, container, false);
        farmer_address=view.findViewById(R.id.farmer_address);
        aadhaar_no=view.findViewById(R.id.aadhaar_no);
        farmer_mobileno=view.findViewById(R.id.farmer_mobileno);
        farmer_emailid=view.findViewById(R.id.farmer_emailid);
//        Config.toast(getActivity());
        farmer_address.setMovementMethod(new ScrollingMovementMethod());
        new AsyncTaskRunnerFeatured().execute((Void[]) null);


//        farmer_address.setText(HomeFragment.farmer_address.getText()+"\n Pin Code: "+HomeFragment.farmer_pincode.getText());
//        aadhaar_no.setText(HomeFragment.adhar_number.getText());
//        farmer_mobileno.setText(HomeFragment.farmer_mobileno.getText());
//        farmer_emailid.setText(HomeFragment.farmer_emailid.getText());
//
//        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
//
//
//        if (sharedPrefrenceUtil.getFarmerAddress()!=null)
//        {
//            farmer_address.setText(sharedPrefrenceUtil.getFarmerAddress()+"\n Pin Code: "+HomeFragment.farmer_pincode.getText());
//        }else{
//            try {
//                String address=HomeFragment.farmer_village.getText()+" , "+sharedPrefrenceUtil.getcityitem()+" , "
//                        +HomeFragment.farmer_mandal.getText()+","
//                        +sharedPrefrenceUtil.getstateitem()+","+HomeFragment.farmer_pincode.getText();
//                farmer_address.setText(address);
//
//            }catch (Exception e){}
//
//        }
// if (sharedPrefrenceUtil.getAdharNumber()!=null)
//        {
//            aadhaar_no.setText(sharedPrefrenceUtil.getAdharNumber());
//        }
// if (sharedPrefrenceUtil.getMobileNumber()!=null)
//        {
//            farmer_mobileno.setText(sharedPrefrenceUtil.getMobileNumber());
//        }
// if (sharedPrefrenceUtil.getEmail()!=null)
//        {
//            farmer_emailid.setText(sharedPrefrenceUtil.getEmail());
//        }

        return view;

    }

    @Override
    public void onResume() {
//        Config.toast(getActivity());
        isViewCreated = true;

//        new AsyncTaskRunnerFeatured().execute((Void[]) null);
        super.onResume();
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
//        Config.toast(getActivity());

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


   class AsyncTaskRunnerFeatured extends AsyncTask<Void,Void,Void> {
        InputStream inpts;
        String result,line;

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            try {
//                Config.toast(getActivity());
                farmer_emailid.setText(farmer_email);
                farmer_mobileno.setText(mobile_no);

                if (farmerPincode.equals("null") || farmerPincode.equals("") || farmerPincode==null || farmerPincode.equals(null))
                    farmerPincode="-";

                if (farmerAddress.equals("null") || farmerAddress.equals(""))
                    farmerAddress="-";
                if (farmer_district.equals("null") || farmer_district.equals("") || farmer_district==null || farmer_district.equals(null) )
                    farmer_district="-";
                 if (farmer_state.equals("null") || farmer_state.equals("") || farmer_state==null || farmer_state.equals(null) )
                     farmer_state="-";

                 farmer_address.setText(farmerAddress + "\n PinCode: " + farmerPincode + "\nDistrict: " + farmer_district
                             + "\nState: " + farmer_state);



            } catch (Exception e) {
                Log.e("Exception ",e.getMessage());
            }

        }

        @Override
        protected Void doInBackground(Void... params) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                    HttpResponse response;
                    JSONObject json = new JSONObject();
                    try {
                        HttpPost post = new HttpPost("http://1.6.145.44/farmers_project/index.php/Farmer_data/farmerdetailsByid");



                        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
                        String id = sharedPrefrenceUtil.getResponseId();

                        JSONObject userJson = new JSONObject();
                        userJson.put("farmer_id", id);
                        userJson.put("lang", sharedPrefrenceUtil.getLangApi());


//                        Log.e("json", String.valueOf(json));


                        StringEntity se = new StringEntity( userJson.toString());
                        post.setHeader(HTTP.CONTENT_TYPE, "application/json");

                        post.setEntity(se);
                        response = client.execute(post);

                        inpts=null;
                        if(response!=null){
                            inpts = response.getEntity().getContent(); //Get the data in the entity
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(inpts));
                        StringBuilder sb = new StringBuilder();

                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        inpts.close();
                        result = sb.toString();

                        JSONObject  jsonObjectMain = new JSONObject(result);

                        JSONObject jsonObject2= jsonObjectMain.getJSONObject("list");
                        JSONObject jsonObject1= jsonObject2.getJSONObject("farmer_details");
                        farmerAddress = jsonObject1.getString("farmer_address");
                        farmerPincode = jsonObject1.getString("farmer_pincode");
                        mobile_no = jsonObject1.getString("farmer_mobileno");
                        farmer_email = jsonObject1.getString("farmer_email");
                        farmer_state = jsonObject1.getString("farmer_state");
                        farmer_district = jsonObject1.getString("farmer_district");


                    } catch(JSONException e) {
                        e.printStackTrace();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            return null;
        }
    }


}
