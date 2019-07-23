
package com.patanjali.pbri_new.model1;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OthersFertilizerRequest {

    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("fertilizer_name")
    private String mFertilizerName;

   @SerializedName("crop_status")
    private String mcrop_status;
 @SerializedName("crop_name")
    private String mcrop_name;

    public OthersFertilizerRequest(String mFarmerId, String mFertilizerName) {
        this.mFarmerId = mFarmerId;
        this.mFertilizerName = mFertilizerName;
    }

    public OthersFertilizerRequest(String mFarmerId, String mFertilizerName, String mcrop_status) {
        this.mFarmerId = mFarmerId;
        this.mFertilizerName = mFertilizerName;
        this.mcrop_status = mcrop_status;
    }

    public String getmcrop_name() {
        return mcrop_name;
    }

    public void setmcrop_name(String crop_name) {
        mcrop_name = crop_name;
    }

 public String getcrop_status() {
        return mcrop_status;
    }

    public void setcrop_status(String crop_status) {
        mcrop_status = crop_status;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFertilizerName() {
        return mFertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        mFertilizerName = fertilizerName;
    }

}
