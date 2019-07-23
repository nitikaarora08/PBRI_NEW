
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class IrrigationList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("irrigation_id")
    private String mIrrigationId;
    @SerializedName("irrigation_name")
    private String mIrrigationName;
    @SerializedName("irrigation_status")
    private String mIrrigationStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getIrrigationId() {
        return mIrrigationId;
    }

    public void setIrrigationId(String irrigationId) {
        mIrrigationId = irrigationId;
    }

    public String getIrrigationName() {
        return mIrrigationName;
    }

    public void setIrrigationName(String irrigationName) {
        mIrrigationName = irrigationName;
    }

    public String getIrrigationStatus() {
        return mIrrigationStatus;
    }

    public void setIrrigationStatus(String irrigationStatus) {
        mIrrigationStatus = irrigationStatus;
    }

}
