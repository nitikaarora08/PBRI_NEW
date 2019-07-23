
package com.patanjali.pbri_new.model;
import com.google.gson.annotations.SerializedName;
import com.patanjali.pbri_new.model1.ListFarmBook;

@SuppressWarnings("unused")
public class FarmerDetailIdResponse {

    @SerializedName("list")
    private ListFarmBook mList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public ListFarmBook getList() {
        return mList;
    }

    public void setList(ListFarmBook list) {
        mList = list;
    }

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

}
