
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GetCropInfoRequest {

    @SerializedName("cropinfo_id")
    private String mCropinfoId;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public GetCropInfoRequest(String mCropinfoId, String mFarmerId) {
        this.mCropinfoId = mCropinfoId;
        this.mFarmerId = mFarmerId;
    }

    public String getCropinfoId() {
        return mCropinfoId;
    }

    public void setCropinfoId(String cropinfoId) {
        mCropinfoId = cropinfoId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
