package com.pabloserrano.recipes.data;

import com.pabloserrano.recipes.data.model.RecipeList;

import io.reactivex.Observable;

public interface RecipesRepository {

    Observable<RecipeList> getRecipes(String keyword);
}
