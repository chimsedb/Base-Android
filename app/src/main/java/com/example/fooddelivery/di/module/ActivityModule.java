package com.example.fooddelivery.di.module;

import android.content.Context;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.ui.activity.base.BaseActivity;
import com.example.fooddelivery.ui.activity.login.LoginViewModel;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.activity.main.MainPagerAdapter;
import com.example.fooddelivery.ui.activity.main.MainViewModel;
import com.example.fooddelivery.ui.activity.splash.SplashViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Context context;
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity, Context context) {
        this.activity = activity;
        this.context = context;
    }

    @Provides
    MainPagerAdapter provideMainPagerAdapter() {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    LoginViewModel provideLoginViewModel() {
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel();
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory<>(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }

    @Provides
    MainViewModel provideMainViewModel() {
        Supplier<MainViewModel> supplier = () -> new MainViewModel(((MainActivity) activity));
        ViewModelProviderFactory<MainViewModel> factory = new ViewModelProviderFactory<>(MainViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }

    @Provides
    SplashViewModel provideSplashViewModel() {
        Supplier<SplashViewModel> supplier = () -> new SplashViewModel();
        ViewModelProviderFactory<SplashViewModel> factory = new ViewModelProviderFactory<>(SplashViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SplashViewModel.class);
    }

    @Provides
    String provideName() {
        return "Hung dep trai";
    }
}
