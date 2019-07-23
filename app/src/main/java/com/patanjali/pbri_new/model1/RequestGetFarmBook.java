
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestGetFarmBook {

    @SerializedName("farmer_farm_labid")
    private String mFarmerFarmLabid;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public RequestGetFarmBook(String mFarmerFarmLabid, String mFarmerId) {
        this.mFarmerFarmLabid = mFarmerFarmLabid;
        this.mFarmerId = mFarmerId;
    }

    public String getFarmerFarmLabid() {
        return mFarmerFarmLabid;
    }

    public void setFarmerFarmLabid(String farmerFarmLabid) {
        mFarmerFarmLabid = farmerFarmLabid;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
