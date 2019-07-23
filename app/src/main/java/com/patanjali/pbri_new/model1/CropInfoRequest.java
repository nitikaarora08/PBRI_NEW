
package com.patanjali.pbri_new.model1;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropInfoRequest {

    @SerializedName("crop_area")
    private String mCropArea;
    @SerializedName("crop_info_id")
    private String mCropInfoId;
    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("crop_status")
    private String mCropStatus;
    @SerializedName("diseases_observed")
    private String mDiseasesObserved;
    @SerializedName("farm_lab_id")
    private String mFarmLabId;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("fertilizer_calculator")
    private String mFertilizerCalculator;
    @SerializedName("fertlizer_name")
    private String mFertlizerName;
    @SerializedName("fst_application_date")
    private String mFstApplicationDate;
    @SerializedName("fst_pestapplication_date")
    private String mFstPestapplicationDate;
    @SerializedName("land_preparation_date")
    private String mLandPreparationDate;
    @SerializedName("nematodes")
    private String mNematodes;
    @SerializedName("no_of_irrigation")
    private String mNoOfIrrigation;
    @SerializedName("others")
    private String mOthers;
    @SerializedName("pesticide")
    private String mPesticide;
    @SerializedName("planting_date")
    private String mPlantingDate;
    @SerializedName("showing_date")
    private String mShowingDate;
    @SerializedName("snd_application_date")
    private String mSndApplicationDate;
    @SerializedName("snd_pestapplication_date")
    private String mSndPestapplicationDate;
    @SerializedName("variety_name")
    private String mVarietyName;
    @SerializedName("virus")
    private String mVirus;
    @SerializedName("weed_control")
    private String mWeedControl;

 @SerializedName("pest_observed")
    private String mPestObserved;

@SerializedName("fst_weed_date")
    private String mfst_weed_date;

@SerializedName("snd_weed_date")
    private String msnd_weed_date;

@SerializedName("sub_crop_id")
    private String msub_crop_id;



    public CropInfoRequest(String mCropArea, String mCropInfoId, String mCropName, String mCropStatus, String mDiseasesObserved,
                           String mFarmLabId, String mFarmerId, String mFertilizerCalculator, String mFertlizerName,
                           String mFstApplicationDate, String mFstPestapplicationDate, String mLandPreparationDate,
                           String mNematodes, String mNoOfIrrigation, String mOthers, String mPesticide, String mPlantingDate,
                           String mShowingDate, String mSndApplicationDate, String mSndPestapplicationDate,
                           String mVarietyName, String mVirus, String mWeedControl,String mPestObserved,String fst_weed_date
    ,String msnd_weed_date,String sub_crop_id) {
        this.mCropArea = mCropArea;
        this.mCropInfoId = mCropInfoId;
        this.mCropName = mCropName;
        this.mCropStatus = mCropStatus;
        this.mDiseasesObserved = mDiseasesObserved;
        this.mFarmLabId = mFarmLabId;
        this.mFarmerId = mFarmerId;
        this.mFertilizerCalculator = mFertilizerCalculator;
        this.mFertlizerName = mFertlizerName;
        this.mFstApplicationDate = mFstApplicationDate;
        this.mFstPestapplicationDate = mFstPestapplicationDate;
        this.mLandPreparationDate = mLandPreparationDate;
        this.mNematodes = mNematodes;
        this.mNoOfIrrigation = mNoOfIrrigation;
        this.mOthers = mOthers;
        this.mPesticide = mPesticide;
        this.mPlantingDate = mPlantingDate;
        this.mShowingDate = mShowingDate;
        this.mSndApplicationDate = mSndApplicationDate;
        this.mSndPestapplicationDate = mSndPestapplicationDate;
        this.mVarietyName = mVarietyName;
        this.mVirus = mVirus;
        this.mWeedControl = mWeedControl;
        this.mPestObserved = mPestObserved;
        this.mfst_weed_date = fst_weed_date;
        this.msnd_weed_date = msnd_weed_date;
        this.msub_crop_id = sub_crop_id;
    }

    public String getsub_crop_id() {
        return msub_crop_id;
    }

    public void getsub_crop_id(String sub_crop_id) {
        msub_crop_id = sub_crop_id;
    }
 public String getCropArea() {
        return mCropArea;
    }

    public void setCropArea(String cropArea) {
        mCropArea = cropArea;
    }

    public String getCropInfoId() {
        return mCropInfoId;
    }

    public void setCropInfoId(String cropInfoId) {
        mCropInfoId = cropInfoId;
    }

    public String getCropName() {
        return mCropName;
    }

    public void setCropName(String cropName) {
        mCropName = cropName;
    }

    public String getCropStatus() {
        return mCropStatus;
    }

    public void setCropStatus(String cropStatus) {
        mCropStatus = cropStatus;
    }

    public String getDiseasesObserved() {
        return mDiseasesObserved;
    }

    public void setDiseasesObserved(String diseasesObserved) {
        mDiseasesObserved = diseasesObserved;
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

    public String getFertilizerCalculator() {
        return mFertilizerCalculator;
    }

    public void setFertilizerCalculator(String fertilizerCalculator) {
        mFertilizerCalculator = fertilizerCalculator;
    }

    public String getFertlizerName() {
        return mFertlizerName;
    }

    public void setFertlizerName(String fertlizerName) {
        mFertlizerName = fertlizerName;
    }

    public String getFstApplicationDate() {
        return mFstApplicationDate;
    }

    public void setFstApplicationDate(String fstApplicationDate) {
        mFstApplicationDate = fstApplicationDate;
    }

    public String getFstPestapplicationDate() {
        return mFstPestapplicationDate;
    }

    public void setFstPestapplicationDate(String fstPestapplicationDate) {
        mFstPestapplicationDate = fstPestapplicationDate;
    }

    public String getLandPreparationDate() {
        return mLandPreparationDate;
    }

    public void setLandPreparationDate(String landPreparationDate) {
        mLandPreparationDate = landPreparationDate;
    }

    public String getNematodes() {
        return mNematodes;
    }

    public void setNematodes(String nematodes) {
        mNematodes = nematodes;
    }

    public String getNoOfIrrigation() {
        return mNoOfIrrigation;
    }

    public void setNoOfIrrigation(String noOfIrrigation) {
        mNoOfIrrigation = noOfIrrigation;
    }

    public String getOthers() {
        return mOthers;
    }

    public void setOthers(String others) {
        mOthers = others;
    }

    public String getPesticide() {
        return mPesticide;
    }

    public void setPesticide(String pesticide) {
        mPesticide = pesticide;
    }

    public String getPlantingDate() {
        return mPlantingDate;
    }

    public void setPlantingDate(String plantingDate) {
        mPlantingDate = plantingDate;
    }

    public String getShowingDate() {
        return mShowingDate;
    }

    public void setShowingDate(String showingDate) {
        mShowingDate = showingDate;
    }

    public String getSndApplicationDate() {
        return mSndApplicationDate;
    }

    public void setSndApplicationDate(String sndApplicationDate) {
        mSndApplicationDate = sndApplicationDate;
    }

    public String getSndPestapplicationDate() {
        return mSndPestapplicationDate;
    }

    public void setSndPestapplicationDate(String sndPestapplicationDate) {
        mSndPestapplicationDate = sndPestapplicationDate;
    }

    public String getVarietyName() {
        return mVarietyName;
    }

    public void setVarietyName(String varietyName) {
        mVarietyName = varietyName;
    }

    public String getVirus() {
        return mVirus;
    }

    public void setVirus(String virus) {
        mVirus = virus;
    }

    public String getWeedControl() {
        return mWeedControl;
    }

    public void setWeedControl(String weedControl) {
        mWeedControl = weedControl;
    }

}
