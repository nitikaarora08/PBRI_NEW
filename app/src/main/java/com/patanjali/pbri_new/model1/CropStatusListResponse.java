
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropStatusListResponse {

    @SerializedName("Crop_StatusList")
    private List<CropStatusList> mCropStatusList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<CropStatusList> getCropStatusList() {
        return mCropStatusList;
    }

    public void setCropStatusList(List<CropStatusList> cropStatusList) {
        mCropStatusList = cropStatusList;
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
