
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TypeOfmaincropList {

    @SerializedName("entry_date")
    private String mEntryDate;
    @SerializedName("main_crop_name")
    private String mMainCropName;
    @SerializedName("main_crop_status")
    private String mMainCropStatus;
    @SerializedName("main_id")
    private String mMainId;

    public String getEntryDate() {
        return mEntryDate;
    }

    public void setEntryDate(String entryDate) {
        mEntryDate = entryDate;
    }

    public String getMainCropName() {
        return mMainCropName;
    }

    public void setMainCropName(String mainCropName) {
        mMainCropName = mainCropName;
    }

    public String getMainCropStatus() {
        return mMainCropStatus;
    }

    public void setMainCropStatus(String mainCropStatus) {
        mMainCropStatus = mainCropStatus;
    }

    public String getMainId() {
        return mMainId;
    }

    public void setMainId(String mainId) {
        mMainId = mainId;
    }

}
