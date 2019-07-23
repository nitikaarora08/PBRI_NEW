
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropDiseasename {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("crop_deseases_id")
    private String mCropDeseasesId;
    @SerializedName("crop_infonameid")
    private String mCropInfonameid;
    @SerializedName("diseases_image")
    private String mDiseasesImage;
    @SerializedName("diseases_name")
    private String mDiseasesName;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("status")
    private String mStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getCropDeseasesId() {
        return mCropDeseasesId;
    }

    public void setCropDeseasesId(String cropDeseasesId) {
        mCropDeseasesId = cropDeseasesId;
    }

    public String getCropInfonameid() {
        return mCropInfonameid;
    }

    public void setCropInfonameid(String cropInfonameid) {
        mCropInfonameid = cropInfonameid;
    }

    public String getDiseasesImage() {
        return mDiseasesImage;
    }

    public void setDiseasesImage(String diseasesImage) {
        mDiseasesImage = diseasesImage;
    }

    public String getDiseasesName() {
        return mDiseasesName;
    }

    public void setDiseasesName(String diseasesName) {
        mDiseasesName = diseasesName;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
