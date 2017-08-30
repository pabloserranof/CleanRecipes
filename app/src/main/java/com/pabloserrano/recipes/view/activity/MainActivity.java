package com.pabloserrano.recipes.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.pabloserrano.recipes.MyApplication;
import com.pabloserrano.recipes.R;
import com.pabloserrano.recipes.data.model.RecipeList;
import com.pabloserrano.recipes.presenter.MainPresenterImp;
import com.pabloserrano.recipes.view.MainView;
import com.pabloserrano.recipes.view.adapter.RecipesAdapter;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenterImp presenter;

    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.recycler_view_city_list)
    RecyclerView recyclerView;

    private RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        initializePresenter();
        initActivity();
    }

    private void initActivity() {
        initializeAdapter();
        initializeRecyclerView();
        initTextWatcher();
    }

    private void initTextWatcher() {
        search.addTextChangedListener(recipesTextWatcher);
    }

    @Override
    public void renderRecipeList(RecipeList recipeList) {
        adapter.addAll(recipeList.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initializeDagger() {
        ((MyApplication) getApplication()).getComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    private void initializeAdapter() {
        adapter = new RecipesAdapter();
    }

    private void initializeRecyclerView() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private final TextWatcher recipesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            presenter.getRecipes(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    } ;

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
        Snackbar.make(findViewById(android.R.id.content), R.string.generic_error, Snackbar.LENGTH_LONG).setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        }).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
