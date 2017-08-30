package com.pabloserrano.recipes.data.remote;

import com.pabloserrano.recipes.data.model.RecipeList;
import com.pabloserrano.recipes.network.ApiService;
import com.pabloserrano.recipes.data.RecipesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

public class RecipesRemoteDataSource implements RecipesRepository {

    @Inject
    ApiService apiService;

    public RecipesRemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    /*
        The recipepuppy API does not allow to decide the number of recipes to fetch.
        The only option is to choose the page so in order to fetch 20 items we need
        to concatenate to calls fetching page 1 and 2.
     */
    @Override
    public Observable<RecipeList> getRecipes(final String keyword) {
        return Observable.zip(apiService.getRecipes(keyword, 1), apiService.getRecipes(keyword, 2),
                new BiFunction<RecipeList, RecipeList, RecipeList>() {
                    @Override
                    public RecipeList apply(@NonNull RecipeList recipeList, @NonNull RecipeList recipeList2) throws Exception {
                        recipeList.getResults().addAll(recipeList2.getResults());
                        return recipeList;
                    }
                });
    }
}
