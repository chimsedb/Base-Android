package com.example.fooddelivery.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.example.fooddelivery.ViewModelProviderFactory;
import com.example.fooddelivery.ui.base.BaseActivity;
import com.example.fooddelivery.ui.login.LoginViewModel;
import com.example.fooddelivery.ui.main.MainActivity;
import com.example.fooddelivery.ui.main.MainViewModel;
import com.example.fooddelivery.ui.splash.SplashViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
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
