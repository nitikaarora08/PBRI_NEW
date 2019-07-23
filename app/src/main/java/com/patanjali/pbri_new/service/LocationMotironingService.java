package com.patanjali.pbri_new.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


/**
 * Created by Patanjali on 20-10-2018.
 */

public class LocationMotironingService extends Service implements
        LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status> {

    public static boolean isServiceRunning=false;
    private static final String TAG = LocationMotironingService.class.getSimpleName();
    private final int UPDATE_INTERVAL = 3000;
    private final int FASTEST_INTERVAL =2000;
    GoogleApiClient mLocationClient;
    LocationRequest mLocationRequest;

    void startUpdates() {
        Log.d(TAG, "api_client " + checkPermission());


        LocationServices.FusedLocationApi.requestLocationUpdates(mLocationClient,
                mLocationRequest, this);

    }

    private void initiateLocationClient() {
        mLocationClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = new LocationRequest();
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                //.setSmallestDisplacement(100.0f)
                .setFastestInterval(FASTEST_INTERVAL);

        mLocationClient.connect();

    }

    void stopLOcationUpdates(){
        try{
        LocationServices.FusedLocationApi.removeLocationUpdates(mLocationClient,this);
}catch (Exception e){}
    }

    @Override
    public void onConnected(Bundle dataBundle) {
if(checkPermission())
    startUpdates();
    }

    private boolean checkPermission() {
        Log.d(TAG, "checkPermission()");
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED);

 }


    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Connection suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "Failed to connect to Google API");

    }


    //to get the location change
    @Override
    public void onLocationChanged(final Location location) {


      //  Toast.makeText(getApplicationContext(),"nooooooooooooooooooo"+SingletonClass.getInstance().getLatitude(),Toast.LENGTH_LONG).show();
        Log.d(TAG, "Location changed " + location);

        if (location != null) {
            Log.d(TAG, " latitude : " + location.getLatitude());
            Log.d(TAG, " longitude : " + location.getLongitude());

            SingletonClass.getInstance().setLongitude(location.getLongitude());
          // Toast.makeText(getApplicationContext(),""+SingletonClass.getInstance().getLatitude(),Toast.LENGTH_LONG).show();
            SingletonClass.getInstance().setLatitude(location.getLatitude());

            LocalBroadcastManager manager= LocalBroadcastManager.getInstance(getApplicationContext());

            Intent intent=new Intent("loction_created");

            manager.sendBroadcast(intent);

            // stopSelf();
           // resetData();

           // Toast.makeText(getApplicationContext(),""+SingletonClass.getInstance().getLatitude(),Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onResult(@NonNull Status status) {

    }
    @Override
    public void onCreate() {

        super.onCreate();
        isServiceRunning=true;
        initiateLocationClient();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        resetData();
    }
    void resetData(){
        isServiceRunning=false;
        SingletonClass.getInstance().setLongitude(0);
        SingletonClass.getInstance().setLatitude(0);
        stopLOcationUpdates();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
