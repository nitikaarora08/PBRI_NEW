

package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OTPVerifyRequest {

    @SerializedName("device_id")
    private String mDeviceId;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("token_id")
    private String mTokenId;


    public OTPVerifyRequest(String mDeviceId, String mFarmerId, String mTokenId) {
        this.mDeviceId = mDeviceId;
        this.mFarmerId = mFarmerId;
        this.mTokenId = mTokenId;
    }

    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String deviceId) {
        mDeviceId = deviceId;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getTokenId() {
        return mTokenId;
    }

    public void setTokenId(String tokenId) {
        mTokenId = tokenId;

    }

}
