
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class CropNameList {

    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("crop_status_id")
    private String mCropStatusId;
    @SerializedName("id")
    private String mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("status")
    private String mStatus;

    public String getCropName() {
        return mCropName;
    }

    public void setCropName(String cropName) {
        mCropName = cropName;
    }

    public String getCropStatusId() {
        return mCropStatusId;
    }

    public void setCropStatusId(String cropStatusId) {
        mCropStatusId = cropStatusId;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
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
