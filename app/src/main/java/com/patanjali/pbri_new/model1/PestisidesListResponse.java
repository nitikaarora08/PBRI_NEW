
package com.patanjali.pbri_new.model1;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PestisidesListResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("pesticides_NameList")
    private List<PesticidesNameList> mPesticidesNameList;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<PesticidesNameList> getPesticidesNameList() {
        return mPesticidesNameList;
    }

    public void setPesticidesNameList(List<PesticidesNameList> pesticidesNameList) {
        mPesticidesNameList = pesticidesNameList;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
