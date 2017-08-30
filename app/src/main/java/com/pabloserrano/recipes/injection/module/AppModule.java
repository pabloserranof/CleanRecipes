package com.pabloserrano.recipes.injection.module;

import android.app.Application;

import com.pabloserrano.recipes.UIThread;
import com.pabloserrano.recipes.data.executor.JobExecutor;
import com.pabloserrano.recipes.domain.executor.PostExecutionThread;
import com.pabloserrano.recipes.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }


    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return mApplication;
    }
}

