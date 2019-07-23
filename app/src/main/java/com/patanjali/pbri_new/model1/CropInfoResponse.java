
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CropInfoResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;
  @SerializedName("inserted_id")
    private String inserted_id;

    public String getinserted_id() {
        return inserted_id;
    }

    public void setinserted_id(String inserted_id) {
        inserted_id = inserted_id;
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
