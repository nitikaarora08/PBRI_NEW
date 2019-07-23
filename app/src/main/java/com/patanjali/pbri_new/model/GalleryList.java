
package com.patanjali.pbri_new.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GalleryList {

    @SerializedName("image")
    private List<String> mImage;

    public List<String> getImage() {
        return mImage;
    }

    public void setImage(List<String> image) {
        mImage = image;
    }

}
