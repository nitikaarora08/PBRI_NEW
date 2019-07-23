
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RecommendCropResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("soil_recommended")
    private List<SoilRecommended> mSoilRecommended;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<SoilRecommended> getSoilRecommended() {
        return mSoilRecommended;
    }

    public void setSoilRecommended(List<SoilRecommended> soilRecommended) {
        mSoilRecommended = soilRecommended;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
