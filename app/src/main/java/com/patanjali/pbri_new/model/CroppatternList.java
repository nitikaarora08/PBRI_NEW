
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class CroppatternList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("soil_id")
    private String mSoilId;
    @SerializedName("soil_name")
    private String mSoilName;
    @SerializedName("soil_status")
    private String mSoilStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getSoilId() {
        return mSoilId;
    }

    public void setSoilId(String soilId) {
        mSoilId = soilId;
    }

    public String getSoilName() {
        return mSoilName;
    }

    public void setSoilName(String soilName) {
        mSoilName = soilName;
    }

    public String getSoilStatus() {
        return mSoilStatus;
    }

    public void setSoilStatus(String soilStatus) {
        mSoilStatus = soilStatus;
    }

}
