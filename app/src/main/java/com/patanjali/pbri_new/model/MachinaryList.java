
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MachinaryList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("machinary_id")
    private String mMachinaryId;
    @SerializedName("machinary_name")
    private String mMachinaryName;
    @SerializedName("machinary_status")
    private String mMachinaryStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getMachinaryId() {
        return mMachinaryId;
    }

    public void setMachinaryId(String machinaryId) {
        mMachinaryId = machinaryId;
    }

    public String getMachinaryName() {
        return mMachinaryName;
    }

    public void setMachinaryName(String machinaryName) {
        mMachinaryName = machinaryName;
    }

    public String getMachinaryStatus() {
        return mMachinaryStatus;
    }

    public void setMachinaryStatus(String machinaryStatus) {
        mMachinaryStatus = machinaryStatus;
    }

}
