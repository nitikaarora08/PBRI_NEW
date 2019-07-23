
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResponseLocationAndSoil {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;
 @SerializedName("farm_lab_id")
    private String farm_lab_id;

    public String getFarmLabID() {
        return farm_lab_id;
    }

    public void setFarmLabID(String farm_lab_id) {
        farm_lab_id = farm_lab_id;
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
