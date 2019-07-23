
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class DistrictList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("district_name")
    private String mDistrictName;
    @SerializedName("district_status")
    private String mDistrictStatus;
    @SerializedName("id")
    private String mId;
    @SerializedName("state_code")
    private String mStateCode;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDistrictName() {
        return mDistrictName;
    }

    public void setDistrictName(String districtName) {
        mDistrictName = districtName;
    }

    public String getDistrictStatus() {
        return mDistrictStatus;
    }

    public void setDistrictStatus(String districtStatus) {
        mDistrictStatus = districtStatus;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getStateCode() {
        return mStateCode;
    }

    public void setStateCode(String stateCode) {
        mStateCode = stateCode;
    }

}
