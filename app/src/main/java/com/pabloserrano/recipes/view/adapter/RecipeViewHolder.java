package com.pabloserrano.recipes.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pabloserrano.recipes.R;
import com.pabloserrano.recipes.data.model.Recipe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recipe_title)
    TextView comicTitle;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void render(Recipe comic) {
        renderComicTitle(comic.getTitle());
    }

    private void renderComicTitle(String title) {
        comicTitle.setText(title);
    }

}

