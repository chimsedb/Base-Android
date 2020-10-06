package com.example.fooddelivery;

import android.app.Application;

import com.example.fooddelivery.di.component.AppComponent;
import com.example.fooddelivery.di.component.DaggerAppComponent;

public class MyApplication extends Application {


    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);
    }
}
