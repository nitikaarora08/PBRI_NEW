
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class LanguageRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("lang")
    private String mLang;

    public LanguageRequest(String mFarmerId, String mLang) {
        this.mFarmerId = mFarmerId;
        this.mLang = mLang;
    }

    public LanguageRequest(String mFarmerId) {
        this.mFarmerId = mFarmerId;
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
