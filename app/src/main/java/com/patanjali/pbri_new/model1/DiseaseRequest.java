
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DiseaseRequest {

    @SerializedName("crop_name_id")
    private String mCropNameId;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public DiseaseRequest(String mCropNameId, String mFarmerId) {
        this.mCropNameId = mCropNameId;
        this.mFarmerId = mFarmerId;
    }

    public String getCropNameId() {
        return mCropNameId;
    }

    public void setCropNameId(String cropNameId) {
        mCropNameId = cropNameId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
