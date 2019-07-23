
package com.patanjali.pbri_new.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class DeseaseList {

    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("disease_id")
    private String mDiseaseId;
    @SerializedName("disease_name")
    private String mDiseaseName;
    @SerializedName("disease_status")
    private String mDiseaseStatus;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDiseaseId() {
        return mDiseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        mDiseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return mDiseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        mDiseaseName = diseaseName;
    }

    public String getDiseaseStatus() {
        return mDiseaseStatus;
    }

    public void setDiseaseStatus(String diseaseStatus) {
        mDiseaseStatus = diseaseStatus;
    }

}
