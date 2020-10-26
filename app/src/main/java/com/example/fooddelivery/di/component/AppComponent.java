package com.example.fooddelivery.di.component;

import android.app.Application;

import com.example.fooddelivery.MyApplication;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MyApplication myApplication);

    DataManager getDataManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
