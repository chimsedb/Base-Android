package com.example.fooddelivery.data;

import com.example.fooddelivery.data.local.PreferencesHelper;
import com.example.fooddelivery.data.model.api.PhotoResponse;
import com.example.fooddelivery.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    private PreferencesHelper preferencesHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper, PreferencesHelper preferencesHelper) {
        this.apiHelper = apiHelper;
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public Observable<List<PhotoResponse>> getListPhotos() {
        return apiHelper.getListPhotos();
    }
}
