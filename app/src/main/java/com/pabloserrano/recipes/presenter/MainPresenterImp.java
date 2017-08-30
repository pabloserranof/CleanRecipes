package com.pabloserrano.recipes.presenter;


import android.support.annotation.NonNull;

import com.pabloserrano.recipes.data.model.RecipeList;
import com.pabloserrano.recipes.domain.exception.DefaultErrorBundle;
import com.pabloserrano.recipes.domain.exception.ErrorBundle;
import com.pabloserrano.recipes.domain.interactor.DefaultObserver;
import com.pabloserrano.recipes.domain.interactor.GetRecipesUseCase;
import com.pabloserrano.recipes.view.MainView;

import javax.inject.Inject;

public class MainPresenterImp implements Presenter {

    private MainView mainView;

    private final GetRecipesUseCase getRecipesUseCase;

    @Inject
    public MainPresenterImp(GetRecipesUseCase getRecipesUseCase) {
        this.getRecipesUseCase = getRecipesUseCase;
    }

    public void setView(@NonNull MainView view) {
        this.mainView = view;
    }

    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getRecipesUseCase.dispose();
        this.mainView = null;
    }

    public void getRecipes(String keyword) {
        this.getRecipesUseCase.execute(new UserDetailsObserver(), GetRecipesUseCase.Params.forKeyword((keyword)));
    }

    private void showViewLoading() {
        this.mainView.showLoading();
    }

    private void hideViewLoading() {
        this.mainView.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        this.mainView.showError(errorBundle.getErrorMessage());
    }

    private void showRecipes(RecipeList recipeList){
        this.mainView.renderRecipeList(recipeList);
    }

    private final class UserDetailsObserver extends DefaultObserver<RecipeList> {

        @Override public void onComplete() {
            MainPresenterImp.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            MainPresenterImp.this.hideViewLoading();
            MainPresenterImp.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override public void onNext(RecipeList recipeList) {
            MainPresenterImp.this.showRecipes(recipeList);
        }
    }
}
