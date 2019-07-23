
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropDataRecordedModel {

    @SerializedName("crop_condition")
    private String mCropCondition;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("grain_yield_plant")
    private String mGrainYieldPlant;
    @SerializedName("grain_yield_plot")
    private String mGrainYieldPlot;
    @SerializedName("harvesting_date")
    private String mHarvestingDate;
    @SerializedName("irrigation_water_ph")
    private String mIrrigationWaterPh;
    @SerializedName("nitrogen_soil_status")
    private String mNitrogenSoilStatus;
    @SerializedName("no_of_fruits")
    private String mNoOfFruits;
    @SerializedName("no_of_rainydate")
    private String mNoOfRainydate;
    @SerializedName("no_of_tiller")
    private String mNoOfTiller;
    @SerializedName("organic_content_ph")
    private String mOrganicContentPh;
    @SerializedName("panicle_size")
    private String mPanicleSize;
    @SerializedName("phosphorus_soil_status")
    private String mPhosphorusSoilStatus;
    @SerializedName("plant_height")
    private String mPlantHeight;
    @SerializedName("potassium_soil_status")
    private String mPotassiumSoilStatus;
    @SerializedName("rain_fall_distribution")
    private String mRainFallDistribution;
    @SerializedName("rain_fall_observation")
    private String mRainFallObservation;
    @SerializedName("th_grain_weight")
    private String mThGrainWeight;

    public CropDataRecordedModel(String mCropCondition, String mFarmerId, String mGrainYieldPlant, String mGrainYieldPlot, String mHarvestingDate, String mIrrigationWaterPh, String mNitrogenSoilStatus, String mNoOfFruits, String mNoOfRainydate, String mNoOfTiller, String mOrganicContentPh, String mPanicleSize, String mPhosphorusSoilStatus, String mPlantHeight, String mPotassiumSoilStatus, String mRainFallDistribution, String mRainFallObservation, String mThGrainWeight) {
        this.mCropCondition = mCropCondition;
        this.mFarmerId = mFarmerId;
        this.mGrainYieldPlant = mGrainYieldPlant;
        this.mGrainYieldPlot = mGrainYieldPlot;
        this.mHarvestingDate = mHarvestingDate;
        this.mIrrigationWaterPh = mIrrigationWaterPh;
        this.mNitrogenSoilStatus = mNitrogenSoilStatus;
        this.mNoOfFruits = mNoOfFruits;
        this.mNoOfRainydate = mNoOfRainydate;
        this.mNoOfTiller = mNoOfTiller;
        this.mOrganicContentPh = mOrganicContentPh;
        this.mPanicleSize = mPanicleSize;
        this.mPhosphorusSoilStatus = mPhosphorusSoilStatus;
        this.mPlantHeight = mPlantHeight;
        this.mPotassiumSoilStatus = mPotassiumSoilStatus;
        this.mRainFallDistribution = mRainFallDistribution;
        this.mRainFallObservation = mRainFallObservation;
        this.mThGrainWeight = mThGrainWeight;
    }

    public String getCropCondition() {
        return mCropCondition;
    }

    public void setCropCondition(String cropCondition) {
        mCropCondition = cropCondition;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getGrainYieldPlant() {
        return mGrainYieldPlant;
    }

    public void setGrainYieldPlant(String grainYieldPlant) {
        mGrainYieldPlant = grainYieldPlant;
    }

    public String getGrainYieldPlot() {
        return mGrainYieldPlot;
    }

    public void setGrainYieldPlot(String grainYieldPlot) {
        mGrainYieldPlot = grainYieldPlot;
    }

    public String getHarvestingDate() {
        return mHarvestingDate;
    }

    public void setHarvestingDate(String harvestingDate) {
        mHarvestingDate = harvestingDate;
    }

    public String getIrrigationWaterPh() {
        return mIrrigationWaterPh;
    }

    public void setIrrigationWaterPh(String irrigationWaterPh) {
        mIrrigationWaterPh = irrigationWaterPh;
    }

    public String getNitrogenSoilStatus() {
        return mNitrogenSoilStatus;
    }

    public void setNitrogenSoilStatus(String nitrogenSoilStatus) {
        mNitrogenSoilStatus = nitrogenSoilStatus;
    }

    public String getNoOfFruits() {
        return mNoOfFruits;
    }

    public void setNoOfFruits(String noOfFruits) {
        mNoOfFruits = noOfFruits;
    }

    public String getNoOfRainydate() {
        return mNoOfRainydate;
    }

    public void setNoOfRainydate(String noOfRainydate) {
        mNoOfRainydate = noOfRainydate;
    }

    public String getNoOfTiller() {
        return mNoOfTiller;
    }

    public void setNoOfTiller(String noOfTiller) {
        mNoOfTiller = noOfTiller;
    }

    public String getOrganicContentPh() {
        return mOrganicContentPh;
    }

    public void setOrganicContentPh(String organicContentPh) {
        mOrganicContentPh = organicContentPh;
    }

    public String getPanicleSize() {
        return mPanicleSize;
    }

    public void setPanicleSize(String panicleSize) {
        mPanicleSize = panicleSize;
    }

    public String getPhosphorusSoilStatus() {
        return mPhosphorusSoilStatus;
    }

    public void setPhosphorusSoilStatus(String phosphorusSoilStatus) {
        mPhosphorusSoilStatus = phosphorusSoilStatus;
    }

    public String getPlantHeight() {
        return mPlantHeight;
    }

    public void setPlantHeight(String plantHeight) {
        mPlantHeight = plantHeight;
    }

    public String getPotassiumSoilStatus() {
        return mPotassiumSoilStatus;
    }

    public void setPotassiumSoilStatus(String potassiumSoilStatus) {
        mPotassiumSoilStatus = potassiumSoilStatus;
    }

    public String getRainFallDistribution() {
        return mRainFallDistribution;
    }

    public void setRainFallDistribution(String rainFallDistribution) {
        mRainFallDistribution = rainFallDistribution;
    }

    public String getRainFallObservation() {
        return mRainFallObservation;
    }

    public void setRainFallObservation(String rainFallObservation) {
        mRainFallObservation = rainFallObservation;
    }

    public String getThGrainWeight() {
        return mThGrainWeight;
    }

    public void setThGrainWeight(String thGrainWeight) {
        mThGrainWeight = thGrainWeight;
    }

}
