
package com.pabloserrano.recipes.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeList {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("version")
    @Expose
    private Double version;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("results")
    @Expose
    private List<Recipe> results = null;

    public String getTitle() {
        return title;
    }

    public Double getVersion() {
        return version;
    }

    public String getHref() {
        return href;
    }

    public List<Recipe> getResults() {
        return results;
    }
}
