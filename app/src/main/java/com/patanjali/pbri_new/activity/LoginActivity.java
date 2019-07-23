package com.patanjali.pbri_new.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.firebase.FirebaseApp;
import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.HomeFragment;
import com.patanjali.pbri_new.model.FarmerDetail;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.LanguageResponse;
import com.patanjali.pbri_new.model.OTPRequest;
import com.patanjali.pbri_new.model.OTPResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.patanjali.pbri_new.service.LocationMotironingService;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.RECEIVE_SMS;

public class LoginActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 200;
EditText editText_empcode;
LocationManager locationManager;
   public static String empcode;
    GoogleApiClient mLocationClient;
    public static final int LOCATION_REQUEST = 99;
    private final static int REQUEST_CHECK_SETTINGS_GPS = 100;


    ProgressDialog mprogressDialog;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    String str1, str2, str3;
    public static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
   requestPermission();
        FirebaseApp.initializeApp(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        editText_empcode = (EditText) findViewById(R.id.user_email_editbox);

    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{RECEIVE_SMS}, PERMISSION_REQUEST_CODE);

    }


    public void sendot(View view) {

        //  if (checkPermission() && checkPermissioncamer()) {

//        Config.toast(getApplicationContext(),MainActivity.Connetion(getApplicationContext())+" conn");
        showLoadingDialog(LoginActivity.this);
        empcode = editText_empcode.getText().toString();

        OTPRequest loginRequest = new OTPRequest(empcode);
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        mapiClinet.doLogin(loginRequest).enqueue(new Callback<OTPResponse>() {
            @Override
            public void onResponse(@NonNull Call<OTPResponse> call, @NonNull Response<OTPResponse> response) {

                hideLoading();
                // String msg=response.body().getError_msg();
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    String otp = response.body().getOtp();
//                    OTPResponse otpResponse = response.body();

                    if (errCode.equals(true)) {

                        OTPResponse otpRespofnse = response.body();
                        FarmerDetail name = otpRespofnse.getFarmerDetail();
                        String farmer = name.getFarmerName();
                        String mobilenumber = name.getFarmerMobileno();
                        String id = name.getFarmerId();
                        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getApplicationContext());
                        sharedPrefrenceUtil.setFarmerName(farmer);
                        sharedPrefrenceUtil.setResponseMobile(mobilenumber);
                        sharedPrefrenceUtil.setResponseId(id);


                        if (sharedPrefrenceUtil.getLang().equalsIgnoreCase("हिंदी"))
                            postHindiLanguage();
                        else
                            postEnglishLanguage();


                        // Toast.makeText(getApplicationContext(), "Please Enter the OTP", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginActivity.this, VerifyOTP.class);
                        i.putExtra("otp", otp);
                        Log.e("otp",otp);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Mobile Number is not Valid...Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    //  Toast.makeText(getApplicationContext(), "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    // Toast.makeText(getApplicationContext(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
            }
            //  showTaost(msg);


            @Override
            public void onFailure(Call<OTPResponse> call, Throwable t) {

                hideLoading();
                Toast.makeText(getApplicationContext(), "Something went Wrong...Try Again", Toast.LENGTH_LONG).show();
                //showTaost("somwthing wet wrong,try later");
//                new async().execute((Void[]) null);

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS:
                boolean granted = true;
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        granted = false;
                        break;
                    }
                }
                if (granted) {
                    // imageName = "dummy_picture_" + System.currentTimeMillis() + ".jpg";
                    //takePicture(imageName);
                }
                break;
            case LOCATION_REQUEST:
                if (
                        grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkGpsProvider();
                }

                break;

        }
    }

   /* public void initiateLocationClient() {
        mLocationClient = new GoogleApiClient.Builder(getApplicationContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mLocationClient.connect();
    }*/

    void startLocationService() {
        if (!LocationMotironingService.isServiceRunning) {
            startService(new Intent(getApplicationContext(), LocationMotironingService.class));
        }
    }


    private void checkGpsProvider() {
        if (mLocationClient != null) {
            if (mLocationClient.isConnected()) {

                int permissionLocation = ContextCompat.checkSelfPermission(getApplicationContext(),
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

                                            status.startResolutionForResult(LoginActivity.this,
                                                    REQUEST_CHECK_SETTINGS_GPS);
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


    private void postEnglishLanguage() {

        showLoadingDialog(LoginActivity.this);
       final SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(LoginActivity.this);
        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id,"eng");
        Call<LanguageResponse> call = mapiClinet.dolanguage(machineryrequest);
        call.enqueue(new Callback<LanguageResponse>() {

            @Override
            public void onResponse(Call<LanguageResponse> call, Response<LanguageResponse> response) {

                hideLoading();

                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();


                    if (errCode.equals(true)) {

                        Toast.makeText(LoginActivity.this, "You have Choosen English Language.Please Wait..........", Toast.LENGTH_LONG).show();
                        sharedPrefrenceUtil.setEnglishLanguageLoginStatus(true);


                    } else {
                    }

                } else {
//                    Toast.makeText(LoginActivity.this,  "No Data Found", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<LanguageResponse> call, Throwable t) {
                hideLoading();
                //  progressDoalog.dismiss();
                Toast.makeText(LoginActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postHindiLanguage() {

        showLoadingDialog(LoginActivity.this);
       final SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(LoginActivity.this);
        String id= sharedPrefrenceUtil.getResponseId();

        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();

        LanguageRequest machineryrequest = new LanguageRequest(id,"hindi");

        Call<LanguageResponse> call = mapiClinet.dolanguage(machineryrequest);

        call.enqueue(new Callback<LanguageResponse>() {

            @Override
            public void onResponse(Call<LanguageResponse> call, Response<LanguageResponse> response) {

                hideLoading();
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        Toast.makeText(LoginActivity.this, "You have Choosen Hindi Language.Please Wait..........", Toast.LENGTH_LONG).show();
                        // hideLoading();

                        sharedPrefrenceUtil.setHindiLanguageLoginStatus(true);

                    }

                    else

                    {

                    }

                } else {
//                    Toast.makeText(LoginActivity.this, "Something Went Wrong!....Please Try Later", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<LanguageResponse> call, Throwable t) {
                hideLoading();
                //  progressDoalog.dismiss();
                Toast.makeText(LoginActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void showLoadingDialog(Context context) {
//        mprogressDialog = new ProgressDialog(context);
//        mprogressDialog.show();
//        if (mprogressDialog.getWindow() != null) {
//            mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        mprogressDialog.setContentView(R.layout.progress_layout);
//        mprogressDialog.setIndeterminate(true);
//        mprogressDialog.setCancelable(false);
//        mprogressDialog.setCanceledOnTouchOutside(false);
//
//    }
//
//    public void hideLoading() {
//        if (mprogressDialog != null && mprogressDialog.isShowing()) {
//            mprogressDialog.cancel();
//        }
//    }

    


//    class  async extends AsyncTask<Void,Void,Void>{
//        @Override
//        protected Void doInBackground(Void... voids) {
//            String result,line;
//            InputStream inpts;
//            try {
//                HttpClient client = new DefaultHttpClient();
//                HttpConnectionParams.setConnectionTimeout(client.getParams(), 20000); //Timeout Limit
//                HttpResponse response;
//                JSONObject json = new JSONObject();
//                try {
//                    HttpPost post = new HttpPost("http://1.6.145.44/farmers_project/index.php/Farmer_login/login");
//
//                    JSONObject userJson = new JSONObject();
//                    userJson.put("farmer_mobileno", editText_empcode.getText().toString());
//                    StringEntity se = new StringEntity(userJson.toString());
//                    post.setHeader(HTTP.CONTENT_TYPE, "application/json");
//
//                    post.setEntity(se);
//                    response = client.execute(post);
//                    int responseCodeDeal = response.getStatusLine().getStatusCode();
//                        Config.toast(getApplicationContext(),"responseCodeMerchantPin :"+responseCodeDeal);
//                    /*Checking response */
//                    inpts = null;
//                    if (response != null) {
//                        inpts = response.getEntity().getContent(); //Get the data in the entity
//                    }
//
//                    BufferedReader br = new BufferedReader(new InputStreamReader(inpts));
//                    StringBuilder sb = new StringBuilder();
//
//                    while ((line = br.readLine()) != null) {
//                        sb.append(line + "\n");
//                    }
//                    inpts.close();
//                    result = sb.toString();
//
//
//                    if (responseCodeDeal==200) {
//                        JSONObject jsonObjectMain = new JSONObject(result);
//                        JSONObject jsonObjectMain1 = jsonObjectMain.getJSONObject("farmer_detail");
//                        String otp = jsonObjectMain.getString("otp");
//                        String id = jsonObjectMain1.getString("farmer_id");
//
//
//                        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getApplicationContext());
//                        sharedPrefrenceUtil.setFarmerName(jsonObjectMain1.getString("farmer_name"));
//                        sharedPrefrenceUtil.setResponseMobile(jsonObjectMain1.getString("farmer_mobileno"));
//                        sharedPrefrenceUtil.setResponseId(id);
//
//
//                        if (sharedPrefrenceUtil.getLang().equalsIgnoreCase("हिंदी"))
//                            postHindiLanguage();
//                        else
//                            postEnglishLanguage();
//
//
//                        // Toast.makeText(getApplicationContext(), "Please Enter the OTP", Toast.LENGTH_LONG).show();
//                        Intent i = new Intent(LoginActivity.this, VerifyOTP.class);
//                        i.putExtra("otp", otp);
//                        Log.e("otp", otp);
//                        startActivity(i);
//                        finish();
//
//                    }
//
//
//
//                } catch (Exception e) {
//                    Log.e("exc",e+"");
//                }
//            } catch (Exception e) {
//                Log.e("exc",e+"");
//            }
//
//                return null;
//            }
//
//        }

}
