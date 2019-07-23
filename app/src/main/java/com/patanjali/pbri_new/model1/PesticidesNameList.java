
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PesticidesNameList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("pesticides_id")
    private String mPesticidesId;
    @SerializedName("pesticides_lang")
    private String mPesticidesLang;
    @SerializedName("pesticides_name")
    private String mPesticidesName;
    @SerializedName("pesticides_status")
    private String mPesticidesStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getPesticidesId() {
        return mPesticidesId;
    }

    public void setPesticidesId(String pesticidesId) {
        mPesticidesId = pesticidesId;
    }

    public String getPesticidesLang() {
        return mPesticidesLang;
    }

    public void setPesticidesLang(String pesticidesLang) {
        mPesticidesLang = pesticidesLang;
    }

    public String getPesticidesName() {
        return mPesticidesName;
    }

    public void setPesticidesName(String pesticidesName) {
        mPesticidesName = pesticidesName;
    }

    public String getPesticidesStatus() {
        return mPesticidesStatus;
    }

    public void setPesticidesStatus(String pesticidesStatus) {
        mPesticidesStatus = pesticidesStatus;
    }

}
