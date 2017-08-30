package com.pabloserrano.recipes;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.pabloserrano.recipes.injection.component.AppComponent;
import com.pabloserrano.recipes.injection.component.DaggerAppComponent;
import com.pabloserrano.recipes.injection.module.AppModule;
import com.pabloserrano.recipes.injection.module.NetModule;
import com.pabloserrano.recipes.injection.module.RepositoryModule;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class MyApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return;
            }
            LeakCanary.install(this);
        }

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .build();

        Timber.plant(new Timber.DebugTree());
    }

    public AppComponent getComponent() {
        return component;
    }

    @VisibleForTesting
    public void setComponent(AppComponent appComponent) {
        this.component = appComponent;
    }
}
