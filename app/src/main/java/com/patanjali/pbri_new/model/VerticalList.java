
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class VerticalList {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;
    @SerializedName("typeOfverticalcropList")
    private List<TypeOfverticalcropList> mTypeOfverticalcropList;

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

    public List<TypeOfverticalcropList> getTypeOfverticalcropList() {
        return mTypeOfverticalcropList;
    }

    public void setTypeOfverticalcropList(List<TypeOfverticalcropList> typeOfverticalcropList) {
        mTypeOfverticalcropList = typeOfverticalcropList;
    }

}
