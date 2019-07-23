
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class PostFarmCostModel {

    @SerializedName("cost_benefit_ratio")
    private String mCostBenefitRatio;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("fertilizer")
    private String mFertilizer;
    @SerializedName("harvesting_and_thresing")
    private String mHarvestingAndThresing;
    @SerializedName("irrigation")
    private String mIrrigation;
    @SerializedName("lab_id")
    private String mLabId;
    @SerializedName("lab_income")
    private String mLabIncome;
    @SerializedName("land_preparation")
    private String mLandPreparation;
    @SerializedName("market_value_main")
    private String mMarketValueMain;
    @SerializedName("market_value_vertical")
    private String mMarketValueVertical;
    @SerializedName("packing")
    private String mPacking;
    @SerializedName("pestisides")
    private String mpestisides;
    @SerializedName("planting")
    private String mPlanting;
    @SerializedName("seed")
    private String mSeed;
    @SerializedName("spraying")
    private String mSpraying;
    @SerializedName("total_cost")
    private String mTotalCost;
    @SerializedName("total_produce_main")
    private String mTotalProduceMain;
    @SerializedName("total_produce_vertical")
    private String mTotalProduceVertical;
    @SerializedName("transportation")
    private String mTransportation;
    @SerializedName("weeding")
    private String mWeeding;
    @SerializedName("winnoing")
    private String mWinnoing;

    @SerializedName("other_exp_amt")
    private String amount;

    @SerializedName("discription")
    private String discription;

    public PostFarmCostModel(String mCostBenefitRatio, String mFarmerId, String mFertilizer, String mHarvestingAndThresing, String mIrrigation, String mLabId, String mLabIncome, String mLandPreparation, String mMarketValueMain, String mMarketValueVertical, String mPacking, String mpestisides, String mPlanting, String mSeed, String mSpraying, String mTotalCost, String mTotalProduceMain, String mTotalProduceVertical, String mTransportation, String mWeeding, String mWinnoing, String amount, String discription) {
        this.mCostBenefitRatio = mCostBenefitRatio;
        this.mFarmerId = mFarmerId;
        this.mFertilizer = mFertilizer;
        this.mHarvestingAndThresing = mHarvestingAndThresing;
        this.mIrrigation = mIrrigation;
        this.mLabId = mLabId;
        this.mLabIncome = mLabIncome;
        this.mLandPreparation = mLandPreparation;
        this.mMarketValueMain = mMarketValueMain;
        this.mMarketValueVertical = mMarketValueVertical;
        this.mPacking = mPacking;
        this.mpestisides = mpestisides;
        this.mPlanting = mPlanting;
        this.mSeed = mSeed;
        this.mSpraying = mSpraying;
        this.mTotalCost = mTotalCost;
        this.mTotalProduceMain = mTotalProduceMain;
        this.mTotalProduceVertical = mTotalProduceVertical;
        this.mTransportation = mTransportation;
        this.mWeeding = mWeeding;
        this.mWinnoing = mWinnoing;
        this.amount = amount;
        this.discription = discription;
    }

    public String getCostBenefitRatio() {
        return mCostBenefitRatio;
    }

    public void setCostBenefitRatio(String costBenefitRatio) {
        mCostBenefitRatio = costBenefitRatio;
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

    public String getHarvestingAndThresing() {
        return mHarvestingAndThresing;
    }

    public void setHarvestingAndThresing(String harvestingAndThresing) {
        mHarvestingAndThresing = harvestingAndThresing;
    }

    public String getIrrigation() {
        return mIrrigation;
    }

    public void setIrrigation(String irrigation) {
        mIrrigation = irrigation;
    }

    public String getLabId() {
        return mLabId;
    }

    public void setLabId(String labId) {
        mLabId = labId;
    }

    public String getLabIncome() {
        return mLabIncome;
    }

    public void setLabIncome(String labIncome) {
        mLabIncome = labIncome;
    }

    public String getLandPreparation() {
        return mLandPreparation;
    }

    public void setLandPreparation(String landPreparation) {
        mLandPreparation = landPreparation;
    }

    public String getMarketValueMain() {
        return mMarketValueMain;
    }

    public void setMarketValueMain(String marketValueMain) {
        mMarketValueMain = marketValueMain;
    }

    public String getMarketValueVertical() {
        return mMarketValueVertical;
    }

    public void setMarketValueVertical(String marketValueVertical) {
        mMarketValueVertical = marketValueVertical;
    }

    public String getPacking() {
        return mPacking;
    }

    public void setPacking(String packing) {
        mPacking = packing;
    }

    public String getpestisides() {
        return mpestisides;
    }

    public void setpestisides(String pestisides) {
        mpestisides = pestisides;
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

    public String getSpraying() {
        return mSpraying;
    }

    public void setSpraying(String spraying) {
        mSpraying = spraying;
    }

    public String getTotalCost() {
        return mTotalCost;
    }

    public void setTotalCost(String totalCost) {
        mTotalCost = totalCost;
    }

    public String getTotalProduceMain() {
        return mTotalProduceMain;
    }

    public void setTotalProduceMain(String totalProduceMain) {
        mTotalProduceMain = totalProduceMain;
    }

    public String getTotalProduceVertical() {
        return mTotalProduceVertical;
    }

    public void setTotalProduceVertical(String totalProduceVertical) {
        mTotalProduceVertical = totalProduceVertical;
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

    public String getWinnoing() {
        return mWinnoing;
    }

    public void setWinnoing(String winnoing) {
        mWinnoing = winnoing;
    }

}
