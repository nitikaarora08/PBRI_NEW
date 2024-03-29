
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestFarmBook {

    @SerializedName("farmer_farm_labid")
    private Object mFarmerFarmLabid;
    @SerializedName("farmer_farmid")
    private Object mFarmerFarmid;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("farmlab_book_id")
    private String mFarmlabBookId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("text")
    private String mText;

    public RequestFarmBook(Object mFarmerFarmLabid, Object mFarmerFarmid, String mFarmerId, String mFarmlabBookId, String mImage, String mText) {
        this.mFarmerFarmLabid = mFarmerFarmLabid;
        this.mFarmerFarmid = mFarmerFarmid;
        this.mFarmerId = mFarmerId;
        this.mFarmlabBookId = mFarmlabBookId;
        this.mImage = mImage;
        this.mText = mText;
    }

    public Object getFarmerFarmLabid() {
        return mFarmerFarmLabid;
    }

    public void setFarmerFarmLabid(Object farmerFarmLabid) {
        mFarmerFarmLabid = farmerFarmLabid;
    }

    public Object getFarmerFarmid() {
        return mFarmerFarmid;
    }

    public void setFarmerFarmid(Object farmerFarmid) {
        mFarmerFarmid = farmerFarmid;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFarmlabBookId() {
        return mFarmlabBookId;
    }

    public void setFarmlabBookId(String farmlabBookId) {
        mFarmlabBookId = farmlabBookId;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
