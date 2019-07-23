package com.patanjali.pbri_new.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.FilePath;
import com.patanjali.pbri_new.MyApplication;
import com.patanjali.pbri_new.NetworkUtility;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.Home;
import com.patanjali.pbri_new.activity.MainActivity;
import com.patanjali.pbri_new.activity.VerifyOTP;
import com.patanjali.pbri_new.adapter.FarmBookAdapter;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.CropType;
import com.patanjali.pbri_new.model.CroppatternList;
import com.patanjali.pbri_new.model.LabList;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.OTPVerifyRequest;
import com.patanjali.pbri_new.model.OTPVerifyResponse;
import com.patanjali.pbri_new.model.PatternList;
import com.patanjali.pbri_new.model.RequestFarmBook;
import com.patanjali.pbri_new.model.RequestGetFarmLab;
import com.patanjali.pbri_new.model.RequestLoactionAndSoil;
import com.patanjali.pbri_new.model.ResponseGetFarmLab;
import com.patanjali.pbri_new.model.ResponseLocationAndSoil;
import com.patanjali.pbri_new.model.ResponseUpdateFarmBook;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model.SoilResponse;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsRequest;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsResponse;
import com.patanjali.pbri_new.model1.CropsInfo;
import com.patanjali.pbri_new.model1.LabListGetResponse;
import com.patanjali.pbri_new.model1.ListFarmBook;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.model1.OthersPestisidesRequest;
import com.patanjali.pbri_new.model1.OthersSoilTypeRequest;
import com.patanjali.pbri_new.model1.RequestGetFarmBook;
import com.patanjali.pbri_new.model1.ResponseGetFarmBook;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.patanjali.pbri_new.service.LocationMotironingService;
import com.patanjali.pbri_new.service.SingletonClass;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.LOCATION_SERVICE;
import static com.patanjali.pbri_new.activity.LoginActivity.LOCATION_REQUEST;
import static com.patanjali.pbri_new.fragments.FarmLabHome.farm_lab_type;
import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type;
import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type_pbri;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FarmLabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FarmLabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmLabFragment extends Fragment implements View.OnClickListener , LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FarmLabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FarmLabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FarmLabFragment newInstance(String param1, String param2) {
        FarmLabFragment fragment = new FarmLabFragment();
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

    ImageView imgClose,imgClose1;
    LocalBroadcastManager manager;
    BroadcastReceiver loactonReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
try {
    if (sharedPrefrenceUtil.getFarmLabID().equals("") || sharedPrefrenceUtil.getFarmLabID() == null) {

try {
    Geocoder geocoder;
    List<Address> addresses;
    geocoder = new Geocoder(context, Locale.getDefault());

    addresses = geocoder.getFromLocation(SingletonClass.getInstance().getLatitude(), SingletonClass.getInstance().getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

    farm_lab_address.setText(address);
}catch (Exception e){}
farmer_location.setText(SingletonClass.getInstance().getLatitude() + "," + SingletonClass.getInstance().getLongitude());
        sharedPrefrenceUtil.setlatLang(SingletonClass.getInstance().getLatitude() + "," + SingletonClass.getInstance().getLongitude());
        manager.unregisterReceiver(loactonReceiver);
    }


}catch (Exception e){}
        }
    };
    GoogleApiClient mLocationClient;

    public void initiateLocationClient() {
        mLocationClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mLocationClient.connect();
    }

    List<PatternList> monocroppinglist;
    String selectmonocropping,selectedsoilname;
    List<CroppatternList> soildata;
    EditText soilcollection_date,landmark,farm_lab_address,farmer_location;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    Spinner farmer_croppingpattern_monocropping,cropseason,farmer_soil;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    String selectedcropseasonitem;
    Button btnSaveDataCollection,btnSaveSoil,btnSaveLoc,btnCancelLoc,btnCancelSoil;
    String id,farmlab_ID;

    private static final int CAMERA_REQUEST = 1;
    private static final int CAMERA_REQUEST1 = 11;
    private static final int CAMERA_REQUEST2 = 21;
    LocationManager locationManager;
    private final static int REQUEST_CHECK_SETTINGS_GPS = 100;
    private static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
  public  static   ImageView farmimage,imageAttached;
    Bitmap photo;
    TextView date_timee;
    String date_time;
    File mImageFile,mImageFile1,mImageFile2;
    private static final int PLACE_PICKER_REQUEST = 2;
    Button change_location;
    public  static RelativeLayout rel_layout_Lang,rel_layout_Lang1;

   public static EditText etNitrogen,etSoilPH,etPotassium,etPhosphorus,etOrganicSoil;
    String click="";
    Button btnMedium,btnLow,btnHigh,btnMedium1,btnLow1,btnHigh1;
    RelativeLayout location,soiltest;
    Location locationGPS;
   public static LinearLayout location1,soiltest1;
    View view;
    public  static ImageView imgText,imgLink,imgPdf;
   public static RelativeLayout RLaddBook, farm_lab_book1,cropInfo,farm_lab_book,data_collection,cropInfo1;
    LinearLayout data_collection1;
    Button btnCancelBook;
    Double lat,lang;
    ProgressDialog progressDialog,mprogressDialog;
    LinearLayout llAttachment;
  public  static   EditText etComplaint;
    public  static  Button btnSaveBook,btnAddNewFarmBook;
    public  static   TextView txtattachmentPath,txtfilePath,txtTitle;
    ImageView imgBack;
    Context context;
    List<CropsInfo> cropsInfo;
    RecyclerView recycler_view;
    public static RelativeLayout frame_layout_others;
    EditText edOthers;
    Button btnSaveOthers;

     RadioButton radioButtonChemicalYes,radioButtonChemicalNo,radioButtonOrganicNo,radioButtonOrganicYes;
     LinearLayout btnCostBenefits, llCertificateAttachment,llOrganicCertificate;
     EditText edChemicalFree;
    RadioGroup radioGrpChemical,radioGrpOrganicCertificate;
  public static   String name,minTemp,MaxTemp,humidity,Country;
    RelativeLayout gif1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_farm_lab, container, false);
        context=getActivity();
        btnAddNewFarmBook=view.findViewById(R.id.btnAddNewFarmBook);
            gif1=view.findViewById(R.id.imgGif);
        btnCostBenefits = view.findViewById(R.id.btnCostBenefits);
        imgBack=view.findViewById(R.id.imgBack);
        RLaddBook=view.findViewById(R.id.RLaddBook);
        recycler_view=view.findViewById(R.id.recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        btnSaveOthers=view.findViewById(R.id.btnSaveOthers);
        edOthers=view.findViewById(R.id.edOthers);
        frame_layout_others=view.findViewById(R.id.frame_layout_others);
//        txtTitle=view.findViewById(R.id.txtTitle);



        btnSaveOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (edOthers.getText().toString().equals("")) {
                        Config.toast(context, "Please enter Soil Type");
                    } else {
                        SaveOtherSoilType();
                        frame_layout_others.setVisibility(View.GONE);
                    }
            }
        });


        recycler_view.setLayoutManager(mLayoutManager);

        btnAddNewFarmBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RLaddBook.setVisibility(View.VISIBLE);
                sharedPrefrenceUtil.setFarmBookID("0");
            }
        });
        btnCostBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.CallFragment4(context,new CostBenefits());
            }
        });

        if (context!=null)
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
         initiateLocationClient();
         mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
//         getDeviceLocation();
         startLocationService();
         getLocation();
        imgClose=view.findViewById(R.id.imgClose);
        imgClose1=view.findViewById(R.id.imgClose1);
        cropInfo=view.findViewById(R.id.cropInfo);
        data_collection=view.findViewById(R.id.data_collection);

        manager = LocalBroadcastManager.getInstance(context);
        manager.registerReceiver(loactonReceiver, new IntentFilter("loction_created"));



//        progressDialog=new ProgressDialog(context);
//        progressDialog.show();
//        progressDialog.setCancelable(false);
        declaration_location_SoilTest_farm_labBook();
        getFarmLabData();
        getFarmBookData();

//        declaration_crop_info();
//        declaration_Data_Collection();
//        getSelectedSpinnerValue();
         etNitrogen.setOnClickListener(this);
        etOrganicSoil.setOnClickListener(this);
        etPhosphorus.setOnClickListener(this);
        etSoilPH.setOnClickListener(this);
        etPotassium.setOnClickListener(this);
        btnHigh.setOnClickListener(this);
        btnHigh1.setOnClickListener(this);
        btnLow.setOnClickListener(this);
        btnLow1.setOnClickListener(this);
        btnMedium.setOnClickListener(this);
        btnMedium1.setOnClickListener(this);
        cropInfo.setOnClickListener(this);
        farm_lab_book.setOnClickListener(this);
        data_collection.setOnClickListener(this);

        onBtnClick();
        id= sharedPrefrenceUtil.getResponseId();

//       if (sharedPrefrenceUtil.getOneTime().equals("0")){
//           getFarmLabData();
//           sharedPrefrenceUtil.setOneTime("2");
//       } if (sharedPrefrenceUtil.getOneTime().equals("2")){
//            getFarmBookData();
//            sharedPrefrenceUtil.setOneTime("1");
//        }

//        getSharedPreferencesData();
//         getTextWatcher();

        GetCropInfoSize();
         Button camera= (Button)view.findViewById(R.id.camerahindi);
        camera.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkCameraPermission()) {

                    if (context!=null) {
                        ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                    }
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

 llAttachment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkCameraPermission()) {
                    if (context!=null) {
                        ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                    }
                } else {

                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("*/*");
//                    Intent cameraIntent = new Intent(android.provider.MediaStore);
                    startActivityForResult(intent, CAMERA_REQUEST1);

                }
            }
        });


        manager = LocalBroadcastManager.getInstance(context);
        manager.registerReceiver(loactonReceiver, new IntentFilter("loction_created"));


//        change_location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//                try {
//                    startActivityForResult(builder.build(context, PLACE_PICKER_REQUEST);
//                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
//                    e.printStackTrace();
//
//                }
//            }
//        });


        farmer_croppingpattern_monocropping.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {
                // Toast.makeText(getApplicationContext(),state_name,Toast.LENGTH_SHORT).show()
                selectmonocropping = monocroppinglist.get(po).getPatternName();
//                sharedPrefrenceUtil.setmonocroppingselecteditem(selectmonocropping);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });


        ArrayAdapter cropseasonn = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,
                context.getResources().getStringArray(R.array.CropSeason_value)){
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
        cropseason.setAdapter(cropseasonn);


        farmer_soil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {
                // Toast.makeText(getApplicationContext(),state_name,Toast.LENGTH_SHORT).show()
                selectedsoilname = soildata.get(po).getSoilName();
                sharedPrefrenceUtil.setsoilselecteditem(selectedsoilname);
                if (po==soildata.size()-1){
                    frame_layout_others.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

         cropseason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                 // Toast.makeText(getApplicationContext(),state_name,Toast.LENGTH_SHORT).show()
                 selectedcropseasonitem = getResources().getStringArray(R.array.CropSeason_value)[po];
                 //    Toast.makeText(getApplicationContext(), religionname,Toast.LENGTH_SHORT).show();
                 sharedPrefrenceUtil.setCropSeason(selectedcropseasonitem);

             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });
         farmer_croppingpattern_monocropping.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

                 // Toast.makeText(getApplicationContext(),state_name,Toast.LENGTH_SHORT).show()
                 selectmonocropping = monocroppinglist.get(po).getPatternName();
                 sharedPrefrenceUtil.setmonocroppingselecteditem(selectmonocropping);

             }


             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });


        soilcollection_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
              DatePickerDialog  picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                String date=dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                String date=year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
                                soilcollection_date.setText(date);
//                                sharedPrefrenceUtil.setSoilSampleCollection(date);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        if (MainActivity.Connetion(context)==false) {
            getDataFromServer();
        }
        else {
            sendCropType();
            soilData();
        }


        new AsyncTaskRunnerFeatured().execute((Void)null);


        return view;

    }
    public boolean checkCameraPermission() {


        int result1 = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
        int result2 = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result3 = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

        return result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
                && result3 == PackageManager.PERMISSION_GRANTED;

    }


    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {


        if (requestCode == CAMERA_REQUEST) {

            if (resultCode == RESULT_OK) {

                // Toast.makeText(context,"aaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();

                photo = (Bitmap) data.getExtras().get("data");

                farmimage.setImageBitmap(photo);
                Calendar call = Calendar.getInstance();
                DateFormat dff = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
                date_time = dff.format(call.getTime());

                date_timee.setText(date_time);

                //farmername.clearFocus();;

                sharedPrefrenceUtil.setDateTime(date_time);

                Uri tempUri = getImageUri(context, photo);

                // CALL THIS METHOD TO GET THE ACTUAL PATH
                 mImageFile = new File(getRealPathFromURI(tempUri));
//                Log.e("path ",mImageFile.getAbsolutePath()+" file "+mImageFile +" uri "+tempUri);

//                 sharedPrefrenceUtil.setImageFile(mImageFile);

                Toast.makeText(context, "Image Capture Successfully!", Toast.LENGTH_SHORT).show();
//                Log.e("path : ",getRealPathFromURI(tempUri)+ " tempUri "+tempUri);

                //System.out.println(mImageCaptureUri);

//                Bitmap immage = photo;
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                byte[] b = baos.toByteArray();
//             String   imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

//                sharedPrefrenceUtil.setName(imageEncoded);
            }
        }

     if (requestCode == CAMERA_REQUEST1) {

            if (resultCode == RESULT_OK) {
                try {
                    Uri selectedFileUri = data.getData();
                   File path = new File(FilePath.getPath(context, selectedFileUri));
//                    Log.i(TAG, "Selected File Path:" + path);

                    if (path != null && !path.equals("")) {

                        Toast.makeText(context, "Selected File Successfully", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context, "New" + path, Toast.LENGTH_SHORT).show();
                        txtfilePath.setText(path.getAbsolutePath());
                        mImageFile1=path;
                        sharedPrefrenceUtil.setAttachedFile(path);


                        try {
                                if (path.getAbsolutePath().contains(".jpg") || path.getAbsolutePath().contains(".png")) {
                                    Bitmap myBitmap = BitmapFactory.decodeFile(path.getAbsolutePath());
                                    imageAttached.setImageBitmap(myBitmap);
                                } else {
                                    imageAttached.setImageResource(R.drawable.pdf);
                                }

                        } catch (Exception e) {
                        }

                    }

                    else
                    {
                        Toast.makeText(context, "Cannot upload file to server", Toast.LENGTH_SHORT).show();
                    }


                       } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

 if (requestCode == CAMERA_REQUEST2) {

            if (resultCode == RESULT_OK) {
                try {
                    Uri selectedFileUri = data.getData();
                   File path = new File(FilePath.getPath(context, selectedFileUri));
//                    Log.i(TAG, "Selected File Path:" + path);

                    if (path != null && !path.equals("")) {

                        Toast.makeText(context, "Selected File Successfully", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(context, "New" + path, Toast.LENGTH_SHORT).show();

                        txtattachmentPath.setVisibility(View.VISIBLE);
                        txtattachmentPath.setText(path.getAbsolutePath());
                        mImageFile2=path;
//                        sharedPrefrenceUtil.setAttachedFile(path);
                    }

                    else
                    {
                        Toast.makeText(context, "Cannot upload file to server", Toast.LENGTH_SHORT).show();
                    }


                       } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }



        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == RESULT_OK) {

            final Place place = PlacePicker.getPlace(context, data);
            StringBuilder stBuilder = new StringBuilder();
            String placename = String.format("%s", place.getName());
            String latitude = String.valueOf(place.getLatLng().latitude);
            String longitude = String.valueOf(place.getLatLng().longitude);
            String address = String.format("%s", place.getAddress());
            stBuilder.append("Latitude: ");
            stBuilder.append(latitude);
            stBuilder.append("\n");
            stBuilder.append("Logitude: ");
            stBuilder.append(longitude);
            stBuilder.append("\n");
            stBuilder.append("Address: ");
            stBuilder.append(address);
            farmer_location.setText(stBuilder.toString());
        } else if (requestCode == REQUEST_CHECK_SETTINGS_GPS) {
            if (resultCode == RESULT_OK) {
                startLocationService();

            }



        }
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
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
    //GetCroppingPATTERN(MONOCROPPING)

    private void getDataFromServer() {

        if (sharedPrefrenceUtil.getCropPattern() != null) {
            monocroppinglist = sharedPrefrenceUtil.getCropPattern().getPatternList();

            CropTypeAdapter adapter = new CropTypeAdapter(context, monocroppinglist);
            farmer_croppingpattern_monocropping.setAdapter(adapter);

            if (!sharedPrefrenceUtil.getmonocroppingselecteditem().isEmpty()) {
                for (int i = 0; i < monocroppinglist.size(); i++) {

                    PatternList data = monocroppinglist.get(i);

                    if (new SharedPrefrenceUtil(context).getmonocroppingselecteditem().equals(data.getPatternName())) {
                        farmer_croppingpattern_monocropping.setSelection(i);
                        break;
                    }
                }
            }
        } else {
            sendCropType();
        }



        if (sharedPrefrenceUtil.getHindiSoilList() != null) {
            soildata = sharedPrefrenceUtil.getHindiSoilList().getCroppatternList();

            SoilAdapter soilAdapter = new SoilAdapter(context, soildata);
            farmer_soil.setAdapter(soilAdapter);

            if (!sharedPrefrenceUtil.getsoilselecteditem().isEmpty()) {
                for (int i = 0; i < soildata.size(); i++) {

                    CroppatternList data = soildata.get(i);

                    if (sharedPrefrenceUtil.getsoilselecteditem().equals(data.getSoilName())) {
                        farmer_soil.setSelection(i);
                        break;
                    }
                }
            }
        } else {
            soilData();
        }
    }



    private void soilData() {
        if (context != null){

       String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id,sharedPrefrenceUtil.getLangApi());

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
                        if (context!=null) {
                            croppatternList.setSoilName(context.getResources().getString(R.string.soiltype));
                            soildata.add(0, croppatternList);

                            CroppatternList croppatternList1 = new CroppatternList();
                            croppatternList1.setSoilName(context.getResources().getString(R.string.others));
                            soildata.add(soildata.size(), croppatternList1);

                            sharedPrefrenceUtil.setHindiSoilList(retailerBeatResponse);


                            SoilAdapter adapter = new SoilAdapter(context, soildata);
                            farmer_soil.setAdapter(adapter);

                            if (!sharedPrefrenceUtil.getsoilselecteditem().isEmpty()) {
                                for (int i = 0; i < soildata.size(); i++) {

                                    CroppatternList data = soildata.get(i);

                                    if (sharedPrefrenceUtil.getsoilselecteditem().equals(data.getSoilName())) {
                                        farmer_soil.setSelection(i);
                                        break;
                                    }
                                }
                            }
                            //list.setAdapter(customAdatorr)
                            // Toast.makeText(
                            //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                            Log.e("response", "" + response.body());
                        }
                    } else {
                    }

                } else {
                    // Toast.makeText(getApplicationContext(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<SoilResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                // Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
    private void onBtnClick() {

//         farmer_location.setText(SingletonClass.getInstance().getLatitude()+" "+SingletonClass.getInstance().getLongitude());

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location1.setVisibility((location1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);



            }
        });
        soiltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefrenceUtil.getFarmLabID().equals("") || sharedPrefrenceUtil.getFarmLabID() == null) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setMessage(R.string.save_farm_loc);
                    alert.setPositiveButton("OK", null);
                    alert.show();
                } else {
                    soiltest1.setVisibility((soiltest1.getVisibility() == View.VISIBLE)
                            ? View.GONE : View.VISIBLE);
                }

            }
        });


        cropInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefrenceUtil.getFarmLabID().equals("") || sharedPrefrenceUtil.getFarmLabID()==null)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setMessage(R.string.save_farm_loc);
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }else {
//                    cropInfo1.setVisibility((cropInfo1.getVisibility() == View.VISIBLE)
//                            ? View.GONE : View.VISIBLE);
                    if (context != null) {
//                        if (sharedPrefrenceUtil.getTotalCrops() > 0)
//                            Config.CallFragment3(context, new CropsList());
//                        else
                            Config.CallFragment2(context, new CropInfoFragment());
                    }
                }

            }
        });

        data_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context != null) {
                    if (sharedPrefrenceUtil.getFarmLabID().equals("") || sharedPrefrenceUtil.getFarmLabID() == null) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setMessage(R.string.save_farm_loc);
                        alert.setPositiveButton("OK", null);
                        alert.show();
                    } else {
                        data_collection1.setVisibility((data_collection1.getVisibility() == View.VISIBLE)
                                ? View.GONE : View.VISIBLE);
                    }
                }
            }
        });
 imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = getFragmentManager().findFragmentById(R.id.container);
                if (f instanceof FarmLabFragment) {
                    lab_type="no";
                    lab_type_pbri="no";
                    getFragmentManager().beginTransaction().remove(f).commit();
                }
            }
        });
imgClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_layout_others.getVisibility()==View.VISIBLE) {
                    frame_layout_others.setVisibility(View.GONE);
                }
            }
        });

        farm_lab_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context != null) {
                    if (sharedPrefrenceUtil.getFarmLabID().equals("") || sharedPrefrenceUtil.getFarmLabID() == null) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setMessage(R.string.save_farm_loc);
                        alert.setPositiveButton("OK", null);
                        alert.show();
                    } else {
                        farm_lab_book1.setVisibility((farm_lab_book1.getVisibility() == View.VISIBLE)
                                ? View.GONE : View.VISIBLE);
                    }
                }
            }
        });

        btnSaveLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String image=sharedPrefrenceUtil.getImageFile()+"";
//                if (image.equals("") || image==null
//                ||image.equals("null") ){
////                    if (imageURL.length()<10){
//                        Config.toast(context,"please capture farm lab Image");
//                    }else{

                if (context != null) {
                    if (landmark.getText().toString().equals("")) {
                        Config.toast(context, "please enter landmark");
                        landmark.setError("please enter landmark");
                    } else {
                        SaveLocationData();
                    }
                }
//                    }
//                }
//                else {
//                    Config.toast(context,image);
//                    location1.setVisibility(View.GONE);
//                }
            }
        });
   btnCancelLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              location1.setVisibility(View.GONE);
            }
        });
        btnCancelSoil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              soiltest1.setVisibility(View.GONE);
            }
        });

        btnSaveSoil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SaveSoilData();
                soiltest1.setVisibility(View.GONE);
            }
        });

     btnSaveBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (mImageFile1!=null)
                        SaveFarmBook();
                    else
                        postBook();
            }
        });


  btnCancelBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RLaddBook.setVisibility(View.GONE);

            }
        });


imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              farm_lab_book1.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etNitrogen:
                rel_layout_Lang.setVisibility(View.VISIBLE);
                click="nit";
                break;
            case R.id.etPhosphorus:
                rel_layout_Lang.setVisibility(View.VISIBLE);
                click="pho";
                break;
            case R.id.etPotassium:
                rel_layout_Lang.setVisibility(View.VISIBLE);
                click="pot";
                break;
       case R.id.etSoilPH:
                rel_layout_Lang1.setVisibility(View.VISIBLE);
           click="ph";
           break;
           case R.id.etOrganicSoil:
                rel_layout_Lang.setVisibility(View.VISIBLE);
           click="org";
           break;
       case R.id.btnMedium:
                if (click.equalsIgnoreCase("nit")){
                    etNitrogen.setText(btnMedium.getText().toString());
                    sharedPrefrenceUtil.setNitrogen(btnMedium.getText().toString());
                }
                 if (click.equalsIgnoreCase("pho")){
                    etPhosphorus.setText(btnMedium.getText().toString());
                     sharedPrefrenceUtil.setPhosphorous(btnMedium.getText().toString());
                 }
                if (click.equalsIgnoreCase("pot")){
                    etPotassium.setText(btnMedium.getText().toString());
                    sharedPrefrenceUtil.setPotassium(btnMedium.getText().toString());
                }
//                if (click.equalsIgnoreCase("ph")){
//                    etSoilPH.setText(btnMedium.getText().toString());
//                }
                  if (click.equalsIgnoreCase("org")){
                    etOrganicSoil.setText(btnMedium.getText().toString());
                      sharedPrefrenceUtil.setOrganicCarbon(btnMedium.getText().toString());
                  }
           rel_layout_Lang.setVisibility(View.GONE);

           break;
            case R.id.btnLow:

                if (click.equalsIgnoreCase("nit")){
                    etNitrogen.setText(btnLow.getText().toString());
                    sharedPrefrenceUtil.setNitrogen(btnLow.getText().toString());
                }
                if (click.equalsIgnoreCase("pho")){
                    etPhosphorus.setText(btnLow.getText().toString());
                    sharedPrefrenceUtil.setPhosphorous(btnLow.getText().toString());
                }
                if (click.equalsIgnoreCase("pot")){
                    etPotassium.setText(btnLow.getText().toString());
                    sharedPrefrenceUtil.setPotassium(btnLow.getText().toString());
                }
//                if (click.equalsIgnoreCase("ph")){
//                    etSoilPH.setText(btnLow.getText().toString());
//                }
                if (click.equalsIgnoreCase("org")){
                    etOrganicSoil.setText(btnLow.getText().toString());
                    sharedPrefrenceUtil.setOrganicCarbon(btnLow.getText().toString());
                }
                rel_layout_Lang.setVisibility(View.GONE);

                break;
            case R.id.btnHigh:
                if (click.equalsIgnoreCase("nit")){
                    etNitrogen.setText(btnHigh.getText().toString());
                    sharedPrefrenceUtil.setNitrogen(btnHigh.getText().toString());
                }
                if (click.equalsIgnoreCase("pho")){
                    etPhosphorus.setText(btnHigh.getText().toString());
                    sharedPrefrenceUtil.setPhosphorous(btnHigh.getText().toString());
                }
                if (click.equalsIgnoreCase("pot")){
                    etPotassium.setText(btnHigh.getText().toString());
                    sharedPrefrenceUtil.setPotassium(btnHigh.getText().toString());
                }
//                if (click.equalsIgnoreCase("ph")){
//                    etSoilPH.setText(btnHigh.getText().toString());
//                }
                if (click.equalsIgnoreCase("org")){
                    etOrganicSoil.setText(btnHigh.getText().toString());
                    sharedPrefrenceUtil.setOrganicCarbon(btnHigh.getText().toString());
                }
                rel_layout_Lang.setVisibility(View.GONE);

                break;

            case R.id.btnMedium1:

                if (click.equalsIgnoreCase("ph")){
                    etSoilPH.setText(btnMedium1.getText().toString());
                    sharedPrefrenceUtil.setPH(btnMedium1.getText().toString());
                }
                rel_layout_Lang1.setVisibility(View.GONE);

                break;
 case R.id.btnLow1:

                if (click.equalsIgnoreCase("ph")){
                    etSoilPH.setText(btnLow1.getText().toString());
                    sharedPrefrenceUtil.setPH(btnLow1.getText().toString());
                }
     rel_layout_Lang1.setVisibility(View.GONE);

                break;
 case R.id.btnHigh1:

                if (click.equalsIgnoreCase("ph")){
                    etSoilPH.setText(btnHigh1.getText().toString());
                    sharedPrefrenceUtil.setPH(btnHigh1.getText().toString());
                }
     rel_layout_Lang1.setVisibility(View.GONE);

                break;


        }

    }




    private void checkGpsProvider() {
        if (mLocationClient != null) {
            if (mLocationClient.isConnected()) {

                if (context != null) {
                    int permissionLocation = ContextCompat.checkSelfPermission(context,
                            Manifest.permission.ACCESS_FINE_LOCATION);

                    if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
                        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                            startLocationService();

                        } else {

                            LocationRequest locationRequest = new LocationRequest();
                            locationRequest.setInterval(8000);
                            locationRequest.setFastestInterval(6000);
                            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

                            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                                    .addLocationRequest(locationRequest);
                            builder.setAlwaysShow(true);

                            //LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

                            PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi
                                    .checkLocationSettings(mLocationClient, builder.build());
                            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {

                                @Override
                                public void onResult(LocationSettingsResult result) {

                                    final Status status = result.getStatus();
                                    switch (status.getStatusCode()) {
                                        case LocationSettingsStatusCodes.SUCCESS:
                                            // Log.d(TAG, "success provider");

                                            startLocationService();
                                            break;
                                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                            //Log.d(TAG, "success required");
                                            // Location settings are not satisfied.
                                            // But could be fixed by showing the user a dialog.
                                            try {
                                                // Show the dialog by calling startResolutionForResult(),
                                                // and check the result in onActivityResult().
                                                // Ask to turn on GPS automatically

                                               if (context!=null)
                                                   status.startResolutionForResult( getActivity(), REQUEST_CHECK_SETTINGS_GPS);
                                            } catch (IntentSender.SendIntentException e) {
                                                //  Log.d(TAG,"error 2");

                                                // Ignore the error.
                                            }
                                            break;
                                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                            //                                   Log.d(TAG, "success unavailble");
                                            // Location settings are not satisfied.
                                            // However, we have no way
                                            // to fix the
                                            // settings so we won't show the dialog.
                                            // finish();
                                            break;
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }


    }

    void startLocationService() {
        if (context != null)
            context.startService(new Intent(context, LocationMotironingService.class));
    }
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (context != null) {
            if (NetworkUtility.checkPermissions(context, new String[]
                    {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST)) {
                checkGpsProvider();
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public void getLocation() {
        try {
            if (context != null) {
                locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
                locationGPS = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (locationGPS != null) {
                    lat = locationGPS.getLatitude();
                    lang = locationGPS.getLongitude();
                } else {
                    startLocationService();
                }
            }
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        this.locationGPS=location;

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

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

            //  Toast.makeText(getApplicationContext(),asr.get(position).getSoilName(),Toast.LENGTH_SHORT).show();
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


    private void sendCropType() {
//final ProgressDialog  p=new ProgressDialog(context);
//p.show();
        final   RelativeLayout gif1=view.findViewById(R.id.imgGif1);
        if (!sharedPrefrenceUtil.getFarmLabID().equals("0"))
        gif1.setVisibility(View.VISIBLE);

        try {

    ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
    LanguageRequest machineryrequest = new LanguageRequest(id);

    Call<CropType> call = mapiClinet.docroptype(machineryrequest);
    call.enqueue(new Callback<CropType>() {

        @Override
        public void onResponse(Call<CropType> call, Response<CropType> response) {
            if (response.body() != null) {
                Boolean errCode = response.body().getStatus();

                if (errCode.equals(true)) {
                    CropType retailerBeatResponse = response.body();
                    monocroppinglist = retailerBeatResponse.getPatternList();
                    PatternList patternList = new PatternList();
                    if (context!=null) {
                        patternList.setPatternName(context.getResources().getString(R.string.cropPattern));
                        monocroppinglist.add(0, patternList);
                        sharedPrefrenceUtil.setCropPattern(retailerBeatResponse);
                        CropTypeAdapter adapter = new CropTypeAdapter(context, monocroppinglist);
                        farmer_croppingpattern_monocropping.setAdapter(adapter);

                        if (!sharedPrefrenceUtil.getmonocroppingselecteditem().isEmpty()) {
                            for (int i = 0; i < monocroppinglist.size(); i++) {
                                PatternList data = monocroppinglist.get(i);
                                if (sharedPrefrenceUtil.getmonocroppingselecteditem().equals(data.getPatternName())) {
                                    farmer_croppingpattern_monocropping.setSelection(i);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
//p.dismiss();
            gif1.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<CropType> call, Throwable t) {
            gif1.setVisibility(View.GONE);
            //  progressDoalog.dismiss();
            //Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
        }
    });
}catch (Exception e){
            gif1.setVisibility(View.GONE);
        }
    }

    public class CropTypeAdapter extends BaseAdapter implements SpinnerAdapter {

        private final Context activity;

        String value_beat;


        private List<PatternList> asr;

        public CropTypeAdapter(Context context, List<PatternList> asr) {
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
            textView.setText(asr.get(position).getPatternName());
            if (position == 0) {
                textView.setTextColor(Color.GRAY);

            } else {
                textView.setTextColor(Color.BLACK);

            }
            //Toast.makeText(getApplicationContext(),asr.get(position).getPatternName(),Toast.LENGTH_SHORT).show();
            return convertView;


        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getPatternName());
            textView.setTextColor(Color.GRAY);
            //st= asr.get(i).getBeatCode();
            // Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
            //  list=(ListView) view1.findViewById(R.id.list_item);
            // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            //  linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
            // recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
            //sendBeatData();
            return view1;
        }
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

    public  void declaration_location_SoilTest_farm_labBook(){
        farmer_croppingpattern_monocropping = (Spinner) view.findViewById(R.id.farmer_croppingpattern_monocropping);
        btnSaveLoc=view.findViewById(R.id.btnSaveLoc);
        btnCancelLoc=view.findViewById(R.id.btnCancelLoc);
        btnCancelSoil=view.findViewById(R.id.btnCancelSoil);
        btnSaveSoil=view.findViewById(R.id.btnSaveSoil);
        btnSaveDataCollection=view.findViewById(R.id.btnSaveDataCollection);
        date_timee=(TextView)view.findViewById(R.id.date_timehindi);
        cropseason = (Spinner) view.findViewById(R.id.cropseason);
        farmer_soil = (Spinner) view.findViewById(R.id.farmer_soil);
        soilcollection_date = (EditText) view.findViewById(R.id.soilcollection_date);
        sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
        farmer_location=(EditText)view.findViewById(R.id.farmer_location);
        farm_lab_address=(EditText)view.findViewById(R.id.farm_lab_address);
        landmark=(EditText)view.findViewById(R.id.landmark);
        farmimage = (ImageView) view.findViewById(R.id.farmimagehindi);
        imageAttached = (ImageView) view.findViewById(R.id.imageAttached);
        change_location=(Button)view.findViewById(R.id.change_location);
        rel_layout_Lang=view.findViewById(R.id.rel_layout_Lang);
        rel_layout_Lang1=view.findViewById(R.id.rel_layout_Lang1);
//        txtFileName=view.findViewById(R.id.txtFileName);

        etNitrogen=view.findViewById(R.id.etNitrogen);
        etPhosphorus=view.findViewById(R.id.etPhosphorus);
        etPotassium=view.findViewById(R.id.etPotassium);
        etOrganicSoil=view.findViewById(R.id.etOrganicSoil);
        etSoilPH=view.findViewById(R.id.etSoilPH);
        btnMedium=view.findViewById(R.id.btnMedium);
        btnLow=view.findViewById(R.id.btnLow);
        btnHigh=view.findViewById(R.id.btnHigh);
        btnMedium1=view.findViewById(R.id.btnMedium1);
        btnLow1=view.findViewById(R.id.btnLow1);
        btnHigh1=view.findViewById(R.id.btnHigh1);
        location=view.findViewById(R.id.location);
        location1=view.findViewById(R.id.location1);
        soiltest=view.findViewById(R.id.soiltest);
        soiltest1=view.findViewById(R.id.soiltest1);


        etNitrogen=view.findViewById(R.id.etNitrogen);
        etPotassium=view.findViewById(R.id.etPotassium);
        etPhosphorus=view.findViewById(R.id.etPhosphorus);
        etOrganicSoil=view.findViewById(R.id.etOrganicSoil);
        etSoilPH=view.findViewById(R.id.etSoilPH);


          farm_lab_book=view.findViewById(R.id.farm_lab_book);
        farm_lab_book1=view.findViewById(R.id.farm_lab_book1);

        imgText=view.findViewById(R.id.imgText);
        imgLink=view.findViewById(R.id.imgLink);
        imgPdf=view.findViewById(R.id.imgPdf);
        llAttachment=view.findViewById(R.id.llAttchment);
        etComplaint=view.findViewById(R.id.etComplain);
        btnSaveBook=view.findViewById(R.id.btnSaveBook);
        btnCancelBook=view.findViewById(R.id.btnCancelBook);
        txtfilePath=view.findViewById(R.id.txtfilePath);
        txtattachmentPath=view.findViewById(R.id.txtattachmentPath);


        radioButtonChemicalYes=view.findViewById(R.id.radioButtonChemicalYes);
        radioButtonChemicalNo=view.findViewById(R.id.radioButtonChemicalNo);
        radioButtonOrganicYes=view.findViewById(R.id.radioButtonOrganicYes);
        radioButtonOrganicNo=view.findViewById(R.id.radioButtonOrganicNo);
        llCertificateAttachment=view.findViewById(R.id.llCertificateAttachment);
        llOrganicCertificate=view.findViewById(R.id.llOrganicCertificate);
        edChemicalFree=view.findViewById(R.id.edChemicalFree);
        radioGrpChemical=view.findViewById(R.id.radioGrpChemical);
        radioGrpOrganicCertificate=view.findViewById(R.id.radioGrpOrganicCertificate);
        txtattachmentPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=txtattachmentPath.getText().toString();
                if (url.contains("http")) {
                    Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        radioGrpChemical.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                boolean isCheckedYes = radioButtonChemicalYes.isChecked();
                boolean isCheckedNo = radioButtonChemicalNo.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isCheckedYes)
                {
                    edChemicalFree.setVisibility(View.VISIBLE);
                    llOrganicCertificate.setVisibility(View.VISIBLE);
                    llCertificateAttachment.setVisibility(View.GONE);
                    boolean isChecked = radioButtonOrganicYes.isChecked();
                    if (isChecked){
                        llCertificateAttachment.setVisibility(View.VISIBLE);
                    }
              }
              if (isCheckedNo)
                {
                    edChemicalFree.setVisibility(View.GONE);
                    llOrganicCertificate.setVisibility(View.GONE);
              }
            }
        });

 radioGrpOrganicCertificate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                boolean isCheckedYes = radioButtonOrganicYes.isChecked();
                boolean isCheckedNo = radioButtonOrganicNo.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isCheckedYes)
                {
                    llCertificateAttachment.setVisibility(View.VISIBLE);
              }
                if (isCheckedNo)
                {
                    llCertificateAttachment.setVisibility(View.GONE);
              }
            }
        });



        llCertificateAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkCameraPermission()) {
                    if (context!=null) {
                        ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                    }
                } else {

                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("*/*");
//                    Intent cameraIntent = new Intent(android.provider.MediaStore);
                    startActivityForResult(intent, CAMERA_REQUEST2);

                }
            }
        });

        txtfilePath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtfilePath.getText().toString().equals("")) {
                    try {
                        Uri uri = Uri.parse(txtfilePath.getText().toString()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }catch (Exception e){}
                }
            }
        });
 imageAttached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtfilePath.getText().toString().equals("")) {
                   try{
                       Uri uri = Uri.parse(txtfilePath.getText().toString()); // missing 'http://' will cause crashed

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                   }catch (Exception e){}

                }
            }
        });

//        farmer_location.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                try {
//                    try {
//                        Geocoder geocoder;
//                        List<Address> addresses;
//                        geocoder = new Geocoder(context, Locale.getDefault());
//
//                        addresses = geocoder.getFromLocation(SingletonClass.getInstance().getLatitude(), SingletonClass.getInstance().getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//
//                        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//
//                        farm_lab_address.setText(address);
//                    }catch (Exception e){}
//                    farmer_location.setText(SingletonClass.getInstance().getLatitude() + "," + SingletonClass.getInstance().getLongitude());
//                    sharedPrefrenceUtil.setlatLang(SingletonClass.getInstance().getLatitude() + "," + SingletonClass.getInstance().getLongitude());
//                    manager.unregisterReceiver(loactonReceiver);
//
//                }catch (Exception e){}
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
    }


        public  void SaveLocationData(){
            final ProgressDialog progressDialoglocation=new ProgressDialog(context);
            progressDialoglocation.show();
            try {
            String checkChemical;
            String checkOrganic,chemicalfree;
            if (radioButtonChemicalYes.isChecked())
                checkChemical="yes";
            else {checkChemical="no";
                edChemicalFree.setText("");
            }
            if (radioButtonOrganicYes.isChecked())
                checkOrganic="yes";
            else checkOrganic="no";

             chemicalfree=edChemicalFree.getText().toString();

            String latlang, address,image, dateAndTime, landMark, seasonCrop, monocropingSelectedItem;
            latlang = farmer_location.getText().toString();
            address = farm_lab_address.getText().toString();
//            image = sharedPrefrenceUtil.getName();
            dateAndTime = date_timee.getText().toString();
            landMark = landmark.getText().toString();
            if (latlang == null && latlang.equals("null"))
                latlang = "1";
            seasonCrop = sharedPrefrenceUtil.getCropSeason();
            monocropingSelectedItem = sharedPrefrenceUtil.getmonocroppingselecteditem();

            RequestBody checkChemical1 = RequestBody.create(MediaType.parse("text/plain"), checkChemical);
            RequestBody checkOrganic1 = RequestBody.create(MediaType.parse("text/plain"), checkOrganic);
            RequestBody chemicalfree1 = RequestBody.create(MediaType.parse("text/plain"), chemicalfree);

            RequestBody latlang1 = RequestBody.create(MediaType.parse("text/plain"), latlang);
            RequestBody farm_lab_type1 = RequestBody.create(MediaType.parse("text/plain"), farm_lab_type);
            RequestBody address1 = RequestBody.create(MediaType.parse("text/plain"), address);
            RequestBody dateAndTime1 = RequestBody.create(MediaType.parse("text/plain"), dateAndTime);
            RequestBody landMark1 = RequestBody.create(MediaType.parse("text/plain"), landMark);
            RequestBody seasonCrop1 = RequestBody.create(MediaType.parse("text/plain"), seasonCrop);
            RequestBody monocropingSelectedItem1 = RequestBody.create(MediaType.parse("text/plain"), monocropingSelectedItem);
            RequestBody id1 = RequestBody.create(MediaType.parse("text/plain"), id);
            MultipartBody.Part profile_img1 = null,profile_img = null;

                try {
                    RequestBody requestBodyProfile = RequestBody.create(MediaType.parse("multipart/form-data"), mImageFile);
            profile_img = MultipartBody.Part.createFormData("image", mImageFile.getName(), requestBodyProfile);

                RequestBody requestBodyProfile1 = RequestBody.create(MediaType.parse("multipart/form-data"), mImageFile2);
                profile_img1 = MultipartBody.Part.createFormData("certificate_upload", mImageFile2.getName(), requestBodyProfile1);
            }catch (Exception e){}

            Call<ResponseLocationAndSoil> call;
            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            if ( sharedPrefrenceUtil.getFarmLabID().equals("") ||
                    sharedPrefrenceUtil.getFarmLabID()==null){
                call = mapiClinet.postFarmLabLocationFirst( id1, latlang1,address1, landMark1,
                        seasonCrop1, monocropingSelectedItem1, dateAndTime1,farm_lab_type1, profile_img,checkChemical1,
                        chemicalfree1,checkOrganic1,profile_img1);

//                Toast.makeText(context, "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID()+" add farm lab value "+sharedPrefrenceUtil.getAddFarmLab(), Toast.LENGTH_LONG).show();
            }else{
                RequestBody farmlab_id = RequestBody.create(MediaType.parse("text/plain"), sharedPrefrenceUtil.getFarmLabID());
               call = mapiClinet.postFarmLabLocation(farmlab_id, id1, latlang1,address1, landMark1,
                        seasonCrop1, monocropingSelectedItem1, dateAndTime1,farm_lab_type1, profile_img,checkChemical1,
                       chemicalfree1,checkOrganic1,profile_img1);
//                Toast.makeText(context, "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID()+" add farm lab value "+sharedPrefrenceUtil.getAddFarmLab(), Toast.LENGTH_LONG).show();

            }

            call.enqueue(new Callback<ResponseLocationAndSoil>() {
                @Override
                public void onResponse(Call<ResponseLocationAndSoil> call, Response<ResponseLocationAndSoil> response) {

//
                    hideLoading();
//                    Log.e("response", "" + response.body());
//                    Log.e("id ", "" + id);
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {
                            Config.toast(context, "SuccessFully Data Syc to Server");
                            ResponseLocationAndSoil responseLocationAndSoil = response.body();
                            try{
//                                if (responseLocationAndSoil.getFarmLabID()!=null || !responseLocationAndSoil.getFarmLabID().equals("null"))
                                if ( sharedPrefrenceUtil.getFarmLabID().equals("") ||
                                        sharedPrefrenceUtil.getFarmLabID()==null){
//                                    sharedPrefrenceUtil.setAddFarmLab("no");
                                    sharedPrefrenceUtil.setFarmLabID(responseLocationAndSoil.getFarmLabID());
//                                    Toast.makeText(context, "id " + id + " and farmlab id : " + sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();
                                    postFarmLabDataServer();
                                }
            }
            catch (Exception e){}

//                            Log.e("response", "" + response.body());

                        } else {
//
                            Toast.makeText(context, "Sucessfully Data Syc to Server", Toast.LENGTH_LONG).show();
                        }
                    }
//                    else {
//                        Toast.makeText(context,  response.body().getMessage(), Toast.LENGTH_LONG).show();
//                    }
                    //  showTaost(msg);

                    progressDialoglocation.dismiss();
                }

                @Override
                public void onFailure(Call<ResponseLocationAndSoil> call, Throwable t) {
//                    if (context!=null)
//                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    progressDialoglocation.dismiss();
                }
            });

        }catch (Exception e){}
        }


    public  void SaveSoilData() {
        if (context != null) {

            String soilType, SoilCollectionData, nitrogen, phosphorous, potassium, organicCarbon, soilPH;
//            latLong;
            soilType = sharedPrefrenceUtil.getsoilselecteditem();
            SoilCollectionData = soilcollection_date.getText().toString();
            nitrogen = etNitrogen.getText().toString();
            phosphorous = etPhosphorus.getText().toString();
            potassium = etPotassium.getText().toString();
            organicCarbon = etOrganicSoil.getText().toString();
            soilPH = etSoilPH.getText().toString();
//            latLong = farmer_location.getText().toString();
//
//            if (latLong == null && latLong.equals("null"))
//                latLong = "1";
            showLoadingDialog();


            RequestLoactionAndSoil requestLoactionAndSoil = new RequestLoactionAndSoil("1", sharedPrefrenceUtil.getFarmLabID(), id, organicCarbon,
                    soilPH, SoilCollectionData, nitrogen, phosphorous, potassium, soilType, farmer_location.getText().toString());
//        Toast.makeText(context, "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();

            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            mapiClinet.dopostfarmerdetails3(requestLoactionAndSoil).enqueue(new Callback<ResponseLocationAndSoil>() {
                @Override
                public void onResponse(Call<ResponseLocationAndSoil> call, Response<ResponseLocationAndSoil> response) {

                    hideLoading();
//                    Log.e("response", "" + response.body());
//                    Log.e("id ", "" + id);
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {
                            Toast.makeText(context, "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
                            Log.e("response", "" + response.body());

                        }
                    }

                }

                @Override
                public void onFailure(Call<ResponseLocationAndSoil> call, Throwable t) {
                    hideLoading();

//                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public  void hideLoading() {
        if (mprogressDialog != null && mprogressDialog.isShowing()) {
            mprogressDialog.cancel();
        }
    }
    public  void showLoadingDialog() {
        if (context != null) {
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
    }


//    public void getSharedPreferencesData() {
//        if (!sharedPrefrenceUtil.getCropSeason().isEmpty()) {
//            for (int i = 0; i < 4; i++) {
//
//                String data = getResources().getStringArray(R.array.CropSeason_value)[i];
//
//                if (sharedPrefrenceUtil.getCropSeason().equals(data)) {
//                    cropseason.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//        if (!sharedPrefrenceUtil.getmonocroppingselecteditem().isEmpty()) {
//            for (int i = 0; i < getResources().getStringArray(R.array.CropSeason_value).length; i++) {
//
//                String data = getResources().getStringArray(R.array.CropSeason_value)[i];
//
//                if (sharedPrefrenceUtil.getmonocroppingselecteditem().equals(data)) {
//                    farmer_croppingpattern_monocropping.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//  if (!sharedPrefrenceUtil.getdatarecordedgeneralobs().isEmpty()) {
//            for (int i = 0; i < getResources().getStringArray(R.array.generalobservation_values).length; i++) {
//
//                String data = getResources().getStringArray(R.array.generalobservation_values)[i];
//
//                if (sharedPrefrenceUtil.getdatarecordedgeneralobs().equals(data)) {
//                    selectgeneralinfo.setSelection(i);
//                    break;
//                }
//            }
//        }
//
//
//
////        if (sharedPrefrenceUtil.getlatLang() != null) {
////            farmer_location.setText(sharedPrefrenceUtil.getlatLang());
////        }
//        if (sharedPrefrenceUtil.getLandMarkMark() != null) {
//            landmark.setText(sharedPrefrenceUtil.getLandMarkMark());
//        }
//
//
//        if (sharedPrefrenceUtil.getName() != null) {
//            if (context != null) {
//
//                try {
//                    Picasso.with(context)
//                            .load(sharedPrefrenceUtil.getName())
//                            .into(farmimage);
//                } catch (Exception e) {
//                }
//            }
//        }
//        if (sharedPrefrenceUtil.getDateTime() != null) {
//            date_timee.setText(sharedPrefrenceUtil.getDateTime());
//
//        }
//
//         if (sharedPrefrenceUtil.getSoilSampleCollection() != null) {
//            soilcollection_date.setText(sharedPrefrenceUtil.getSoilSampleCollection());
//
//        }
//
// if (sharedPrefrenceUtil.getNitrogen() != null) {
//            etNitrogen.setText(sharedPrefrenceUtil.getNitrogen());
//
//        }
//
// if (sharedPrefrenceUtil.getPhosphorous() != null) {
//            etPhosphorus.setText(sharedPrefrenceUtil.getPhosphorous());
//
//        }
//
// if (sharedPrefrenceUtil.getPotassium() != null) {
//            etPotassium.setText(sharedPrefrenceUtil.getPotassium());
//
//        }
//
//if (sharedPrefrenceUtil.getOrganicCarbon() != null) {
//            etOrganicSoil.setText(sharedPrefrenceUtil.getOrganicCarbon());
//
//        }
//
//if (sharedPrefrenceUtil.getPH() != null) {
//            etSoilPH.setText(sharedPrefrenceUtil.getPH());
//
//        }
//
//if (sharedPrefrenceUtil.getImageFile().exists()) {
//
//        Bitmap myBitmap = BitmapFactory.decodeFile(sharedPrefrenceUtil.getImageFile().getAbsolutePath());
//        farmimage.setImageBitmap(myBitmap);
//        }
//
//if (sharedPrefrenceUtil.getAttachedFile().exists()) {
//        Bitmap myBitmap = BitmapFactory.decodeFile(sharedPrefrenceUtil.getAttachedFile().getAbsolutePath());
//        imageAttached.setImageBitmap(myBitmap);
//        }
//
//
//    }

     void getFarmLabData() {
         if (!sharedPrefrenceUtil.getFarmLabID().equals("0"))
             gif1.setVisibility(View.VISIBLE);
        if (context!=null)
          id= sharedPrefrenceUtil.getResponseId();
         farmlab_ID=sharedPrefrenceUtil.getFarmLabID();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        RequestGetFarmLab machineryrequest = new RequestGetFarmLab(id,farmlab_ID);

        Call<ResponseGetFarmLab> call = mapiClinet.getFarmLab(machineryrequest);
        call.enqueue(new Callback<ResponseGetFarmLab>() {

            @Override
            public void onResponse(Call<ResponseGetFarmLab> call, Response<ResponseGetFarmLab> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        try {
                            ResponseGetFarmLab retailerBeatResponse = response.body();
                            LabList list = retailerBeatResponse.getList();
                            String image, latlang, dateTime, landMark, season_crop, crop_pattern;

                            image = list.getImage();
                            latlang = list.getLatlong();
                            dateTime = list.getDateApp();
                            landMark = list.getLandmark();
                            season_crop = list.getCropSeason();
                            crop_pattern = list.getCroppingPattern();
                            try {
                                new AsyncTaskLoadImage( farmimage).execute(image);
                                new AsyncTaskLoadImageCertificate().execute(list.getCertificateUpload());
                            }catch(Exception e){
                                gif1.setVisibility(View.GONE);
                            }

                            String chemical=list.getChemicalFreeFarming();
                            String organicCertificate=list.getReceivedOrganicCertificate();
                            String FreeFarmingText=list.getFreeFarmingText();
                            edChemicalFree.setText(FreeFarmingText);

                            if (chemical.equalsIgnoreCase("yes"))
                                radioButtonChemicalYes.setChecked(true);
                            else
                                radioButtonChemicalNo.setChecked(true);

                            if (organicCertificate.equalsIgnoreCase("yes"))
                                radioButtonOrganicYes.setChecked(true);
                            else
                                radioButtonOrganicNo.setChecked(true);
                            txtattachmentPath.setText(list.getCertificateUpload());

                                farmer_location.setText(latlang);
                                farm_lab_address.setText(list.getFarmAddress());

                            landmark.setText(landMark);

                            if (!list.getSoilStatusNitrogen().equals("")) {
                                etNitrogen.setText(list.getSoilStatusNitrogen());
                                sharedPrefrenceUtil.setNitrogen(list.getSoilStatusNitrogen());
                            }

                            if (!list.getSoilStatusPhosphorus().equals("")) {
                                etPhosphorus.setText(list.getSoilStatusPhosphorus());
                                sharedPrefrenceUtil.setPhosphorous(list.getSoilStatusPhosphorus());
                            }
                            if (!list.getSoilStatusPotassium().equals("")) {
                                etPotassium.setText(list.getSoilStatusPotassium());
                                sharedPrefrenceUtil.setPotassium(list.getSoilStatusPotassium());
                            }
                            date_timee.setText(dateTime);

                            if (!list.getOrganicCarbon().equals(""))
                                etOrganicSoil.setText(list.getOrganicCarbon());


                            if (!list.getSoilPh().equals(""))
                                etSoilPH.setText(list.getSoilPh());

                                soilcollection_date.setText(list.getSoilSampleDate());

                                for (int i = 0; i < monocroppinglist.size(); i++) {

                                    PatternList data = monocroppinglist.get(i);

                                    if (crop_pattern.equalsIgnoreCase(data.getPatternName())) {
                                        farmer_croppingpattern_monocropping.setSelection(i);
                                        break;
                                    }
                                }
//                            }
//
//
//                            if (sharedPrefrenceUtil.getCropSeason() == null) {
                                for (int i = 0; i < getResources().getStringArray(R.array.CropSeason_value).length; i++) {

                                    String data = getResources().getStringArray(R.array.CropSeason_value)[i];

                                    if (season_crop.equalsIgnoreCase(data)) {
                                        cropseason.setSelection(i);
                                        break;
                                    }
                                }


                        }catch(Exception e){
                            gif1.setVisibility(View.GONE);
                        }

                    }else
                        gif1.setVisibility(View.GONE);

                }
                //  showTaost(msg);
//                progressDialog.dismiss();
                else
                    gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseGetFarmLab> call, Throwable t) {
                gif1.setVisibility(View.GONE);
//                progressDialog.dismiss();
                //  progressDoalog.dismiss();
                //Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }






    private void getFarmBookData() {
        final String  id= sharedPrefrenceUtil.getResponseId();
        final String  farmlabid= sharedPrefrenceUtil.getFarmLabID();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        RequestGetFarmBook machineryrequest = new RequestGetFarmBook(farmlabid,id);
        Call<ResponseGetFarmBook> call = mapiClinet.getFarmLabBooklist(machineryrequest);
        call.enqueue(new Callback<ResponseGetFarmBook>() {

            @Override
            public void onResponse(Call<ResponseGetFarmBook> call, Response<ResponseGetFarmBook> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        try {
                            ResponseGetFarmBook retailerBeatResponse = response.body();
                            List<ListFarmBook> list = retailerBeatResponse.getList();

                             if (context != null) {
                                 FarmBookAdapter adapter = new FarmBookAdapter(context, list);
                                 recycler_view.setAdapter(adapter);
                             }
                        }catch(Exception e){}
                     }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetFarmBook> call, Throwable t) {
                //  progressDoalog.dismiss();
//                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }




    public  void SaveFarmBook(){
        try {
            String text;
            text = etComplaint.getText().toString();
            RequestBody text1 = RequestBody.create(MediaType.parse("text/plain"), text);
            RequestBody farmlab_id = RequestBody.create(MediaType.parse("text/plain"), sharedPrefrenceUtil.getFarmLabID());
            RequestBody id1 = RequestBody.create(MediaType.parse("text/plain"), id);
            RequestBody farmlab_book_id = RequestBody.create(MediaType.parse("text/plain"), sharedPrefrenceUtil.getFarmBookID());

            RequestBody requestBodyProfile = RequestBody.create(MediaType.parse("multipart/form-data"),mImageFile1);
            MultipartBody.Part profile_img = MultipartBody.Part.createFormData("image",
                    mImageFile1.getName(), requestBodyProfile);
//            Toast.makeText(context, "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();

//            Log.e("id ", "" + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID());
            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            mapiClinet.postFarmBook(farmlab_id, id1,farmlab_book_id, text1, profile_img).enqueue(new Callback<ResponseUpdateFarmBook>() {
                @Override
                public void onResponse(Call<ResponseUpdateFarmBook> call, Response<ResponseUpdateFarmBook> response) {

                    hideLoading();
                    Log.e("response", "" + response.body());
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {
                            if (context!=null)
                            Toast.makeText(context, "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
//                            Log.e("response", "" + response.body());
                            getFarmBookData();
                        }
//                        else {
//                            if (context!=null)
//                            Toast.makeText(context, "Something went wrong...", Toast.LENGTH_LONG).show();
//                        }
//                    } else {
//                        if (context!=null)
//                            Toast.makeText(context, "Something went wrong...", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseUpdateFarmBook> call, Throwable t) {
                    hideLoading();
                    if (context!=null)
                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });


        }catch (Exception e){}
    }


    public  void postBook() {
        final ProgressDialog pd=new ProgressDialog(context);
        pd.show();
        RequestFarmBook otpVerifyRequest = new RequestFarmBook(sharedPrefrenceUtil.getFarmLabID(),"1",id,
                sharedPrefrenceUtil.getFarmBookID(),"",etComplaint.getText().toString());
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        mapiClinet.postFarmBook(otpVerifyRequest).enqueue(new Callback<ResponseUpdateFarmBook>() {

            @Override
            public void onResponse(@NonNull Call<ResponseUpdateFarmBook> call, @NonNull Response<ResponseUpdateFarmBook> response) {
                if (response.body() != null) {
                    Boolean status = response.body().getStatus();
                    //String otp = response.body().getOtp();
                    if (status.equals(true)) {
                       Config.toast(context,"Successfully saved");
                        getFarmBookData();
                    }
//                    else {
//                        Config.toast(context,"Failed");
//                        //showTaost(msg);
//                    }

                }
//                else {
//                    Config.toast(context,"Failed");
//                }
                //  showTaost(msg);
           pd.show();
            }
            @Override
            public void onFailure(Call<ResponseUpdateFarmBook> call, Throwable t) {
                pd.show();
                Config.toast(context,"Something went wrong");
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
                            cropsInfo   = getCropInfoResponse.getCropsInfo();
//                            sharedPrefrenceUtil.setTotalCrops(cropsInfo.size());
                            if (cropsInfo.size()>0)
                            sharedPrefrenceUtil.setCropInfoID(Integer.parseInt(cropsInfo.get(0).getCropInfoId()));
                            else
                                sharedPrefrenceUtil.setCropInfoID(0);
//                            Toast.makeText(context, "get Total Crops Size: "+sharedPrefrenceUtil.getTotalCrops(), Toast.LENGTH_LONG).show();
//                            Log.e("response", "" + response.body());
                        }catch(Exception e){}
                    }


                } else {
                    sharedPrefrenceUtil.setTotalCrops(0);
                }
                if (cropsInfo==null)
                    sharedPrefrenceUtil.setCropInfoID(0);

            }

            @Override
            public void onFailure(Call<CropInfoTotalCropsResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                if (context!=null)
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });




    }



    public void postFarmLabDataServer() {
        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest cropinformation = new SoilRequest(id);
        Call<LabListGetResponse> call = mapiClinet.getLabList(cropinformation);
        call.enqueue(new Callback<LabListGetResponse>() {

            @Override
            public void onResponse(Call<LabListGetResponse> call, Response<LabListGetResponse> response) {
                try {
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {
                            LabListGetResponse labListResponse = response.body();
                            String s = labListResponse.getMessage();
                            List<com.patanjali.pbri_new.model1.List> labList = new ArrayList<>();
                            labList = labListResponse.getList();
                            FarmLabHome.listLabs.setAdapter(new FarmLabHome.StoreAdapter(context, labList));
                            FarmLabHome.getVoucher = labListResponse.getList();
                            int labSize = labList.size();
                            sharedPrefrenceUtil.setTotalFarmlabs(labSize);
//                            Config.toast(context, "labsize " + labList.size());
                            Toast.makeText(context, "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();

                        }
                    }
            }catch (Exception e){}

            }

            @Override
            public void onFailure(Call<LabListGetResponse> call, Throwable t) {
                if (context!=null)
                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onDestroy() {
        OkHttpClient client =new OkHttpClient();
        client.dispatcher().cancelAll();
        super.onDestroy();
    }




    public void SaveOtherSoilType() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OthersSoilTypeRequest machineryrequest = new OthersSoilTypeRequest(id,edOthers.getText().toString());
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherSoilType(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added SoilType");
                        soilData();
                    } else {
                    }

                } else {
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




    public class AsyncTaskLoadImage  extends AsyncTask<String, String, Bitmap> {
//        ProgressDialog progressDialog=new ProgressDialog(context);
        private final static String TAG = "AsyncTaskLoadImage";
        private ImageView imageView;

        @Override
        protected void onPreExecute() {
//            progressDialog.show();
            super.onPreExecute();
        }

        public AsyncTaskLoadImage(ImageView imageView) {
            this.imageView = imageView;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
                Uri tempUri = getImageUri(context, bitmap);
                mImageFile = new File(getRealPathFromURI(tempUri));
//                sharedPrefrenceUtil.setImageFile(mImageFile);
            } catch (IOException e) {
//                Log.e(TAG, e+"");
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
//            progressDialog.dismiss();
            gif1.setVisibility(View.GONE);
        }
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
                mImageFile2 = new File(getRealPathFromURI(tempUri));
            } catch (IOException e) {
//                Log.e(TAG,e+"");
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
        }
    }


    class AsyncTaskRunnerFeatured extends AsyncTask<Void,Void,Void> {
        InputStream inpts;
        String result,line;

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            try {
                if (farm_lab_address.equals(""))
                    farm_lab_address.setText(name);

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
                try {
                    double lat=SingletonClass.getInstance().getLatitude();
                    double lang=SingletonClass.getInstance().getLongitude();
                    HttpGet post = new HttpGet("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lang+"&APPID=dc2522c3426d32f53ae6e86ea87134d1&units=metric");

                        Log.e("lat ", String.valueOf(lat)+" longitude : "+lang);

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
                    JSONObject jsonObject1= jsonObjectMain.getJSONObject("main");
                    JSONObject jsonObject2= jsonObjectMain.getJSONObject("sys");
//                    String farmerAddress = jsonObject1.getString("farmer_address");
                    name=jsonObjectMain.getString("name");
                    minTemp=jsonObject1.getString("temp_min");
                    MaxTemp=jsonObject1.getString("temp_max");
                    Country=jsonObject2.getString("country");
                    humidity=jsonObject1.getString("humidity");
                    Config.toast(context,"city: "+name);


                } catch(JSONException e) {
//                    e.printStackTrace();
                }

            }catch (Exception e){
//                e.printStackTrace();
            }
            return null;
        }
    }

}
