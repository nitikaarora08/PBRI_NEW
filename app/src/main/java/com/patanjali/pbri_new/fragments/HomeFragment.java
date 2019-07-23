package com.patanjali.pbri_new.fragments;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.DistrictRequest;
import com.patanjali.pbri_new.NetworkUtility;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.FarmerProfile;
import com.patanjali.pbri_new.activity.MainActivity;
import com.patanjali.pbri_new.activity.ScannedBarcodeActivity;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.CityResponse;
import com.patanjali.pbri_new.model.DistrictList;
import com.patanjali.pbri_new.model.EducationList;
import com.patanjali.pbri_new.model.EducationResponse;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.PostFarmerDetails;
import com.patanjali.pbri_new.model.PostResponseFarmerDetail;
import com.patanjali.pbri_new.model.StateList;
import com.patanjali.pbri_new.model.StateResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.activity.FarmerProfile.gif;
import static com.patanjali.pbri_new.activity.FarmerProfile.imgUpload;
import static com.patanjali.pbri_new.activity.FarmerProfile.txtCity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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







    List<EducationList> educationLists;
    TextView btnScan;
    RelativeLayout llScanAadhar;
    String selectedbiofertilizeritem,selectedreligionitem,selectedcasteitem ,selectedsocialitem,
            selectedphysicaldis,genderselecteditem,selectedverticalitem,selectedcerelitem,irrigationselecteditem,
            selectedmaincropitem,selectedcityName,eduName, statenamevalidation, state_name, stateselected,
            selectedsoilname, selectmonocropping, maincrop_name, crop_name, diseases_values_observerd;
    public static EditText farmer_production,farmer_location,farmer_profit,farmer_totalincome,
            farmer_totalinvestment,farmer_marketing,farmer_yieldofverticaldcrop,farmer_yield_maincrop,
            farmer_verticalcrop,farmer_areacrop,
            farmer_no_children,farmer_no_female,farmer_no_male,farmer_poultry,farmer_goats,farmer_Buffallow,
            farmer_cow,input_pincode,farmername,landholding, adhar_number, farmer_pancard,
            farmer_village, farmer_mandal, farmer_landholding, farmer_landmark, farmer_dob, farmer_age,
            farmer_emailid, farmer_mobileno, farmer_address, farmer_pincode;

   public static Spinner  spinner_education, spinner_gender, spinner_state, spinner_city, farmer_soil,
            farmer_croppingpattern_monocropping, spinner_typeofmaincrop, spinner_typeofverticakcrop,
            farmer_physicaldisibilty, farmer_socialstatus, caste_category, farmer_religion, cropseason,
            biofertilizer;
    public static   boolean click1=true,click2=true,click3=true;
    DatePickerDialog picker;
    String[] physicaldisibility_values = {"शारीरिक विकलांगता", "हाँ", "नहीं"};
    String[] CasteCategory_values = {"जाति श्रेणी", "सामान्य", "अन्य पिछड़ा वर्ग","अनुसूचित जाति","अनुसूचित जनजाति"};
    String[] Religion_values = {"धर्म", "हिन्दू", "मुस्लिम", "सिख", "इसाई", " बुद्ध", "जैन"};
    String[] Socialstatus_values = {"सामाजिक स्थिति ", "गरीबी रेखा से ऊपर", "गरीबी रेखा से नीचे"};

  public static   String[] farmer_gender = {"लिंग", "पुरुष", "महिला"};

    String[] CropSeason_value = {"मौसम का फसल", "खरीफ", "रबी", "ग्रीष्मकालीन फसल"};


    String[] BioFertilizer_Value = {"जैव उर्वरक के स्रोत", "स्वंय", "बाहरी"};
    String[] males=new String[]{};
    String[] female=new String[]{} ;//= {"Select","1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
    String[] children=new String[]{} ;//= {"Select","1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};

    String id;
    public static   Spinner spinner_male,spinner_female,spinner_children;
    public static RelativeLayout  rel_layout_details2,rel_layout_FamilyMembers2;
    ProgressDialog mprogressDialog;
    LinearLayout llMale,llFemale,llChildren,rel_layout_PersonnelDetails2;
  TextView txtMale,txtFemale,txtChildren;
    Button save_farmerdetails;
    public static  List<StateList> statelist = new ArrayList<>();
   public static List<DistrictList> citylist;
     RelativeLayout relative_layout;
    TextView txtDate;
    Button btnOk,btnBack;
    DatePicker datePicker;
    EditText farmer_wmobileno;
//    ProgressDialog progressDialog;
    JSONObject jsonObject3;
    ScrollView sv;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    String farmer_village_name,farmersAge,landmark,farmer_mandal_name,farmer_state,farmer_district;
    String farmer_name,adhar_no,date_of_birth,farmerAddress,farmerPincode,mobile_no,noOfMale,noOfFemale,noOfChildren,whatsappMobileNo
            ,farmerGender,farmer_education,farmer_profilepic,farmer_email,farmer_cast_category,farmerReligion;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnScan = view.findViewById(R.id.btnScan);
        context=getActivity();
//        progressDialog = new ProgressDialog(context);
        btnBack = view.findViewById(R.id.btnBack);
        males = new String[]{getResources().getString(R.string.select), "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        female = new String[]{getResources().getString(R.string.select), "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        children = new String[]{getResources().getString(R.string.select), "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        txtChildren = view.findViewById(R.id.txtChildren);
        txtMale = view.findViewById(R.id.txtMale);
        txtFemale = view.findViewById(R.id.txtFemale);
//        sv=view.findViewById(R.id.sv);
        sharedPrefrenceUtil = new SharedPrefrenceUtil(getActivity());

        llScanAadhar = view.findViewById(R.id.llScanAadhar);
        save_farmerdetails = view.findViewById(R.id.save_farmerdetails);
//        rel_layout_details1=view.findViewById(R.id.rel_layout_details1);
        rel_layout_details2 = view.findViewById(R.id.rel_layout_details2);
//        rel_layout_PersonnelDetails1=view.findViewById(R.id.rel_layout_PersonnelDetails1);
        rel_layout_PersonnelDetails2 = view.findViewById(R.id.rel_layout_PersonnelDetails2);
//        rel_layout_FamilyMembers1=view.findViewById(R.id.rel_layout_FamilyMembers1);
        rel_layout_FamilyMembers2 = view.findViewById(R.id.rel_layout_FamilyMembers2);

        farmer_emailid = (EditText) view.findViewById(R.id.farmer_emailid);
        farmer_wmobileno = (EditText) view.findViewById(R.id.farmer_wmobileno);
        farmer_mobileno = (EditText) view.findViewById(R.id.farmer_mobileno);
        farmername = (EditText) view.findViewById(R.id.input_name);
        farmer_dob = (EditText) view.findViewById(R.id.dob);
        adhar_number = (EditText) view.findViewById(R.id.aadhaar_no);
        input_pincode = (EditText) view.findViewById(R.id.farmer_pincode);
        farmer_address = (EditText) view.findViewById(R.id.farmer_address);
        farmer_pincode = (EditText) view.findViewById(R.id.farmer_pincode);
        spinner_gender = (Spinner) view.findViewById(R.id.spinner_gender);
        spinner_male = (Spinner) view.findViewById(R.id.spinner_male);
        spinner_female = (Spinner) view.findViewById(R.id.spinner_Female);
        spinner_children = (Spinner) view.findViewById(R.id.spinner_Children);
        farmer_religion = (Spinner) view.findViewById(R.id.farmer_religion);
        caste_category = (Spinner) view.findViewById(R.id.caste_category);
        spinner_education = (Spinner) view.findViewById(R.id.farmer_education);
        spinner_state = (Spinner) view.findViewById(R.id.farmer_state);
        spinner_city = (Spinner) view.findViewById(R.id.farmer_city);


        farmer_age = (EditText) view.findViewById(R.id.farmer_age);
        farmer_village = (EditText) view.findViewById(R.id.farmer_village);
        farmer_mandal = (EditText) view.findViewById(R.id.mandal_name);
        farmer_landmark = (EditText) view.findViewById(R.id.landmark);
//        farmer_address.setMovementMethod(new ScrollingMovementMethod());


        llMale = view.findViewById(R.id.llMale);
        llFemale = view.findViewById(R.id.llFemale);
        llChildren = view.findViewById(R.id.llChildren);

        farmer_mobileno.setEnabled(false);
        llMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_male.performClick();
            }
        });
        llFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_female.performClick();
            }
        });
        llChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_children.performClick();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        farmer_mobileno.setText(sharedPrefrenceUtil.getMobileNumber() + "id" + sharedPrefrenceUtil.getResponseId());
        datePicker = view.findViewById(R.id.datePicker);
        relative_layout = view.findViewById(R.id.relative_layout);
        btnOk = view.findViewById(R.id.btnOk);


        relative_layout.setVisibility(View.GONE);
        farmer_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative_layout.setVisibility(View.VISIBLE);
            }
        });

//        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getActivity());
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("hello","hello");
//        editor.commit();



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = datePicker.getDayOfMonth();
                int m = datePicker.getMonth() + 1;
                String month,day;
                month=m+"";
                day=d+"";
                if (m<10)
                    month="0"+m;
                if (d<10)
                    day="0"+d;
                int year = datePicker.getYear();
//                String date=day+"-"+m+"-"+year+","+currentDateandTime;
                String date = year + "-" + month + "-" + day;
                // Config.Toast(getActivity(),date);
                farmer_dob.setText(date);
                relative_layout.setVisibility(View.GONE);
                int age = Integer.parseInt(Config.getAge(year, Integer.parseInt(month),  Integer.parseInt(day)));
                new SharedPrefrenceUtil(getActivity()).setDob(date + "");

                if (age > 10 && age<100) {
                    farmer_age.setText(age + "");
                    new SharedPrefrenceUtil(getActivity()).setFramerAge(age + "");
                }else {
                    farmer_age.setText("");
                    new SharedPrefrenceUtil(getActivity()).setFramerAge("");
                }

            }
        });


        //edu list


        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()
                selectedcityName = citylist.get(po).getDistrictName();

                if (selectedcityName.contains("select")){
                    sharedPrefrenceUtil.setstateitem("");
                    sharedPrefrenceUtil.setcityitem("");
                    FarmerProfile.txtCity.setText("");
                }else
                    sharedPrefrenceUtil.setcityitem(selectedcityName);

                if (selectedcityName.equalsIgnoreCase("Select District")|| selectedcityName.equalsIgnoreCase("जिले का चयन करें")
                        || selectedcityName.equals(null)){
                    sharedPrefrenceUtil.setstateitem("");
                    sharedPrefrenceUtil.setcityitem("");
                    FarmerProfile.txtCity.setText("");
                }else
                    FarmerProfile.txtCity.setText(selectedcityName + " ( " + sharedPrefrenceUtil.getstateitem() + " )");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                // your code here

            }

        });


        if (MainActivity.Connetion(getActivity()) == true)
        {
            sendStateData();
    }else {

            if (sharedPrefrenceUtil.getStateList() != null) {

                List<StateList> temList = sharedPrefrenceUtil.getStateList().getStateList();

                StateList stateMOdel = new StateList();
                stateMOdel.setStateName(getResources().getString(R.string.Select_State));
                statelist.add(stateMOdel);
                statelist.addAll(temList);
                StateAdapter stateAdapter = new StateAdapter(getContext(), statelist);
                spinner_state.setAdapter(stateAdapter);

                if (!sharedPrefrenceUtil.getstateitem().isEmpty()) {
                    for (int i = 0; i < statelist.size(); i++) {

                        StateList data = statelist.get(i);

                        if (sharedPrefrenceUtil.getstateitem().equals(data.getStateName())) {
                            spinner_state.setSelection(i);
                            break;
                        }
                    }
                }
            } else {


                sendStateData();
            }
        }


        DistrictList districtModel2 = new DistrictList();
        citylist=new ArrayList<DistrictList>();
        districtModel2.setDistrictName(getResources().getString(R.string.Select_District));
        citylist.add(0, districtModel2);
        CityAdapter adapter = new CityAdapter(getContext(), citylist);
        spinner_city.setAdapter(adapter);




        StateList stateModel = new StateList();
        statelist=new ArrayList<StateList>();
        stateModel.setStateName(getResources().getString(R.string.Select_State));
        statelist.add(0, stateModel);
        StateAdapter adapter1 = new StateAdapter(getContext(), statelist);
        spinner_state.setAdapter(adapter1);




        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                                                        // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()

                                                        String stateselectedname;
                                                        stateselected = statelist.get(po).getStateId();
                                                        stateselectedname = statelist.get(po).getStateName();

                                                        if (stateselectedname.equals(getResources().getString(R.string.Select_State))) {
                                                            FarmerProfile.txtCity.setText("");
                                                            DistrictList districtModel2 = new DistrictList();
                                                            citylist=new ArrayList<DistrictList>();
                                                            districtModel2.setDistrictName(getResources().getString(R.string.Select_District));
                                                            citylist.add(0, districtModel2);
                                                            CityAdapter adapter = new CityAdapter(getContext(), citylist);
                                                            spinner_city.setAdapter(adapter);
                                                        }else {
                                                            sharedPrefrenceUtil.setstateitem(stateselectedname);
                                                            sendCityData(stateselected);
                                                        }

                                                        if (stateselectedname.equalsIgnoreCase("Select State")|| stateselectedname.equalsIgnoreCase("राज्य चुनें")
                                                        || stateselected.equals(null)){
                                                            sharedPrefrenceUtil.setstateitem("");
                                                            sharedPrefrenceUtil.setcityitem("");
                                                            FarmerProfile.txtCity.setText("");
                                                        }

//                                                        if (stateselectedname.equalsIgnoreCase("Jammu and Kashmir")) {
//}
//                                                            if (adhar_number.length() == 12) {
//                                                                adhar_number.setError(null);
//                                                                farmer_pancard.setError(null);
//
//                                                            } else {
//                                                                adhar_number.setError(null);
//                                                                farmer_pancard.setError("Please Enter Valid Pancard number");
//                                                                textwatcherforadharno();
//                                                            }
//
//
//                                                        } else {

                                                    }

                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> parent) {

                                                    }


                                                });

        save_farmerdetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


//                String s = farmer_pancard.getText().toString(); // get your editext value here
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String emailPatterncapital = "[A-ZA-Z0-9._-]+@[A-Z]+\\.+[A-Z]+";

                Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
//                Matcher matcher = pattern.matcher(s);

                // Check if pattern matches


                if (farmername.getText().toString().isEmpty()) {

                    farmername.setError("Please Enter Farmer Name");
                    Toast.makeText(getContext(), "Please Enter the Name", Toast.LENGTH_LONG).show();

                }
//                else if (farmer_dob.getText().toString().isEmpty()) {
//
//
//                    farmer_dob.setError("Please Enter the Date Of Birth");
//                    Toast.makeText(getContext(), "Please Enter the Date Of Birth", Toast.LENGTH_LONG).show();
//                }
                else if (adhar_number.getText().toString().isEmpty()) {


                    adhar_number.setError("Please Enter the Aadhar Number");
                    Toast.makeText(getContext(), "Please Enter the Aadhar Number", Toast.LENGTH_LONG).show();
                }
                else  if (adhar_number.length() != 12 && adhar_number.length() > 0) {

                    Toast.makeText(getContext(), "If You are Entering Aadhaar Number Then It should be Valid", Toast.LENGTH_LONG).show();
                }
                else if (genderselecteditem.equalsIgnoreCase("Gender")
                || genderselecteditem.equalsIgnoreCase("लिंग")){
                        Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_LONG).show();
//                    }
                }


//                else if (farmer_emailid.getText().toString().isEmpty()) {
//                    farmer_emailid.setError("Please Enter the Email ID");
//                    Toast.makeText(getContext(), "Please Enter the Email ID", Toast.LENGTH_LONG).show();
//                }
                else if (farmer_address.getText().toString().isEmpty()) {
                    farmer_address.setError("Please Enter Address");
                    Toast.makeText(getContext(), "Please Enter Address", Toast.LENGTH_LONG).show();
                }
//                else if (txtMale.getText().toString().equalsIgnoreCase("select")) {
//
//
//                    txtMale.setError("Please Enter Number of Male");
//                    Toast.makeText(getContext(), "Please Enter the Family Size", Toast.LENGTH_LONG).show();
//                } else if (txtFemale.getText().toString().equalsIgnoreCase("select")) {
//
//
//                    txtFemale.setError("Please Enter Number of Female");
//                    Toast.makeText(getContext(), "Please Enter the Family Size", Toast.LENGTH_LONG).show();
//                }  else if (txtChildren.getText().toString().equalsIgnoreCase("select")) {
//
//
//                    txtChildren.setError("Please Enter Number of Children");
//                    Toast.makeText(getContext(), "Please Enter the Family Size", Toast.LENGTH_LONG).show();
//                }

                else if (!farmer_emailid.getText().toString().matches(emailPattern) && farmer_emailid.getText().toString().length() > 0 && (!farmer_emailid.getText().toString().matches(emailPatterncapital))) {

                    Toast.makeText(getContext(), "If You are Entering Email Id Then It should be Valid", Toast.LENGTH_LONG).show();
                }
                else{

                    if (NetworkUtility.isNetworkAvailable(getContext())) {
                        // postData();



                        PostFarmerDetails();
//                            PostFramPic();

                        //  Toast.make
                        // Text(getActivity(),"aaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(getActivity(), "Data Saved Successfully...Sync to Server Automatically", Toast.LENGTH_SHORT).show();
//                            JobServiceToPostFarmerDetails();
                    }
                }
            }
        });






        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = getResources().getStringArray(R.array.farmer_gender)[po];
//                 Toast.makeText(getActivity(),genderselecteditem,Toast.LENGTH_SHORT).show();
                if (genderselecteditem.contains("F")|| genderselecteditem.contains("f")){
                    spinner_gender.setSelection(2);
                    sharedPrefrenceUtil.setGenderItemSelected("F");

                }else if (genderselecteditem.contains("M") || genderselecteditem.contains("m")){
                    spinner_gender.setSelection(1);
                    sharedPrefrenceUtil.setGenderItemSelected("M");

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        spinner_male.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                txtMale.setText(genderselecteditem);
                sharedPrefrenceUtil.setMale(genderselecteditem);

                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()

//                SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
//                sharedPrefrenceUtil.setGenderItemSelected(genderselecteditem);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

//        if (!sharedPreferences.getGenderItemSelected().isEmpty()) {
            for (int i = 0; i < males.length; i++) {
                String genderselected = males[i];

                if (genderselected.equals(sharedPrefrenceUtil.getGenderItemSelected()))

                {
                    spinner_male.setSelection(i);
                }
            }
//        }

       spinner_female.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = female[po];
                txtFemale.setText(genderselecteditem);
                sharedPrefrenceUtil.setFeMale(genderselecteditem);

                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()

//                SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
//                sharedPrefrenceUtil.setGenderItemSelected(genderselecteditem);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

//        if (!sharedPreferences.getGenderItemSelected().isEmpty()) {
            for (int i = 0; i < female.length; i++) {
                String genderselected = female[i];

                if (genderselected.equals(sharedPrefrenceUtil.getGenderItemSelected()))

                {
                    spinner_female.setSelection(i);
                }
            }
//        }



        if (!sharedPrefrenceUtil.getReligion().isEmpty()) {
            for (int i = 0; i < getResources().getStringArray(R.array.Religion_values).length; i++) {
                String religionselecteditem = getResources().getStringArray(R.array.Religion_values)[i];

                if (religionselecteditem.equals(sharedPrefrenceUtil.getReligion()))

                {
                    farmer_religion.setSelection(i);
                }

            }

        }



        farmer_religion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()
                selectedreligionitem = getResources().getStringArray(R.array.Religion_values)[po];
                //    Toast.makeText(getActivity(), religionname,Toast.LENGTH_SHORT).show();
                sharedPrefrenceUtil.setReligion(selectedreligionitem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        caste_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()
                selectedcasteitem = getResources().getStringArray(R.array.CasteCategory_values)[po];
                //    Toast.makeText(getActivity(), religionname,Toast.LENGTH_SHORT).show();
                sharedPrefrenceUtil.setCasteSelectedItem(selectedcasteitem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        spinner_education.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {


                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()
                eduName = educationLists.get(po).getEducationName();
                sharedPrefrenceUtil.setEducation(eduName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

       spinner_children.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = children[po];
                txtChildren.setText(genderselecteditem);
                sharedPrefrenceUtil.setChildren(genderselecteditem);


                // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show()

//                SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
//                sharedPrefrenceUtil.setGenderItemSelected(genderselecteditem);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

//        if (!sharedPreferences.getGenderItemSelected().isEmpty()) {
            for (int i = 0; i < children.length; i++) {
                String genderselected = children[i];

                if (genderselected.equals(sharedPrefrenceUtil.getGenderItemSelected()))

                {
                    spinner_children.setSelection(i);
                }
            }
//        }

        getStaticDataSpinner();



        llScanAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.Intent(getActivity(), ScannedBarcodeActivity.class);
            }
        });



        adhar_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                String farmeradhar = adhar_number.getText().toString();

                if (farmeradhar.length() >= 1) {
                    if (farmeradhar.length() != 12) {

                        adhar_number.setError("Please Enter Valid Aadhaar Number");
                        Toast.makeText(getActivity(), "Please enter 12 digit adhar card number", Toast.LENGTH_SHORT).show();

                    }
                    // saveThisItem(txtClientID.getText().toString(), "company", txtCompany.getText().toString());

                }
            }
        });



//        String serverData="no";
//        SharedPreferences Preferences=PreferenceManager.getDefaultSharedPreferences(getContext());
//        serverData=Preferences.getString("serverDataCost","no");
//        if (serverData.equals("no")) {
//            SharedPreferences.Editor editor=Preferences.edit().putString("serverDataCost","yes1");
//            editor.commit();
//        }else if (serverData.equals("yes1")) {
//            new AsyncTaskRunnerFeatured().execute((Void[]) null);
//            SharedPreferences.Editor editor=Preferences.edit().putString("serverDataCost","yes");
//            editor.commit();
//        }

//        if (MainActivity.Connetion(getActivity())==false) {
        new AsyncTaskRunnerFeatured().execute((Void[]) null);
        getAllSavedField();
//        }
        getDataFromServer();
        SetAllFieldData();
//        FocusChangeError();


//        String address=sharedPreferences.getVilalgeName()+","+sharedPreferences.getcityitem()+","+sharedPreferences.getMandal()+","+sharedPreferences.getstateitem()+","+sharedPreferences.getPinCode();
//        sharedPrefrenceUtil.setFramerAddress(address);


            if (farmer_profilepic==null) {
                imgUpload.setImageResource(R.drawable.profile);
            }

            if (FarmerProfile.txtCity.getText().toString().contains("null")) {
                String c = FarmerProfile.txtCity.getText().toString();
            c.replace("null","");
                FarmerProfile.txtCity.setText(c);
            }
 if (FarmerProfile.txtCity.getText().toString().contains("select")) {
                FarmerProfile.txtCity.setText("");
            }


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


    private void getStaticDataSpinner() {
        ArrayAdapter mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.farmer_gender)){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        spinner_gender.setAdapter(mAdapter);

 ArrayAdapter male_adapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        spinner_male.setAdapter(male_adapter);


   ArrayAdapter female_adapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,female){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        spinner_female.setAdapter(female_adapter);


   ArrayAdapter children_adapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,children){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);
                tv.setTextSize(20);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);
                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        spinner_children.setAdapter(children_adapter);

        ArrayAdapter  religion = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Religion_values)){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };
        farmer_religion.setAdapter(religion);


        ArrayAdapter  castecategory = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.CasteCategory_values)){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };
        caste_category.setAdapter(castecategory);

    }



    private void sendEducation() {

       String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id);

        Call<EducationResponse> call = mapiClinet.doEducation(machineryrequest);
        call.enqueue(new Callback<EducationResponse>() {

            @Override
            public void onResponse(Call<EducationResponse> call, Response<EducationResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        EducationResponse retailerBeatResponse = response.body();
                        educationLists = retailerBeatResponse.getEducationList();

                        EducationList educationList = new EducationList();
                        educationList.setEducationName(context.getResources().getString(R.string.education));
                        educationLists.add(0, educationList);

                        sharedPrefrenceUtil.setEduList(retailerBeatResponse);


                        EducationAdapter adapter = new EducationAdapter(getContext(), educationLists);
                        spinner_education.setAdapter(adapter);

                        if (sharedPrefrenceUtil.getEduList()!=null) {
                            if (sharedPrefrenceUtil.getEduList().getEducationList() != null) {
                                if (sharedPrefrenceUtil.getEduList().getEducationList().size() > 0) {
                                    for (int i = 0; i < sharedPrefrenceUtil.getEduList().getEducationList().size(); i++) {
                                        EducationList data = sharedPrefrenceUtil.getEduList().getEducationList().get(i);

                                        if (sharedPrefrenceUtil.getEducation().equals(data.getEducationName())) {
                                            spinner_education.setSelection(i);
                                            sharedPrefrenceUtil.setEducation(data.getEducationName());

                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        //list.setAdapter(customAdatorr
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                        Log.e("response", "" + response.body());

                    } else {
                    }


                } else {
                    // Toast.makeText(getActivity(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<EducationResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Education Adapter
    public class EducationAdapter extends BaseAdapter implements SpinnerAdapter {

        private final Context activity;

        String value_beat;


        private List<EducationList> asr;

        public EducationAdapter(Context context, List<EducationList> asr) {
            this.asr = asr;
            activity = context;
        }

        public int getCount() {
            return asr.size();
        }

        public Object getItem(int i) {
            return asr.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }


        @Override

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            }
            TextView textView = convertView.findViewById(R.id.text);
            textView.setText(asr.get(position).getEducationName());

            if (position == 0) {
                textView.setTextColor(Color.GRAY);

            } else {
                textView.setTextColor(Color.BLACK);

            }
            // Toast.makeText(getActivity(),asr.get(position).getEducationName(),Toast.LENGTH_SHORT).show();
            return convertView;

        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getEducationName());
            textView.setTextColor(Color.GRAY);
            //st= asr.get(i).getBeatCode();
            // Toast.makeText(getActivity(),st,Toast.LENGTH_SHORT).show();
            //  list=(ListView) view1.findViewById(R.id.list_item);
            // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            //  linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
            // recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
            //sendBeatData();
            return view1;
        }
    }




//




    private void getDataFromServer() {

        if (MainActivity.Connetion(getActivity()) == true)
        {
            sendEducation();
        }else {
//edu list

            if (sharedPrefrenceUtil.getEduList() != null) {
                educationLists = sharedPrefrenceUtil.getEduList().getEducationList();

                EducationAdapter adapter = new EducationAdapter(getContext(), educationLists);
                spinner_education.setAdapter(adapter);

                if (!sharedPrefrenceUtil.getEducation().isEmpty()) {
                    for (int i = 0; i < educationLists.size(); i++) {

                        EducationList data = educationLists.get(i);

                        if (sharedPrefrenceUtil.getEducation().equals(data.getEducationName())) {
                            spinner_education.setSelection(i);
                            break;
                        }
                    }
                }

            }
//        else {
//            sendEducation();
//        }

        }
//MainCropList

        if (sharedPrefrenceUtil.getReligion() != null) {
            for (int i = 0; i < getResources().getStringArray(R.array.Religion_values).length; i++) {

                String religionselecteditem = getResources().getStringArray(R.array.Religion_values)[i];

                if (religionselecteditem.equalsIgnoreCase(sharedPrefrenceUtil.getReligion()))

                {
                    farmer_religion.setSelection(i);
                }
            }
                    }
//
 if (!sharedPrefrenceUtil.getCasteSelectedItem().isEmpty()) {
     for (int i = 0; i < getResources().getStringArray(R.array.CasteCategory_values).length; i++) {

         String CasteCategory_values = getResources().getStringArray(R.array.CasteCategory_values)[i];

         if (CasteCategory_values.equalsIgnoreCase(sharedPrefrenceUtil.getCasteSelectedItem())) {
             caste_category.setSelection(i);
         }
     }
 }

    }



    private void getAllSavedField() {
//        if (MainActivity.Connetion(context)==false) {
//            if (sharedPrefrenceUtil.getProfilePic().exists()) {
//                Bitmap myBitmap = BitmapFactory.decodeFile(sharedPrefrenceUtil.getProfilePic().getAbsolutePath());
//                imgUpload.setImageBitmap(myBitmap);
//            }
//        }
        if (!sharedPrefrenceUtil.getGenderItemSelected().isEmpty()) {
            if (sharedPrefrenceUtil.getGenderItemSelected().contains("F")|| sharedPrefrenceUtil.getGenderItemSelected().contains("f")){
                spinner_gender.setSelection(2);

            }else if (sharedPrefrenceUtil.getGenderItemSelected().contains("M")|| sharedPrefrenceUtil.getGenderItemSelected().contains("m")){
                spinner_gender.setSelection(1);

            }
        }
        if (sharedPrefrenceUtil.getFarmerName()!=null)
        {
            FarmerProfile.txtName.setText(sharedPrefrenceUtil.getFarmerName());
            farmername.setText(sharedPrefrenceUtil.getFarmerName());

        }

        if (sharedPrefrenceUtil.getAdharNumber()!=null)
        {
            adhar_number.setText(sharedPrefrenceUtil.getAdharNumber());

        }
        if (sharedPrefrenceUtil.getDob()!=null)
        {
            farmer_dob.setText(sharedPrefrenceUtil.getDob());
        }


        if (sharedPrefrenceUtil.getFramerAge()!=null)
        {
            farmer_age.setText(sharedPrefrenceUtil.getFramerAge());
        }

        if (sharedPrefrenceUtil.getMobileNumber()!=null)
        {
            farmer_mobileno.setText(sharedPrefrenceUtil.getMobileNumber());
        }
 if (sharedPrefrenceUtil.getWhatsappMobileNumber()!=null)
        {
            farmer_wmobileno.setText(sharedPrefrenceUtil.getWhatsappMobileNumber());
        }

        if (sharedPrefrenceUtil.getEmail()!=null)
        {
            farmer_emailid.setText(sharedPrefrenceUtil.getEmail());
        }

        if (sharedPrefrenceUtil.getFarmerAddress()!=null)
        {
            farmer_address.setText(sharedPrefrenceUtil.getFarmerAddress());
        }

        if (sharedPrefrenceUtil.getPinCode()!=null)
        {
            farmer_pincode.setText(sharedPrefrenceUtil.getPinCode());
        }

 if (sharedPrefrenceUtil.getLandMarkMark()!=null)
        {
            farmer_landmark.setText(sharedPrefrenceUtil.getLandMarkMark());
        }
if (sharedPrefrenceUtil.getVilalgeName()!=null)
        {
            farmer_village.setText(sharedPrefrenceUtil.getVilalgeName());
        }
if (sharedPrefrenceUtil.getMandal()!=null)
        {
            farmer_mandal.setText(sharedPrefrenceUtil.getMandal());
        }


        try{
            if (sharedPrefrenceUtil.getstateitem().equalsIgnoreCase("")){
                  FarmerProfile.txtCity.setText("");
            }else
               FarmerProfile.txtCity.setText(sharedPrefrenceUtil.getcityitem()+" ( "+sharedPrefrenceUtil.getstateitem()+" ) ");
        }catch (Exception e){}


        if (sharedPrefrenceUtil.getMale()!=null) {
            for (int i = 0; i < males.length; i++) {

                String data = males[i];

                if (sharedPrefrenceUtil.getMale().equals(data)) {
                    spinner_male.setSelection(i);
                    break;
                }
            }
        }
         if (sharedPrefrenceUtil.getFeMale()!=null) {
            for (int i = 0; i < female.length; i++) {

                String data = female[i];

                if (sharedPrefrenceUtil.getFeMale().equals(data)) {
                    spinner_female.setSelection(i);
                    break;
                }
            }
        }
         if (sharedPrefrenceUtil.getChildren()!=null) {
            for (int i = 0; i < children.length; i++) {

                String data = children[i];

                if (sharedPrefrenceUtil.getChildren().equals(data)) {
                    spinner_children.setSelection(i);
                    break;
                }
            }
        }




        if (sharedPrefrenceUtil.getMale()!=null)
        {
            txtMale.setText(sharedPrefrenceUtil.getMale());
        }

        if (sharedPrefrenceUtil.getFeMale()!=null)
        {
            txtFemale.setText(sharedPrefrenceUtil.getFeMale());
        }
        if (sharedPrefrenceUtil.getChildren()!=null)
        { txtChildren.setText(sharedPrefrenceUtil.getChildren()); }


    }





    private void SetAllFieldData() {


        farmername.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {


            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                sharedPrefrenceUtil.setFarmerName(farmername.getText().toString());
                FarmerProfile.txtName.setText(farmername.getText().toString());
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

          adhar_number.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {


            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                sharedPrefrenceUtil.setAdharNumber(adhar_number.getText().toString());
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

        farmer_mobileno.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setMobileNumber(farmer_mobileno.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

  farmer_wmobileno.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setWhatsappMobileNumber(farmer_wmobileno.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });


        txtMale.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setMale(txtMale.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
//
//
        txtFemale.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setFeMale(txtFemale.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
//
//
        txtChildren.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setChildren(txtChildren.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });



        farmer_emailid.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setEmail(farmer_emailid.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });




        farmer_mandal.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setMandalName(farmer_mandal.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });




        farmer_dob.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setDob(farmer_dob.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });





        input_pincode.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setPinCode(input_pincode.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

        farmer_address.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setFramerAddress(farmer_address.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

 farmer_village.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setVilalgeName(farmer_village.getText().toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });


farmer_landmark.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setLandMarkMark(farmer_landmark.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(getActivity(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();
            }
        });



    }





    class AsyncTaskRunnerFeatured extends AsyncTask<Void,Void,Void> {
        InputStream inpts;
        String result,line;
        JSONArray jsonArray;

        @Override
        protected void onPreExecute() {
            gif.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


                try {
                    farmername.setText(farmer_name);
                    farmer_dob.setText(date_of_birth);
                    adhar_number.setText(adhar_no);
                    if (!farmerPincode.equals(null))
                        farmer_pincode.setText(farmerPincode);
                    farmer_address.setText(farmerAddress);
                    farmer_emailid.setText(farmer_email);
                    farmer_mobileno.setText(mobile_no);
                    farmer_village.setText(farmer_village_name);
                    farmer_mandal.setText(farmer_mandal_name);
                    farmer_landmark.setText(landmark);
                    farmer_wmobileno.setText(whatsappMobileNo);

                    if (!jsonObject3.toString().equals("")) {
                        txtFemale.setText(noOfFemale);
                        txtMale.setText(noOfMale);
                        txtChildren.setText(noOfChildren);
                    }
                    farmer_age.setText(farmersAge);
//                    Config.toast(context,farmer_profilepic);


                    try{
                        Picasso.with(getActivity())
                                .load(farmer_profilepic)
                                .into(FarmerProfile.imgUpload);
                        gif.setVisibility(View.GONE);
                    }catch (Exception e){
                        gif.setVisibility(View.GONE);
                    }


//                    if (!sharedPrefrencestate.getstateitem().isEmpty()) {
                        for (int i = 0; i < statelist.size(); i++) {

                            StateList data = statelist.get(i);

                            if (sharedPrefrenceUtil.getstateitem().equalsIgnoreCase(data.getStateName())) {
                                spinner_state.setSelection(i);
                                break;
                            }
                        }
//                    }

//                    if (!sharedPrefrencestate.getcityitem().isEmpty()) {
                        for (int i = 0; i < citylist.size(); i++) {

                            DistrictList data = citylist.get(i);

                            if (sharedPrefrenceUtil.getcityitem().equalsIgnoreCase(data.getDistrictName())) {
                                spinner_city.setSelection(i);
                                break;
                            }
                        }
//                    }


                    if (!sharedPrefrenceUtil.getEducation().isEmpty()) {
                        for (int i = 0; i < educationLists.size(); i++) {

                            EducationList data = educationLists.get(i);

                            if (sharedPrefrenceUtil.getEducation().equalsIgnoreCase(data.getEducationName())) {
                                spinner_education.setSelection(i);
                                break;
                            }
                        }
                    }

// if (!sharedPrefrencestate.getReligion().isEmpty()) {
                        for (int i = 0; i < getResources().getStringArray(R.array.Religion_values).length; i++) {

                            String religionselecteditem = getResources().getStringArray(R.array.Religion_values)[i];

                            if (religionselecteditem.equalsIgnoreCase(farmerReligion))

                            {
                                farmer_religion.setSelection(i);
                            }
                        }
//                    }
//
// if (!sharedPrefrencestate.getCasteSelectedItem().isEmpty()) {
                        for (int i = 0; i < getResources().getStringArray(R.array.CasteCategory_values).length; i++) {

                            String CasteCategory_values = getResources().getStringArray(R.array.CasteCategory_values)[i];

                            if (CasteCategory_values.equalsIgnoreCase(farmer_cast_category))

                            {
                                caste_category.setSelection(i);
                            }
                        }

//                        for (int i = 0; i < getResources().getStringArray(R.array.farmer_gender).length; i++) {
//
//                            String genderselecteditem = getResources().getStringArray(R.array.farmer_gender)[i];

                            if (farmerGender.contains("F")|| farmerGender.contains("f")){
                                spinner_gender.setSelection(2);
                                sharedPrefrenceUtil.setGenderItemSelected("F");

                            }else if (farmerGender.contains("M") || farmerGender.contains("m")){
                                spinner_gender.setSelection(1);
                                sharedPrefrenceUtil.setGenderItemSelected("M");

//                            }
                        }
//                    }



                    new AsyncTaskLoadImageCertificate().execute(farmer_profilepic);


                } catch (Exception e) {
//                    Log.e("Exception ",e.getMessage());
                    gif.setVisibility(View.GONE);
                }

        }

        @Override
        protected Void doInBackground(Void... params) {

                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                    HttpResponse response;
                    try {

                        HttpPost post = new HttpPost("http://1.6.145.44/farmers_project/index.php/Farmer_data/farmerdetailsByid");

                        String id = sharedPrefrenceUtil.getResponseId();

                        JSONObject userJson = new JSONObject();
//                        userJson.put("radiusMetres", "5000000");
                        userJson.put("farmer_id", id);
                    userJson.put("lang", sharedPrefrenceUtil.getLangApi());


                        StringEntity se = new StringEntity( userJson.toString());
                        post.setHeader(HTTP.CONTENT_TYPE, "application/json");
//                                    post.setHeader("Authorization", "bearer "+token);
//                        post.setHeader("Authorization", "bearer "+token);
                        post.setEntity(se);
                        response = client.execute(post);
                        int responseCodeDeal=response.getStatusLine().getStatusCode();
//                        Config.Toast(context,"responseCodeMerchantPin :"+responseCodeDeal);
                        /*Checking response */
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

//                        if(responseCodeDeal==200){
//                            Config.Toast(context,"Your Email changed successfully");
//                        }else{
//                            Config.Toast(context,"Something went wrong....try again");
//                        }




                        JSONObject  jsonObjectMain = new JSONObject(result);

                        JSONObject jsonObject2= jsonObjectMain.getJSONObject("list");
                        JSONObject jsonObject1= jsonObject2.getJSONObject("farmer_details");

                        try {
                             jsonObject3 = jsonObject2.getJSONObject("farmer_familysize");
                            if (!jsonObject3.toString().equals("")) {
                                noOfMale = jsonObject3.getString("no_of_male");
                                sharedPrefrenceUtil.setMale(noOfMale);

                                noOfFemale = jsonObject3.getString("no_of_female");
                                sharedPrefrenceUtil.setFeMale(noOfFemale);

                                noOfChildren = jsonObject3.getString("no_of_children");
                                sharedPrefrenceUtil.setChildren(noOfChildren);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }



//                        jsonArray= jsonObjectMain.getJSONArray("cost_list");
//                        Log.e("jsonArray ",jsonArray+"");

//                        if(jsonArray!=null && jsonArray.length()>0) {

//                        for (int i=0;i<jsonArray.length();i++){
//                            for (int i = 0; i < 1; i++) {
//                                jsonObject1 = jsonArray.getJSONObject(i);



                                 farmer_name = jsonObject1.getString("farmer_name");
                                sharedPrefrenceUtil.setFarmerName(farmer_name);


                                 adhar_no = jsonObject1.getString("farmer_adharcard");


                                 date_of_birth = jsonObject1.getString("farmer_dob");

                                 farmerAddress = jsonObject1.getString("farmer_address");
                        if (farmerAddress.equals("null") || farmerAddress.equals(null) )
                            farmerAddress="";
                        else
                            sharedPrefrenceUtil.setFramerAddress(farmerAddress);

                        Log.e("date_of_birth",date_of_birth);

                        if (date_of_birth.equals("null"))
                            date_of_birth="";
                        else
                            sharedPrefrenceUtil.setDob(date_of_birth);

                       Log.e("date_of_birth",date_of_birth);

                                 farmerPincode = jsonObject1.getString("farmer_pincode");
                        if (farmerPincode.equals("null") || farmer_pincode.equals(null) )
                            farmerPincode="";
                        else
                            sharedPrefrenceUtil.setPinCode(farmerPincode);

                                 mobile_no = jsonObject1.getString("farmer_mobileno");
                                sharedPrefrenceUtil.setMobileNumber(mobile_no);

                                 farmerGender = jsonObject1.getString("farmer_gender");
                                sharedPrefrenceUtil.setGenderItemSelected(farmerGender);

                                 farmer_education = jsonObject1.getString("farmer_education");
                                sharedPrefrenceUtil.setEducation(farmer_education);

                                 farmerReligion = jsonObject1.getString("farmer_religion");
                                sharedPrefrenceUtil.setReligion(farmerReligion);

                                 farmer_cast_category = jsonObject1.getString("farmer_cast_category");
                                sharedPrefrenceUtil.setCasteSelectedItem(farmer_cast_category);


                                farmer_email = jsonObject1.getString("farmer_email");

                        farmer_village_name = jsonObject1.getString("farmer_village_name");
                        sharedPrefrenceUtil.setVilalgeName(farmer_village_name);

                        farmer_mandal_name = jsonObject1.getString("farmer_mandal_name");
                        sharedPrefrenceUtil.setMandalName(farmer_mandal_name);

                        farmer_state = jsonObject1.getString("farmer_state");
                        sharedPrefrenceUtil.setstateitem(farmer_state);
//                        sharedPrefrenceUtil.setstateselectedIten(farmer_state);

                        farmer_district = jsonObject1.getString("farmer_district");
                        sharedPrefrenceUtil.setcityitem(farmer_district);

                        landmark = jsonObject1.getString("landmark");
                        sharedPrefrenceUtil.setLandMarkMark(landmark);

                        farmersAge = jsonObject1.getString("farmer_age");

                       whatsappMobileNo = jsonObject1.getString("whatsapp");
                        sharedPrefrenceUtil.setWhatsappMobileNumber(whatsappMobileNo);


                        sharedPrefrenceUtil.setemailAbout(farmer_email);
                        sharedPrefrenceUtil.setMobileAbout(mobile_no);
                        sharedPrefrenceUtil.setAddressAbout(farmerAddress+"\nPincode : "+farmerPincode+
                                "\n District: "+farmer_district
                                +"\n State: "+farmer_state);

                        farmer_profilepic = jsonObject1.getString("farmer_profilepic");


                        if (farmersAge.equals("null"))
                            farmersAge="";
                        else
                            sharedPrefrenceUtil.setFramerAge(farmersAge);

                        if (adhar_no.equals("null"))
                            adhar_no="";
                        else
                            sharedPrefrenceUtil.setAdharNumber(adhar_no);


                        if (farmer_email.equals("null"))
                            farmer_email="";
                        else
                            sharedPrefrenceUtil.setEmail(farmer_email);


//                            }
//                        }
//                        else{
//                            CustomAlertDialog customAlertDialog=new CustomAlertDialog();
//                            customAlertDialog.showDialog(getActivity(),"No Data Found At Selected Location");
//                        }


                    } catch(JSONException e) {
                        e.printStackTrace();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

//



            return null;
        }
    }




    public void PostFarmerDetails() {

        showLoadingDialog(getContext());
        String id = sharedPrefrenceUtil.getResponseId();
        String name = sharedPrefrenceUtil.getFarmerName();
        final String emailid = sharedPrefrenceUtil.getEmail();
        String children = sharedPrefrenceUtil.getChildren();
        String female = sharedPrefrenceUtil.getFeMale();
        String male = sharedPrefrenceUtil.getMale();
        final String pincode = sharedPrefrenceUtil.getPinCode();
        String dob = farmer_dob.getText().toString();
        String landmark = sharedPrefrenceUtil.getLandMarkMark();
        String adharno = sharedPrefrenceUtil.getAdharNumber();
        String villagename = sharedPrefrenceUtil.getVilalgeName();
        final String state = sharedPrefrenceUtil.getstateitem();
        final String address = sharedPrefrenceUtil.getFarmerAddress();
        final String city = sharedPrefrenceUtil.getcityitem();
        String education = sharedPrefrenceUtil.getEducation();
        String farmerage = sharedPrefrenceUtil.getFramerAge();
        String mandalname = sharedPrefrenceUtil.getMandal();
        String farmercastecategory = sharedPrefrenceUtil.getCasteSelectedItem();
        String farmerreligion = sharedPrefrenceUtil.getReligion();
        String farmergender = sharedPrefrenceUtil.getGenderItemSelected();
        String whatsappMobileNo = farmer_wmobileno.getText().toString();
        final String mobile_no = sharedPrefrenceUtil.getMobileNumber();
        Log.e("dob",dob);

        PostFarmerDetails postFarmerDetails= new PostFarmerDetails(address,adharno,farmerage,farmercastecategory,city,dob,
                education,emailid,male,farmergender,id,mandalname,name,pincode,farmerreligion,state,villagename,children,
                female,male,landmark,whatsappMobileNo,mobile_no);



        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        mapiClinet.dopostfarmerdetails(postFarmerDetails).enqueue(new Callback<PostResponseFarmerDetail>() {



            @Override
            public void onResponse(Call<PostResponseFarmerDetail> call, Response<PostResponseFarmerDetail> response) {

                hideLoading();
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        sharedPrefrenceUtil.setemailAbout(emailid);
                        sharedPrefrenceUtil.setMobileAbout(mobile_no);
                        sharedPrefrenceUtil.setAddressAbout(address+"\nPincode : "+pincode+"\n District: "+city
                                +"\n State: "+state);

                        Toast.makeText(getContext(), "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();

                        if (AboutFarmer.farmer_emailid!=null) {
                            AboutFarmer.farmer_emailid.setText(emailid);
                            AboutFarmer.farmer_mobileno.setText(mobile_no);
                            AboutFarmer.farmer_address.setText(address+"\nPincode : "+pincode+"\nDistrict: "+city
                                    +"\nState: "+state);
                        }
                        //list.setAdapter(customAdatorr
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                        Log.e("response", "" + response.body());

                    }
//                    else {
//
//                        Toast.makeText(getContext(), "Sucessfully Data Syc to Server", Toast.LENGTH_LONG).show();
//                    }
//
//
//                } else {
//                    Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<PostResponseFarmerDetail> call, Throwable t) {
                hideLoading();
                //  progressDoalog.dismiss();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void showLoadingDialog(Context context) {
        mprogressDialog = new ProgressDialog(context);
        mprogressDialog.show();
        if (mprogressDialog.getWindow() != null) {
            mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        mprogressDialog.setContentView(R.layout.progress_layout);
        mprogressDialog.setIndeterminate(true);
        mprogressDialog.setCancelable(false);

        mprogressDialog.setCanceledOnTouchOutside(false);

    }

    public void hideLoading() {
        if (mprogressDialog != null && mprogressDialog.isShowing()) {
            mprogressDialog.cancel();
        }
    }



    private void sendCityData(String stateselected) {

        id = sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        DistrictRequest machineryrequest = new DistrictRequest(id, sharedPrefrenceUtil.getLangApi() +
                "", stateselected);

        Call<CityResponse> call = mapiClinet.dodistrict(machineryrequest);
        call.enqueue(new Callback<CityResponse>() {

            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        CityResponse retailerBeatResponse = response.body();
                        citylist = retailerBeatResponse.getDistrictList();

                        DistrictList districtModel = new DistrictList();

//                        citylist.add(0, districtModel);


                        sharedPrefrenceUtil.setCityList(retailerBeatResponse);


                        CityAdapter adapter = new CityAdapter(getContext(), citylist);
                        spinner_city.setAdapter(adapter);


                        if (!sharedPrefrenceUtil.getcityitem().isEmpty()) {
                            for (int i = 0; i < citylist.size(); i++) {

                                DistrictList data = citylist.get(i);

                                if (sharedPrefrenceUtil.getcityitem().equals(data.getDistrictName())) {
                                    spinner_city.setSelection(i);
                                    break;
                                }
                            }
                        }
                        //list.setAdapter(customAdatorr)
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                        Log.e("response", "" + response.body());

                    } else {
                    }

                } else {
                    // Toast.makeText(getActivity(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                //  Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class CityAdapter extends BaseAdapter implements SpinnerAdapter {

        private final Context activity;

        String value_beat;


        private List<DistrictList> asr;

        public CityAdapter(Context context, List<DistrictList> asr) {
            this.asr = asr;
            activity = context;
        }

        public int getCount() {
            return asr.size();
        }

        public Object getItem(int i) {
            return asr.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }


        @Override

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            }
            TextView textView = convertView.findViewById(R.id.text);
            textView.setText(asr.get(position).getDistrictName());

            if (position == 0) {
                textView.setTextColor(Color.GRAY);

            } else {
                textView.setTextColor(Color.BLACK);

            }

            //Toast.makeText(getActivity(),asr.get(position).getPatternName(),Toast.LENGTH_SHORT).show();
            return convertView;


        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getDistrictName());
            textView.setTextColor(Color.GRAY);
            //st= asr.get(i).getBeatCode();
            // Toast.makeText(getActivity(),st,Toast.LENGTH_SHORT).show();
            //  list=(ListView) view1.findViewById(R.id.list_item);
            // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            //  linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
            // recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
            //sendBeatData();
            return view1;
        }
    }


    private void sendStateData() {
        id = sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id, sharedPrefrenceUtil.getLangApi());
        Call<StateResponse> call = mapiClinet.dostate(machineryrequest);
        call.enqueue(new Callback<StateResponse>() {

            @Override
            public void onResponse(Call<StateResponse> call, Response<StateResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        StateResponse retailerBeatResponse = response.body();
                        List<StateList> temList = retailerBeatResponse.getStateList();


//                        StateList stateModel = new StateList();
//                        stateModel.setStateName(getResources().getString(R.string.Select_State));
//                        statelist.add(stateModel);

                        statelist.addAll(temList);


                        sharedPrefrenceUtil.setStateList(retailerBeatResponse);

                        StateAdapter adapter = new StateAdapter(getActivity(), statelist);
                        spinner_state.setAdapter(adapter);

                        if (!sharedPrefrenceUtil.getstateitem().isEmpty()) {
                            for (int i = 0; i < statelist.size(); i++) {

                                StateList data = statelist.get(i);

                                if (sharedPrefrenceUtil.getstateitem().equals(data.getStateName())) {
                                    spinner_state.setSelection(i);
                                    break;
                                }
                            }
                        }

                        //list.setAdapter(customAdatorr)
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                        Log.e("response", "" + response.body());

                    } else {
                    }

                } else {
                    // Toast.makeText(getActivity(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<StateResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                // Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


   /* public void sendCheckBoxData(CheckBox checkBox) {

       SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getActivity());
       sharedPrefrenceUtil.setCheckMachine(machinedata);


    }*/

    public class StateAdapter extends BaseAdapter implements SpinnerAdapter {

        private final Context activity;

        String value_beat;


        private List<StateList> state_namee;

        public StateAdapter(Context context, List<StateList> state_namee) {

            this.state_namee = state_namee;
            activity = context;
        }

        public int getCount() {
            return state_namee.size();
        }

        public Object getItem(int i) {
            return state_namee.get(i);
        }

        public long getItemId
                (int i) {
            return (long) i;
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            }
           TextView textView = convertView.findViewById(R.id.text);
            textView.setText(state_namee.get(position).getStateName());


            if (position == 0) {
                textView.setTextColor(Color.GRAY);

            } else {
                textView.setTextColor(Color.BLACK);

            }
            //state_name=state_namee.get(position).getStateId();
            // Toast.makeText(getActivity(),state_name,Toast.LENGTH_SHORT).show();
            //Toast.makeText(getActivity(),asr.get(position).getPatternName(),Toast.LENGTH_SHORT).show();


            return convertView;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);

            TextView textView = view1.findViewById(R.id.text);
            textView.setText(state_namee.get(i).getStateName());
            state_name = state_namee.get(i).getStateId();
            statenamevalidation = state_namee.get(i).getStateName();

            textView.setTextColor(Color.GRAY);

            return view1;
        }
    }

public void  FocusChangeError(){
    adhar_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

            if(!hasFocus){
                //this if condition is true when edittext lost focus...
                //check here for number is larger than 10 or not
                if (adhar_number.getText().length()<12){
                    adhar_number.setTextColor(Color.RED);
                    adhar_number.setError("please enter valid aadhar number");
                }else{
                    adhar_number.setTextColor(Color.BLACK);
                }
            }
        }
    });


    farmer_wmobileno.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

            if(!hasFocus){
                //this if condition is true when edittext lost focus...
                //check here for number is larger than 10 or not
                if (farmer_wmobileno.getText().length()<10){
                    farmer_wmobileno.setTextColor(Color.RED);
                    farmer_wmobileno.setError("please enter valid phone number");
                }else{
                    farmer_wmobileno.setTextColor(Color.BLACK);
                }
            }
        }
    });

farmer_pincode.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

            if(!hasFocus){
                //this if condition is true when edittext lost focus...
                //check here for number is larger than 10 or not
                if (farmer_pincode.getText().length()<6){
                    farmer_pincode.setTextColor(Color.RED);
                    farmer_pincode.setError("please enter pin code");
                }else{
                    farmer_pincode.setTextColor(Color.BLACK);
                }
            }
        }
    });

farmer_emailid.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

            if(!hasFocus){
                //this if condition is true when edittext lost focus...
                //check here for number is larger than 10 or not
                if (!farmer_emailid.getText().toString().contains("@") ||!farmer_emailid.getText().toString().contains(".")||
                        farmer_emailid.getText().toString().contains(" ")){
                    farmer_emailid.setTextColor(Color.RED);
                    farmer_emailid.setError("please enter valid Email Account");
                }else{
                    farmer_emailid.setTextColor(Color.BLACK);
                }
            }
        }
    });


}



    public class AsyncTaskLoadImageCertificate  extends AsyncTask<String, String, Bitmap> {
        private final static String TAG = "AsyncTaskLoadImage";
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
                Uri tempUri = getImageUri(context, bitmap);
                sharedPrefrenceUtil.setProfilePic(new File(getRealPathFromURI(tempUri)));
            } catch (IOException e) {
//                Log.e(TAG,e+"");
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (context.getContentResolver() != null) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }}
