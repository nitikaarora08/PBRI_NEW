
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class FarmPicRequest {

    @SerializedName("farm_pic")
    private String mFarmPic;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public FarmPicRequest(String mFarmPic, String mFarmerId) {
        this.mFarmPic = mFarmPic;
        this.mFarmerId = mFarmerId;
    }

    public String getFarmPic() {
        return mFarmPic;
    }

    public void setFarmPic(String farmPic) {
        mFarmPic = farmPic;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
