
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SoilRecommended {

    @SerializedName("bio_fertilizer")
    private String mBioFertilizer;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("fym_ton")
    private String mFymTon;
    @SerializedName("green_manuring")
    private String mGreenManuring;
    @SerializedName("Jivamrit")
    private String mJivamrit;
    @SerializedName("npk_value")
    private String mNpkValue;
    @SerializedName("oil_cake")
    private String mOilCake;
    @SerializedName("PROM")
    private String mPROM;
    @SerializedName("recommended_combination")
    private String mRecommendedCombination;
    @SerializedName("soil_combination_id")
    private String mSoilCombinationId;

    public String getBioFertilizer() {
        return mBioFertilizer;
    }

    public void setBioFertilizer(String bioFertilizer) {
        mBioFertilizer = bioFertilizer;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getFymTon() {
        return mFymTon;
    }

    public void setFymTon(String fymTon) {
        mFymTon = fymTon;
    }

    public String getGreenManuring() {
        return mGreenManuring;
    }

    public void setGreenManuring(String greenManuring) {
        mGreenManuring = greenManuring;
    }

    public String getJivamrit() {
        return mJivamrit;
    }

    public void setJivamrit(String jivamrit) {
        mJivamrit = jivamrit;
    }

    public String getNpkValue() {
        return mNpkValue;
    }

    public void setNpkValue(String npkValue) {
        mNpkValue = npkValue;
    }

    public String getOilCake() {
        return mOilCake;
    }

    public void setOilCake(String oilCake) {
        mOilCake = oilCake;
    }

    public String getPROM() {
        return mPROM;
    }

    public void setPROM(String pROM) {
        mPROM = pROM;
    }

    public String getRecommendedCombination() {
        return mRecommendedCombination;
    }

    public void setRecommendedCombination(String recommendedCombination) {
        mRecommendedCombination = recommendedCombination;
    }

    public String getSoilCombinationId() {
        return mSoilCombinationId;
    }

    public void setSoilCombinationId(String soilCombinationId) {
        mSoilCombinationId = soilCombinationId;
    }

}
