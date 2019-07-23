package com.patanjali.pbri_new.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.patanjali.pbri_new.model.CityResponse;
import com.patanjali.pbri_new.model.CropPatternType;
import com.patanjali.pbri_new.model.CropType;
import com.patanjali.pbri_new.model.DiseaseModel;
import com.patanjali.pbri_new.model.EducationResponse;
import com.patanjali.pbri_new.model.IrrigationModel;
import com.patanjali.pbri_new.model.MachineryResponse;
import com.patanjali.pbri_new.model.MainCrop;
import com.patanjali.pbri_new.model.PestObserverdModel;
import com.patanjali.pbri_new.model.ResponseIrrigationList;
import com.patanjali.pbri_new.model.SaveMachineData;
import com.patanjali.pbri_new.model.SavePestData;
import com.patanjali.pbri_new.model.SoilResponse;
import com.patanjali.pbri_new.model.StateResponse;
import com.patanjali.pbri_new.model.VerticalList;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Patanjali on 10-10-2018.
 */

public class SharedPrefrenceUtil {
    Context context;

    public SharedPrefrenceUtil(Context context) {
        this.context = context;
    }

   public void setFarmerName(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("FarmerName", farmerName);
        editor.commit();
    }

    public void setStraw(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setStraw", farmerName);
        editor.commit();
    }

    public String getStraw() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setStraw", "");
    }

    public void setAnnualRainfall(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setAnnualRainfall", farmerName);
        editor.commit();
    }

    public String getAnnualRainfall() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setAnnualRainfall", "");
    }

 public void setMinTemp(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMinTemp", farmerName);
        editor.commit();
    }

    public String getMinTemp() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setMinTemp", "");
    }

public void setMaxTemp(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMaxTemp", farmerName);
        editor.commit();
    }

    public String getMaxTemp() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setMaxTemp", "");
    }

public void setRelHumidity(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setRelHumidity", farmerName);
        editor.commit();
    }

    public String getRelHumidity() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setRelHumidity", "");
    }

public void setSunshineHours(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSunshineHours", farmerName);
        editor.commit();
    }

    public String getSunshineHours() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setSunshineHours", "");
    }


    public void setFarmBookDesc(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFarmBookDesc", farmerName);
        editor.commit();
    }

    public String getFarmBookDesc() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setFarmBookDesc", "");
    }



    public void setByproduct(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setByproduct", farmerName);
        editor.commit();
    }

    public String getByproduct() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setByproduct", "");
    }




 public String getlatLang() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("latlang", "");
    }


    public void setSheep(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Sheep", farmerName);
        editor.commit();
    }

    public String getSheep() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Sheep", "0");
    }


  public void setPrown(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Prown", farmerName);
        editor.commit();
    }

    public String getPrown() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Prown", "");
    }

public void setCrab(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Crab", farmerName);
        editor.commit();
    }

    public String getCrab() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Crab", "");
    }


public void setFish(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Fish", farmerName);
        editor.commit();
    }

    public String getFish() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Fish", "");
    }

public void setOneTime(String farmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("onetime", farmerName);
        editor.commit();
    }

    public String getOneTime() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("onetime", "0");
    }



    public String getLang() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Lang", "English");
    }
    public void setLang(String Lang) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Lang", Lang);
        editor.commit();
    }

    public void setLangApi(String Lang) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setLangApi", Lang);
        editor.commit();
    }
    public String getLangApi() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setLangApi", "eng");
    }

  public void setlatLang(String Lang) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("latlang", Lang);
        editor.commit();
    }

    public String getFarmerName() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("FarmerName", "");
    }




    public void setResponseFarmerName(String setResponseFarmerName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setResponseFarmerName", setResponseFarmerName);
        editor.commit();
    }


    public String getResponseFarmerName() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setResponseFarmerName", "");

    }


    public void setResponseMobile(String setResponseMobile) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setResponseMobile", setResponseMobile);
        editor.commit();
    }

    public String getResponseMobile() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setResponseMobile", "");

    }

    public void setResponseId(String setResponseId) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setResponseId", setResponseId);
        editor.commit();
    }

    public String getResponseId() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setResponseId", "");

    }

    public void setMobileNumber(String setMobileNumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMobileNumber", setMobileNumber);
        editor.commit();
    }

    public String getMobileNumber() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setMobileNumber", "");
    }


   public void setWhatsappMobileNumber(String setMobileNumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("set_wMobileNumber", setMobileNumber);
        editor.commit();
    }

    public String getWhatsappMobileNumber() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("set_wMobileNumber", "");
    }


    public void setCow(String setCow) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setCow", setCow);
        editor.commit();
    }

    public String getCow() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setCow", "0");
    }

    public void setHindiCow(String setCow) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetCow", setCow);
        editor.commit();
    }

    public String getHindiCow() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetCow", "");
    }


    public void setbaffallow(String setbaffallow) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setbaffallow", setbaffallow);
        editor.commit();
    }

    public String getbaffallow() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setbaffallow", "0");
    }

    public void setHindibaffallow(String setbaffallow) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetbaffallow", setbaffallow);
        editor.commit();
    }

    public void setName(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("Name",name);
        editor.commit();
    }
    public String getName()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("Name","");
    }

  public void setAttachment(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setAttachment",name);
        editor.commit();
    }
    public String getAttachment()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("setAttachment","");
    }

   public void setFarmLabID(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setFarmLabID",name);
        editor.commit();
    }
    public String getFarmLabID()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("setFarmLabID","");
    }

    public void setFarmBookID(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setFarmBookID",name);
        editor.commit();
    }
    public String getFarmBookID()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("setFarmBookID","");
    }

    public void setTotalCrops(int name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putInt("setTotalCrops",name);
        editor.commit();
    }
    public int getTotalCrops()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getInt("setTotalCrops",0);
    }

    public void setTotalFarmlabs(int name)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("setTotalFarmlabs",name);
        editor.commit();
    }
    public int getTotalFarmlabs()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("setTotalFarmlabs",2);
    }

    public void setHindiName(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("HindiName",name);
        editor.commit();
    }
    public String getHindiName()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("HindiName","");
    }


    public void setDateTime(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("datetime",name);
        editor.commit();
    }
    public String getDateTime()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("datetime","");
    }

  public void setAddFarmLab(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setAddFarmLab",name);
        editor.commit();
    }
    public String getAddFarmLab()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("setAddFarmLab","");
    }

   public void setImageFile(File name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setAttachedFile", String.valueOf(name));
        editor.commit();
    }
    public File getImageFile()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return new File(sharedPreferences.getString("setAttachedFile", ""));
    }

    public void setProfilePic(File name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setProfilePic", String.valueOf(name));
        editor.commit();
    }
    public File getProfilePic()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return new File(sharedPreferences.getString("setProfilePic", ""));
    }
 public void setProfilepicName(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("setProfilepicName", String.valueOf(name));
        editor.commit();
    }
    public String getProfilepicName()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("setProfilepicName", "");
    }

     public void setAttachedFile(File name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("image", String.valueOf(name));
        editor.commit();
    }
    public File getAttachedFile()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return new File(sharedPreferences.getString("image", ""));
    }

    public void setHindiDateTime(String name)
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("hindidatetime",name);
        editor.commit();
    }
    public String getHindiDateTime()
    {

        SharedPreferences sharedPreferences= context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        return sharedPreferences.getString("hindidatetime","");
    }


    public String getHindibaffallow() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetbaffallow", "");
    }

    public void setPautry(String setPautry) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPautry", setPautry);
        editor.commit();
    }

    public String getPautry() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPautry", "0");
    }

    public void setHindiPautry(String setPautry) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetPautry", setPautry);
        editor.commit();
    }

    public String getHindiPautry() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetPautry", "");
    }


    public void setMale(String setMale) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMale", setMale);
        editor.commit();
    }

    public String getHindiMale() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetMale", "");
    }

    public void setHindiMale(String setMale) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetMale", setMale);
        editor.commit();
    }

    public String getMale() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setMale", "");
    }



    public void setFeMale(String setFeMale) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFeMale", setFeMale);
        editor.commit();
    }

    public String getFeMale() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFeMale", "");
    }

    public void setHindiFeMale(String setFeMale) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetFeMale", setFeMale);
        editor.commit();
    }

    public String getHindiFeMale() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetFeMale", "");
    }



    public void setChildren(String children) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("children", children);
        editor.commit();
    }

    public String getChildren() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("children", "");
    }

    public void setHindiChildren(String children) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindichildren", children);
        editor.commit();
    }

    public String getHindiChildren() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindichildren", "");
    }


    public void setGoat(String setGoat) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setGoat", setGoat);
        editor.commit();
    }

    public String getGoat() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setGoat", "0");
    }


    public void seHinditGoat(String setGoat) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetGoat", setGoat);
        editor.commit();
    }

    public String getHindiGoat() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetGoat", "");
    }




    public void setEmployeeCode(String employeeCode) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("EmployeeCode", employeeCode);
        editor.commit();

    }

    public String getEmployeeCode() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("EmployeeCode", "");
    }

    public void setEducation(String employeeCode) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("educode", employeeCode);
        editor.commit();

    }

    public String getEducation() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("educode", "");
    }

    public void setHindiItemEducation(String employeeCode) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hindieducode", employeeCode);
        editor.commit();

    }

    public String getHindiItemEducation() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindieducode", "");
    }



    public void setReligion(String religionName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("ReligionName", religionName);
        editor.commit();

    }
    public String getReligion() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("ReligionName", "");
    }

    public void setCropSeason(String setCropSeason) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setCropSeason", setCropSeason);
        editor.commit();

    }
    public String getCropSeason() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setCropSeason", "");
    }

    public void setEmail(String emailName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("EmailName", emailName);
        editor.commit();

    }
    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("EmailName", "");
    }

    public void setHindiEmail(String emailName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindiEmailName", emailName);
        editor.commit();

    }
    public String getHindiEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindiEmailName", "");
    }

    public void setAdharNumber(String adharnumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("AdharNumber", adharnumber);
        editor.commit();

    }
    public String getAdharNumber() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("AdharNumber", "");
    }

    public void setHindiAdharNumber(String adharnumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindiAdharNumber", adharnumber);
        editor.commit();

    }
    public String getHindiAdharNumber() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindiAdharNumber", "");
    }

    public void setPanNumber(String pannumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("PanNumber", pannumber);
        editor.commit();

    }
    public String getPanNumber() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("PanNumber", "");

    }

    public void setHindiPanNumber(String pannumber) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindiPanNumber", pannumber);
        editor.commit();

    }
    public String getHindiPanNumber() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("hindiPanNumber", "");

    }

    public void setVilalgeName(String villagename) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("villagename", villagename);
        editor.commit();

    }


    public String getVilalgeName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("villagename", "");

    }


    public void setHindiVilalgeName(String villagename) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindivillagename", villagename);
        editor.commit();

    }


    public String getHindiVilalgeName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("hindivillagename", "");

    }

    public void setFramerAge(String setFramerAge) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFramerAge", setFramerAge);
        editor.commit();

    }
    public String getFramerAge() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setFramerAge", "");

    }


    public void setFamilySize(String familysize) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("FamilySize", familysize);
        editor.commit();

    }

    public String getFamilySize() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("FamilySize", "");

    }

    public void setMandalName(String mandal_name) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("mandal_name", mandal_name);
        editor.commit();

    }

    public String getMandal() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("mandal_name", "");

    }

     public void setemailAbout(String mandal_name) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setemail", mandal_name);
        editor.commit();

    }

    public String getemailAbout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setemail", "");

    }
 public void setAddressAbout(String mandal_name) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setAddressAbout", mandal_name);
        editor.commit();

    }

    public String getAddressAbout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setAddressAbout", "");

    }

    public void setMobileAbout(String mandal_name) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMobileAbout", mandal_name);
        editor.commit();

    }

    public String getMobileAbout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setMobileAbout", "");

    }




    public void setLandholding(String setLandholding) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setLandholding", setLandholding);
        editor.commit();

    }

    public String getLandholding() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setLandholding", "");

    }

    public void setLandMarkMark(String setLandMarkMark) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setLandMarkMark", setLandMarkMark);
        editor.commit();

    }

    public String getLandMarkMark() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setLandMarkMark", "");

    }

    public void setDob(String setDob) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setDob", setDob);
        editor.commit();

    }

    public String getDob() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setDob", "");

    }


    public void setFramerAddress(String farmeraddress) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("FramerAddress", farmeraddress);
        editor.commit();

    }

    public String getFarmerAddress() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("FramerAddress", "");

    }

    public void setMaincrop(String setMaincrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMaincrop", setMaincrop);
        editor.commit();

    }

    public String getMaincrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setMaincrop", "");

    }

    public void setVerticalcrop(String setVerticalcrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setVerticalcrop", setVerticalcrop);
        editor.commit();

    }

    public String getVerticalcrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setVerticalcrop", "");

    }

    public void setFarmerMarketing(String setFarmerMarketing) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFarmerMarketing", setFarmerMarketing);
        editor.commit();

    }

    public String getFarmerMarketing() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setFarmerMarketing", "");

    }

    public void setTotalInvestmentCrop(String setTotalInvestmentCrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setTotalInvestmentCrop", setTotalInvestmentCrop);
        editor.commit();

    }

    public String getTotalInvestmentCrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setTotalInvestmentCrop", "");

    }

    public void setIrrigationItem(String setIrrigationItem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setIrrigationItem", setIrrigationItem);
        editor.commit();

    }

    public String getIrrigationItem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setIrrigationItem", "");

    }

    public void setTotalIncomeCrop(String setTotalIncomeCrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setTotalIncomeCrop", setTotalIncomeCrop);
        editor.commit();

    }

    public String getTotalIncomeCrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setTotalIncomeCrop", "");

    }
    public void setProfit(String setProfit) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setProfit", setProfit);
        editor.commit();

    }

    public String getProfit() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setProfit", "");

    }


    public void setYieldMainCrop(String setYieldMainCrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setYieldMainCrop", setYieldMainCrop);
        editor.commit();

    }

    public String getYieldMainCrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setYieldMainCrop", "");

    }

    public void setYieldVerticalCrop(String setYieldVerticalCrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setYieldVerticalCrop", setYieldVerticalCrop);
        editor.commit();

    }

    public String getYieldVerticalCrop() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setYieldVerticalCrop", "");

    }


    public void setPinCode(String PinCode) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("PinCode", PinCode);
        editor.commit();

    }

    public String getPinCode() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("PinCode", "");

    }

    public void setAreaSoil(String soilarea) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("AreaSoil", soilarea);
        editor.commit();

    }

    public String getAreaSoil() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("AreaSoil", "");

    }


    public void setCropArea(String croparea) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("CropArea", croparea);
        editor.commit();

    }

    public String getCropArea() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("CropArea", "");

    }

    public void setproduction(String production) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Production", production);
        editor.commit();

    }

    public String getproduction() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("Production", "");

    }


    public void setMarketing(String marketing) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Marketing", marketing);
        editor.commit();

    }

    public String getMarketing() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("Marketing", "");

    }


    public void setLiveStock(String soilarea) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("LiveStock", soilarea);
        editor.commit();

    }

    public String getLiveStock() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("LiveStock", "");

    }



  public void setLogin(String soilarea) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("login", soilarea);
        editor.commit();

    }

    public String getLogin() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("login", "false");

    }




    public void setLoginStatus(boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsLogin", value);
        editor.commit();
    }

    public boolean getLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getBoolean("IsLogin", false);
    }


    public boolean getEnglishLanguageLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("englishIsLogin", false);
    }

    public void setEnglishLanguageLoginStatus(boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("englishIsLogin", value);
        editor.commit();
    }

    public boolean getAdsStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("setAdsStatus", false);
    }

    public void setAdsStatus(boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("setAdsStatus", value);
        editor.commit();
    }


    public boolean getHindiLanguageLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("hindiIsLogin", false);
    }

    public void setHindiLanguageLoginStatus(boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("hindiIsLogin", value);
        editor.commit();
    }



    public void setCheckIn(boolean checkIn) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("IsCheckIN", checkIn);
        editor.commit();
    }

    public boolean getCheckIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("IsCheckIN", false);
    }

    public void setCheckMachine(boolean backValue) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("CheckIn", backValue);
        editor.commit();
    }

    public boolean getCheckMachine() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("CheckIn", false);
    }


    public void setImageValue(boolean imagevalue) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("ImageValue", imagevalue);
        editor.commit();
    }

    public boolean getImageValue() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("ImageValue", false);
    }

    public void setstateselectedIten(String stateselected) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("StateSelected", stateselected);
        editor.commit();

    }

    public Boolean getstateselectedIten() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getBoolean("StateSelected", false);
    }

    public void setchecjmachineitem(String checkitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("CheckedItem", checkitem);
        editor.commit();

    }

    public String getchecjmachineitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("CheckedItem", "");
    }


    public void setEduList(EducationResponse retailerBeatResponse){
    SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

    SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
    Gson gson = new Gson();
    String json = gson.toJson(retailerBeatResponse);
    prefsEditor.putString("eduList", json);
    prefsEditor.commit();

}

    public EducationResponse getEduList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("eduList", "");
        if(json.isEmpty())
            return null;
        else {
            EducationResponse obj = gson.fromJson(json, EducationResponse.class);
            return obj;
        }
    }

    public void setHindiEduList(EducationResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("eduListhindi", json);
        prefsEditor.commit();

    }

    public EducationResponse getHindiEduList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("eduListhindi", "");
        if(json.isEmpty())
            return null;
        else {
            EducationResponse obj = gson.fromJson(json, EducationResponse.class);
            return obj;
        }
    }





    public void setCropList(CropPatternType retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("cropList", json);
        prefsEditor.commit();

    }

    public CropPatternType getCropList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cropList", "");
        if(json.isEmpty())
            return null;
        else {
            CropPatternType obj = gson.fromJson(json, CropPatternType.class);
            return obj;
        }
        }

    public void setCropPattern(CropType retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("croptype", json);
        prefsEditor.commit();

    }

    public CropType getCropPattern() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("croptype", "");
        if (json.isEmpty())
            return null;
        else {
            CropType obj = gson.fromJson(json, CropType.class);
            return obj;

        }
    }


    public void setHindiCropPattern(CropType retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindicroptype", json);
        prefsEditor.commit();

    }

    public CropType getHindiCropPattern() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindicroptype", "");
        if (json.isEmpty())
            return null;
        else {
            CropType obj = gson.fromJson(json, CropType.class);
            return obj;

        }
    }

    public void setMachineryItem(MachineryResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("machineitem", json);
        prefsEditor.commit();

    }

    public MachineryResponse getMachineryItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("machineitem", "");

        if (json.isEmpty())
            return null;
        else {
            MachineryResponse obj = gson.fromJson(json, MachineryResponse.class);
            return obj;
        }
    }


    public void setHindiMachineryItem(MachineryResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindimachineitem", json);
        prefsEditor.commit();

    }

    public MachineryResponse getHindiMachineryItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindimachineitem", "");

        if (json.isEmpty())
            return null;
        else {
            MachineryResponse obj = gson.fromJson(json, MachineryResponse.class);
            return obj;
        }
    }


    public void setDiaseaseList(DiseaseModel retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("diseaselist", json);
        prefsEditor.commit();

    }

    public DiseaseModel getDiaseaseList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("diseaselist", "");

        if (json.isEmpty())
            return null;
        else {
            DiseaseModel obj = gson.fromJson(json, DiseaseModel.class);
            return obj;
        }
    }


    public void setHindiDiaseaseList(DiseaseModel retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindidiseaselist", json);
        prefsEditor.commit();

    }

    public DiseaseModel getHindiDiaseaseList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindidiseaselist", "");

        if (json.isEmpty())
            return null;
        else {
            DiseaseModel obj = gson.fromJson(json, DiseaseModel.class);
            return obj;
        }
    }


    public void setPestList(PestObserverdModel retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("pestlist", json);
        prefsEditor.commit();

    }

    public PestObserverdModel getPestList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("pestlist", "");

        if (json.isEmpty())
            return null;
        else {
            PestObserverdModel obj = gson.fromJson(json, PestObserverdModel.class);
            return obj;
        }
    }


    public void setHindiPestList(PestObserverdModel retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindipestlist", json);
        prefsEditor.commit();

    }

    public PestObserverdModel getHindiPestList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindipestlist", "");

        if (json.isEmpty())
            return null;
        else {
            PestObserverdModel obj = gson.fromJson(json, PestObserverdModel.class);
            return obj;
        }
    }

    public void setMainCropList(MainCrop retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("maincroplist", json);
        prefsEditor.commit();

    }

    public MainCrop getMainCropList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("maincroplist", "");

        if (json.isEmpty())
            return null;
        else {
            MainCrop obj = gson.fromJson(json, MainCrop.class);
            return obj;
        }
    }


    public void setHindiMainCropList(MainCrop retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindimaincroplist", json);
        prefsEditor.commit();

    }

    public MainCrop getHindiMainCropList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindimaincroplist", "");

        if (json.isEmpty())
            return null;
        else {
            MainCrop obj = gson.fromJson(json, MainCrop.class);
            return obj;
        }
    }


    public void setmaincropselecteditem(String setmaincropselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setmaincropselecteditem", setmaincropselecteditem);
        editor.commit();

    }

    public String getmaincropselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setmaincropselecteditem", "");
    }




    public void sethindimaincropselecteditem(String sethindimaincropselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("sethindimaincropselecteditem", sethindimaincropselecteditem);
        editor.commit();

    }

    public String gethindimaincropselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("sethindimaincropselecteditem", "");
    }
    public void setverticalCropList(VerticalList retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("verticalcroplist", json);
        prefsEditor.commit();

    }

    public VerticalList getverticalCropList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("verticalcroplist", "");

        if (json.isEmpty())
            return null;
        else {
            VerticalList obj = gson.fromJson(json, VerticalList.class);
            return obj;
        }
    }



    public void setHindiverticalCropList(VerticalList retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("verticalhindicroplist", json);
        prefsEditor.commit();

    }

    public VerticalList getHindiverticalCropList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("verticalhindicroplist", "");

        if (json.isEmpty())
            return null;
        else {
            VerticalList obj = gson.fromJson(json, VerticalList.class);
            return obj;
        }
    }


    public void setStateList(StateResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("statelist", json);
        prefsEditor.commit();

    }

    public StateResponse getStateList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("statelist", "");

        if (json.isEmpty())
            return null;
        else {
            StateResponse obj = gson.fromJson(json, StateResponse.class);
            return obj;

        }
    }


    public void setHindiStateList(StateResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("statehindilist", json);
        prefsEditor.commit();

    }

    public StateResponse getHindiStateList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("statehindilist", "");

        if (json.isEmpty())
            return null;
        else {
            StateResponse obj = gson.fromJson(json, StateResponse.class);
            return obj;

        }

    }
    public void setMachineList(MachineryResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("machinelist", json);
        prefsEditor.commit();

    }

    public MachineryResponse getMachineList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("machinelist", "");

        if (json.isEmpty())
            return null;
        else {
            MachineryResponse obj = gson.fromJson(json, MachineryResponse.class);
            return obj;
        }
    }

    public void setHindiSoilList(SoilResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindisoillist", json);
        prefsEditor.commit();

    }

    public SoilResponse getHindiSoilList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindisoillist", "");

        if (json.isEmpty())
            return null;
        else {
            SoilResponse obj = gson.fromJson(json, SoilResponse.class);
            return obj;
        }
    }


    public void setSoilList(SoilResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("soillist", json);
        prefsEditor.commit();

    }

    public SoilResponse getSoilList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("soillist", "");

        if (json.isEmpty())
            return null;
        else {
            SoilResponse obj = gson.fromJson(json, SoilResponse.class);
            return obj;
        }
    }
    //citylist


    public void setCityList(CityResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("citylist", json);
        prefsEditor.commit();

    }

    public CityResponse getCityList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("citylist", "");

        if (json.isEmpty())
            return null;
        else {
            CityResponse obj = gson.fromJson(json, CityResponse.class);
            return obj;
        }
    }

    public void setHindiCityList(CityResponse retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("cityhindilist", json);
        prefsEditor.commit();

    }

    public CityResponse getHindiCityList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cityhindilist", "");

        if (json.isEmpty())
            return null;
        else {
            CityResponse obj = gson.fromJson(json, CityResponse.class);
            return obj;
        }
    }
    //YesIrrigationLisr

    public void setIrrigationList(ResponseIrrigationList retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("yesirrigationlist", json);
        prefsEditor.commit();

    }

    public ResponseIrrigationList getIrrigationList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("yesirrigationlist", "");

        if (json.isEmpty())
            return null;
        else {
            ResponseIrrigationList obj = gson.fromJson(json, ResponseIrrigationList.class);
            return obj;
        }
    }


    public void setHindiIrrigationList(IrrigationModel retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(retailerBeatResponse);
        prefsEditor.putString("hindiyesirrigationlist", json);
        prefsEditor.commit();

    }


    public IrrigationModel getHindiIrrigationList() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindiyesirrigationlist", "");

        if (json.isEmpty())
            return null;
        else {
            IrrigationModel obj = gson.fromJson(json, IrrigationModel.class);
            return obj;
        }
    }

    //saving mcine data

    public void setCheckMachineItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("CheckMachineItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("CheckMachineItem", "");
            prefsEditor.commit();
        }

    }


    public SaveMachineData  getCheckMachineItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CheckMachineItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }



    public void setHindiCheckMachineItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("setHindiCheckMachineItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("setHindiCheckMachineItem", "");
            prefsEditor.commit();
        }

    }


    public SaveMachineData  getHindiCheckMachineItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("setHindiCheckMachineItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }

    public void setCheckDiseaseItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("CheckDiseaseItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("CheckDiseaseItem", "");
            prefsEditor.commit();
        }

    }
    public SaveMachineData  getCheckDiseaseItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CheckDiseaseItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }


    public void setHindiCheckDiseaseItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("hindiCheckDiseaseItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("hindiCheckDiseaseItem", "");
            prefsEditor.commit();
        }

    }
    public SaveMachineData  getHindiCheckDiseaseItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindiCheckDiseaseItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }


    public void setCheckYesIrrigItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("CheckYesItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("CheckYesItem", "");
            prefsEditor.commit();
        }

    }
    public SaveMachineData  getCheckYesIrrigItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CheckYesItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }


    public void setHindiCheckYesIrrigItem(SaveMachineData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("hindiCheckYesItem", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("hindiCheckYesItem", "");
            prefsEditor.commit();
        }

    }
    public SaveMachineData  getHindiCheckYesIrrigItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindiCheckYesItem", "");
        if(json.isEmpty())
            return null;
        else {
            SaveMachineData obj = gson.fromJson(json, SaveMachineData.class);
            return obj;
        }
    }

    public void setCheckPestItem(SavePestData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("SavePestData", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("SavePestData", "");
            prefsEditor.commit();
        }

    }

    public SavePestData  getCheckPestItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("SavePestData", "");
        if(json.isEmpty())
            return null;
        else {
            SavePestData obj = gson.fromJson(json, SavePestData.class);
            return obj;
        }
    }

    public void setHindiCheckPestItem(SavePestData retailerBeatResponse){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if(retailerBeatResponse!=null) {
            Gson gson = new Gson();
            String json = gson.toJson(retailerBeatResponse);
            prefsEditor.putString("hindiSavePestData", json);
            prefsEditor.commit();
        }
        else {

            prefsEditor.putString("hindiSavePestData", "");
            prefsEditor.commit();
        }

    }

    public SavePestData  getHindiCheckPestItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("hindiSavePestData", "");
        if(json.isEmpty())
            return null;
        else {
            SavePestData obj = gson.fromJson(json, SavePestData.class);
            return obj;
        }
    }


    public void setirrigationseleteditem(String irrigationitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("IrrigationItem", irrigationitem);
        editor.commit();

    }

    public String getirrigationseleteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("IrrigationItem", "");
    }

    public void sethindiirrigationseleteditem(String irrigationitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("HindiIrrigationItem", irrigationitem);
        editor.commit();
    }

    public String gethindiirrigationseleteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("HindiIrrigationItem", "");
    }

    public void setphysicaldisibiltyseleteditem(String disibilityitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("DisibiltyItem", disibilityitem);
        editor.commit();

    }

    public String getphysicaldisibiltyseleteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("DisibiltyItem", "");
    }


    public void setslectedsocialditem(String setslectedsocialditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setslectedsocialditem", setslectedsocialditem);
        editor.commit();

    }

    public String getslectedsocialditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setslectedsocialditem", "");
    }


    public void setcastecategoryitem(String setcastecategoryitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setcastecategoryitem", setcastecategoryitem);
        editor.commit();

    }

    public String getcastecategoryitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setcastecategoryitem", "");
    }

    public void setverticalselecteditem(String setverticalselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setverticalselecteditem", setverticalselecteditem);
        editor.commit();

    }

    public void setsoilselecteditem(String setsoilselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setsoilselecteditem", setsoilselecteditem);
        editor.commit();

    }

    public String getsoilselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setsoilselecteditem", "");
    }

    public void sethindisoilselecteditem(String sethindisoilselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("sethindisoilselecteditem", sethindisoilselecteditem);
        editor.commit();

    }

    public String gethindisoilselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("sethindisoilselecteditem", "");
    }


    public String getverticalselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setverticalselecteditem", "");
    }

    public void setmonocroppingselecteditem(String setmonocroppingselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setmonocroppingselecteditem", setmonocroppingselecteditem);
        editor.commit();

    }

    public String gethindiverticalselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("sethindiverticalselecteditem", "");
    }

    public void sethindiverticalselecteditem(String setverticalselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("sethindiverticalselecteditem", setverticalselecteditem);
        editor.commit();

    }

    public String getmonocroppingselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setmonocroppingselecteditem", "");
    }


    public void setbiofertilizerselecteditem(String setbiofertilizerselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setbiofertilizerselecteditem", setbiofertilizerselecteditem);
        editor.commit();

    }

    public String getbiofertilizerselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setbiofertilizerselecteditem", "");
    }


    public void sethindimonocroppingselecteditem(String setbiofertilizerselecteditem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hindisetbiofertilizerselecteditem", setbiofertilizerselecteditem);
        editor.commit();

    }

    public String gethindimonocroppingselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("hindisetbiofertilizerselecteditem", "");
    }

    public void setcrelsselecteditem(String cerelsitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("cerelsitem", cerelsitem);
        editor.commit();

    }

    public String getcrelsselecteditem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("stateitem", "");
    }
    public void setstateitem(String stateitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("stateitem", stateitem);
        editor.commit();

    }

    public String getstateitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("stateitem", "");
    }


    public void sethindistateitem(String stateitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("statehindiitem", stateitem);
        editor.commit();

    }

    public String gethindistateitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("statehindiitem", "");
    }

    public void setcityitem(String cityitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("cityitem", cityitem);
        editor.commit();

    }



    public String getcityitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("cityitem", "");
    }

    public void sethindicityitem(String cityitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("cityhindiitem", cityitem);
        editor.commit();

    }



    public String gethindicityitem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("cityhindiitem", "");
    }


    //Saved CROPinformation




    public void setOnlyCropName(String setOnlyCropName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setOnlyCropName", setOnlyCropName);
        editor.commit();
    }

    public String getOnlyCropName() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setOnlyCropName", "");
    }

    public void setOnlyVarietyName(String setOnlyVarietyName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setOnlyVarietyName", setOnlyVarietyName);
        editor.commit();
    }

    public String getOnlyVarietyName() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setOnlyVarietyName", "");
    }

    public void setDateOfSowing(String setDateOfSowing) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setDateOfSowing", setDateOfSowing);
        editor.commit();
    }

    public String getDateOfSowing() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setDateOfSowing", "");
    }
    public void setDateOfPlanting(String setDateOfPlanting) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setDateOfPlanting", setDateOfPlanting);
        editor.commit();
    }

    public String getDateOfPlanting() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setDateOfPlanting", "");
    }
    public void setLandPreprationDate(String setLandPreprationDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setLandPreprationDate", setLandPreprationDate);
        editor.commit();
    }

    public String getLandPreprationDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setLandPreprationDate", "");
    }
    public void setSoilSampleCollection(String setSoilSampleCollection) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSoilSampleCollection", setSoilSampleCollection);
        editor.commit();
    }

    public String getSoilSampleCollection() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSoilSampleCollection", "");
    }

    public void setFirstSplit(String setFirstSplit) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFirstSplit", setFirstSplit);
        editor.commit();
    }

    public String getFirstSplit() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFirstSplit", "");
    }
    public void setSecondSplit(String setSecondSplit) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSecondSplit", setSecondSplit);
        editor.commit();
    }

    public String getSecondSplit() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSecondSplit", "");
    }

    public void setTopDoseDate(String setTopDoseDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setTopDoseDate", setTopDoseDate);
        editor.commit();
    }

    public String getTopDoseDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setTopDoseDate", "");
    }

    public void setNoOfIrrigation(String setNoOfIrrigation) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setNoOfIrrigation", setNoOfIrrigation);
        editor.commit();
    }

    public String getNoOfIrrigation() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setNoOfIrrigation", "");
    }
    public void setWeedNoticed(String setWeedNoticed) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setWeedNoticed", setWeedNoticed);
        editor.commit();
    }

    public String getWeedNoticed() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setWeedNoticed", "");
    }

    public void setFirstWeedData(String setFirstWeedData) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFirstWeedData", setFirstWeedData);
        editor.commit();
    }

    public String getFirstWeedingDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFirstWeedData", "");
    }
    public void setSecondWeedData(String setSecondWeedData) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSecondWeedData", setSecondWeedData);
        editor.commit();
    }

    public String getSecondWeedData() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSecondWeedData", "");
    }

    public void setFirstApplicationDate(String setFirstApplicationDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFirstApplicationDate", setFirstApplicationDate);
        editor.commit();
    }

    public String getFirstApplicationDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFirstApplicationDate", "");
    }

    public void setSecondApplicationDate(String setSecondApplicationDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSecondApplicationDate", setSecondApplicationDate);
        editor.commit();
    }

    public String getSecondApplicationDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSecondApplicationDate", "");
    }

    public void setSecondApplicationDiseaseDate(String setSecondApplicationDiseaseDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSecondApplicationDiseaseDate", setSecondApplicationDiseaseDate);
        editor.commit();
    }

    public String getSecondApplicationDiseaseDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSecondApplicationDiseaseDate", "");
    }

    public void setFirstApplicationDiseaseDate(String setFirstApplicationDiseaseDate) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFirstApplicationDiseaseDate", setFirstApplicationDiseaseDate);
        editor.commit();
    }

    public String getFirstApplicationDiseaseDate() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFirstApplicationDiseaseDate", "");
    }

    // Data Recorded

    public void setPlantHeight(String setPlantHeight) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPlantHeight", setPlantHeight);
        editor.commit();
    }

    public String getPlantHeight() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPlantHeight", "");
    }


    public void setNoProductivityTiller(String setNoProductivityTiller) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setNoProductivityTiller", setNoProductivityTiller);
        editor.commit();
    }

    public String getNoProductivityTiller() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setNoProductivityTiller", "");
    }

    public void setPanicleSize(String setPanicleSize) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPanicleSize", setPanicleSize);
        editor.commit();
    }

    public String getPanicleSize() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPanicleSize", "");
    }

    public void setNoOfFruit(String setNoOfFruit) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setNoOfFruit", setNoOfFruit);
        editor.commit();
    }

    public String getNoOfFruit() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setNoOfFruit", "");
    }

    public void setDateOfHarvesting(String setDateOfHarvesting) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setDateOfHarvesting", setDateOfHarvesting);
        editor.commit();
    }

    public String getDateOfHarvesting() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setDateOfHarvesting", "");
    }
    public void setgrainweight(String setgrainweight) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setgrainweight", setgrainweight);
        editor.commit();
    }

    public String getgrainweight() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setgrainweight", "");
    }

    public void setgrainYieldPlant(String setgrainYieldPlant) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setgrainYieldPlant", setgrainYieldPlant);
        editor.commit();
    }


    public String getGenderItemSelected() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("getGenderItemSelected", "");
    }

    public void setGenderItemSelected(String getGenderItemSelected) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("getGenderItemSelected", getGenderItemSelected);
        editor.commit();
    }

    public String getHindiGenderItemSelected() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("getGenderHindiItemSelected", "");
    }

    public void setHindiGenderItemSelected(String getGenderItemSelected) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("getGenderHindiItemSelected", getGenderItemSelected);
        editor.commit();
    }


    public String getgrainYieldPlant() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setgrainYieldPlant", "");
    }

    public void setgrainYieldPlot(String setgrainYieldPlot) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setgrainYieldPlot", setgrainYieldPlot);
        editor.commit();
    }

    public String getgrainYieldPlot() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setgrainYieldPlot", "");
    }

    public void setNitrogen(String setNitrogen) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setNitrogen", setNitrogen);
        editor.commit();
    }

    public String getNitrogen() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setNitrogen", "");
    }

    public void setSocialSelectedItem(String setSocialSelectedItem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSocialSelectedItem", setSocialSelectedItem);
        editor.commit();
    }

    public String getSocialSelectedItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSocialSelectedItem", "");
    }


    public void setCasteSelectedItem(String setCasteSelectedItem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setCasteSelectedItem", setCasteSelectedItem);
        editor.commit();
    }

    public String getCasteSelectedItem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setCasteSelectedItem", "");
    }
    public void setPhosphorous(String setPhosphorous) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPhosphorous", setPhosphorous);
        editor.commit();
    }

    public String getPhosphorous() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPhosphorous", "");
    }

    public void setPotassium(String setPotassium) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPotassium", setPotassium);
        editor.commit();
    }

    public String getPotassium() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPotassium", "");
    }

    public void setOrgainicMatter(String setOrgainicMatter) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setOrgainicMatter", setOrgainicMatter);
        editor.commit();
    }

    public String getOrgainicMatter() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setOrgainicMatter", "");
    }

    public void setIrrigationMatter(String setIrrigationMatter) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setIrrigationMatter", setIrrigationMatter);
        editor.commit();
    }

    public String getIrrigationMatter() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setIrrigationMatter", "");
    }

    public void setLandpreparation(String setLandpreparation) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setLandpreparation", setLandpreparation);
        editor.commit();
    }

    public String getLandpreparation() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setLandpreparation", "");
    }

    //Cost

    public void setSeed(String setSeed) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSeed", setSeed);
        editor.commit();
    }

    public String getSeed() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSeed", "");
    }

    public void setFertilizer(String setFertilizer) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setFertilizer", setFertilizer);
        editor.commit();
    }

    public String getFertilizer() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setFertilizer", "");
    }

    public void setpestisides(String setpestisides) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setpestisides", setpestisides);
        editor.commit();
    }

    public String getpestisides() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setpestisides", "");
    }
    public void setPlanting(String setPlanting) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPlanting", setPlanting);
        editor.commit();
    }
 public void setPlanting1(String setPlanting) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPlanting1", setPlanting);
        editor.commit();
    }

    public String getPlanting() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPlanting", "");
    }

    public String getPlanting1() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPlanting1", "");
    }
    public void setWeeding(String setWeeding) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setWeeding", setWeeding);
        editor.commit();
    }

    public String getWeeding() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setWeeding", "");
    }
    public void setIrrigation(String setIrrigation) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setIrrigation", setIrrigation);
        editor.commit();
    }

    public String getIrrigation() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setIrrigation", "");
    }

    public void setSpraying(String setSpraying) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setSpraying", setSpraying);
        editor.commit();
    }

    public String getSpraying() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setSpraying", "");
    }
    public void setHarvestingThresing(String setHarvestingThresing) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setHarvestingThresing", setHarvestingThresing);
        editor.commit();
    }

    public String getHarvestingThresing() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setHarvestingThresing", "");
    }
    public void setwinnoing(String setwinnoing) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setwinnoing", setwinnoing);
        editor.commit();
    }

    public String getwinnoing() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setwinnoing", "");
    }
    public void setPacking(String setPacking) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setPacking", setPacking);
        editor.commit();
    }

    public String getPacking() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setPacking", "");
    }
    public void settranportation(String settranportation) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("settranportation", settranportation);
        editor.commit();
    }

    public String gettranportation() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("settranportation", "");
    }
    public void setTotalProducemaincrop(String TotalProducemaincrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("TotalProducemaincrop", TotalProducemaincrop);
        editor.commit();
    }

    public String getTotalProducemaincrop() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("TotalProducemaincrop", "");
    }

    public void setTotalProduceverticalcrop(String setTotalProduceverticalcrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setTotalProduceverticalcrop", setTotalProduceverticalcrop);
        editor.commit();
    }

    public String getTotalProduceverticalcrop() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setTotalProduceverticalcrop", "");
    }

    public void setTotalCostExpenditure(String setTotalCostExpenditure) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setTotalCostExpenditure", setTotalCostExpenditure);
        editor.commit();
    }

    public String getTotalCostExpenditure() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setTotalCostExpenditure", "");
    }

    public void setMarketValuemaincrop(String setMarketValuemaincrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMarketValuemaincrop", setMarketValuemaincrop);
        editor.commit();
    }

    public String getMarketValuemaincrop() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setMarketValuemaincrop", "");
    }

    public void setMarketValueverticalcrop(String setMarketValueverticalcrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setMarketValueverticalcrop", setMarketValueverticalcrop);
        editor.commit();
    }

    public String getMarketValueverticalcrop() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setMarketValueverticalcrop", "");
    }

    public void setAmount(String setMarketValueverticalcrop) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("amount", setMarketValueverticalcrop);
        editor.commit();
    }

    public String getAmount() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("amount", "");
    }

    public void setIncomefarmlab(String setIncomefarmlab) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setIncomefarmlab", setIncomefarmlab);
        editor.commit();
    }

    public String getIncomefarmlab() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setIncomefarmlab", "");
    }

    public void setCostBenefitratio(String setCostBenefitratio) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setCostBenefitratio", setCostBenefitratio);
        editor.commit();
    }

    public String getCostBenefitratio() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setCostBenefitratio", "");
    }

    public void setCostDiscription(String setCostDiscription) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setCostDiscription", setCostDiscription);
        editor.commit();
    }

    public String getCostDiscription() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setCostDiscription", "");
    }



    public void setNoOfRainyDays(String setNoOfRainyDays) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setNoOfRainyDays", setNoOfRainyDays);
        editor.commit();
    }

    public String getNoOfRainyDays() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setNoOfRainyDays", "");
    }


    public void setfarmlabpracticestatus(String setfarmlabpracticestatus) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmlabpracticestatus", setfarmlabpracticestatus);
        editor.commit();
    }

    public String getfarmlabpracticestatus() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmlabpracticestatus", "");
    }

    public void setfarmlabmaincrostatus(String setfarmlabmaincrostatus) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmlabmaincrostatus", setfarmlabmaincrostatus);
        editor.commit();
    }

    public String getfarmlabmaincrostatus() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmlabmaincrostatus", "");
    }

    public void setfarmlabverticalcrostatus(String setfarmlabverticalcrostatus) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmlabverticalcrostatus", setfarmlabverticalcrostatus);
        editor.commit();
    }

    public String getfarmlabverticalcrostatus() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmlabverticalcrostatus", "");
    }

    public void setdatarecordedrainfall(String setdatarecordedrainfall) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setdatarecordedrainfall", setdatarecordedrainfall);
        editor.commit();
    }

    public String getdatarecordedrainfall() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setdatarecordedrainfall", "");
    }


    public void setHindidatarecordedrainfall(String setdatarecordedrainfall) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Hindisetdatarecordedrainfall", setdatarecordedrainfall);
        editor.commit();
    }

    public String getHindidatarecordedrainfall() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Hindisetdatarecordedrainfall", "");
    }

    public void setdatarecordedcropcond(String setdatarecordedcropcond) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setdatarecordedcropcond", setdatarecordedcropcond);
        editor.commit();
    }

    public String getdatarecordedcropcond() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setdatarecordedcropcond", "");
    }

    public void setHindidatarecordedcropcond(String setdatarecordedcropcond) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Hindisetdatarecordedcropcond", setdatarecordedcropcond);
        editor.commit();
    }

    public String getHindidatarecordedcropcond() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Hindisetdatarecordedcropcond", "");
    }

    public void setdatarecordedgeneralobs(String setdatarecordedgeneralobs) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setdatarecordedgeneralobs", setdatarecordedgeneralobs);
        editor.commit();
    }

    public String getdatarecordedgeneralobs() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setdatarecordedgeneralobs", "");
    }


    public void setHindidatarecordedgeneralobs(String setdatarecordedgeneralobs) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Hindisetdatarecordedgeneralobs", setdatarecordedgeneralobs);
        editor.commit();
    }

    public String getHindidatarecordedgeneralobs() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("Hindisetdatarecordedgeneralobs", "");
    }
    public void setfarmsoilitem(String setfarmsoilitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmsoilitem", setfarmsoilitem);
        editor.commit();
    }

    public String getfarmsoilitem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmsoilitem", "");
    }
    public void setfarmphosphorousitem(String setfarmphosphorousitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmphosphorousitem", setfarmphosphorousitem);
        editor.commit();
    }

    public String getfarmphosphorousitem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmphosphorousitem", "");
    }
    public void setfarmpotassiumitem(String setfarmpotassiumitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmpotassiumitem", setfarmpotassiumitem);
        editor.commit();
    }

    public String getfarmpotassiumitem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmpotassiumitem", "");
    }
    public void setOrganicCarbon(String setfarmorganicitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("organic", setfarmorganicitem);
        editor.commit();
    }

    public String getOrganicCarbon() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("organic", "");
    }
   public void setPH(String setfarmorganicitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("PH", setfarmorganicitem);
        editor.commit();
    }

    public String getPH() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("PH", "");
    }
    public void setfarmirrigationitem(String setfarmirrigationitem) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setfarmirrigationitem", setfarmirrigationitem);
        editor.commit();
    }

    public String getfarmirrigationitem() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setfarmirrigationitem", "");
    }
 public void setBeekeeping(String setfarmirrigationitem) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("getBeekeeping", setfarmirrigationitem);
        editor.commit();
    }

    public String getBeekeeping() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("getBeekeeping", "");
    }
public void setSericulture(String setfarmirrigationitem) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("setSericulture", setfarmirrigationitem);
        editor.commit();
    }

    public String getSericulture() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setSericulture", "");
    }
public void setMainCropID(String setfarmirrigationitem) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("setMainCropID", setfarmirrigationitem);
        editor.commit();
    }

    public String getMainCropID() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setMainCropID", "");
    }
public void setSubCropID(String setfarmirrigationitem) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("setSubCropID", setfarmirrigationitem);
        editor.commit();
    }

    public String getSubCropID() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getString("setSubCropID", "");
    }
public void setCropInfoID(int setfarmirrigationitem) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("setCropInfoID", setfarmirrigationitem);
        editor.commit();
    }

    public int getCropInfoID() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getInt("setCropInfoID", 0);
    }
//public void setTotalCropsSize(int setfarmirrigationitem) {
//        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("setTotalCropsSize", setfarmirrigationitem);
//        editor.commit();
//    }
//
//    public int getTotalCropsSize() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
//        return sharedPreferences.getInt("setTotalCropsSize", 0);
//    }


    public void setb1(String setb1) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb1", setb1);
        editor.commit();
    }

    public String getb1() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb1", "");
    }

    public void setb2(String setb2) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb2", setb2);
        editor.commit();
    }

    public String getb2() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb2", "");
    }

    public void setb3(String setb3) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb3", setb3);
        editor.commit();
    }

    public String getb3() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb3", "");
    }

    public void setb4(String setb4) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb4", setb4);
        editor.commit();
    }

    public String getb4() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb4", "");
    }

    public void setb5(String setb5) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb5", setb5);
        editor.commit();
    }

    public String getb5() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb5", "");
    }


    public void setb6(String setb6) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb6", setb6);
        editor.commit();
    }

    public String getb6() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb6", "");
    }

    public void setb7(String setb7) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb7", setb7);
        editor.commit();
    }

    public String getb7() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb7", "");
    }

    public void setb8(String setb8) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb8", setb8);
        editor.commit();
    }

    public String getb8() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb8", "");
    }


    public void setb9(String setb9) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setb9", setb9);
        editor.commit();
    }

    public String getb9() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setb9", "");
    }





    public void setotherexpense(String setotherexpense) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("setotherexpense", setotherexpense);
        editor.commit();
    }

    public String getotherexpense() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);

        return sharedPreferences.getString("setotherexpense", "");
    }


    public void setCostStatus(boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Cost", value);
        editor.commit();
    }

    public boolean getCostStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
        return sharedPreferences.getBoolean("Cost", false);
    }



}
