
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResponsePostCropInformation {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

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
