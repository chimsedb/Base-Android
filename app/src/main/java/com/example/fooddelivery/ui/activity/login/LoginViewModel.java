package com.example.fooddelivery.ui.activity.login;

import android.util.Log;

import com.example.fooddelivery.BuildConfig;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.PhotoResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void login() {
        getNavigator().login();
//        StringUtils.token = "64545";
//        getDataManager().getListPhotos()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<PhotoResponse>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull List<PhotoResponse> photoResponses) {
//                        Log.d("123123", photoResponses.get(0).getTitle() + " - " + photoResponses.get(0).getId());
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d("123123", e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
