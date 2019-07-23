package com.patanjali.pbri_new.network;


import com.patanjali.pbri_new.DistrictRequest;
import com.patanjali.pbri_new.model.RequestFarmBook;
import com.patanjali.pbri_new.model1.CostBenifitGetResponse;
import com.patanjali.pbri_new.model1.CropInfoRequest;
import com.patanjali.pbri_new.model1.CropInfoResponse;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsRequest;
import com.patanjali.pbri_new.model1.CropInfoTotalCropsResponse;
import com.patanjali.pbri_new.model1.CropStatusListResponse;
import com.patanjali.pbri_new.model1.DiseaseRequest;
import com.patanjali.pbri_new.model1.DiseaseResponse;
import com.patanjali.pbri_new.model1.FertilizerResponse;
import com.patanjali.pbri_new.model1.GetCropInfoRequest;
import com.patanjali.pbri_new.model1.GetCropInfoResponse;
import com.patanjali.pbri_new.model1.HelpResponse;
import com.patanjali.pbri_new.model1.LabListGetResponse;
import com.patanjali.pbri_new.model.CityRequest;
import com.patanjali.pbri_new.model.CityResponse;
import com.patanjali.pbri_new.model.CropDataRecordedModel;
import com.patanjali.pbri_new.model.CropPatternType;
import com.patanjali.pbri_new.model.CropRequest;
import com.patanjali.pbri_new.model.CropType;
import com.patanjali.pbri_new.model.DataCollectionRequest;
import com.patanjali.pbri_new.model.DataCollectionResponse;
import com.patanjali.pbri_new.model.DiseaseModel;
import com.patanjali.pbri_new.model.EducationResponse;
import com.patanjali.pbri_new.model.FarmPicResponse;
import com.patanjali.pbri_new.model.FarmerDetailIdResponse;
import com.patanjali.pbri_new.model.FarmerIdRequest;
import com.patanjali.pbri_new.model.GalleryRequest;
import com.patanjali.pbri_new.model.GalleryResponse;
import com.patanjali.pbri_new.model.IrrigationModel;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.LanguageResponse;
import com.patanjali.pbri_new.model.MachineryResponse;
import com.patanjali.pbri_new.model.MainCrop;
import com.patanjali.pbri_new.model.OTPRequest;
import com.patanjali.pbri_new.model.OTPResponse;
import com.patanjali.pbri_new.model.OTPVerifyRequest;
import com.patanjali.pbri_new.model.OTPVerifyResponse;
import com.patanjali.pbri_new.model.PestObserverdModel;
import com.patanjali.pbri_new.model.PostCropInformationModel;
import com.patanjali.pbri_new.model.PostFarmCostModel;
import com.patanjali.pbri_new.model.PostFarmLabModel;
import com.patanjali.pbri_new.model.PostFarmerDetails;
import com.patanjali.pbri_new.model.PostResponseFarmerDetail;
import com.patanjali.pbri_new.model.ProfilePicResponse;
import com.patanjali.pbri_new.model.RequestDataCollection;
import com.patanjali.pbri_new.model.RequestGetFarmLab;
import com.patanjali.pbri_new.model.RequestLoactionAndSoil;
import com.patanjali.pbri_new.model.RequestSaveFarmDetails;
import com.patanjali.pbri_new.model.ResponseCropDataRecorded;
import com.patanjali.pbri_new.model.ResponseDataCollection;
import com.patanjali.pbri_new.model.ResponseFarmCostModel;
import com.patanjali.pbri_new.model.ResponseFarmLabModel;
import com.patanjali.pbri_new.model.ResponseGetFarmLab;
import com.patanjali.pbri_new.model.ResponseIrrigationList;
import com.patanjali.pbri_new.model.ResponseLocationAndSoil;
import com.patanjali.pbri_new.model.ResponsePostCropInformation;
import com.patanjali.pbri_new.model.ResponseSaveFarmDetails;
import com.patanjali.pbri_new.model.ResponseUpdateFarmBook;
import com.patanjali.pbri_new.model.ResponseVersionCheck;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model.SoilResponse;
import com.patanjali.pbri_new.model.StateResponse;
import com.patanjali.pbri_new.model.VersionCheckModel;
import com.patanjali.pbri_new.model.VersionResponse;
import com.patanjali.pbri_new.model.VerticalList;
import com.patanjali.pbri_new.model1.OtherDiseaseRequest;
import com.patanjali.pbri_new.model1.OtherPestRequest;
import com.patanjali.pbri_new.model1.OtherRequestSubCrop;
import com.patanjali.pbri_new.model1.OthersPestisidesRequest;
import com.patanjali.pbri_new.model1.OthersSoilTypeRequest;
import com.patanjali.pbri_new.model1.PestNameResponse;
import com.patanjali.pbri_new.model1.PestisidesListResponse;
import com.patanjali.pbri_new.model1.PostCostRequest;
import com.patanjali.pbri_new.model1.PostCostResponse;
import com.patanjali.pbri_new.model1.RecommendCropRequest;
import com.patanjali.pbri_new.model1.RecommendCropResponse;
import com.patanjali.pbri_new.model1.RequestGetFarmBook;
import com.patanjali.pbri_new.model1.OthersFertilizerRequest;
import com.patanjali.pbri_new.model1.ResponseGetFarmBook;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.model1.SubCropsRequest;
import com.patanjali.pbri_new.model1.SubCropsResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {
    /*--------Image Upload  API---------------------------*/


    @POST("Advertising/advertisement")
    Call<ResponseVersionCheck> checkversiondata(@Body VersionCheckModel request);

    @GET("Send_notification/getVersion")
    Call<VersionResponse> checkversioncode();

    @POST("Farmer_login/logindetail")
    Call<OTPVerifyResponse> verifyotp(@Body OTPVerifyRequest request);

    @POST("Crops_info/cropsinfoData")
    Call<ResponsePostCropInformation> docropinformation(@Body PostCropInformationModel request);

    @POST("Farmer_login/login")
    Call<OTPResponse> doLogin(@Body OTPRequest request);


    @POST("Cost_estimation/cost_calculation")
    Call<ResponseFarmCostModel> docostdata(@Body PostFarmCostModel request);

    @POST("Farmer_farmlab/farmer_farmlab")

    Call<ResponseFarmLabModel> dofarmlab(@Body PostFarmLabModel request);

    @POST("Farmer_masterdata/farmer_croppattern")
    Call<CropType> docroptype(@Body LanguageRequest request);

    @POST("Farmer_farmlab/getfarmerFarmlabbylabid")
    Call<ResponseGetFarmLab> getFarmLab(@Body RequestGetFarmLab request);

    @POST("Farmer_cropsdata/farmer_cropsdata")
    Call<ResponseCropDataRecorded> docropdatarecorded(@Body CropDataRecordedModel request);

   @POST("Farmer_masterdata/farmer_crop")
    Call<CropPatternType> docroppattern(@Body CropRequest request);

    @POST("Farmer_masterdata/farmer_machinary")
    Call<MachineryResponse> doMachinery(@Body LanguageRequest request);

    @POST("Farmer_masterdata/diseaseList")
    Call<DiseaseModel> doDiseaseObseverd(@Body LanguageRequest request);

    @POST("Farmer_masterdata/insectList")
    Call<PestObserverdModel> doPesrObseverd(@Body LanguageRequest request);


    @POST("Farmer_masterdata/typeOfmaincropList")
    Call<MainCrop> doMainCrop(@Body LanguageRequest request);

    @POST("Farmer_masterdata/farmer_education")
    Call<EducationResponse> doEducation(@Body LanguageRequest request);



    @POST("Farmer_data/farmer_details")
    Call<PostResponseFarmerDetail> dopostfarmerdetails(@Body PostFarmerDetails request);


    @POST("Farm/farmer_farmupdate")
    Call<ResponseSaveFarmDetails> dopostfarmerdetails1(@Body RequestSaveFarmDetails request);






    @Multipart
    @POST("Farmer_farmlab/farmer_farmlab")
    Call<ResponseLocationAndSoil> postFarmLabLocation(@Part("farm_lab_id") RequestBody farm_lab_id,
                                                          @Part("farmer_id") RequestBody farmer_id,
                                                          @Part("latlong") RequestBody latlong,
                                                          @Part("farm_address") RequestBody address,
                                                          @Part("landmark") RequestBody landmark,
                                                          @Part("crop_season") RequestBody crop_season,
                                                          @Part("cropping_pattern") RequestBody cropping_pattern,
                                                          @Part("date") RequestBody date,
                                                      @Part("farm_lab_type") RequestBody farm_lab_type,
                                                      @Part MultipartBody.Part file,
                                                      @Part("chemical_free_farming") RequestBody chemical,
                                                      @Part("free_farming_text") RequestBody chemicalfree,
                                                      @Part("received_organic_certificate") RequestBody organic,
                                                      @Part MultipartBody.Part file1
    );

  @Multipart
    @POST("Farmer_farmlab/farmer_farmlab")
    Call<ResponseLocationAndSoil> postFarmLabLocationFirst(
                                                          @Part("farmer_id") RequestBody farmer_id,
                                                          @Part("latlong") RequestBody latlong,
                                                          @Part("farm_address") RequestBody address,
                                                          @Part("landmark") RequestBody landmark,
                                                          @Part("crop_season") RequestBody crop_season,
                                                          @Part("cropping_pattern") RequestBody cropping_pattern,
                                                          @Part("date") RequestBody date,
                                                          @Part("farm_lab_type") RequestBody farm_lab_type,
                                                          @Part MultipartBody.Part file,
                                                            @Part("chemical_free_farming") RequestBody chemical,
                                                          @Part("free_farming_text") RequestBody chemicalfree,
                                                          @Part("received_organic_certificate") RequestBody organic,
                                                          @Part MultipartBody.Part file1
    );



 @POST("Soil_test/farmer_farmlab")
    Call<ResponseLocationAndSoil> dopostfarmerdetails3(@Body RequestLoactionAndSoil request);

    @POST("Farm_lab_book/lab_book")
    Call<ResponseUpdateFarmBook> postFarmBook(@Body RequestFarmBook request);


    @Multipart
    @POST("Farm_lab_book/lab_book")
    Call<ResponseUpdateFarmBook> postFarmBook(@Part("farmer_farm_labid") RequestBody farm_lab_id,
                                                          @Part("farmer_id") RequestBody farmer_id,
                                                          @Part("farmlab_book_id") RequestBody farmlab_book_id,
                                                          @Part("text") RequestBody latlong,
                                                          @Part MultipartBody.Part file
    );

 @POST("Lab_book_data/getlab_book")
    Call<ResponseGetFarmBook> getFarmLabBook(@Body RequestGetFarmBook request);
@POST("Farm_lab_book/getlabbookbylabid")
    Call<ResponseGetFarmBook> getFarmLabBooklist(@Body RequestGetFarmBook request);


    @POST("Farmlab_datacollection/farmer_datacollection")
    Call<ResponseDataCollection> updateDataCollection(@Body RequestDataCollection request);


 @POST("Farmlab_datacollection/getdatacollectionbydatainfoid")
    Call<DataCollectionResponse> getDataCollection(@Body DataCollectionRequest request);



    @POST("Farmer_data/farmerdetailsByid")
    Call<FarmerDetailIdResponse> dopostfarmerdetailsById(@Body FarmerIdRequest request);

    @Multipart
    @POST("Farmer_data/updateFarmpic")
    Call<FarmPicResponse> dopostfarmpic(@Part("farmer_id") RequestBody field1, @Part MultipartBody.Part file);


    @Multipart
    @POST("Farmer_data/farmer_details")
    Call<PostResponseFarmerDetail> doposttestfarmerdetails(@Part("farmer_id") RequestBody farmerid, @Part("area_main_crop")
            RequestBody maincroparea, @Part("farm_machinary") RequestBody machinedata, @Part MultipartBody.Part file);

/*
    @Multipart
    @POST("Farmer_data/farmer_details")
    Call<PostResponseFarmerDetail> doposttestfarmerdetails(@Part("area_main_crop") RequestBody maincroparea, @Query("farm_machinary[]") ArrayList<String> machineData);*/

    @POST("Farmer_masterdata/stateList")
    Call<StateResponse> dostate(@Body LanguageRequest request);

    @POST("Farmer_login/select_language")
    Call<LanguageResponse> dolanguage(@Body LanguageRequest request);

    @POST("Farmer_masterdata/districtList")
    Call<CityResponse> docity(@Body CityRequest request);

    @POST("Farmer_masterdata/irrigationList")
    Call<IrrigationModel> doyesirrigation(@Body LanguageRequest request);

 @POST("Farmer_masterdata/irrigationList")
    Call<ResponseIrrigationList> doyesirrigation1(@Body LanguageRequest request);

    @POST("Farmer_masterdata/farmer_soil")
    Call<SoilResponse> doSoil(@Body LanguageRequest request);

    @POST("Farmer_masterdata/districtList")
    Call<CityResponse> dodistrict(@Body DistrictRequest request);

    @POST("Farmer_masterdata/typeOfverticalcropList ")
    Call<VerticalList> doVerticalcrop(@Body LanguageRequest request);

    @POST("Farmer_Gallery/gallery")
    Call<GalleryResponse> gallery(@Body GalleryRequest request);

    @Multipart
    @POST("Farmer_data/updateprofilepic")
    Call<ProfilePicResponse> postProfilePic(@Part("farmer_id") RequestBody farmer_id,
                                            @Part MultipartBody.Part file
    );

    @POST("Farmer_farmlab/getfarmdetailsbyfarmerId")
    Call<LabListGetResponse> getLabList(@Body SoilRequest request);

@POST("Farmer_masterdata/cropstatusList")
    Call<CropStatusListResponse> getMainCrop(@Body SoilRequest request);

@POST("Farmer_masterdata/cropnameList")
    Call<SubCropsResponse> getSubCrop(@Body SubCropsRequest request);

@POST("Farmer_masterdata/cropPesticidesList")
    Call<PestisidesListResponse> getPestList(@Body SoilRequest request);

@POST("Farmer_masterdata/cropFertilizerList")
    Call<FertilizerResponse> getFertilizer(@Body SoilRequest request);

@POST("Farmer_masterdata/cropDiseasename")
    Call<DiseaseResponse> getDiseases(@Body DiseaseRequest request);
@POST("Farmer_masterdata/cropPestname")
    Call<PestNameResponse> getPest(@Body DiseaseRequest request);
@POST("Crops_info/cropsinfoData")
    Call<CropInfoResponse> getCropInfo(@Body CropInfoRequest request);

@POST("Crops_info/getCropsinfobycropinfoid")
    Call<GetCropInfoResponse> getCropInfoData(@Body GetCropInfoRequest request);
@POST("Crops_info/getCropsinfobyFarmerlabid")
    Call<CropInfoTotalCropsResponse> getTotalCrops(@Body CropInfoTotalCropsRequest request);



    @POST("Cost_benefit/cost_calculation")
    Call<PostCostResponse> postcostdata(@Body PostCostRequest request);

    @POST("Cost_benefit/costbenefitbyFarmerId")
    Call<CostBenifitGetResponse> getcostdata(@Body RequestGetFarmLab request);
  @POST("Farmer_masterdata/soil_recommended")
    Call<RecommendCropResponse> getRecommendData(@Body RecommendCropRequest request);

  @POST("Add_othersdata/addFertilizer")
    Call<OthersFertilizerResponse> postOtherFertilizer(@Body OthersFertilizerRequest request);
 @POST("Add_othersdata/addmaincrop_info")
    Call<OthersFertilizerResponse> postOtherMainCrop(@Body OthersFertilizerRequest request);
@POST("Add_othersdata/addsubcrop_infoName")
    Call<OthersFertilizerResponse> PostSubCropOTHER(@Body OtherRequestSubCrop request);

 @POST("Add_othersdata/addPesticides")
    Call<OthersFertilizerResponse> postOtherPesticides(@Body OthersPestisidesRequest request);

@POST("Add_othersdata/addSoil")
    Call<OthersFertilizerResponse> postOtherSoilType(@Body OthersSoilTypeRequest request);

    @POST("Add_othersdata/addCroppestName")
    Call<OthersFertilizerResponse> postOtherPest(@Body OtherPestRequest request);
 @POST("Add_othersdata/addCropdiseases")
    Call<OthersFertilizerResponse> postOtherDisease(@Body OtherDiseaseRequest request);

@POST("Farmer_farmlab/delete_farmlab")
    Call<ResponseGetFarmLab> deleteFarmLab(@Body RequestGetFarmLab request);


    @Multipart
    @POST("Help/help")
    Call<HelpResponse> postHelp(
                                    @Part("farmer_id") RequestBody farmer_id,
                                    @Part("contact") RequestBody contact,
                                    @Part("comment") RequestBody comment,
                                    @Part("text") RequestBody text,
                                    @Part MultipartBody.Part file
    );

}
