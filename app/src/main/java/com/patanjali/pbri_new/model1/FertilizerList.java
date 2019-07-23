
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class FertilizerList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("fertilizer_id")
    private String mFertilizerId;
    @SerializedName("fertilizer_lang")
    private String mFertilizerLang;
    @SerializedName("fertilizer_name")
    private String mFertilizerName;
    @SerializedName("fertilizer_status")
    private String mFertilizerStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getFertilizerId() {
        return mFertilizerId;
    }

    public void setFertilizerId(String fertilizerId) {
        mFertilizerId = fertilizerId;
    }

    public String getFertilizerLang() {
        return mFertilizerLang;
    }

    public void setFertilizerLang(String fertilizerLang) {
        mFertilizerLang = fertilizerLang;
    }

    public String getFertilizerName() {
        return mFertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        mFertilizerName = fertilizerName;
    }

    public String getFertilizerStatus() {
        return mFertilizerStatus;
    }

    public void setFertilizerStatus(String fertilizerStatus) {
        mFertilizerStatus = fertilizerStatus;
    }

}
