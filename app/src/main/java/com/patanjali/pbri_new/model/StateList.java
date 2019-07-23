
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class StateList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("state_id")
    private String mStateId;
    @SerializedName("state_name")
    private String mStateName;
    @SerializedName("state_status")
    private String mStateStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getStateId() {
        return mStateId;
    }

    public void setStateId(String stateId) {
        mStateId = stateId;
    }

    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String stateName) {
        mStateName = stateName;
    }

    public String getStateStatus() {
        return mStateStatus;
    }

    public void setStateStatus(String stateStatus) {
        mStateStatus = stateStatus;
    }

}
