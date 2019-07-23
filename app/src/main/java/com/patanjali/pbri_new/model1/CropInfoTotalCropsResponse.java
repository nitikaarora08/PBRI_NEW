
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropInfoTotalCropsResponse {

    @SerializedName("crops_info")
    private List<CropsInfo> mCropsInfo;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<CropsInfo> getCropsInfo() {
        return mCropsInfo;
    }

    public void setCropsInfo(List<CropsInfo> cropsInfo) {
        mCropsInfo = cropsInfo;
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
