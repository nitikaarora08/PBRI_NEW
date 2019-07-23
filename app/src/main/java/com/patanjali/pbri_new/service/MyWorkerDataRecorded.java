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
//import com.patanjali.pbri_new.model.CropDataRecordedModel;
//import com.patanjali.pbri_new.model.ResponseCropDataRecorded;
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
//public class MyWorkerDataRecorded extends Worker {
//
//
//
//     ArrayList<String> machinedataa = new ArrayList<>();
//
//
//     ArrayList<String> saveCheckedItem = new ArrayList<>();
//
//
//
//
//    @NonNull
//    @Override
//    public WorkerResult doWork() {
//
//        PostCropDataRecorded();
//        return WorkerResult.SUCCESS;
//
//    }
//
//    public void PostCropDataRecorded() {
//
//
//        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
//        String id= sharedPrefrenceUtil.getResponseId();
//        String plantheight= sharedPrefrenceUtil.getPlantHeight();
//        String npofproductivetiller= sharedPrefrenceUtil.getNoProductivityTiller();
//        String panicle= sharedPrefrenceUtil.getPanicleSize();
//        String nooffruit =sharedPrefrenceUtil.getNoOfFruit();
//        String dateofharvesting= sharedPrefrenceUtil.getDateOfHarvesting();
//        String thousandgramweight= sharedPrefrenceUtil.getgrainweight();
//        String grainyieldplant= sharedPrefrenceUtil.getgrainYieldPlant();
//        String grainyieldplot= sharedPrefrenceUtil.getgrainYieldPlot();
//        String soilnitrogen = sharedPrefrenceUtil.getNitrogen();
//        String soilphosphosphorous= sharedPrefrenceUtil.getPhosphorous();
//        String potassium = sharedPrefrenceUtil.getPotassium();
//        String irrigation= sharedPrefrenceUtil.getIrrigationMatter();
//        String noofrainydays= sharedPrefrenceUtil.getNoOfRainyDays();
//        String setorganicmatter= sharedPrefrenceUtil.getOrgainicMatter();
//
//        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//        final CropDataRecordedModel cropinformation = new CropDataRecordedModel("1", id, grainyieldplant,
//                grainyieldplant, dateofharvesting,
//                irrigation,soilnitrogen, nooffruit, noofrainydays, npofproductivetiller,
//                setorganicmatter, panicle, soilphosphosphorous, plantheight,potassium,
//                "5", "7", thousandgramweight);
//
//        Call<ResponseCropDataRecorded> call = mapiClinet.docropdatarecorded(cropinformation);
//        call.enqueue(new Callback<ResponseCropDataRecorded>() {
//
//            @Override
//            public void onResponse(Call<ResponseCropDataRecorded> call, Response<ResponseCropDataRecorded> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//
//                        if (getApplicationContext()!=null)
//                            Toast.makeText(getApplicationContext(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());
//
//                    } else {
//
////                        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
//                    }
//
//
//                } else {
////                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseCropDataRecorded> call, Throwable t) {
//                //  progressDoalog.dismiss();
//                Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}