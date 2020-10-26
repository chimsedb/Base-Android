package com.example.fooddelivery.di.module;

import com.example.fooddelivery.data.AppDataManager;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.local.AppPreferencesHelper;
import com.example.fooddelivery.data.local.PreferencesHelper;
import com.example.fooddelivery.data.remote.ApiHelper;
import com.example.fooddelivery.data.remote.AppApiHelper;
import com.example.fooddelivery.data.remote.ServiceEndPoint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("User-Agent", "Your-App-Name")
                            .header("Accept", "application/vnd.yourapi.v1.full+json")
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new retrofit2.Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
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
