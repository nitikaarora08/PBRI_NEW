
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OtherDiseaseRequest {

    @SerializedName("crop_infonameid")
    private String mCropInfonameid;
    @SerializedName("diseases_name")
    private String mDiseasesName;
    @SerializedName("farmer_id")
    private String mFarmerId;

    public OtherDiseaseRequest(String mCropInfonameid, String mDiseasesName, String mFarmerId) {
        this.mCropInfonameid = mCropInfonameid;
        this.mDiseasesName = mDiseasesName;
        this.mFarmerId = mFarmerId;
    }

    public String getCropInfonameid() {
        return mCropInfonameid;
    }

    public void setCropInfonameid(String cropInfonameid) {
        mCropInfonameid = cropInfonameid;
    }

    public String getDiseasesName() {
        return mDiseasesName;
    }

    public void setDiseasesName(String diseasesName) {
        mDiseasesName = diseasesName;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

}
