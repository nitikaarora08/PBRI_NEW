
package com.patanjali.pbri_new.model1;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GetDataRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;

    public GetDataRequest(String mFarmerId) {
        this.mFarmerId = mFarmerId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
