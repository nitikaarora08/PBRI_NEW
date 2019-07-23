
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class PostFarmerDetail {

    @SerializedName("area_main_crop")
    private String mAreaMainCrop;
    @SerializedName("area_vertical_crop")
    private String mAreaVerticalCrop;
    @SerializedName("crop_season")
    private String mCropSeason;
    @SerializedName("entry_date")
    private String mEntryDate;
    @SerializedName("farm_croppattern")
    private String mFarmCroppattern;
    @SerializedName("farm_irrigatedval")
    private List<String> mFarmIrrigatedval;
    @SerializedName("farm_irrigation")
    private String mFarmIrrigation;
    @SerializedName("farm_latlong")
    private String mFarmLatlong;
    @SerializedName("farm_machinary")
    private List<String> mFarmMachinary;
    @SerializedName("farm_soil")
    private String mFarmSoil;
    @SerializedName("farmer_address")
    private String mFarmerAddress;
    @SerializedName("farmer_adharcard")
    private String mFarmerAdharcard;
    @SerializedName("farmer_age")
    private String mFarmerAge;
    @SerializedName("farmer_cast_category")
    private String mFarmerCastCategory;
    @SerializedName("farmer_district")
    private String mFarmerDistrict;
    @SerializedName("farmer_dob")
    private String mFarmerDob;
    @SerializedName("farmer_education")
    private String mFarmerEducation;
    @SerializedName("farmer_email")
    private String mFarmerEmail;
    @SerializedName("farmer_familysize")
    private String mFarmerFamilysize;
    @SerializedName("farmer_gender")
    private String mFarmerGender;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("farmer_livestock")
    private String mFarmerLivestock;
    @SerializedName("farmer_mandal_name")
    private String mFarmerMandalName;
    @SerializedName("farmer_name")
    private String mFarmerName;
    @SerializedName("farmer_pancard")
    private String mFarmerPancard;
    @SerializedName("farmer_physical_disability")
    private String mFarmerPhysicalDisability;
    @SerializedName("farmer_pinno")
    private String mFarmerPinno;
    @SerializedName("farmer_religion")
    private String mFarmerReligion;
    @SerializedName("farmer_social_status")
    private String mFarmerSocialStatus;
    @SerializedName("farmer_state")
    private String mFarmerState;
    @SerializedName("farmer_village_name")
    private String mFarmerVillageName;
    @SerializedName("farming_practice")
    private String mFarmingPractice;
    @SerializedName("land_holding")
    private String mLandHolding;
    @SerializedName("land_mark")
    private String mLandMark;
    @SerializedName("marketing")
    private String mMarketing;
    @SerializedName("no_of_buffallow")
    private String mNoOfBuffallow;
    @SerializedName("no_of_children")
    private String mNoOfChildren;
    @SerializedName("no_of_cows")
    private String mNoOfCows;
    @SerializedName("no_of_female")
    private String mNoOfFemale;
    @SerializedName("no_of_goats")
    private String mNoOfGoats;
    @SerializedName("no_of_male")
    private String mNoOfMale;
    @SerializedName("no_of_poultry")
    private String mNoOfPoultry;
    @SerializedName("profit_loss")
    private String mProfitLoss;
    @SerializedName("soil_area")
    private String mSoilArea;
    @SerializedName("source_bio")
    private String mSourceBio;
    @SerializedName("total_income_crop")
    private String mTotalIncomeCrop;
    @SerializedName("total_investment_crop")
    private String mTotalInvestmentCrop;
    @SerializedName("type_of_verticalcrop")
    private String mTypeOfVerticalcrop;
    @SerializedName("types_of_maincrops")
    private String mTypesOfMaincrops;
    @SerializedName("yield_main_crop")
    private String mYieldMainCrop;
    @SerializedName("yield_vertical_crop")
    private String mYieldVerticalCrop;

    public PostFarmerDetail(String mFarmerAddress, String mFarmerAdharcard, String mFarmerCastCategory,
                            String mFarmerDob, String mFarmerEducation, String mFarmerEmail, String mFarmerGender,
                            String mFarmerId, String mFarmerName,
                            String mFarmerReligion, String mNoOfChildren, String mNoOfFemale) {
        this.mFarmerAddress = mFarmerAddress;
        this.mFarmerAdharcard = mFarmerAdharcard;
        this.mFarmerCastCategory = mFarmerCastCategory;
        this.mFarmerDob = mFarmerDob;
        this.mFarmerEducation = mFarmerEducation;
        this.mFarmerEmail = mFarmerEmail;
        this.mFarmerGender = mFarmerGender;
        this.mFarmerId = mFarmerId;
        this.mFarmerName = mFarmerName;
        this.mFarmerReligion = mFarmerReligion;
        this.mNoOfChildren = mNoOfChildren;
        this.mNoOfFemale = mNoOfFemale;
        this.mNoOfMale = mNoOfMale;
    }

    public PostFarmerDetail(String mAreaMainCrop, String mAreaVerticalCrop, String mCropSeason, String mEntryDate, String mFarmCroppattern, List<String> mFarmIrrigatedval, String mFarmIrrigation, String mFarmLatlong, List<String> mFarmMachinary, String mFarmSoil, String mFarmerAddress, String mFarmerAdharcard, String mFarmerAge, String mFarmerCastCategory, String mFarmerDistrict, String mFarmerDob, String mFarmerEducation, String mFarmerEmail, String mFarmerFamilysize, String mFarmerGender, String mFarmerId, String mFarmerLivestock, String mFarmerMandalName, String mFarmerName, String mFarmerPancard, String mFarmerPhysicalDisability, String mFarmerPinno, String mFarmerReligion, String mFarmerSocialStatus, String mFarmerState, String mFarmerVillageName, String mFarmingPractice, String mLandHolding, String mLandMark, String mMarketing, String mNoOfBuffallow, String mNoOfChildren, String mNoOfCows, String mNoOfFemale, String mNoOfGoats, String mNoOfMale, String mNoOfPoultry, String mProfitLoss, String mSoilArea, String mSourceBio, String mTotalIncomeCrop, String mTotalInvestmentCrop, String mTypeOfVerticalcrop, String mTypesOfMaincrops, String mYieldMainCrop, String mYieldVerticalCrop) {
        this.mAreaMainCrop = mAreaMainCrop;
        this.mAreaVerticalCrop = mAreaVerticalCrop;
        this.mCropSeason = mCropSeason;
        this.mEntryDate = mEntryDate;
        this.mFarmCroppattern = mFarmCroppattern;
        this.mFarmIrrigatedval = mFarmIrrigatedval;
        this.mFarmIrrigation = mFarmIrrigation;
        this.mFarmLatlong = mFarmLatlong;
        this.mFarmMachinary = mFarmMachinary;
        this.mFarmSoil = mFarmSoil;
        this.mFarmerAddress = mFarmerAddress;
        this.mFarmerAdharcard = mFarmerAdharcard;
        this.mFarmerAge = mFarmerAge;
        this.mFarmerCastCategory = mFarmerCastCategory;
        this.mFarmerDistrict = mFarmerDistrict;
        this.mFarmerDob = mFarmerDob;
        this.mFarmerEducation = mFarmerEducation;
        this.mFarmerEmail = mFarmerEmail;
        this.mFarmerFamilysize = mFarmerFamilysize;
        this.mFarmerGender = mFarmerGender;
        this.mFarmerId = mFarmerId;
        this.mFarmerLivestock = mFarmerLivestock;
        this.mFarmerMandalName = mFarmerMandalName;
        this.mFarmerName = mFarmerName;
        this.mFarmerPancard = mFarmerPancard;
        this.mFarmerPhysicalDisability = mFarmerPhysicalDisability;
        this.mFarmerPinno = mFarmerPinno;
        this.mFarmerReligion = mFarmerReligion;
        this.mFarmerSocialStatus = mFarmerSocialStatus;
        this.mFarmerState = mFarmerState;
        this.mFarmerVillageName = mFarmerVillageName;
        this.mFarmingPractice = mFarmingPractice;
        this.mLandHolding = mLandHolding;
        this.mLandMark = mLandMark;
        this.mMarketing = mMarketing;
        this.mNoOfBuffallow = mNoOfBuffallow;
        this.mNoOfChildren = mNoOfChildren;
        this.mNoOfCows = mNoOfCows;
        this.mNoOfFemale = mNoOfFemale;
        this.mNoOfGoats = mNoOfGoats;
        this.mNoOfMale = mNoOfMale;
        this.mNoOfPoultry = mNoOfPoultry;
        this.mProfitLoss = mProfitLoss;
        this.mSoilArea = mSoilArea;
        this.mSourceBio = mSourceBio;
        this.mTotalIncomeCrop = mTotalIncomeCrop;
        this.mTotalInvestmentCrop = mTotalInvestmentCrop;
        this.mTypeOfVerticalcrop = mTypeOfVerticalcrop;
        this.mTypesOfMaincrops = mTypesOfMaincrops;
        this.mYieldMainCrop = mYieldMainCrop;
        this.mYieldVerticalCrop = mYieldVerticalCrop;
    }


    public PostFarmerDetail(String mAreaMainCrop, String mAreaVerticalCrop, String mCropSeason, String mEntryDate, String mFarmCroppattern,  String mFarmIrrigation, String mFarmLatlong,  String mFarmSoil, String mFarmerAddress, String mFarmerAdharcard, String mFarmerAge, String mFarmerCastCategory, String mFarmerDistrict, String mFarmerDob, String mFarmerEducation, String mFarmerEmail, String mFarmerFamilysize, String mFarmerGender, String mFarmerId, String mFarmerLivestock, String mFarmerMandalName, String mFarmerName, String mFarmerPancard, String mFarmerPhysicalDisability, String mFarmerPinno, String mFarmerReligion, String mFarmerSocialStatus, String mFarmerState, String mFarmerVillageName, String mFarmingPractice, String mLandHolding, String mLandMark, String mMarketing, String mNoOfBuffallow, String mNoOfChildren, String mNoOfCows, String mNoOfFemale, String mNoOfGoats, String mNoOfMale, String mNoOfPoultry, String mProfitLoss, String mSoilArea, String mSourceBio, String mTotalIncomeCrop, String mTotalInvestmentCrop, String mTypeOfVerticalcrop, String mTypesOfMaincrops, String mYieldMainCrop, String mYieldVerticalCrop) {
        this.mAreaMainCrop = mAreaMainCrop;
        this.mAreaVerticalCrop = mAreaVerticalCrop;
        this.mCropSeason = mCropSeason;
        this.mEntryDate = mEntryDate;
        this.mFarmCroppattern = mFarmCroppattern;
//        this.mFarmIrrigatedval = mFarmIrrigatedval;
        this.mFarmIrrigation = mFarmIrrigation;
        this.mFarmLatlong = mFarmLatlong;
//        this.mFarmMachinary = mFarmMachinary;
        this.mFarmSoil = mFarmSoil;
        this.mFarmerAddress = mFarmerAddress;
        this.mFarmerAdharcard = mFarmerAdharcard;
        this.mFarmerAge = mFarmerAge;
        this.mFarmerCastCategory = mFarmerCastCategory;
        this.mFarmerDistrict = mFarmerDistrict;
        this.mFarmerDob = mFarmerDob;
        this.mFarmerEducation = mFarmerEducation;
        this.mFarmerEmail = mFarmerEmail;
        this.mFarmerFamilysize = mFarmerFamilysize;
        this.mFarmerGender = mFarmerGender;
        this.mFarmerId = mFarmerId;
        this.mFarmerLivestock = mFarmerLivestock;
        this.mFarmerMandalName = mFarmerMandalName;
        this.mFarmerName = mFarmerName;
        this.mFarmerPancard = mFarmerPancard;
        this.mFarmerPhysicalDisability = mFarmerPhysicalDisability;
        this.mFarmerPinno = mFarmerPinno;
        this.mFarmerReligion = mFarmerReligion;
        this.mFarmerSocialStatus = mFarmerSocialStatus;
        this.mFarmerState = mFarmerState;
        this.mFarmerVillageName = mFarmerVillageName;
        this.mFarmingPractice = mFarmingPractice;
        this.mLandHolding = mLandHolding;
        this.mLandMark = mLandMark;
        this.mMarketing = mMarketing;
        this.mNoOfBuffallow = mNoOfBuffallow;
        this.mNoOfChildren = mNoOfChildren;
        this.mNoOfCows = mNoOfCows;
        this.mNoOfFemale = mNoOfFemale;
        this.mNoOfGoats = mNoOfGoats;
        this.mNoOfMale = mNoOfMale;
        this.mNoOfPoultry = mNoOfPoultry;
        this.mProfitLoss = mProfitLoss;
        this.mSoilArea = mSoilArea;
        this.mSourceBio = mSourceBio;
        this.mTotalIncomeCrop = mTotalIncomeCrop;
        this.mTotalInvestmentCrop = mTotalInvestmentCrop;
        this.mTypeOfVerticalcrop = mTypeOfVerticalcrop;
        this.mTypesOfMaincrops = mTypesOfMaincrops;
        this.mYieldMainCrop = mYieldMainCrop;
        this.mYieldVerticalCrop = mYieldVerticalCrop;
    }


    public String getAreaMainCrop() {
        return mAreaMainCrop;
    }

    public void setAreaMainCrop(String areaMainCrop) {
        mAreaMainCrop = areaMainCrop;
    }

    public String getAreaVerticalCrop() {
        return mAreaVerticalCrop;
    }

    public void setAreaVerticalCrop(String areaVerticalCrop) {
        mAreaVerticalCrop = areaVerticalCrop;
    }

    public String getCropSeason() {
        return mCropSeason;
    }

    public void setCropSeason(String cropSeason) {
        mCropSeason = cropSeason;
    }

    public String getEntryDate() {
        return mEntryDate;
    }

    public void setEntryDate(String entryDate) {
        mEntryDate = entryDate;
    }

    public String getFarmCroppattern() {
        return mFarmCroppattern;
    }

    public void setFarmCroppattern(String farmCroppattern) {
        mFarmCroppattern = farmCroppattern;
    }

    public List<String> getFarmIrrigatedval() {
        return mFarmIrrigatedval;
    }

    public void setFarmIrrigatedval(List<String> farmIrrigatedval) {
        mFarmIrrigatedval = farmIrrigatedval;
    }

    public String getFarmIrrigation() {
        return mFarmIrrigation;
    }

    public void setFarmIrrigation(String farmIrrigation) {
        mFarmIrrigation = farmIrrigation;
    }

    public String getFarmLatlong() {
        return mFarmLatlong;
    }

    public void setFarmLatlong(String farmLatlong) {
        mFarmLatlong = farmLatlong;
    }

    public List<String> getFarmMachinary() {
        return mFarmMachinary;
    }

    public void setFarmMachinary(List<String> farmMachinary) {
        mFarmMachinary = farmMachinary;
    }

    public String getFarmSoil() {
        return mFarmSoil;
    }

    public void setFarmSoil(String farmSoil) {
        mFarmSoil = farmSoil;
    }

    public String getFarmerAddress() {
        return mFarmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        mFarmerAddress = farmerAddress;
    }

    public String getFarmerAdharcard() {
        return mFarmerAdharcard;
    }

    public void setFarmerAdharcard(String farmerAdharcard) {
        mFarmerAdharcard = farmerAdharcard;
    }

    public String getFarmerAge() {
        return mFarmerAge;
    }

    public void setFarmerAge(String farmerAge) {
        mFarmerAge = farmerAge;
    }

    public String getFarmerCastCategory() {
        return mFarmerCastCategory;
    }

    public void setFarmerCastCategory(String farmerCastCategory) {
        mFarmerCastCategory = farmerCastCategory;
    }

    public String getFarmerDistrict() {
        return mFarmerDistrict;
    }

    public void setFarmerDistrict(String farmerDistrict) {
        mFarmerDistrict = farmerDistrict;
    }

    public String getFarmerDob() {
        return mFarmerDob;
    }

    public void setFarmerDob(String farmerDob) {
        mFarmerDob = farmerDob;
    }

    public String getFarmerEducation() {
        return mFarmerEducation;
    }

    public void setFarmerEducation(String farmerEducation) {
        mFarmerEducation = farmerEducation;
    }

    public String getFarmerEmail() {
        return mFarmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        mFarmerEmail = farmerEmail;
    }

    public String getFarmerFamilysize() {
        return mFarmerFamilysize;
    }

    public void setFarmerFamilysize(String farmerFamilysize) {
        mFarmerFamilysize = farmerFamilysize;
    }

    public String getFarmerGender() {
        return mFarmerGender;
    }

    public void setFarmerGender(String farmerGender) {
        mFarmerGender = farmerGender;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFarmerLivestock() {
        return mFarmerLivestock;
    }

    public void setFarmerLivestock(String farmerLivestock) {
        mFarmerLivestock = farmerLivestock;
    }

    public String getFarmerMandalName() {
        return mFarmerMandalName;
    }

    public void setFarmerMandalName(String farmerMandalName) {
        mFarmerMandalName = farmerMandalName;
    }

    public String getFarmerName() {
        return mFarmerName;
    }

    public void setFarmerName(String farmerName) {
        mFarmerName = farmerName;
    }

    public String getFarmerPancard() {
        return mFarmerPancard;
    }

    public void setFarmerPancard(String farmerPancard) {
        mFarmerPancard = farmerPancard;
    }

    public String getFarmerPhysicalDisability() {
        return mFarmerPhysicalDisability;
    }

    public void setFarmerPhysicalDisability(String farmerPhysicalDisability) {
        mFarmerPhysicalDisability = farmerPhysicalDisability;
    }

    public String getFarmerPinno() {
        return mFarmerPinno;
    }

    public void setFarmerPinno(String farmerPinno) {
        mFarmerPinno = farmerPinno;
    }

    public String getFarmerReligion() {
        return mFarmerReligion;
    }

    public void setFarmerReligion(String farmerReligion) {
        mFarmerReligion = farmerReligion;
    }

    public String getFarmerSocialStatus() {
        return mFarmerSocialStatus;
    }

    public void setFarmerSocialStatus(String farmerSocialStatus) {
        mFarmerSocialStatus = farmerSocialStatus;
    }

    public String getFarmerState() {
        return mFarmerState;
    }

    public void setFarmerState(String farmerState) {
        mFarmerState = farmerState;
    }

    public String getFarmerVillageName() {
        return mFarmerVillageName;
    }

    public void setFarmerVillageName(String farmerVillageName) {
        mFarmerVillageName = farmerVillageName;
    }

    public String getFarmingPractice() {
        return mFarmingPractice;
    }

    public void setFarmingPractice(String farmingPractice) {
        mFarmingPractice = farmingPractice;
    }

    public String getLandHolding() {
        return mLandHolding;
    }

    public void setLandHolding(String landHolding) {
        mLandHolding = landHolding;
    }

    public String getLandMark() {
        return mLandMark;
    }

    public void setLandMark(String landMark) {
        mLandMark = landMark;
    }

    public String getMarketing() {
        return mMarketing;
    }

    public void setMarketing(String marketing) {
        mMarketing = marketing;
    }

    public String getNoOfBuffallow() {
        return mNoOfBuffallow;
    }

    public void setNoOfBuffallow(String noOfBuffallow) {
        mNoOfBuffallow = noOfBuffallow;
    }

    public String getNoOfChildren() {
        return mNoOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        mNoOfChildren = noOfChildren;
    }

    public String getNoOfCows() {
        return mNoOfCows;
    }

    public void setNoOfCows(String noOfCows) {
        mNoOfCows = noOfCows;
    }

    public String getNoOfFemale() {
        return mNoOfFemale;
    }

    public void setNoOfFemale(String noOfFemale) {
        mNoOfFemale = noOfFemale;
    }

    public String getNoOfGoats() {
        return mNoOfGoats;
    }

    public void setNoOfGoats(String noOfGoats) {
        mNoOfGoats = noOfGoats;
    }

    public String getNoOfMale() {
        return mNoOfMale;
    }

    public void setNoOfMale(String noOfMale) {
        mNoOfMale = noOfMale;
    }

    public String getNoOfPoultry() {
        return mNoOfPoultry;
    }

    public void setNoOfPoultry(String noOfPoultry) {
        mNoOfPoultry = noOfPoultry;
    }

    public String getProfitLoss() {
        return mProfitLoss;
    }

    public void setProfitLoss(String profitLoss) {
        mProfitLoss = profitLoss;
    }

    public String getSoilArea() {
        return mSoilArea;
    }

    public void setSoilArea(String soilArea) {
        mSoilArea = soilArea;
    }

    public String getSourceBio() {
        return mSourceBio;
    }

    public void setSourceBio(String sourceBio) {
        mSourceBio = sourceBio;
    }

    public String getTotalIncomeCrop() {
        return mTotalIncomeCrop;
    }

    public void setTotalIncomeCrop(String totalIncomeCrop) {
        mTotalIncomeCrop = totalIncomeCrop;
    }

    public String getTotalInvestmentCrop() {
        return mTotalInvestmentCrop;
    }

    public void setTotalInvestmentCrop(String totalInvestmentCrop) {
        mTotalInvestmentCrop = totalInvestmentCrop;
    }

    public String getTypeOfVerticalcrop() {
        return mTypeOfVerticalcrop;
    }

    public void setTypeOfVerticalcrop(String typeOfVerticalcrop) {
        mTypeOfVerticalcrop = typeOfVerticalcrop;
    }

    public String getTypesOfMaincrops() {
        return mTypesOfMaincrops;
    }

    public void setTypesOfMaincrops(String typesOfMaincrops) {
        mTypesOfMaincrops = typesOfMaincrops;
    }

    public String getYieldMainCrop() {
        return mYieldMainCrop;
    }

    public void setYieldMainCrop(String yieldMainCrop) {
        mYieldMainCrop = yieldMainCrop;
    }

    public String getYieldVerticalCrop() {
        return mYieldVerticalCrop;
    }

    public void setYieldVerticalCrop(String yieldVerticalCrop) {
        mYieldVerticalCrop = yieldVerticalCrop;
    }

}
