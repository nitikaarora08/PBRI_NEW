
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DiseaseResponse {

    @SerializedName("cropDiseasename")
    private List<CropDiseasename> mCropDiseasename;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<CropDiseasename> getCropDiseasename() {
        return mCropDiseasename;
    }

    public void setCropDiseasename(List<CropDiseasename> cropDiseasename) {
        mCropDiseasename = cropDiseasename;
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
