
package com.pabloserrano.recipes.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("ingredients")
    @Expose
    private String ingredients;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getThumbnail() {
        return thumbnail;
    }

}
