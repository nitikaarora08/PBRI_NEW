
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class PatternList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("pattern_id")
    private String mPatternId;
    @SerializedName("pattern_name")
    private String mPatternName;
    @SerializedName("pattern_status")
    private String mPatternStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getPatternId() {
        return mPatternId;
    }

    public void setPatternId(String patternId) {
        mPatternId = patternId;
    }

    public String getPatternName() {
        return mPatternName;
    }

    public void setPatternName(String patternName) {
        mPatternName = patternName;
    }

    public String getPatternStatus() {
        return mPatternStatus;
    }

    public void setPatternStatus(String patternStatus) {
        mPatternStatus = patternStatus;
    }

}
