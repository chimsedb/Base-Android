package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.PhotoResponse;

import java.util.List;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<List<PhotoResponse>> getListPhotos();
}
