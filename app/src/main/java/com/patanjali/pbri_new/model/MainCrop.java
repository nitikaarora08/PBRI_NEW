
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class MainCrop {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;
    @SerializedName("typeOfmaincropList")
    private List<TypeOfmaincropList> mTypeOfmaincropList;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

    public List<TypeOfmaincropList> getTypeOfmaincropList() {
        return mTypeOfmaincropList;
    }

    public void setTypeOfmaincropList(List<TypeOfmaincropList> typeOfmaincropList) {
        mTypeOfmaincropList = typeOfmaincropList;
    }

}
