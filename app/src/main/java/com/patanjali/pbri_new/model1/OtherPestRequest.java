
package com.patanjali.pbri_new.model1;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OtherPestRequest {

    @SerializedName("crop_infonameid")
    private String mCropInfonameid;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("pest_name")
    private String mPestName;
 @SerializedName("diseases_name")
    private String mdiseases_name;


    public OtherPestRequest(String mCropInfonameid, String mFarmerId, String mPestName) {
        this.mCropInfonameid = mCropInfonameid;
        this.mFarmerId = mFarmerId;
        this.mPestName = mPestName;
    }

    public String getdiseases_name() {
        return mdiseases_name;
    }

    public void setdiseases_name(String diseases_name) {
        mdiseases_name = diseases_name;
    }

  public String getCropInfonameid() {
        return mCropInfonameid;
    }

    public void setCropInfonameid(String cropInfonameid) {
        mCropInfonameid = cropInfonameid;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getPestName() {
        return mPestName;
    }

    public void setPestName(String pestName) {
        mPestName = pestName;
    }

}
