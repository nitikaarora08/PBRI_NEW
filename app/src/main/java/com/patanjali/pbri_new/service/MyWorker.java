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
//import com.patanjali.pbri_new.model.PostFarmerDetail;
//import com.patanjali.pbri_new.model.PostResponseFarmerDetail;
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
//public class MyWorker extends Worker {
//
//
//
//     ArrayList<String> machinedataa = new ArrayList<>();
//
//
//     ArrayList<String> saveCheckedItem = new ArrayList<>();
//
//
//    @NonNull
//    @Override
//    public WorkerResult doWork() {
//
//        PostFarmerDetail();
//        return WorkerResult.SUCCESS;
//
//    }
//
//    private void PostFarmerDetail() {
//
//        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
//        String id= sharedPrefrenceUtil.getResponseId();
//        String name= sharedPrefrenceUtil.getResponseFarmerName();
//        String maincroparea=sharedPrefrenceUtil.getCropArea();
//        String verticalcrop= sharedPrefrenceUtil.getVerticalcrop();
//        String emailid= sharedPrefrenceUtil.getEmail();
//        String children=sharedPrefrenceUtil.getChildren();
//        String female= sharedPrefrenceUtil.getFeMale();
//        String male= sharedPrefrenceUtil.getMale();
//        String vertcalcropyield= sharedPrefrenceUtil.getYieldVerticalCrop();
//        String maincropyield= sharedPrefrenceUtil.getYieldMainCrop();
//        String pincode= sharedPrefrenceUtil.getPinCode();
//        String dob= sharedPrefrenceUtil.getDob();
//        String landholding= sharedPrefrenceUtil.getLandholding();
//        String landmark= sharedPrefrenceUtil.getLandMarkMark();
//        String adharno= sharedPrefrenceUtil.getAdharNumber();
//        String villagename= sharedPrefrenceUtil.getVilalgeName();
//        String marketing= sharedPrefrenceUtil.getMarketing();
//        String state= sharedPrefrenceUtil.getstateitem();
//        String address= sharedPrefrenceUtil.getFarmerAddress();
//        String city= sharedPrefrenceUtil.getcityitem();
//        String education= sharedPrefrenceUtil.getEducation();
//        String farmerage= sharedPrefrenceUtil.getFramerAge();
//        String mandalname= sharedPrefrenceUtil.getMandal();
//        String pancard= sharedPrefrenceUtil.getPanNumber();
//        String totalinvestmentcrop= sharedPrefrenceUtil.getTotalInvestmentCrop();
//
//        String farmercastecategory= sharedPrefrenceUtil.getCasteSelectedItem();
//        String physicaldisibilty= sharedPrefrenceUtil.getphysicaldisibiltyseleteditem();
//        String farmerreligion= sharedPrefrenceUtil.getReligion();
//        String socialstatus= sharedPrefrenceUtil.getSocialSelectedItem();
//        String veticalcroptype= sharedPrefrenceUtil.getverticalselecteditem();
//        String maincroptype= sharedPrefrenceUtil.getmaincropselecteditem();
//        String noofcow= sharedPrefrenceUtil.getCow();
//        String noofbaffalow= sharedPrefrenceUtil.getbaffallow();
//        String totalincomecrop= sharedPrefrenceUtil.getTotalIncomeCrop();
//        String farmergender= sharedPrefrenceUtil.getGenderItemSelected();
//
//        saveCheckedItem= sharedPrefrenceUtil.getCheckMachineItem().getData();
//      //  machinedataa.addAll(saveCheckedItem);
//
//        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//        final PostFarmerDetail machineryrequest = new PostFarmerDetail(maincroparea,verticalcrop, "35", dob, "5", saveCheckedItem, "28.58890", "77.8999023",saveCheckedItem, "9",address,adharno,farmerage,farmercastecategory,city, dob,education,
//                "dd", "3",farmergender,id, "4",mandalname,name,pancard,
//
//                physicaldisibilty, pincode,farmerreligion,socialstatus,state,villagename, "5", landholding, landmark,marketing,
//                noofbaffalow, children, noofcow,female, "1", male, "1", "1", "1", "1", totalincomecrop,totalinvestmentcrop,
//                veticalcroptype, maincroptype, maincropyield, vertcalcropyield);
//
//        Call<PostResponseFarmerDetail> call = mapiClinet.dopostfarmerdetails(machineryrequest);
//        call.enqueue(new Callback<PostResponseFarmerDetail>() {
//
//
//            @Override
//            public void onResponse(Call<PostResponseFarmerDetail> call, Response<PostResponseFarmerDetail> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//
//                        Log.e("key",response.body().getMessage());
//
//                        Toast.makeText(getApplicationContext(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());
//
//                    }
//
//                    else {
//
//                        Toast.makeText(getApplicationContext(), "Something Went Wrong....", Toast.LENGTH_LONG).show();
//                    }
//
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Something Went Wrong....Try Again", Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//                }
//
//            @Override
//            public void onFailure(Call<PostResponseFarmerDetail> call, Throwable t) {
//                //  progressDoalog.dismiss();
//                Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//
//}
