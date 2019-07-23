
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ProfilePicResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("profilePath")
    private String mProfilePath;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
