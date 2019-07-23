
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class CityResponse {

    @SerializedName("districtList")
    private List<DistrictList> mDistrictList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<DistrictList> getDistrictList() {
        return mDistrictList;
    }

    public void setDistrictList(List<DistrictList> districtList) {
        mDistrictList = districtList;
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
