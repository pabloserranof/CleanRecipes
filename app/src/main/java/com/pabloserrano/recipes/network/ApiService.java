package com.pabloserrano.recipes.network;

import com.pabloserrano.recipes.data.model.RecipeList;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_URL = "http://www.recipepuppy.com/api/";

    @GET(".")
    Observable<RecipeList> getRecipes(@Query("q") String recipe, @Query("p") int page);
}