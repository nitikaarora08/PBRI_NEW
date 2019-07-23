
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropPestname {

//    @SerializedName("created_at")
//    private String mCreatedAt;
    @SerializedName("crop_infonameid")
    private String mCropInfonameid;
    @SerializedName("crop_pest_id")
    private String mCropPestId;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("pest_image")
    private String mPestImage;
    @SerializedName("pest_name")
    private String mPestName;
//    @SerializedName("pest_status")
//    private String mPestStatus;
//
//    public String getCreatedAt() {
//        return mCreatedAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        mCreatedAt = createdAt;
//    }

    public String getCropInfonameid() {
        return mCropInfonameid;
    }

    public void setCropInfonameid(String cropInfonameid) {
        mCropInfonameid = cropInfonameid;
    }

    public String getCropPestId() {
        return mCropPestId;
    }

    public void setCropPestId(String cropPestId) {
        mCropPestId = cropPestId;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public String getPestImage() {
        return mPestImage;
    }

    public void setPestImage(String pestImage) {
        mPestImage = pestImage;
    }

    public String getPestName() {
        return mPestName;
    }

    public void setPestName(String pestName) {
        mPestName = pestName;
    }

//    public String getPestStatus() {
//        return mPestStatus;
//    }
//
//    public void setPestStatus(String pestStatus) {
//        mPestStatus = pestStatus;
//    }

}
