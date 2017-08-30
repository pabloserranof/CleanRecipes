package com.pabloserrano.recipes.injection.module;

import com.pabloserrano.recipes.UIThread;
import com.pabloserrano.recipes.data.RecipesRepository;
import com.pabloserrano.recipes.data.RecipesRepositoryImpl;
import com.pabloserrano.recipes.data.remote.RecipesRemoteDataSource;
import com.pabloserrano.recipes.domain.executor.PostExecutionThread;
import com.pabloserrano.recipes.domain.interactor.GetRecipesUseCase;
import com.pabloserrano.recipes.network.ApiService;
import com.pabloserrano.recipes.presenter.MainPresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public RecipesRepository provideRepository(ApiService apiService) {
        return new RecipesRepositoryImpl(new RecipesRemoteDataSource(apiService));
    }

    @Singleton
    @Provides
    public MainPresenterImp provideMainPresenterImp(GetRecipesUseCase getRecipesUseCase) {
        return new MainPresenterImp(getRecipesUseCase);
    }
}
