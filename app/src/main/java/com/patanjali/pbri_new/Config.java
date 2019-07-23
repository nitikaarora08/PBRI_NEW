package com.patanjali.pbri_new;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import com.patanjali.pbri_new.fragments.CropInfoFragment;
import com.patanjali.pbri_new.model.LabListResponse;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Config {


    public static  void Intent(Context context,Class c){
        Intent i=new Intent(context,c);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }




    public static void CallFragment(Context context , Fragment fragment){
        if (context != null){
            FragmentTransaction transaction= ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }}

public static void CallFragment1(Context context , Fragment fragment){
    if (context != null){
        FragmentTransaction transaction= ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container1, fragment);
        transaction.commit();
    }}
    public static void CallFragment2(Context context , Fragment fragment){
        if (context != null){
            FragmentTransaction transaction= ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container2, fragment);
        transaction.commit();
    }}

 public static void CallFragment3(Context context , Fragment fragment){
     if (context != null) {
         FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
         transaction.replace(R.id.container3, fragment);
         transaction.commit();
     }}

public static void CallFragment4(Context context , Fragment fragment) {
    if (context != null){
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container4, fragment);
    transaction.commit();
} }
    public static void CallFragment5(CropInfoFragment context , Fragment fragment) {
        if (context != null) {
            FragmentTransaction transaction = (context).getFragmentManager().beginTransaction();
            transaction.replace(R.id.container5, fragment);
            transaction.commit();
        }
    }


//    public static void ProgressDialogShow(Context context ){
//        ProgressDialog progressDialog=new ProgressDialog(context);
//        progressDialog.show();
//    }
//
//  public static void ProgressDialogHide(Context context ){
//        ProgressDialog progressDialog=new ProgressDialog(context);
//        progressDialog.show();
//    }

    public static String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }




    public  static  void toast(Context context,String mess){
        if (context!=null)
        Toast.makeText(context,mess,Toast.LENGTH_SHORT).show();
    }

}
