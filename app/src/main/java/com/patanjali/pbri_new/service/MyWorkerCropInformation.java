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
//import com.patanjali.pbri_new.model.PostCropInformationModel;
//import com.patanjali.pbri_new.model.ResponsePostCropInformation;
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
//public class MyWorkerCropInformation extends Worker {
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
//        postCropInformation();
//        return WorkerResult.SUCCESS;
//
//    }
//
//    public void postCropInformation() {
//
//        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
//
//        pestobservedlist= sharedPrefrenceUtil.getCheckPestItem().getData();
//        diseasesobservedlist= sharedPrefrenceUtil.getCheckDiseaseItem().getData();
//        String id= sharedPrefrenceUtil.getResponseId();
//        String maincropname=  sharedPrefrenceUtil.getOnlyCropName();
//        String varietyname= sharedPrefrenceUtil.getOnlyVarietyName();
//        String dateofsowing= sharedPrefrenceUtil.getDateOfSowing();
//        String dateofplanting= sharedPrefrenceUtil.getDateOfPlanting();
//        String landpreparationdate= sharedPrefrenceUtil.getLandpreparation();
//        String soilsamplecollectiondate= sharedPrefrenceUtil.getSoilSampleCollection();
//        String firstsplitdosedate = sharedPrefrenceUtil.getFirstSplit();
//        String secondsplitdosedate = sharedPrefrenceUtil.getSecondSplit();
//        String topdosedate= sharedPrefrenceUtil.getTopDoseDate();
//        String noofirrigation= sharedPrefrenceUtil.getNoOfIrrigation();
//        String weednoticed= sharedPrefrenceUtil.getWeedNoticed();
//        String firstweedingdate= sharedPrefrenceUtil.getFirstWeedingDate();
//        String firstpestappdate= sharedPrefrenceUtil.getFirstApplicationDate();
//        String secondpestappdate= sharedPrefrenceUtil.getSecondApplicationDate();
//
//        String secondweedingdate= sharedPrefrenceUtil.getSecondWeedData();
//        String firstdiseaseappdate= sharedPrefrenceUtil.getFirstApplicationDiseaseDate();
//        String seconddiseaseappdate= sharedPrefrenceUtil.getSecondApplicationDiseaseDate();
//
//
//
//        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//        final PostCropInformationModel cropinformation = new PostCropInformationModel("","",maincropname, "4", "5",
//                firstdiseaseappdate, pestobservedlist,
//                seconddiseaseappdate, id, firstsplitdosedate, firstweedingdate, "3", landpreparationdate, noofirrigation, diseasesobservedlist,
//                firstpestappdate, secondpestappdate,
//                dateofplanting, secondsplitdosedate, secondweedingdate, dateofsowing, soilsamplecollectiondate, topdosedate, varietyname, weednoticed);
//
//        Call<ResponsePostCropInformation> call = mapiClinet.docropinformation(cropinformation);
//        call.enqueue(new Callback<ResponsePostCropInformation>() {
//
//            @Override
//            public void onResponse(Call<ResponsePostCropInformation> call, Response<ResponsePostCropInformation> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//
//                        Toast.makeText(getApplicationContext(), "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());
//
//                    } else {
//
////                        Toast.makeText(getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG).show();
//                    }
//
//
//                } else {
////                    Toast.makeText(getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponsePostCropInformation> call, Throwable t) {
//                //  progressDoalog.dismiss();
//                if (getApplicationContext()!=null)
//                    Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}