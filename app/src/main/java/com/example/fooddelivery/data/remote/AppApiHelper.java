package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.PhotoResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppApiHelper implements ApiHelper{
    private ServiceEndPoint serviceEndPoint;

    @Inject
    public AppApiHelper(ServiceEndPoint serviceEndPoint) {
        this.serviceEndPoint = serviceEndPoint;
    }

    public Observable<List<PhotoResponse>> getListPhotos() {
        return serviceEndPoint.getListPhotos();
    }

}
