package com.example.fooddelivery.di.module;

import com.example.fooddelivery.data.AppDataManager;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.local.AppPreferencesHelper;
import com.example.fooddelivery.data.local.PreferencesHelper;
import com.example.fooddelivery.data.remote.ServiceEndPoint;
import com.example.fooddelivery.data.remote.ApiHelper;
import com.example.fooddelivery.data.remote.AppApiHelper;
import com.example.fooddelivery.di.scope.ApiInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new retrofit2.Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ServiceEndPoint provideServiceEndPoint(Retrofit retrofit){
        return retrofit.create(ServiceEndPoint.class);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


}
