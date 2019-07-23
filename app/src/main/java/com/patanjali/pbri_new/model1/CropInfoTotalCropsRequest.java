
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropInfoTotalCropsRequest {

    @SerializedName("farm_lab_id")
    private String mFarmLabId;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public CropInfoTotalCropsRequest(String mFarmLabId, String mFarmerId) {
        this.mFarmLabId = mFarmLabId;
        this.mFarmerId = mFarmerId;
    }

    public String getFarmLabId() {
        return mFarmLabId;
    }

    public void setFarmLabId(String farmLabId) {
        mFarmLabId = farmLabId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
