package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.MainActivity;
import com.patanjali.pbri_new.adapter.HindiPersonalDeatilCustomAdpter;
import com.patanjali.pbri_new.adapter.YesIrrigationHindiCustomAdpter;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.CroppatternList;
import com.patanjali.pbri_new.model.InsectList;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.MachinaryList;
import com.patanjali.pbri_new.model.MachineryResponse;
import com.patanjali.pbri_new.model.RequestSaveFarmDetails;
import com.patanjali.pbri_new.model.ResponseIrrigationList;
import com.patanjali.pbri_new.model.ResponseSaveFarmDetails;
import com.patanjali.pbri_new.model.SaveMachineData;
import com.patanjali.pbri_new.model.SoilResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.internal.zzagz.runOnUiThread;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FarmDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FarmDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FarmDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FarmDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FarmDetailsFragment newInstance(String param1, String param2) {
        FarmDetailsFragment fragment = new FarmDetailsFragment();
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

 public static    LinearLayout agriculture1;
    ProgressDialog mprogressDialog;
    RelativeLayout myButton;
//    LinearLayout horiculture1;
//    RelativeLayout myhoriculturebutton;
public static  RelativeLayout livestock1;
    RelativeLayout mylivestockbutton;
    public static   RelativeLayout aquaculture1;
    RelativeLayout myaquaculturebutton;
    public static    LinearLayout farm_income1;
    RelativeLayout myfarmincomebutton;
    private static final int PLACE_PICKER_REQUEST = 2;
    private static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    private static final int CAMERA_REQUEST = 1;
    private final static int REQUEST_CHECK_SETTINGS_GPS = 100;

//    Bitmap photo;
//    TextView date_timee;
//    String date_time;




    EditText landholding, farmer_no_children;
//            EditText farmer_location;
    TextView irrigation_type;
//    Button change_location;
//    ImageView farmimage;
    Spinner farmer_soil;
    String selectedsoilname;
    RecyclerView recyclerView;
    List<CroppatternList> soildata;
    public ArrayList<String> yesirrigationserverdata = new ArrayList<>();
    List<InsectList> yesirrigationlist = new ArrayList<>();
    String id;
    CheckBox checkCrab,checkFish,checkPrown;
    CheckBox spinner_machinery, typeofmaincrop;
    public ArrayList<String> machinedata = new ArrayList<>();
    List<MachinaryList> messagess = new ArrayList<>();
    private void AlertDialogApi() {

        spinner_machinery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDiolog();


            }


        });
    }
    String farm_total_income,farm_total_investment,land_holding, agriculture_irrigation, beekeeping,sericulture,farm_irrigatedval,agriculture_machinery;
    String no_of_cows, no_of_goats, no_of_sheep, no_of_buffallow, no_of_poultry;
    String genderselecteditem;
    String no_of_prawn,no_of_fish,no_of_crab;
    Button btnCancelIncome,btnSaveAqua,btnCancelAqua,btnSaveIncome,btnOk,btnCancel,btnBack;

    Button save_farmerdetails,btnCancelLiveStock,btnSaveLiveStock;
    String[] males = new String[102];
    TextView etSheep,etCow,etBuffalo,etGoats,etPourtry,etFish,etCrab,etPrown;
    SharedPrefrenceUtil sharedPreferences;
    EditText farmer_totalinvestment,farmer_totalincome;
    LinearLayout llCrab,llCow,llPoultry,llGoat,llBuffalo,llSheep,llPrawn,llFish;
    Spinner spinner_cow,spinner_Sheep,spinner_Goat,spinner_Buffalo,spinner_Poultry,spinner_Prown,spinner_Fish,spinner_Crab;
    View view;
    ArrayAdapter cow_adapter;
    ArrayAdapter buff_adapter;
    ArrayAdapter poultry_adapter;
    ArrayAdapter sheep_adapter;
    ArrayAdapter goat_adapter;
    CheckBox cbSericulture,cbBeekeeping;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view=   inflater.inflate(R.layout.fragment_farm_details, container, false);
        declarations();

       context =getActivity();
        sharedPreferences = new SharedPrefrenceUtil(context);
        id= sharedPreferences.getResponseId();
        onBtnClick();

        if (MainActivity.Connetion(context)==true) {
            sendIrrigationData1();
            getMachinary();
            soilData();
        }
        else {
            getDataFromServer();
        }





        llCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_cow.performClick();
            }
        });
        llBuffalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_Buffalo.performClick();
            }
        });
        llGoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_Goat.performClick();
            }
        });

        llSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_Sheep.performClick();
            }
        });


        llPoultry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_Poultry.performClick();
            }
        });





        cbBeekeeping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

                if (isChecked) {
                    sharedPreferences.setBeekeeping("1");
                } else {
                    sharedPreferences.setBeekeeping("0");
                }
            }  });

  cbSericulture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

                if (isChecked) {
                    sharedPreferences.setSericulture("1");
                } else {
                    sharedPreferences.setSericulture("0");
                }
            }  });


//         Calendar call = Calendar.getInstance();
//        DateFormat dff = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
//        date_time = dff.format(call.getTime());
//        date_timee = (TextView) view.findViewById(R.id.date_timehindi);
//        farmimage = (ImageView) view.findViewById(R.id.farmimagehindi);
//        farmer_location = (EditText) view.findViewById(R.id.farmer_location);
//        change_location=(Button)view.findViewById(R.id.change_location);
//        Button camera= (Button)view.findViewById(R.id.camerahindi);
//        horiculture1=view.findViewById(R.id.horiculture1);
//        myhoriculturebutton=view.findViewById(R.id.horiculture);
//        camera.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (!checkCameraPermission()) {
//
//                    ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                    Manifest.permission.READ_EXTERNAL_STORAGE},
//                            REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
//                } else {
//
//                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
//
//                }
//            }
//        });


        if (MainActivity.Connetion(context)==false)

        {    runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                        alert.setMessage("No Internet Connection!!");
                        alert.setPositiveButton("OK", null);
                        alert.show();
                    }
                });
        }




        farmer_soil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {


                // Toast.makeText(getApplicationContext(),state_name,Toast.LENGTH_SHORT).show()
                selectedsoilname = soildata.get(po).getSoilName();
                sharedPreferences.sethindisoilselecteditem(selectedsoilname);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        spinner_cow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                etCow.setText(genderselecteditem);
                sharedPreferences.setCow(genderselecteditem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        spinner_Buffalo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                etBuffalo.setText(genderselecteditem);
                sharedPreferences.setbaffallow(genderselecteditem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });


        spinner_Goat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                etGoats.setText(genderselecteditem);
                sharedPreferences.setGoat(genderselecteditem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        spinner_Poultry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                etPourtry.setText(genderselecteditem);
                sharedPreferences.setPautry(genderselecteditem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        spinner_Sheep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                genderselecteditem = males[po];
                etSheep.setText(genderselecteditem);
                sharedPreferences.setSheep(genderselecteditem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        AlertDialogApi();
        SetAllFieldData();
        new AsyncTaskRunnerFeatured().execute((Void[]) null);
        getSharedPrefernceData();

        return view;
    }


    public void getSharedPrefernceData(){

//        if (!sharedPreferences.getCow().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getCow().equals(data)) {
//                    spinner_cow.setSelection(i);
//                    break;
//                }
//            }
//        }
//
// if (!sharedPreferences.getbaffallow().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getbaffallow().equals(data)) {
//                    spinner_Buffalo.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//if (!sharedPreferences.getSheep().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getSheep().equals(data)) {
//                    spinner_Sheep.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//if (!sharedPreferences.getPautry().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getPautry().equals(data)) {
//                    spinner_Poultry.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//if (!sharedPreferences.getGoat().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getGoat().equals(data)) {
//                    spinner_Goat.setSelection(i);
//                    break;
//                }
//            }
//        }


//if (!sharedPreferences.getFish().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];

//                if (sharedPreferences.getFish().equals(data)) {
//                    spinner_Fish.setSelection(i);
////                    break;
//                }
//            }


//        }


//if (!sharedPreferences.getPrown().isEmpty()) {
////            for (int i = 0; i < males.length; i++) {
////
////                String data = males[i];
////
////                if (sharedPreferences.getPrown().equals(data)) {
////                    spinner_Prown.setSelection(i);
////                    break;
////                }
////            }
//
//
//}


//if (!sharedPreferences.getCrab().isEmpty()) {
//            for (int i = 0; i < males.length; i++) {
//
//                String data = males[i];
//
//                if (sharedPreferences.getCrab().equals(data)) {
//                    spinner_Crab.setSelection(i);
//                    break;
//                }
//            }

//}


//        if (sharedPreferences.getCow() != null) {
//            etCow.setText(sharedPreferences.getCow());
//        }
//        if (sharedPreferences.getbaffallow() != null) {
//            etBuffalo.setText(sharedPreferences.getbaffallow());
//        }
//        if (sharedPreferences.getPautry() != null) {
//            etPourtry.setText(sharedPreferences.getPautry());
//        }
//        if (sharedPreferences.getGoat() != null) {
//            etGoats.setText(sharedPreferences.getGoat());
//        }
//        if (sharedPreferences.getSheep() != null) {
//            etSheep.setText(sharedPreferences.getSheep());
//        }
        if (sharedPreferences.getFish() != null) {
//            etFish.setText(sharedPreferences.getFish());
            if (sharedPreferences.getFish().equals("1")) {
                checkFish.setChecked(true);
            }
        }
        if (sharedPreferences.getPrown() != null) {
//            etPrown.setText(sharedPreferences.getPrown());
            if (sharedPreferences.getPrown().equals("1")) {
                checkPrown.setChecked(true);
            }
        }
        if (sharedPreferences.getCrab() != null) {
//            etCrab.setText(sharedPreferences.getCrab());
            if (sharedPreferences.getCrab().equals("1")) {
                checkCrab.setChecked(true);
            }

        }
         if (sharedPreferences.getLandholding() != null) {
             landholding.setText(sharedPreferences.getLandholding());
        }
          if (sharedPreferences.getTotalInvestmentCrop() != null) {
             farmer_totalinvestment.setText(sharedPreferences.getTotalInvestmentCrop());
        }
         if (sharedPreferences.getTotalIncomeCrop() != null) {
             farmer_totalincome.setText(sharedPreferences.getTotalIncomeCrop());
        }
         if (sharedPreferences.getBeekeeping() != null) {
             if (sharedPreferences.getBeekeeping().equals("1")){
                 cbBeekeeping.setChecked(true);
             }
        }
        if (sharedPreferences.getSericulture() != null) {
            if (sharedPreferences.getSericulture().equals("1")){
                cbSericulture.setChecked(true);
            }
        }



    }

    public void SaveData(){
        showLoadingDialog(context);
        String landHolding,soilType,irrigationStatus,irrigationValues,machinery,Cows,Goats,Buffalows,Prowns,Paultry,Sheep,Fish,Crab
                ,totalinvestment,totalincome;
        irrigationStatus=sharedPreferences.getirrigationseleteditem();
        landHolding=landholding.getText().toString();
        Cows=etCow.getText().toString();
        Goats=etGoats.getText().toString();
        Buffalows=etBuffalo.getText().toString();
//        Prowns=etPrown.getText().toString();
        Paultry=etPourtry.getText().toString();
        Sheep=etSheep.getText().toString();
//        Fish=etFish.getText().toString();
//        Crab=etCrab.getText().toString();
        totalinvestment=farmer_totalinvestment.getText().toString();
        totalincome=farmer_totalincome.getText().toString();
//        Log.e("irrigation values : ", String.valueOf(yesirrigationserverdata));
//        Log.e("machinary values : ", String.valueOf(machinedata));

        RequestSaveFarmDetails requestSaveFarmDetails=new RequestSaveFarmDetails(irrigationStatus,
                landHolding,  String.valueOf(machinedata),selectedsoilname,sharedPreferences.getBeekeeping(),String.valueOf(yesirrigationserverdata)
                ,totalincome,totalinvestment,id,"1",Buffalows,Cows,sharedPreferences.getCrab(),sharedPreferences.getFish(),
                Goats,Paultry,sharedPreferences.getPrown(), Sheep,sharedPreferences.getSericulture());


        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        mapiClinet.dopostfarmerdetails1(requestSaveFarmDetails).enqueue(new Callback<ResponseSaveFarmDetails>() {


            @Override
            public void onResponse(Call<ResponseSaveFarmDetails> call, Response<ResponseSaveFarmDetails> response) {
                hideLoading();
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Toast.makeText(getContext(), "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSaveFarmDetails> call, Throwable t) {
                hideLoading();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void hideLoading() {
        if (mprogressDialog != null && mprogressDialog.isShowing()) {
            mprogressDialog.cancel();
        }
    }
    public void showLoadingDialog(Context context) {
        mprogressDialog = new ProgressDialog(context);
        mprogressDialog.show();
        if (mprogressDialog.getWindow() != null) {
            mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        mprogressDialog.setContentView(R.layout.progress_layout);
        mprogressDialog.setIndeterminate(true);
//        mprogressDialog.setCancelable(false);
//        mprogressDialog.setCanceledOnTouchOutside(false);
    }



    public void alertDialogYesIrrigation() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_irrigation, null);
        dialogBuilder.setView(dialogView);


         recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);


        YesIrrigationHindiCustomAdpter adapter = new YesIrrigationHindiCustomAdpter(FarmDetailsFragment.this, yesirrigationlist);
        recyclerView.setAdapter(adapter);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);

        Button ok_button = dialogView.findViewById(R.id.button2);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yesirrigationserverdata.size() > 0) {
                    SaveMachineData diseasemodel = new SaveMachineData();
                    diseasemodel.setData(yesirrigationserverdata);
                    sharedPreferences.setCheckYesIrrigItem(diseasemodel);
                } else {
                    sharedPreferences.setCheckYesIrrigItem(null);
                }
                alertDialog.dismiss();

            }
        });
    }




    private void onBtnClick() {

        btnSaveLiveStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livestock1.setVisibility(View.GONE);
            }
        });
        btnCancelLiveStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livestock1.setVisibility(View.GONE);
            }
        });

         btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = getFragmentManager().findFragmentById(R.id.container);

                if (f instanceof FarmDetailsFragment) {

                    getFragmentManager().beginTransaction().remove(f).commit();

                }
            }
        });


        irrigation_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder2=new AlertDialog.Builder(context);
                builder2.setMessage(getResources().getString(R.string.please_select_irrigation_status));
                builder2.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        alertDialogYesIrrigation();

                        irrigation_type.setText(getResources().getString(R.string.irrigation_status_yes));

                        sharedPreferences.setirrigationseleteditem(getResources().getString(R.string.irrigation_status_yes));

                    }

                });

                builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {


                        irrigation_type.setText(getResources().getString(R.string.irrigation_status_no));
                        sharedPreferences.setirrigationseleteditem(getResources().getString(R.string.irrigation_status_no));
                    }

                });

                builder2.show();


            }
        });


        save_farmerdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agriculture1.setVisibility((agriculture1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);



            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agriculture1.setVisibility((agriculture1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });
         btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agriculture1.setVisibility((agriculture1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

        btnCancelIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farm_income1.setVisibility((farm_income1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

 btnSaveIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farm_income1.setVisibility((farm_income1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });
        btnCancelAqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aquaculture1.setVisibility((aquaculture1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });
 btnSaveAqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aquaculture1.setVisibility((aquaculture1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

         poultry_adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                tv.setTextColor(Color.BLACK);
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };
 cow_adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                tv.setTextColor(Color.BLACK);
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };
 buff_adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                tv.setTextColor(Color.BLACK);
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };
 sheep_adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                tv.setTextColor(Color.BLACK);
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };
 goat_adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,males){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.GRAY);
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);
                tv.setTextColor(Color.BLACK);
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        spinner_cow.setAdapter(cow_adapter);
        spinner_Buffalo.setAdapter(buff_adapter);
        spinner_Sheep.setAdapter(sheep_adapter);
        spinner_Poultry.setAdapter(poultry_adapter);
        spinner_Goat.setAdapter(goat_adapter);

        etCow.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPreferences.setMale(etCow.getText().toString());
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) { }
        });
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void SetAllFieldData() {

        landholding.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPreferences.setLandholding(landholding.getText().toString());
           }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }
            @Override
            public void afterTextChanged(Editable arg0) { }
        });
    }



    private void getDataFromServer() {
        //Get soildata


        if (sharedPreferences.getHindiSoilList() != null) {
            soildata = sharedPreferences.getHindiSoilList().getCroppatternList();
            SoilAdapter soilAdapter = new SoilAdapter(context, soildata);
            farmer_soil.setAdapter(soilAdapter);
            if (!sharedPreferences.gethindisoilselecteditem().isEmpty()) {
                for (int i = 0; i < soildata.size(); i++) {
                    CroppatternList data = soildata.get(i);
                    if (sharedPreferences.gethindisoilselecteditem().equals(data.getSoilName())) {
                        farmer_soil.setSelection(i);
                        break;
                    }
                }
            }
        } else {
            soilData();
        }

        if (!sharedPreferences.getirrigationseleteditem().isEmpty()) {
            irrigation_type.setText(sharedPreferences.getirrigationseleteditem());

        }

        if (sharedPreferences.getIrrigationList() != null) {
            yesirrigationlist = sharedPreferences.getIrrigationList().getInsectList();
            if (sharedPreferences.getCheckYesIrrigItem() != null) {
                ArrayList<String> saveCheckedItem = sharedPreferences.getCheckYesIrrigItem().getData();
                yesirrigationserverdata.addAll(saveCheckedItem);
            }
        } else {
            sendIrrigationData1();
        }

        //MachineryData()
        if (sharedPreferences.getHindiMachineryItem() != null) {
            messagess = sharedPreferences.getHindiMachineryItem().getMachinaryList();
            if (sharedPreferences.getCheckMachineItem() != null) {
                spinner_machinery.setChecked(true);
                ArrayList<String> saveCheckedItem = sharedPreferences.getCheckMachineItem().getData();
                machinedata.addAll(saveCheckedItem);
            }
        } else {
            getMachinary();
        }

    }




//Getsoildata

    private void soilData() {
        final RelativeLayout gif1=view.findViewById(R.id.imgGif);
        gif1.setVisibility(View.VISIBLE);
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id);
        Call<SoilResponse> call = mapiClinet.doSoil(machineryrequest);
        call.enqueue(new Callback<SoilResponse>() {
            @Override
            public void onResponse(Call<SoilResponse> call, Response<SoilResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        SoilResponse retailerBeatResponse = response.body();

                        soildata = retailerBeatResponse.getCroppatternList();

                        CroppatternList croppatternList = new CroppatternList();
                        if (context != null) {
                            croppatternList.setSoilName(context.getResources().getString(R.string.soiltype));
                            soildata.add(0, croppatternList);
                            sharedPreferences.setHindiSoilList(retailerBeatResponse);
                            SoilAdapter adapter = new SoilAdapter(getContext(), soildata);
                            farmer_soil.setAdapter(adapter);
                            if (!sharedPreferences.getsoilselecteditem().isEmpty()) {
                                for (int i = 0; i < soildata.size(); i++) {
                                    CroppatternList data = soildata.get(i);
                                    if (sharedPreferences.getsoilselecteditem().equals(data.getSoilName())) {
                                        farmer_soil.setSelection(i);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<SoilResponse> call, Throwable t) {
                gif1.setVisibility(View.GONE);
            }
        });
    }

    public class SoilAdapter extends BaseAdapter implements SpinnerAdapter {

        private final Context activity;

        String value_beat;


        private List<CroppatternList> asr;

        public SoilAdapter(Context context, List<CroppatternList> asr) {
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
            textView.setText(asr.get(position).getSoilName());
            if (position == 0) {
                textView.setTextColor(Color.GRAY);

            } else {
                textView.setTextColor(Color.BLACK);

            }
            return convertView;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getSoilName());
            textView.setTextColor(Color.GRAY);
            return view1;
        }

    }


    private void alertDiolog() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_irrigation, null);
        dialogBuilder.setView(dialogView);

        RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        HindiPersonalDeatilCustomAdpter adapter = new HindiPersonalDeatilCustomAdpter(FarmDetailsFragment.this, messagess);
        recyclerView.setAdapter(adapter);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);

        Button ok_button = dialogView.findViewById(R.id.button2);
        //Button cancel_button = dialogView.findViewById(R.id.button3);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (machinedata.size() > 0) {

                    spinner_machinery.setChecked(true);

                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(machinedata);

                    sharedPreferences.setCheckMachineItem(dataModel);

                } else {

                    spinner_machinery.setChecked(false);
                    sharedPreferences.setCheckMachineItem(null);

                }

                alertDialog.dismiss();

            }
        });

    }



    //GetMachinaryApi(IrrigationData)


    public void getMachinary() {
//       showLoadingDialog(context);
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id);
        Call<MachineryResponse> call = mapiClinet.doMachinery(machineryrequest);
        call.enqueue(new Callback<MachineryResponse>() {

            @Override
            public void onResponse(Call<MachineryResponse> call, Response<MachineryResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        MachineryResponse retailerBeatResponse = response.body();
                        messagess = retailerBeatResponse.getMachinaryList();
                        sharedPreferences.setHindiMachineryItem(retailerBeatResponse);
                    }
                }
//            hideLoading();
            }

            @Override
            public void onFailure(Call<MachineryResponse> call, Throwable t) {
//                hideLoading();
            }
        });
    }



    public void sendIrrigationData1() {

       final RelativeLayout gif1=view.findViewById(R.id.imgGif);
        gif1.setVisibility(View.VISIBLE);
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id);
        Call<ResponseIrrigationList> call = mapiClinet.doyesirrigation1(machineryrequest);
        call.enqueue(new Callback<ResponseIrrigationList>() {

            @Override
            public void onResponse(Call<ResponseIrrigationList> call, Response<ResponseIrrigationList> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        ResponseIrrigationList retailerBeatResponse = response.body();
                        yesirrigationlist = retailerBeatResponse.getInsectList();
                            sharedPreferences.setIrrigationList(retailerBeatResponse);
                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseIrrigationList> call, Throwable t) {
                gif1.setVisibility(View.GONE);
            }
        });
    }

//



    class AsyncTaskRunnerFeatured extends AsyncTask<Void,Void,Void> {
        InputStream inpts;
        String result,line;
        JSONArray jsonArray;
        RelativeLayout gif1=view.findViewById(R.id.imgGif);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            gif1.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
                try {

                    landholding.setText(land_holding);
                    farmer_totalinvestment.setText(farm_total_investment);
                    farmer_totalincome.setText(farm_total_income);
                    etCow.setText(no_of_cows);
                    etBuffalo.setText(no_of_buffallow);
                    etSheep.setText(no_of_sheep);
                    etPourtry.setText(no_of_poultry);
                    etGoats.setText(no_of_goats);
                    sharedPreferences.setIrrigation(agriculture_irrigation);
                    sharedPreferences.setLandholding(land_holding);
                    sharedPreferences.setNoOfIrrigation(farm_irrigatedval);
                    sharedPreferences.setCow(no_of_cows);
                    sharedPreferences.setGoat(no_of_goats);
                    sharedPreferences.setbaffallow(no_of_buffallow);
                    sharedPreferences.setPautry(no_of_poultry);
                    sharedPreferences.setSheep(no_of_sheep);
                    sharedPreferences.setTotalInvestmentCrop(farm_total_investment);
                    sharedPreferences.setTotalIncomeCrop(farm_total_income);
                    sharedPreferences.setLandholding(land_holding);

                    for (int i = 0; i <= 101; i++) {
                        if (i<=100)
                        males[i] = i + "";
                        else
                            males[i] =  getResources().getString(R.string.morethan100);

                        String genderselected = males[i];


                        if (genderselected.equals(sharedPreferences.getCow())) {
                            spinner_cow.setSelection(i);
                        }
                        if (genderselected.equals(sharedPreferences.getbaffallow())) {
                            spinner_Buffalo.setSelection(i);
                        }
                        if (genderselected.equals(sharedPreferences.getSheep())) {
                            spinner_Sheep.setSelection(i);
                        }
                        if (genderselected.equals(sharedPreferences.getGoat())) {
                            spinner_Goat.setSelection(i);
                        }
                        if (genderselected.equals(sharedPreferences.getPautry())) {
                            spinner_Poultry.setSelection(i);
                        }
                    }


//                    etCrab.setText(no_of_crab);
//                    etFish.setText(no_of_fish);
//                    etPrown.setText(no_of_prawn);
//                    sharedPreferences.setFish(no_of_fish);
//                    sharedPreferences.setPrown(no_of_prawn);
//                    sharedPreferences.setCrab(no_of_crab);

                    if (sharedPreferences.getFish().equals("1"))
                        checkFish.setChecked(true);
                   if (sharedPreferences.getCrab().equals("1"))
                        checkCrab.setChecked(true);
                   if (sharedPreferences.getPrown().equals("1"))
                        checkPrown.setChecked(true);




                } catch (Exception e) {
                    Log.e("Exception ", e.getMessage());
                }
            gif1.setVisibility(View.GONE);
        }



        @Override
        protected Void doInBackground(Void... params) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                    HttpResponse response;
//

                    try {
                        HttpPost post = new HttpPost("http://1.6.145.44/farmers_project/index.php/Farmer_data/farmerdetailsByid");
                        JSONObject userJson = new JSONObject();
                        userJson.put("farmer_id", id);
                        userJson.put("lang", sharedPreferences.getLangApi());

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
                        JSONArray jsonArray= jsonObject2.getJSONArray("farm_details");
                        JSONObject jsonObject1=new JSONObject();
                        JSONObject jsonObject3= jsonObject2.getJSONObject("livestocks");
                        JSONObject jsonObject4= jsonObject2.getJSONObject("aquaculture");
//                        jsonArray= jsonObjectMain.getJSONArray("cost_list");
//                        Log.e("jsonArray ",jsonArray+"");

//                        if(jsonArray!=null && jsonArray.length()>0) {

//                            for (int i = 0; i < 1; i++) {
                            jsonObject1 = jsonArray.getJSONObject(0);


                            land_holding = jsonObject1.getString("agriculture_landholding");
                        farm_total_investment = jsonObject1.getString("farm_total_investment");
                        farm_total_income = jsonObject1.getString("farm_total_income");
//
//
                            agriculture_irrigation = jsonObject1.getString("agriculture_irrigation");
                        farm_irrigatedval = jsonObject1.getString("farm_irrigatedval");
                        sericulture = jsonObject1.getString("sericulture");
                        beekeeping = jsonObject1.getString("beekeeping");

                        no_of_cows = jsonObject3.getString("no_of_cows");


                        no_of_goats = jsonObject3.getString("no_of_goats");

                        no_of_buffallow = jsonObject3.getString("no_of_buffallow");

                        no_of_poultry = jsonObject3.getString("no_of_poultry");

                        no_of_sheep = jsonObject3.getString("no_of_sheep");

                        no_of_fish = jsonObject4.getString("no_of_fish");
                        no_of_crab = jsonObject4.getString("no_of_crab");
                        no_of_prawn = jsonObject4.getString("no_of_prawn");

                        sharedPreferences.setBeekeeping(beekeeping);
                        sharedPreferences.setSericulture(sericulture);
                        sharedPreferences.setFish(no_of_fish);
                        sharedPreferences.setCrab(no_of_crab);
                        sharedPreferences.setPrown(no_of_prawn);



//                            if (agriculture_irrigation.equalsIgnoreCase("1")){
                                ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(farm_irrigatedval.split(",")));

                       for(int k=0;k<myList1.size();k++) {
//                           if (yesirrigationlist!=null)
//                               yesirrigationlist.clear();
                           String s=myList1.get(k);
                           yesirrigationserverdata.add(s);
                       }
//                        final YesIrrigationHindiCustomAdpter adapter = new YesIrrigationHindiCustomAdpter(FarmDetailsFragment.this, yesirrigationlist);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                recyclerView.setAdapter(adapter);
//                            }
//                        });

//                        SaveMachineData diseasemodel = new SaveMachineData();
//                        diseasemodel.setData(yesirrigationserverdata);
//
//                        sharedPreferences.setCheckYesIrrigItem(diseasemodel);

                        agriculture_machinery = jsonObject1.getString("agriculture_machinery");
                        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(agriculture_machinery.split(",")));

                        SaveMachineData saveMachineData = new SaveMachineData();
                        machinedata=myList;
                        saveMachineData.setData(myList);

                        sharedPreferences.setCheckMachineItem(saveMachineData);


                    } catch(JSONException e) {
                        e.printStackTrace();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                               }


            return null;
        }
    }




public void declarations(){
    agriculture1=view.findViewById(R.id.agriculture1);
    btnOk=view.findViewById(R.id.btnOk);
    btnCancel=view.findViewById(R.id.btnCancel);
    btnBack=view.findViewById(R.id.btnBack);
    btnSaveLiveStock=view.findViewById(R.id.btnSaveLiveStock);
    btnCancelLiveStock=view.findViewById(R.id.btnCancelLiveStock);
    btnCancelIncome=view.findViewById(R.id.btnCancelIncome);
    btnSaveIncome=view.findViewById(R.id.btnOkIncome);
    btnCancelAqua=view.findViewById(R.id.btnCancelAqua);
    btnSaveAqua=view.findViewById(R.id.btnOkAqua);

    landholding=(EditText)view.findViewById(R.id.landholding);
    farmer_soil = (Spinner) view.findViewById(R.id.farmer_soil);
    irrigation_type=(TextView)view.findViewById(R.id.irrigation_type);
    spinner_machinery = (CheckBox) view.findViewById(R.id.spinner_machinery);
    farmer_totalinvestment =  view.findViewById(R.id.farmer_totalinvestment);
    farmer_totalincome =  view.findViewById(R.id.farmer_totalincome);
    save_farmerdetails =  view.findViewById(R.id.save_farmerdetails);

    spinner_cow=view.findViewById(R.id.spinner_cow);
    spinner_Sheep=view.findViewById(R.id.spinner_Sheep);
    spinner_Goat=view.findViewById(R.id.spinner_Goat);
    spinner_Buffalo=view.findViewById(R.id.spinner_Buffalo);
    spinner_Poultry=view.findViewById(R.id.spinner_Poultry);
//    spinner_Prown=view.findViewById(R.id.spinner_Prown);
//    spinner_Fish=view.findViewById(R.id.spinner_Fish);
//    spinner_Crab=view.findViewById(R.id.spinner_Crab);


    etSheep=view.findViewById(R.id.etSheep);
    etPourtry=view.findViewById(R.id.etPourtry);
    etCow=view.findViewById(R.id.etCow);
    etBuffalo=view.findViewById(R.id.etBuffalo);
    etGoats=view.findViewById(R.id.etGoats);
    etFish=view.findViewById(R.id.etFish);
    etPrown=view.findViewById(R.id.etPrown);
    etCrab=view.findViewById(R.id.etCrab);
    checkFish=view.findViewById(R.id.checkFish);
    checkPrown=view.findViewById(R.id.checkPrown);
    checkCrab=view.findViewById(R.id.checkCrab);




    llCrab=view.findViewById(R.id.llCrab);
    llCow=view.findViewById(R.id.llCow);
    llPoultry=view.findViewById(R.id.llPoultry);
    llGoat=view.findViewById(R.id.llGoat);
    llBuffalo=view.findViewById(R.id.llBuffalo);
    llPrawn=view.findViewById(R.id.llPrawn);
    llFish=view.findViewById(R.id.llFish);
    llSheep=view.findViewById(R.id.llSheep);

    myButton=view.findViewById(R.id.agriculture);

    livestock1=view.findViewById(R.id.livestock1);
    mylivestockbutton=view.findViewById(R.id.livestock);
    aquaculture1=view.findViewById(R.id.aquaculture1);
    myaquaculturebutton=view.findViewById(R.id.aquaculture);
    farm_income1=view.findViewById(R.id.farm_income1);
    myfarmincomebutton=view.findViewById(R.id.farm_income);

    cbBeekeeping=view.findViewById(R.id.cbBeekeeping);
    cbSericulture=view.findViewById(R.id.cbSericulture);


    checkCrab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub

            if (isChecked) {
                sharedPreferences.setCrab("1");
            } else {
                sharedPreferences.setCrab("0");
            }
        }  });

    checkFish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub

            if (isChecked) {
                sharedPreferences.setFish("1");
            } else {
                sharedPreferences.setFish("0");
            }
        }  });

    checkPrown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub

            if (isChecked) {
                sharedPreferences.setPrown("1");
            } else {
                sharedPreferences.setPrown("0");
            }
        }  });


    mylivestockbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            livestock1.setVisibility((livestock1.getVisibility() == View.VISIBLE)
                    ? View.GONE : View.VISIBLE);
        }
    });
  myaquaculturebutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            aquaculture1.setVisibility((aquaculture1.getVisibility() == View.VISIBLE)
                    ? View.GONE : View.VISIBLE);
        }
    });
  myfarmincomebutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            farm_income1.setVisibility((farm_income1.getVisibility() == View.VISIBLE)
                    ? View.GONE : View.VISIBLE);
        }
    });




}




}
