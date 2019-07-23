
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class CropType {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("PatternList")
    private List<PatternList> mPatternList;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<PatternList> getPatternList() {
        return mPatternList;
    }

    public void setPatternList(List<PatternList> patternList) {
        mPatternList = patternList;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
