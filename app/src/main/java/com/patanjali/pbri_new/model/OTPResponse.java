
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class OTPResponse {

    @SerializedName("farmer_detail")
    private FarmerDetail mFarmerDetail;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("mobile")
    private String mMobile;
    @SerializedName("otp")
    private String mOtp;
    @SerializedName("status")
    private Boolean mStatus;

    public FarmerDetail getFarmerDetail() {
        return mFarmerDetail;
    }

    public void setFarmerDetail(FarmerDetail farmerDetail) {
        mFarmerDetail = farmerDetail;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getOtp() {
        return mOtp;
    }

    public void setOtp(String otp) {
        mOtp = otp;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
