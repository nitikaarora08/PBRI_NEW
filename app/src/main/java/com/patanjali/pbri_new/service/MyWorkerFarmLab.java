//package com.patanjali.pbri_new.service;
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//import androidx.work.Worker;
//import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
//import com.patanjali.pbri_new.model.PostFarmLabModel;
//import com.patanjali.pbri_new.model.ResponseFarmLabModel;
//import com.patanjali.pbri_new.network.ApiInterface;
//import com.patanjali.pbri_new.network.RetrofitClientInstance;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by Patanjali on 23-12-2018.
// */
//
//public class MyWorkerFarmLab extends Worker {
//
//
//    ArrayList<String> machinedataa = new ArrayList<>();
//
//
//    ArrayList<String> pestobservedlist = new ArrayList<>();
//
//    ArrayList<String> diseasesobservedlist = new ArrayList<>();
//
//
//    @NonNull
//    @Override
//    public WorkerResult doWork() {
//
//        postFarmLabDataServer();
//
//        return WorkerResult.SUCCESS;
//
//    }
//
//    public void postFarmLabDataServer() {
//
//
//        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
//        String id= sharedPrefrenceUtil.getResponseId();
//        String Irrigatioph= sharedPrefrenceUtil.getIrrigationMatter();
//        String soilphosphorous= sharedPrefrenceUtil.getPhosphorous();
//        String soilpotassium= sharedPrefrenceUtil.getPotassium();
//        String soilnitrogen= sharedPrefrenceUtil.getNitrogen();
//        String orgaincmaater= sharedPrefrenceUtil.getOrgainicMatter();
//
//        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//        final PostFarmLabModel cropinformation = new PostFarmLabModel("1", id, Irrigatioph, "4", "5", orgaincmaater, "", soilnitrogen, soilphosphorous, soilpotassium);
//
//        Call<ResponseFarmLabModel> call = mapiClinet.dofarmlab(cropinformation);
//        call.enqueue(new Callback<ResponseFarmLabModel>() {
//
//            @Override
//            public void onResponse(Call<ResponseFarmLabModel> call, Response<ResponseFarmLabModel> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//
//                        if (getApplicationContext()!=null)
//                        Toast.makeText(getApplicationContext(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());
//
//                    } else {
//
////                        Toast.makeText(getApplicationContext(),  "", Toast.LENGTH_LONG).show();
//                    }
//
//                } else {
////                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseFarmLabModel> call, Throwable t) {
//                //  progressDoalog.dismiss();
//                if (getApplicationContext()!=null)
//                    Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//}