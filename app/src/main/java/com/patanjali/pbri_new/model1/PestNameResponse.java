
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PestNameResponse {

    @SerializedName("cropPestname")
    private List<CropPestname> mCropPestname;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<CropPestname> getCropPestname() {
        return mCropPestname;
    }

    public void setCropPestname(List<CropPestname> cropPestname) {
        mCropPestname = cropPestname;
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
