
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestLoactionAndSoil {

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
    @SerializedName("organic_carbon")
    private String mOrganicCarbon;
    @SerializedName("soil_ph")
    private String mSoilPh;
    @SerializedName("soil_sample_date")
    private String mSoilSampleDate;
    @SerializedName("soil_status_nitrogen")
    private String mSoilStatusNitrogen;
    @SerializedName("soil_status_phosphorus")
    private String mSoilStatusPhosphorus;
    @SerializedName("soil_status_potassium")
    private String mSoilStatusPotassium;
    @SerializedName("soil_type")
    private String mSoilType;


    public RequestLoactionAndSoil(String mCropSeason, String mCroppingPattern, String mFarmId,
                                  String mFarmerId, String mImage, String mLandmark, String mLatlong,String mSoilSampleDate) {
        this.mCropSeason = mCropSeason;
        this.mCroppingPattern = mCroppingPattern;
        this.mFarmId = mFarmId;
        this.mFarmLabId = mFarmLabId;
        this.mFarmerId = mFarmerId;
        this.mImage = mImage;
        this.mLandmark = mLandmark;
        this.mLatlong = mLatlong;
        this.mSoilSampleDate = mSoilSampleDate;
    }

    public RequestLoactionAndSoil(String mFarmId, String mFarmLabId, String mFarmerId, String mOrganicCarbon,
                                  String mSoilPh, String mSoilSampleDate,
                                  String mSoilStatusNitrogen, String mSoilStatusPhosphorus,
                                  String mSoilStatusPotassium, String mSoilType,String mLatlong) {
        this.mFarmId = mFarmId;
        this.mFarmLabId = mFarmLabId;
        this.mFarmerId = mFarmerId;
        this.mOrganicCarbon = mOrganicCarbon;
        this.mSoilPh = mSoilPh;
        this.mSoilSampleDate = mSoilSampleDate;
        this.mSoilStatusNitrogen = mSoilStatusNitrogen;
        this.mSoilStatusPhosphorus = mSoilStatusPhosphorus;
        this.mSoilStatusPotassium = mSoilStatusPotassium;
        this.mSoilType = mSoilType;
        this.mLatlong = mLatlong;
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

    public String getOrganicCarbon() {
        return mOrganicCarbon;
    }

    public void setOrganicCarbon(String organicCarbon) {
        mOrganicCarbon = organicCarbon;
    }

    public String getSoilPh() {
        return mSoilPh;
    }

    public void setSoilPh(String soilPh) {
        mSoilPh = soilPh;
    }

    public String getSoilSampleDate() {
        return mSoilSampleDate;
    }

    public void setSoilSampleDate(String soilSampleDate) {
        mSoilSampleDate = soilSampleDate;
    }

    public String getSoilStatusNitrogen() {
        return mSoilStatusNitrogen;
    }

    public void setSoilStatusNitrogen(String soilStatusNitrogen) {
        mSoilStatusNitrogen = soilStatusNitrogen;
    }

    public String getSoilStatusPhosphorus() {
        return mSoilStatusPhosphorus;
    }

    public void setSoilStatusPhosphorus(String soilStatusPhosphorus) {
        mSoilStatusPhosphorus = soilStatusPhosphorus;
    }

    public String getSoilStatusPotassium() {
        return mSoilStatusPotassium;
    }

    public void setSoilStatusPotassium(String soilStatusPotassium) {
        mSoilStatusPotassium = soilStatusPotassium;
    }

    public String getSoilType() {
        return mSoilType;
    }

    public void setSoilType(String soilType) {
        mSoilType = soilType;
    }

}
