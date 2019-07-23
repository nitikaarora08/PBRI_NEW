
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PostFarmerDetails {

    @SerializedName("farmer_address")
    private String mFarmerAddress;
    @SerializedName("farmer_adharcard")
    private String mFarmerAdharcard;
    @SerializedName("farmer_age")
    private String mFarmerAge;
    @SerializedName("farmer_cast_category")
    private String mFarmerCastCategory;
    @SerializedName("farmer_district")
    private String mFarmerDistrict;
    @SerializedName("farmer_dob")
    private String mFarmerDob;
    @SerializedName("farmer_education")
    private String mFarmerEducation;
    @SerializedName("farmer_email")
    private String mFarmerEmail;
    @SerializedName("farmer_familysize")
    private String mFarmerFamilysize;
    @SerializedName("farmer_gender")
    private String mFarmerGender;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("farmer_mandal_name")
    private String mFarmerMandalName;
    @SerializedName("farmer_name")
    private String mFarmerName;
    @SerializedName("farmer_pinno")
    private String mFarmerPinno;
    @SerializedName("farmer_religion")
    private String mFarmerReligion;
    @SerializedName("farmer_state")
    private String mFarmerState;
    @SerializedName("farmer_village_name")
    private String mFarmerVillageName;
    @SerializedName("no_of_children")
    private String mNoOfChildren;
    @SerializedName("no_of_female")
    private String mNoOfFemale;
    @SerializedName("no_of_male")
    private String mNoOfMale;
 @SerializedName("landmark")
    private String landmark;
@SerializedName("farmer_whatsapp")
    private String whatsapp;
@SerializedName("farmer_mobileno")
    private String farmer_mobileno;

    public PostFarmerDetails(String mFarmerAddress, String mFarmerAdharcard, String mFarmerAge, String mFarmerCastCategory,
                             String mFarmerDistrict, String mFarmerDob, String mFarmerEducation, String mFarmerEmail,
                             String mFarmerFamilysize, String mFarmerGender, String mFarmerId, String mFarmerMandalName,
                             String mFarmerName, String mFarmerPinno, String mFarmerReligion,
                             String mFarmerState, String mFarmerVillageName, String mNoOfChildren, String mNoOfFemale,
                             String mNoOfMale,String landmark,String farmer_whatsapp,String farmer_mobileno) {
        this.mFarmerAddress = mFarmerAddress;
        this.mFarmerAdharcard = mFarmerAdharcard;
        this.mFarmerAge = mFarmerAge;
        this.mFarmerCastCategory = mFarmerCastCategory;
        this.mFarmerDistrict = mFarmerDistrict;
        this.mFarmerDob = mFarmerDob;
        this.mFarmerEducation = mFarmerEducation;
        this.mFarmerEmail = mFarmerEmail;
        this.mFarmerFamilysize = mFarmerFamilysize;
        this.mFarmerGender = mFarmerGender;
        this.mFarmerId = mFarmerId;
        this.mFarmerMandalName = mFarmerMandalName;
        this.mFarmerName = mFarmerName;
        this.mFarmerPinno = mFarmerPinno;
        this.mFarmerReligion = mFarmerReligion;
        this.mFarmerState = mFarmerState;
        this.mFarmerVillageName = mFarmerVillageName;
        this.mNoOfChildren = mNoOfChildren;
        this.mNoOfFemale = mNoOfFemale;
        this.mNoOfMale = mNoOfMale;
        this.landmark = landmark;
        this.whatsapp = farmer_whatsapp;
        this.farmer_mobileno = farmer_mobileno;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getFarmer_whatsapp() {
        return whatsapp;
    }

    public void setFarmer_whatsapp(String farmer_whatsapp) {
        this.whatsapp = farmer_whatsapp;
    }

    public String getFarmer_mobileno() {
        return farmer_mobileno;
    }

    public void setFarmer_mobileno(String farmer_mobileno) {
        this.farmer_mobileno = farmer_mobileno;
    }

    public String getFarmerAddress() {
        return mFarmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        mFarmerAddress = farmerAddress;
    }

    public String getFarmerAdharcard() {
        return mFarmerAdharcard;
    }

    public void setFarmerAdharcard(String farmerAdharcard) {
        mFarmerAdharcard = farmerAdharcard;
    }

    public String getFarmerAge() {
        return mFarmerAge;
    }

    public void setFarmerAge(String farmerAge) {
        mFarmerAge = farmerAge;
    }

    public String getFarmerCastCategory() {
        return mFarmerCastCategory;
    }

    public void setFarmerCastCategory(String farmerCastCategory) {
        mFarmerCastCategory = farmerCastCategory;
    }

    public String getFarmerDistrict() {
        return mFarmerDistrict;
    }

    public void setFarmerDistrict(String farmerDistrict) {
        mFarmerDistrict = farmerDistrict;
    }

    public String getFarmerDob() {
        return mFarmerDob;
    }

    public void setFarmerDob(String farmerDob) {
        mFarmerDob = farmerDob;
    }

    public String getFarmerEducation() {
        return mFarmerEducation;
    }

    public void setFarmerEducation(String farmerEducation) {
        mFarmerEducation = farmerEducation;
    }

    public String getFarmerEmail() {
        return mFarmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        mFarmerEmail = farmerEmail;
    }

    public String getFarmerFamilysize() {
        return mFarmerFamilysize;
    }

    public void setFarmerFamilysize(String farmerFamilysize) {
        mFarmerFamilysize = farmerFamilysize;
    }

    public String getFarmerGender() {
        return mFarmerGender;
    }

    public void setFarmerGender(String farmerGender) {
        mFarmerGender = farmerGender;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFarmerMandalName() {
        return mFarmerMandalName;
    }

    public void setFarmerMandalName(String farmerMandalName) {
        mFarmerMandalName = farmerMandalName;
    }

    public String getFarmerName() {
        return mFarmerName;
    }

    public void setFarmerName(String farmerName) {
        mFarmerName = farmerName;
    }

    public String getFarmerPinno() {
        return mFarmerPinno;
    }

    public void setFarmerPinno(String farmerPinno) {
        mFarmerPinno = farmerPinno;
    }

    public String getFarmerReligion() {
        return mFarmerReligion;
    }

    public void setFarmerReligion(String farmerReligion) {
        mFarmerReligion = farmerReligion;
    }

    public String getFarmerState() {
        return mFarmerState;
    }

    public void setFarmerState(String farmerState) {
        mFarmerState = farmerState;
    }

    public String getFarmerVillageName() {
        return mFarmerVillageName;
    }

    public void setFarmerVillageName(String farmerVillageName) {
        mFarmerVillageName = farmerVillageName;
    }

    public String getNoOfChildren() {
        return mNoOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        mNoOfChildren = noOfChildren;
    }

    public String getNoOfFemale() {
        return mNoOfFemale;
    }

    public void setNoOfFemale(String noOfFemale) {
        mNoOfFemale = noOfFemale;
    }

    public String getNoOfMale() {
        return mNoOfMale;
    }

    public void setNoOfMale(String noOfMale) {
        mNoOfMale = noOfMale;
    }

}
