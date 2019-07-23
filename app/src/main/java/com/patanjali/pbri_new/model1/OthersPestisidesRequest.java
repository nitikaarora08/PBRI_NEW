
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OthersPestisidesRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("pesticides_name")
    private String mPesticidesName;

    public OthersPestisidesRequest(String mFarmerId, String mPesticidesName) {
        this.mFarmerId = mFarmerId;
        this.mPesticidesName = mPesticidesName;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getPesticidesName() {
        return mPesticidesName;
    }

    public void setPesticidesName(String pesticidesName) {
        mPesticidesName = pesticidesName;
    }

}
