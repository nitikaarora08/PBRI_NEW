
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class SoilResponse {

    @SerializedName("croppatternList")
    private List<CroppatternList> mCroppatternList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<CroppatternList> getCroppatternList() {
        return mCroppatternList;
    }

    public void setCroppatternList(List<CroppatternList> croppatternList) {
        mCroppatternList = croppatternList;
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
