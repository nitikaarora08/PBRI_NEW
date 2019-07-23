
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class MaachineryRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;

    public MaachineryRequest(String mFarmerId) {
        this.mFarmerId = mFarmerId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
