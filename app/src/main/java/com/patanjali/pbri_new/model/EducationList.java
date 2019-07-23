
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EducationList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("edu_id")
    private String mEduId;
    @SerializedName("education_lang")
    private String mEducationLang;
    @SerializedName("education_name")
    private String mEducationName;
    @SerializedName("education_status")
    private String mEducationStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEduId() {
        return mEduId;
    }

    public void setEduId(String eduId) {
        mEduId = eduId;
    }

    public String getEducationLang() {
        return mEducationLang;
    }

    public void setEducationLang(String educationLang) {
        mEducationLang = educationLang;
    }

    public String getEducationName() {
        return mEducationName;
    }

    public void setEducationName(String educationName) {
        mEducationName = educationName;
    }

    public String getEducationStatus() {
        return mEducationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        mEducationStatus = educationStatus;
    }

}
