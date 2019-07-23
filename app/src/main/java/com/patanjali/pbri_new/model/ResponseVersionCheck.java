package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")


public class ResponseVersionCheck {

    @SerializedName("ad_list")
    private List<AdList> mAdList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<AdList> getAdList() {
        return mAdList;
    }

    public void setAdList(List<AdList> adList) {
        mAdList = adList;
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
