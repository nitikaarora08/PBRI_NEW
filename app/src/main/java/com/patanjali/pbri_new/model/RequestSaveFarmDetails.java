
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestSaveFarmDetails {

    @SerializedName("agriculture_irrigation")
    private String mAgricultureIrrigation;
    @SerializedName("agriculture_landholding")
    private String mAgricultureLandholding;
    @SerializedName("agriculture_machinery")
    private String mAgricultureMachinery;
    @SerializedName("agriculture_soil")
    private String mAgricultureSoil;
    @SerializedName("beekeeping")
    private String mBeekeeping;
    @SerializedName("farm_irrigatedval")
    private String mFarmIrrigatedval;
    @SerializedName("farm_total_income")
    private String mFarmTotalIncome;
    @SerializedName("farm_total_investment")
    private String mFarmTotalInvestment;
    @SerializedName("farmer_id")
    private String mFarmerId;
    @SerializedName("farms_id")
    private String mFarmsId;
    @SerializedName("no_of_buffallow")
    private String mNoOfBuffallow;
    @SerializedName("no_of_cows")
    private String mNoOfCows;
    @SerializedName("no_of_crab")
    private String mNoOfCrab;
    @SerializedName("no_of_fish")
    private String mNoOfFish;
    @SerializedName("no_of_goats")
    private String mNoOfGoats;
    @SerializedName("no_of_poultry")
    private String mNoOfPoultry;
    @SerializedName("no_of_prawn")
    private String mNoOfPrawn;
    @SerializedName("no_of_sheep")
    private String mNoOfSheep;
    @SerializedName("sericulture")
    private String mSericulture;

    public RequestSaveFarmDetails(String mAgricultureIrrigation, String mAgricultureLandholding,
                                  String mAgricultureMachinery, String mAgricultureSoil, String mBeekeeping,
                                  String mFarmIrrigatedval, String mFarmTotalIncome, String mFarmTotalInvestment,
                                  String mFarmerId, String mFarmsId, String mNoOfBuffallow, String mNoOfCows, String mNoOfCrab,
                                  String mNoOfFish, String mNoOfGoats, String mNoOfPoultry, String mNoOfPrawn, String mNoOfSheep,
                                  String mSericulture) {
        this.mAgricultureIrrigation = mAgricultureIrrigation;
        this.mAgricultureLandholding = mAgricultureLandholding;
        this.mAgricultureMachinery = mAgricultureMachinery;
        this.mAgricultureSoil = mAgricultureSoil;
        this.mBeekeeping = mBeekeeping;
        this.mFarmIrrigatedval = mFarmIrrigatedval;
        this.mFarmTotalIncome = mFarmTotalIncome;
        this.mFarmTotalInvestment = mFarmTotalInvestment;
        this.mFarmerId = mFarmerId;
        this.mFarmsId = mFarmsId;
        this.mNoOfBuffallow = mNoOfBuffallow;
        this.mNoOfCows = mNoOfCows;
        this.mNoOfCrab = mNoOfCrab;
        this.mNoOfFish = mNoOfFish;
        this.mNoOfGoats = mNoOfGoats;
        this.mNoOfPoultry = mNoOfPoultry;
        this.mNoOfPrawn = mNoOfPrawn;
        this.mNoOfSheep = mNoOfSheep;
        this.mSericulture = mSericulture;
    }

    public RequestSaveFarmDetails(String mFarmerId, String mFarmsId, String mNoOfBuffallow, String mNoOfCows,
                                  String mNoOfCrab, String mNoOfFish, String mNoOfGoats, String mNoOfPoultry,
                                  String mNoOfPrawn, String mNoOfSheep) {
        this.mFarmerId = mFarmerId;
        this.mFarmsId = mFarmsId;
        this.mNoOfBuffallow = mNoOfBuffallow;
        this.mNoOfCows = mNoOfCows;
        this.mNoOfCrab = mNoOfCrab;
        this.mNoOfFish = mNoOfFish;
        this.mNoOfGoats = mNoOfGoats;
        this.mNoOfPoultry = mNoOfPoultry;
        this.mNoOfPrawn = mNoOfPrawn;
        this.mNoOfSheep = mNoOfSheep;
    }

    public String getAgricultureIrrigation() {
        return mAgricultureIrrigation;
    }

    public void setAgricultureIrrigation(String agricultureIrrigation) {
        mAgricultureIrrigation = agricultureIrrigation;
    }

    public String getAgricultureLandholding() {
        return mAgricultureLandholding;
    }

    public void setAgricultureLandholding(String agricultureLandholding) {
        mAgricultureLandholding = agricultureLandholding;
    }

    public String getAgricultureMachinery() {
        return mAgricultureMachinery;
    }

    public void setAgricultureMachinery(String agricultureMachinery) {
        mAgricultureMachinery = agricultureMachinery;
    }

    public String getAgricultureSoil() {
        return mAgricultureSoil;
    }

    public void setAgricultureSoil(String agricultureSoil) {
        mAgricultureSoil = agricultureSoil;
    }

    public String getBeekeeping() {
        return mBeekeeping;
    }

    public void setBeekeeping(String beekeeping) {
        mBeekeeping = beekeeping;
    }

    public String getFarmIrrigatedval() {
        return mFarmIrrigatedval;
    }

    public void setFarmIrrigatedval(String farmIrrigatedval) {
        mFarmIrrigatedval = farmIrrigatedval;
    }

    public String getFarmTotalIncome() {
        return mFarmTotalIncome;
    }

    public void setFarmTotalIncome(String farmTotalIncome) {
        mFarmTotalIncome = farmTotalIncome;
    }

    public String getFarmTotalInvestment() {
        return mFarmTotalInvestment;
    }

    public void setFarmTotalInvestment(String farmTotalInvestment) {
        mFarmTotalInvestment = farmTotalInvestment;
    }

    public String getFarmerId() {
        return mFarmerId;
    }

    public void setFarmerId(String farmerId) {
        mFarmerId = farmerId;
    }

    public String getFarmsId() {
        return mFarmsId;
    }

    public void setFarmsId(String farmsId) {
        mFarmsId = farmsId;
    }

    public String getNoOfBuffallow() {
        return mNoOfBuffallow;
    }

    public void setNoOfBuffallow(String noOfBuffallow) {
        mNoOfBuffallow = noOfBuffallow;
    }

    public String getNoOfCows() {
        return mNoOfCows;
    }

    public void setNoOfCows(String noOfCows) {
        mNoOfCows = noOfCows;
    }

    public String getNoOfCrab() {
        return mNoOfCrab;
    }

    public void setNoOfCrab(String noOfCrab) {
        mNoOfCrab = noOfCrab;
    }

    public String getNoOfFish() {
        return mNoOfFish;
    }

    public void setNoOfFish(String noOfFish) {
        mNoOfFish = noOfFish;
    }

    public String getNoOfGoats() {
        return mNoOfGoats;
    }

    public void setNoOfGoats(String noOfGoats) {
        mNoOfGoats = noOfGoats;
    }

    public String getNoOfPoultry() {
        return mNoOfPoultry;
    }

    public void setNoOfPoultry(String noOfPoultry) {
        mNoOfPoultry = noOfPoultry;
    }

    public String getNoOfPrawn() {
        return mNoOfPrawn;
    }

    public void setNoOfPrawn(String noOfPrawn) {
        mNoOfPrawn = noOfPrawn;
    }

    public String getNoOfSheep() {
        return mNoOfSheep;
    }

    public void setNoOfSheep(String noOfSheep) {
        mNoOfSheep = noOfSheep;
    }

    public String getSericulture() {
        return mSericulture;
    }

    public void setSericulture(String sericulture) {
        mSericulture = sericulture;
    }

}
