
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TypeOfverticalcropList {

    @SerializedName("entry_date")
    private String mEntryDate;
    @SerializedName("vertical_crop_name")
    private String mVerticalCropName;
    @SerializedName("vertical_crop_status")
    private String mVerticalCropStatus;
    @SerializedName("vertical_id")
    private String mVerticalId;

    public String getEntryDate() {
        return mEntryDate;
    }

    public void setEntryDate(String entryDate) {
        mEntryDate = entryDate;
    }

    public String getVerticalCropName() {
        return mVerticalCropName;
    }

    public void setVerticalCropName(String verticalCropName) {
        mVerticalCropName = verticalCropName;
    }

    public String getVerticalCropStatus() {
        return mVerticalCropStatus;
    }

    public void setVerticalCropStatus(String verticalCropStatus) {
        mVerticalCropStatus = verticalCropStatus;
    }

    public String getVerticalId() {
        return mVerticalId;
    }

    public void setVerticalId(String verticalId) {
        mVerticalId = verticalId;
    }

}
