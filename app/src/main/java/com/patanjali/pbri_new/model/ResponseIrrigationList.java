
package com.patanjali.pbri_new.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResponseIrrigationList {

    @SerializedName("insectList")
    private List<InsectList> mInsectList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<InsectList> getInsectList() {
        return mInsectList;
    }

    public void setInsectList(List<InsectList> insectList) {
        mInsectList = insectList;
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
