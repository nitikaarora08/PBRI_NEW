
package com.patanjali.pbri_new.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GalleryResponse {

    @SerializedName("galleryList")
    private GalleryList mGalleryList;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public GalleryList getGalleryList() {
        return mGalleryList;
    }

    public void setGalleryList(GalleryList galleryList) {
        mGalleryList = galleryList;
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
