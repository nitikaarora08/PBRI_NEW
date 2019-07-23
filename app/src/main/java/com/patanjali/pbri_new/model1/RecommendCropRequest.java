
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RecommendCropRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("npk_value")
    private String mNpkValue;

    public RecommendCropRequest(String mFarmerId, String mNpkValue) {
        this.mFarmerId = mFarmerId;
        this.mNpkValue = mNpkValue;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getNpkValue() {
        return mNpkValue;
    }

    public void setNpkValue(String npkValue) {
        mNpkValue = npkValue;
    }

}
