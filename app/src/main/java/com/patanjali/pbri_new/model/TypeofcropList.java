
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TypeofcropList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("crop_id")
    private String mCropId;
    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("crop_status")
    private String mCropStatus;

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

}
