
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataCollectionRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
   @SerializedName("crop_info_id")
    private String mcrop_info_id;



    public DataCollectionRequest(String mFarmerId, String mcrop_info_id) {
        this.mFarmerId = mFarmerId;
        this.mcrop_info_id = mcrop_info_id;
    }

    public String getcrop_info_id() {
        return mcrop_info_id;
    }

    public void setcrop_info_id(String crop_info_id) {
        mcrop_info_id = crop_info_id;
    }
   public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
