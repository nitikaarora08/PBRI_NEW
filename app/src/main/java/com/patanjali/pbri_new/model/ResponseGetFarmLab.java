
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResponseGetFarmLab {

    @SerializedName("list")
    private LabList mList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public LabList getList() {
        return mList;
    }

    public void setList(LabList list) {
        mList = list;
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
