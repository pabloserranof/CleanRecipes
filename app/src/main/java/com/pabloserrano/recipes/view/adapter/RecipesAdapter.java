/*
 * Copyright (C) 2015 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pabloserrano.recipes.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloserrano.recipes.R;
import com.pabloserrano.recipes.data.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class RecipesAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final List<Recipe> listRecipes;

    public RecipesAdapter() {
        this.listRecipes = new ArrayList<>();
    }

    public void addAll(List<Recipe> listRecipes) {
        this.listRecipes.clear();
        this.listRecipes.addAll(listRecipes);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_recipe_list, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.render(listRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        Timber.d("size " + listRecipes.size());
        return listRecipes == null ? 0 : listRecipes.size();
    }

}
