package com.example.fooddelivery.di.module;

import android.app.Application;
import android.content.Context;

import com.example.fooddelivery.BuildConfig;
import com.example.fooddelivery.data.AppDataManager;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.local.AppPreferencesHelper;
import com.example.fooddelivery.data.local.PreferencesHelper;
import com.example.fooddelivery.data.remote.ApiHelper;
import com.example.fooddelivery.data.remote.AppApiHelper;
import com.example.fooddelivery.data.remote.ServiceEndPoint;
import com.example.fooddelivery.di.scope.PreferenceInfo;
import com.example.fooddelivery.ui.activity.utils.StringUtils;
import com.example.fooddelivery.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    Interceptor provideInterceptorHeader() {
        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", StringUtils.token)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Interceptor provideInterceptorHeader) {
        return new OkHttpClient.Builder()
                .addInterceptor(provideInterceptorHeader)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    ServiceEndPoint provideServiceEndPoint(Retrofit retrofit) {
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
