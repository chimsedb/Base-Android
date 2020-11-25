package com.example.fooddelivery.ui.activity.login;

import android.util.Log;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.UpdateUserInfoRequest;
import com.example.fooddelivery.data.model.api.response.UpdateUserInfoResponse;
import com.example.fooddelivery.data.model.pref.UserInfo;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.facebook.GraphResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setUserInfo(GraphResponse response) {
        getDataManager().setUserInfo(response);
    }

    public void updateUserInfo() {
        UserInfo userInfo = getDataManager().getUserInfo();
        UpdateUserInfoRequest request = new UpdateUserInfoRequest(
                userInfo.getId(),
                userInfo.getName(),
                userInfo.getEmail(),
                userInfo.getAvatar(),
                getDataManager().getCurrentAddress()
        );
        getDataManager().updateUserInfo(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UpdateUserInfoResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull UpdateUserInfoResponse updateUserInfoResponses) {
                        Log.d("123123", updateUserInfoResponses + "zxc");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("123123",e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
