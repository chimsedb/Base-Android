package com.example.fooddelivery.data.remote;

import com.example.fooddelivery.data.model.api.PhotoResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceEndPoint {
    @GET("/photos")
    Observable<List<PhotoResponse>> getListPhotos();
}
