
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OthersSoilTypeRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("soil_name")
    private String mSoilName;

    public OthersSoilTypeRequest(String mFarmerId, String mSoilName) {
        this.mFarmerId = mFarmerId;
        this.mSoilName = mSoilName;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getSoilName() {
        return mSoilName;
    }

    public void setSoilName(String soilName) {
        mSoilName = soilName;
    }

}
