
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class OTPRequest {

    @SerializedName("farmer_mobileno")
    private String mFarmerMobileno;



    public OTPRequest(String mFarmerMobileno) {
        this.mFarmerMobileno = mFarmerMobileno;
    }

    public String getFarmerMobileno() {
        return mFarmerMobileno;
    }

    public void setFarmerMobileno(String farmerMobileno) {
        mFarmerMobileno = farmerMobileno;
    }

}
