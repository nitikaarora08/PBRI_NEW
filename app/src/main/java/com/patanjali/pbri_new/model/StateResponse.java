
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class StateResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("stateList")
    private List<StateList> mStateList;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<StateList> getStateList() {
        return mStateList;
    }

    public void setStateList(List<StateList> stateList) {
        mStateList = stateList;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
