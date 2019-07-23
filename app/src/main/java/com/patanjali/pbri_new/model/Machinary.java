
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Machinary {

    @SerializedName("machinary_name")
    private String mMachinaryName;

    public String getMachinaryName() {
        return mMachinaryName;
    }

    public void setMachinaryName(String machinaryName) {
        mMachinaryName = machinaryName;
    }

}
