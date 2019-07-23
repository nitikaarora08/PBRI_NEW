
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LabListGetResponse {

    @SerializedName("list")
    private java.util.List<List> mList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public java.util.List<List> getList() {
        return mList;
    }

    public void setList(java.util.List<List> list) {
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
