
package com.patanjali.pbri_new.model1;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ListFarmBook {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("farmer_farm_labid")
    private String mFarmerFarmLabid;
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

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getFarmerFarmLabid() {
        return mFarmerFarmLabid;
    }

    public void setFarmerFarmLabid(String farmerFarmLabid) {
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
