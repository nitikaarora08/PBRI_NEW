
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OtherRequestSubCrop {

    @SerializedName("crop_name")
    private String mCropName;
    @SerializedName("crop_status_id")
    private String mCropStatusId;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public OtherRequestSubCrop(String mCropName, String mCropStatusId, String mFarmerId) {
        this.mCropName = mCropName;
        this.mCropStatusId = mCropStatusId;
        this.mFarmerId = mFarmerId;
    }

    public String getCropName() {
        return mCropName;
    }

    public void setCropName(String cropName) {
        mCropName = cropName;
    }

    public String getCropStatusId() {
        return mCropStatusId;
    }

    public void setCropStatusId(String cropStatusId) {
        mCropStatusId = cropStatusId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
