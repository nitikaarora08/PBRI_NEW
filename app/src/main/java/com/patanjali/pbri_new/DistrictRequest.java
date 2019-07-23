
package com.patanjali.pbri_new;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class DistrictRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("state_code")
    private String mStateCode;


    public DistrictRequest(String mFarmerId, String mLang, String mStateCode) {
        this.mFarmerId = mFarmerId;
        this.mLang = mLang;
        this.mStateCode = mStateCode;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public String getStateCode() {
        return mStateCode;
    }

    public void setStateCode(String stateCode) {
        mStateCode = stateCode;
    }

}
