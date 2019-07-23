
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class ReuestLoactionAndSoil {

    @SerializedName("crop_season")
    private String mCropSeason;
    @SerializedName("cropping_pattern")
    private String mCroppingPattern;
    @SerializedName("farm_id")
    private String mFarmId;
    @SerializedName("farm_lab_id")
    private String mFarmLabId;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("landmark")
    private String mLandmark;
    @SerializedName("latlong")
    private String mLatlong;
    @SerializedName("soil_sample_date")
    private String mSoilSampleDate;
    @SerializedName("soil_type")
    private String mSoilType;


    public ReuestLoactionAndSoil(String mCropSeason, String mCroppingPattern, String mFarmId, String mFarmLabId, String mFarmerId, String mImage, String mLandmark, String mLatlong, String mSoilSampleDate, String mSoilType) {
        this.mCropSeason = mCropSeason;
        this.mCroppingPattern = mCroppingPattern;
        this.mFarmId = mFarmId;
        this.mFarmLabId = mFarmLabId;
        this.mFarmerId = mFarmerId;
        this.mImage = mImage;
        this.mLandmark = mLandmark;
        this.mLatlong = mLatlong;
        this.mSoilSampleDate = mSoilSampleDate;
        this.mSoilType = mSoilType;
    }

    public String getCropSeason() {
        return mCropSeason;
    }

    public void setCropSeason(String cropSeason) {
        mCropSeason = cropSeason;
    }

    public String getCroppingPattern() {
        return mCroppingPattern;
    }

    public void setCroppingPattern(String croppingPattern) {
        mCroppingPattern = croppingPattern;
    }

    public String getFarmId() {
        return mFarmId;
    }

    public void setFarmId(String farmId) {
        mFarmId = farmId;
    }

    public String getFarmLabId() {
        return mFarmLabId;
    }

    public void setFarmLabId(String farmLabId) {
        mFarmLabId = farmLabId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getLandmark() {
        return mLandmark;
    }

    public void setLandmark(String landmark) {
        mLandmark = landmark;
    }

    public String getLatlong() {
        return mLatlong;
    }

    public void setLatlong(String latlong) {
        mLatlong = latlong;
    }

    public String getSoilSampleDate() {
        return mSoilSampleDate;
    }

    public void setSoilSampleDate(String soilSampleDate) {
        mSoilSampleDate = soilSampleDate;
    }

    public String getSoilType() {
        return mSoilType;
    }

    public void setSoilType(String soilType) {
        mSoilType = soilType;
    }

}
