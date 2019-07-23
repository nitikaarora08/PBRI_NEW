
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Irrigation {

    @SerializedName("irrigation_name")
    private String mIrrigationName;

    public String getIrrigationName() {
        return mIrrigationName;
    }

    public void setIrrigationName(String irrigationName) {
        mIrrigationName = irrigationName;
    }

}
