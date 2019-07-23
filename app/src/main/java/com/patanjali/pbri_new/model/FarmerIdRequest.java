
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class FarmerIdRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("lang")
    private String mLang;

    public FarmerIdRequest(String mFarmerId, String mLang) {
        this.mFarmerId = mFarmerId;
        this.mLang = mLang;
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

}
