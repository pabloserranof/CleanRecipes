package com.pabloserrano.recipes.view;

import com.pabloserrano.recipes.data.model.RecipeList;

public interface MainView extends LoadDataView {

    void renderRecipeList(RecipeList recipeList);
}
