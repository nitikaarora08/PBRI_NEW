
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class MachineryResponse {

    @SerializedName("machinaryList")
    private List<MachinaryList> mMachinaryList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<MachinaryList> getMachinaryList() {
        return mMachinaryList;
    }

    public void setMachinaryList(List<MachinaryList> machinaryList) {
        mMachinaryList = machinaryList;
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
