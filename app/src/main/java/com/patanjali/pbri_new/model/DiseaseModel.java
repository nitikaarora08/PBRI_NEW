
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class DiseaseModel {

    @SerializedName("deseaseList")
    private List<DeseaseList> mDeseaseList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<DeseaseList> getDeseaseList() {
        return mDeseaseList;
    }

    public void setDeseaseList(List<DeseaseList> deseaseList) {
        mDeseaseList = deseaseList;
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
