
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropDetail {

    @SerializedName("area_main_crop")
    private String mAreaMainCrop;
    @SerializedName("area_of_crops")
    private String mAreaOfCrops;
    @SerializedName("area_vertical_crop")
    private String mAreaVerticalCrop;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("crop_id")
    private String mCropId;
    @SerializedName("crop_season")
    private String mCropSeason;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("marketing")
    private String mMarketing;
    @SerializedName("profit_loss")
    private String mProfitLoss;
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

    public String getAreaMainCrop() {
        return mAreaMainCrop;
    }

    public void setAreaMainCrop(String areaMainCrop) {
        mAreaMainCrop = areaMainCrop;
    }

    public String getAreaOfCrops() {
        return mAreaOfCrops;
    }

    public void setAreaOfCrops(String areaOfCrops) {
        mAreaOfCrops = areaOfCrops;
    }

    public String getAreaVerticalCrop() {
        return mAreaVerticalCrop;
    }

    public void setAreaVerticalCrop(String areaVerticalCrop) {
        mAreaVerticalCrop = areaVerticalCrop;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getCropId() {
        return mCropId;
    }

    public void setCropId(String cropId) {
        mCropId = cropId;
    }

    public String getCropSeason() {
        return mCropSeason;
    }

    public void setCropSeason(String cropSeason) {
        mCropSeason = cropSeason;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getMarketing() {
        return mMarketing;
    }

    public void setMarketing(String marketing) {
        mMarketing = marketing;
    }

    public String getProfitLoss() {
        return mProfitLoss;
    }

    public void setProfitLoss(String profitLoss) {
        mProfitLoss = profitLoss;
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
