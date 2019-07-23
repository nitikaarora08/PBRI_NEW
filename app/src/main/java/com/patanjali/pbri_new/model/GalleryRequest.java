
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GalleryRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;

    public GalleryRequest(String mFarmerId) {
        this.mFarmerId = mFarmerId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
