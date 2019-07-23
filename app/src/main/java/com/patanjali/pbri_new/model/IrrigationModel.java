
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class IrrigationModel {

    @SerializedName("irrigationList")
    private List<IrrigationList> mIrrigationList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<IrrigationList> getIrrigationList() {
        return mIrrigationList;
    }

    public void setIrrigationList(List<IrrigationList> irrigationList) {
        mIrrigationList = irrigationList;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
