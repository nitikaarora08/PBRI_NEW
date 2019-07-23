
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class CropPatternType {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;
    @SerializedName("typeofcropList")
    private List<TypeofcropList> mTypeofcropList;

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

    public List<TypeofcropList> getTypeofcropList() {
        return mTypeofcropList;
    }

    public void setTypeofcropList(List<TypeofcropList> typeofcropList) {
        mTypeofcropList = typeofcropList;
    }

}
