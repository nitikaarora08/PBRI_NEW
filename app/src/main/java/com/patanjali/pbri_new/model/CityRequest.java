
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class CityRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("state_code")
    private String mStateCode;

    public CityRequest(String mFarmerId, String mStateCode) {
        this.mFarmerId = mFarmerId;
        this.mStateCode = mStateCode;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getStateCode() {
        return mStateCode;
    }

    public void setStateCode(String stateCode) {
        mStateCode = stateCode;
    }

}
