
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PostCropInformationModel {

    @SerializedName("basal_dose")
    private String mBasalDose;
    @SerializedName("crop_details_id")
    private String mCropDetailsId;
    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("crop_nematodes")
    private String mCropNematodes;
    @SerializedName("crop_virus")
    private String mCropVirus;
    @SerializedName("diseases_first_date")
    private String mDiseasesFirstDate;
    @SerializedName("diseases_observed")
    private List<String> mDiseasesObserved;
    @SerializedName("diseases_second_date")
    private String mDiseasesSecondDate;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("first_splitdose_date")
    private String mFirstSplitdoseDate;
    @SerializedName("first_weeding_date")
    private String mFirstWeedingDate;
    @SerializedName("lab_id")
    private String mLabId;
    @SerializedName("land_preparation_date")
    private String mLandPreparationDate;
    @SerializedName("no_of_irrigation")
    private String mNoOfIrrigation;
    @SerializedName("pest_observed")
    private List<String> mPestObserved;
    @SerializedName("pestfirst_application_date")
    private String mPestfirstApplicationDate;
    @SerializedName("pestsecond_application_date")
    private String mPestsecondApplicationDate;
    @SerializedName("planting_date")
    private String mPlantingDate;
    @SerializedName("second_splitdose_date")
    private String mSecondSplitdoseDate;
    @SerializedName("second_weeding_date")
    private String mSecondWeedingDate;
    @SerializedName("showing_date")
    private String mShowingDate;
    @SerializedName("soil_collect_date")
    private String mSoilCollectDate;
    @SerializedName("top_dose_date")
    private String mTopDoseDate;
    @SerializedName("variety_name")
    private String mVarietyName;
    @SerializedName("weed_noticed")
    private String mWeedNoticed;

    public PostCropInformationModel(String mBasalDose, String mCropDetailsId, String mCropName, String mCropNematodes, String mCropVirus, String mDiseasesFirstDate, List<String> mDiseasesObserved, String mDiseasesSecondDate, String mFarmerId, String mFirstSplitdoseDate, String mFirstWeedingDate, String mLabId, String mLandPreparationDate, String mNoOfIrrigation, List<String> mPestObserved, String mPestfirstApplicationDate, String mPestsecondApplicationDate, String mPlantingDate, String mSecondSplitdoseDate, String mSecondWeedingDate, String mShowingDate, String mSoilCollectDate, String mTopDoseDate, String mVarietyName, String mWeedNoticed) {
        this.mBasalDose = mBasalDose;
        this.mCropDetailsId = mCropDetailsId;
        this.mCropName = mCropName;
        this.mCropNematodes = mCropNematodes;
        this.mCropVirus = mCropVirus;
        this.mDiseasesFirstDate = mDiseasesFirstDate;
        this.mDiseasesObserved = mDiseasesObserved;
        this.mDiseasesSecondDate = mDiseasesSecondDate;
        this.mFarmerId = mFarmerId;
        this.mFirstSplitdoseDate = mFirstSplitdoseDate;
        this.mFirstWeedingDate = mFirstWeedingDate;
        this.mLabId = mLabId;
        this.mLandPreparationDate = mLandPreparationDate;
        this.mNoOfIrrigation = mNoOfIrrigation;
        this.mPestObserved = mPestObserved;
        this.mPestfirstApplicationDate = mPestfirstApplicationDate;
        this.mPestsecondApplicationDate = mPestsecondApplicationDate;
        this.mPlantingDate = mPlantingDate;
        this.mSecondSplitdoseDate = mSecondSplitdoseDate;
        this.mSecondWeedingDate = mSecondWeedingDate;
        this.mShowingDate = mShowingDate;
        this.mSoilCollectDate = mSoilCollectDate;
        this.mTopDoseDate = mTopDoseDate;
        this.mVarietyName = mVarietyName;
        this.mWeedNoticed = mWeedNoticed;
    }

    public String getBasalDose() {
        return mBasalDose;
    }

    public void setBasalDose(String basalDose) {
        mBasalDose = basalDose;
    }

    public String getCropDetailsId() {
        return mCropDetailsId;
    }

    public void setCropDetailsId(String cropDetailsId) {
        mCropDetailsId = cropDetailsId;
    }

    public String getCropName() {
        return mCropName;
    }

    public void setCropName(String cropName) {
        mCropName = cropName;
    }

    public String getCropNematodes() {
        return mCropNematodes;
    }

    public void setCropNematodes(String cropNematodes) {
        mCropNematodes = cropNematodes;
    }

    public String getCropVirus() {
        return mCropVirus;
    }

    public void setCropVirus(String cropVirus) {
        mCropVirus = cropVirus;
    }

    public String getDiseasesFirstDate() {
        return mDiseasesFirstDate;
    }

    public void setDiseasesFirstDate(String diseasesFirstDate) {
        mDiseasesFirstDate = diseasesFirstDate;
    }

    public List<String> getDiseasesObserved() {
        return mDiseasesObserved;
    }

    public void setDiseasesObserved(List<String> diseasesObserved) {
        mDiseasesObserved = diseasesObserved;
    }

    public String getDiseasesSecondDate() {
        return mDiseasesSecondDate;
    }

    public void setDiseasesSecondDate(String diseasesSecondDate) {
        mDiseasesSecondDate = diseasesSecondDate;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFirstSplitdoseDate() {
        return mFirstSplitdoseDate;
    }

    public void setFirstSplitdoseDate(String firstSplitdoseDate) {
        mFirstSplitdoseDate = firstSplitdoseDate;
    }

    public String getFirstWeedingDate() {
        return mFirstWeedingDate;
    }

    public void setFirstWeedingDate(String firstWeedingDate) {
        mFirstWeedingDate = firstWeedingDate;
    }

    public String getLabId() {
        return mLabId;
    }

    public void setLabId(String labId) {
        mLabId = labId;
    }

    public String getLandPreparationDate() {
        return mLandPreparationDate;
    }

    public void setLandPreparationDate(String landPreparationDate) {
        mLandPreparationDate = landPreparationDate;
    }

    public String getNoOfIrrigation() {
        return mNoOfIrrigation;
    }

    public void setNoOfIrrigation(String noOfIrrigation) {
        mNoOfIrrigation = noOfIrrigation;
    }

    public List<String> getPestObserved() {
        return mPestObserved;
    }

    public void setPestObserved(List<String> pestObserved) {
        mPestObserved = pestObserved;
    }

    public String getPestfirstApplicationDate() {
        return mPestfirstApplicationDate;
    }

    public void setPestfirstApplicationDate(String pestfirstApplicationDate) {
        mPestfirstApplicationDate = pestfirstApplicationDate;
    }

    public String getPestsecondApplicationDate() {
        return mPestsecondApplicationDate;
    }

    public void setPestsecondApplicationDate(String pestsecondApplicationDate) {
        mPestsecondApplicationDate = pestsecondApplicationDate;
    }

    public String getPlantingDate() {
        return mPlantingDate;
    }

    public void setPlantingDate(String plantingDate) {
        mPlantingDate = plantingDate;
    }

    public String getSecondSplitdoseDate() {
        return mSecondSplitdoseDate;
    }

    public void setSecondSplitdoseDate(String secondSplitdoseDate) {
        mSecondSplitdoseDate = secondSplitdoseDate;
    }

    public String getSecondWeedingDate() {
        return mSecondWeedingDate;
    }

    public void setSecondWeedingDate(String secondWeedingDate) {
        mSecondWeedingDate = secondWeedingDate;
    }

    public String getShowingDate() {
        return mShowingDate;
    }

    public void setShowingDate(String showingDate) {
        mShowingDate = showingDate;
    }

    public String getSoilCollectDate() {
        return mSoilCollectDate;
    }

    public void setSoilCollectDate(String soilCollectDate) {
        mSoilCollectDate = soilCollectDate;
    }

    public String getTopDoseDate() {
        return mTopDoseDate;
    }

    public void setTopDoseDate(String topDoseDate) {
        mTopDoseDate = topDoseDate;
    }

    public String getVarietyName() {
        return mVarietyName;
    }

    public void setVarietyName(String varietyName) {
        mVarietyName = varietyName;
    }

    public String getWeedNoticed() {
        return mWeedNoticed;
    }

    public void setWeedNoticed(String weedNoticed) {
        mWeedNoticed = weedNoticed;
    }

}
