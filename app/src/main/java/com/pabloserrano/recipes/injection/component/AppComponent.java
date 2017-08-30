package com.pabloserrano.recipes.injection.component;

import com.pabloserrano.recipes.injection.module.AppModule;
import com.pabloserrano.recipes.injection.module.NetModule;
import com.pabloserrano.recipes.injection.module.RepositoryModule;
import com.pabloserrano.recipes.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
