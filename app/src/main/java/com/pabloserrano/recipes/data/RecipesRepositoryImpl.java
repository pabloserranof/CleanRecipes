package com.pabloserrano.recipes.data;

import com.pabloserrano.recipes.data.model.RecipeList;

import io.reactivex.Observable;

public class RecipesRepositoryImpl implements RecipesRepository {

    private RecipesRepository recipesRemoteDataSource;

    public RecipesRepositoryImpl(RecipesRepository recipesRemoteDataSource) {
        this.recipesRemoteDataSource = recipesRemoteDataSource;
    }

    @Override
    public Observable<RecipeList> getRecipes(String keyword) {
        return recipesRemoteDataSource.getRecipes(keyword);
    }
}