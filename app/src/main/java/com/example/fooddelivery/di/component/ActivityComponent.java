package com.example.fooddelivery.di.component;

import com.example.fooddelivery.di.module.ActivityModule;
import com.example.fooddelivery.di.scope.ActivityScope;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.login.LoginActivity;
import com.example.fooddelivery.ui.activity.splash.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);
}
