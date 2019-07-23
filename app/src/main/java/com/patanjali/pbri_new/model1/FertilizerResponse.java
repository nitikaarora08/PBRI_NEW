
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class FertilizerResponse {

    @SerializedName("Crop_NameList")
    private List<FertilizerList> mCropNameList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<FertilizerList> getCropNameList() {
        return mCropNameList;
    }

    public void setCropNameList(List<FertilizerList> cropNameList) {
        mCropNameList = cropNameList;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
