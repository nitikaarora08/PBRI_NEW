
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class PostFarmLabModel {

    @SerializedName("farm_id")
    private String mFarmId;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("irrgigation_ph")
    private String mIrrgigationPh;
    @SerializedName("land_layout_main")
    private String mLandLayout;
    @SerializedName("land_layout_vertical")
    private String mLayoutName;
    @SerializedName("organic_matter_ph")
    private String mOrganicMatterPh;
    @SerializedName("soil_sample_date")
    private String mSoilSampleDate;
    @SerializedName("soil_status_nitrogen")
    private String mSoilStatusNitrogen;
    @SerializedName("soil_status_phosphorus")
    private String mSoilStatusPhosphorus;
    @SerializedName("soil_status_potassium")
    private String mSoilStatusPotassium;

    public PostFarmLabModel(String mFarmId, String mFarmerId, String mIrrgigationPh, String mLandLayout, String mLayoutName, String mOrganicMatterPh, String mSoilSampleDate, String mSoilStatusNitrogen, String mSoilStatusPhosphorus, String mSoilStatusPotassium) {
        this.mFarmId = mFarmId;
        this.mFarmerId = mFarmerId;
        this.mIrrgigationPh = mIrrgigationPh;
        this.mLandLayout = mLandLayout;
        this.mLayoutName = mLayoutName;
        this.mOrganicMatterPh = mOrganicMatterPh;
        this.mSoilSampleDate = mSoilSampleDate;
        this.mSoilStatusNitrogen = mSoilStatusNitrogen;
        this.mSoilStatusPhosphorus = mSoilStatusPhosphorus;
        this.mSoilStatusPotassium = mSoilStatusPotassium;
    }

    public String getFarmId() {
        return mFarmId;
    }

    public void setFarmId(String farmId) {
        mFarmId = farmId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getIrrgigationPh() {
        return mIrrgigationPh;
    }

    public void setIrrgigationPh(String irrgigationPh) {
        mIrrgigationPh = irrgigationPh;
    }

    public String getLandLayout() {
        return mLandLayout;
    }

    public void setLandLayout(String landLayout) {
        mLandLayout = landLayout;
    }

    public String getLayoutName() {
        return mLayoutName;
    }

    public void setLayoutName(String layoutName) {
        mLayoutName = layoutName;
    }

    public String getOrganicMatterPh() {
        return mOrganicMatterPh;
    }

    public void setOrganicMatterPh(String organicMatterPh) {
        mOrganicMatterPh = organicMatterPh;
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

}
