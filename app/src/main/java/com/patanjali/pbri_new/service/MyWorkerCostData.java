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
//import com.patanjali.pbri_new.model.PostFarmCostModel;
//import com.patanjali.pbri_new.model.ResponseFarmCostModel;
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
//public class MyWorkerCostData extends Worker {
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
//        postCostDataServer();
//        return WorkerResult.SUCCESS;
//
//    }
//
//    public void postCostDataServer() {
//
//        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
//        String id= sharedPrefrenceUtil.getResponseId();
//        String landpreparation= sharedPrefrenceUtil.getLandpreparation();
//        String seed= sharedPrefrenceUtil.getSeed();
//        String fertilizer= sharedPrefrenceUtil.getSeed();
//        String pestiside= sharedPrefrenceUtil.getpestisides();
//        String planting = sharedPrefrenceUtil.getPlanting();
//        String weeding = sharedPrefrenceUtil.getWeeding();
//        String irrigation= sharedPrefrenceUtil.getIrrigation();
//        String spraying= sharedPrefrenceUtil.getSpraying();
//        String harvestingthreashing= sharedPrefrenceUtil.getHarvestingThresing();
//        String winoying= sharedPrefrenceUtil.getwinnoing();
//        String packing= sharedPrefrenceUtil.getPacking();
//        String transportation= sharedPrefrenceUtil.gettranportation();
//        String totalproducemaincrop= sharedPrefrenceUtil.getTotalProducemaincrop();
//        String totalproduceverticalcrop= sharedPrefrenceUtil.getTotalProduceverticalcrop();
//        String totalcostexpenditure= sharedPrefrenceUtil.getTotalCostExpenditure();
//        String marketvaluemaincrop= sharedPrefrenceUtil.getMarketValuemaincrop();
//        String marketvalueverticalcrop= sharedPrefrenceUtil.getMarketValueverticalcrop();
//        String farmlabincome= sharedPrefrenceUtil.getIncomefarmlab();
//        String costbenifitratio= sharedPrefrenceUtil.getCostBenefitratio();
//        String amount= sharedPrefrenceUtil.getAmount();
//        String discription= sharedPrefrenceUtil.getCostDiscription();
//
//
//        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//        final PostFarmCostModel cropinformation = new PostFarmCostModel(costbenifitratio,id,fertilizer, harvestingthreashing, irrigation,
//                "6",farmlabincome, landpreparation, marketvaluemaincrop, marketvalueverticalcrop, packing, pestiside, planting,
//                seed,spraying, totalcostexpenditure, totalproducemaincrop, totalproduceverticalcrop, transportation, weeding,
//                winoying,amount,discription);
//
//        Call<ResponseFarmCostModel> call = mapiClinet.docostdata(cropinformation);
//        call.enqueue(new Callback<ResponseFarmCostModel>() {
//
//            @Override
//            public void onResponse(Call<ResponseFarmCostModel> call, Response<ResponseFarmCostModel> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//
//                        Toast.makeText(getApplicationContext(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());
//
//
//                    } else {
//
//                        Toast.makeText(getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG).show();
//                    }
//
//
//                } else {
//                    Toast.makeText(getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseFarmCostModel> call, Throwable t) {
//                //  progressDoalog.dismiss();
//                Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//}
