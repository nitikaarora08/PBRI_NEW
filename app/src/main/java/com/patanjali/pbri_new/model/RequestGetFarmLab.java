
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestGetFarmLab {

    @SerializedName("farmer_id")
    private String mFarmerId;
 @SerializedName("farm_lab_id")
    private String farm_lab_id;

    public RequestGetFarmLab(String mFarmerId) {
        this.mFarmerId = mFarmerId;
    }

    public RequestGetFarmLab(String mFarmerId, String farm_lab_id) {
        this.mFarmerId = mFarmerId;
        this.farm_lab_id = farm_lab_id;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

  public String getFarmLabID() {
        return farm_lab_id;
    }

    public void setFarmLabID(String farm_lab_id) {
        farm_lab_id = farm_lab_id;
    }

}
