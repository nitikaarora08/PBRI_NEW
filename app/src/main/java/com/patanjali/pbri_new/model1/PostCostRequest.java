
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PostCostRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("fertilizer")
    private String mFertilizer;
    @SerializedName("harvesting_and_threshing")
    private String mHarvestingAndThreshing;
    @SerializedName("irrigation")
    private String mIrrigation;
    @SerializedName("land_preparation")
    private String mLandPreparation;
    @SerializedName("main_crop_market_value")
    private String mMainCropMarketValue;
    @SerializedName("main_crop_marketing")
    private String mMainCropMarketing;
    @SerializedName("main_crop_production")
    private String mMainCropProduction;
    @SerializedName("other_expenses")
    private String mOtherExpenses;
    @SerializedName("other_market_value")
    private String mOtherMarketValue;
    @SerializedName("other_marketing")
    private String mOtherMarketing;
    @SerializedName("other_production")
    private String mOtherProduction;
    @SerializedName("packing")
    private String mPacking;
    @SerializedName("pesticides")
    private String mPesticides;
    @SerializedName("planting")
    private String mPlanting;
    @SerializedName("seed")
    private String mSeed;
    @SerializedName("sub_crop_market_value")
    private String mSubCropMarketValue;
    @SerializedName("sub_crop_marketing")
    private String mSubCropMarketing;
    @SerializedName("sub_crop_production")
    private String mSubCropProduction;
    @SerializedName("transportation")
    private String mTransportation;
    @SerializedName("weeding")
    private String mWeeding;
    @SerializedName("winnowing")
    private String mWinnowing;
  @SerializedName("farm_lab_id")
    private String farmlabid;


    public PostCostRequest(String farmlabid,String mFarmerId, String mFertilizer, String mHarvestingAndThreshing, String mIrrigation, String mLandPreparation, String mMainCropMarketValue, String mMainCropMarketing, String mMainCropProduction, String mOtherExpenses, String mOtherMarketValue, String mOtherMarketing, String mOtherProduction, String mPacking, String mPesticides, String mPlanting, String mSeed, String mSubCropMarketValue, String mSubCropMarketing, String mSubCropProduction, String mTransportation, String mWeeding, String mWinnowing) {
        this.farmlabid = farmlabid;
        this.mFarmerId = mFarmerId;
        this.mFertilizer = mFertilizer;
        this.mHarvestingAndThreshing = mHarvestingAndThreshing;
        this.mIrrigation = mIrrigation;
        this.mLandPreparation = mLandPreparation;
        this.mMainCropMarketValue = mMainCropMarketValue;
        this.mMainCropMarketing = mMainCropMarketing;
        this.mMainCropProduction = mMainCropProduction;
        this.mOtherExpenses = mOtherExpenses;
        this.mOtherMarketValue = mOtherMarketValue;
        this.mOtherMarketing = mOtherMarketing;
        this.mOtherProduction = mOtherProduction;
        this.mPacking = mPacking;
        this.mPesticides = mPesticides;
        this.mPlanting = mPlanting;
        this.mSeed = mSeed;
        this.mSubCropMarketValue = mSubCropMarketValue;
        this.mSubCropMarketing = mSubCropMarketing;
        this.mSubCropProduction = mSubCropProduction;
        this.mTransportation = mTransportation;
        this.mWeeding = mWeeding;
        this.mWinnowing = mWinnowing;
    }

    public String getfarm_lab_id() {
        return farmlabid;
    }

    public void setfarm_lab_id(String farmlabid) {
        this.farmlabid = farmlabid;
    }
 public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFertilizer() {
        return mFertilizer;
    }

    public void setFertilizer(String fertilizer) {
        mFertilizer = fertilizer;
    }

    public String getHarvestingAndThreshing() {
        return mHarvestingAndThreshing;
    }

    public void setHarvestingAndThreshing(String harvestingAndThreshing) {
        mHarvestingAndThreshing = harvestingAndThreshing;
    }

    public String getIrrigation() {
        return mIrrigation;
    }

    public void setIrrigation(String irrigation) {
        mIrrigation = irrigation;
    }

    public String getLandPreparation() {
        return mLandPreparation;
    }

    public void setLandPreparation(String landPreparation) {
        mLandPreparation = landPreparation;
    }

    public String getMainCropMarketValue() {
        return mMainCropMarketValue;
    }

    public void setMainCropMarketValue(String mainCropMarketValue) {
        mMainCropMarketValue = mainCropMarketValue;
    }

    public String getMainCropMarketing() {
        return mMainCropMarketing;
    }

    public void setMainCropMarketing(String mainCropMarketing) {
        mMainCropMarketing = mainCropMarketing;
    }

    public String getMainCropProduction() {
        return mMainCropProduction;
    }

    public void setMainCropProduction(String mainCropProduction) {
        mMainCropProduction = mainCropProduction;
    }

    public String getOtherExpenses() {
        return mOtherExpenses;
    }

    public void setOtherExpenses(String otherExpenses) {
        mOtherExpenses = otherExpenses;
    }

    public String getOtherMarketValue() {
        return mOtherMarketValue;
    }

    public void setOtherMarketValue(String otherMarketValue) {
        mOtherMarketValue = otherMarketValue;
    }

    public String getOtherMarketing() {
        return mOtherMarketing;
    }

    public void setOtherMarketing(String otherMarketing) {
        mOtherMarketing = otherMarketing;
    }

    public String getOtherProduction() {
        return mOtherProduction;
    }

    public void setOtherProduction(String otherProduction) {
        mOtherProduction = otherProduction;
    }

    public String getPacking() {
        return mPacking;
    }

    public void setPacking(String packing) {
        mPacking = packing;
    }

    public String getPesticides() {
        return mPesticides;
    }

    public void setPesticides(String pesticides) {
        mPesticides = pesticides;
    }

    public String getPlanting() {
        return mPlanting;
    }

    public void setPlanting(String planting) {
        mPlanting = planting;
    }

    public String getSeed() {
        return mSeed;
    }

    public void setSeed(String seed) {
        mSeed = seed;
    }

    public String getSubCropMarketValue() {
        return mSubCropMarketValue;
    }

    public void setSubCropMarketValue(String subCropMarketValue) {
        mSubCropMarketValue = subCropMarketValue;
    }

    public String getSubCropMarketing() {
        return mSubCropMarketing;
    }

    public void setSubCropMarketing(String subCropMarketing) {
        mSubCropMarketing = subCropMarketing;
    }

    public String getSubCropProduction() {
        return mSubCropProduction;
    }

    public void setSubCropProduction(String subCropProduction) {
        mSubCropProduction = subCropProduction;
    }

    public String getTransportation() {
        return mTransportation;
    }

    public void setTransportation(String transportation) {
        mTransportation = transportation;
    }

    public String getWeeding() {
        return mWeeding;
    }

    public void setWeeding(String weeding) {
        mWeeding = weeding;
    }

    public String getWinnowing() {
        return mWinnowing;
    }

    public void setWinnowing(String winnowing) {
        mWinnowing = winnowing;
    }

}
