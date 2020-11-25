package com.example.fooddelivery.ui.fragment.set_location;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.UpdateUserInfoRequest;
import com.example.fooddelivery.data.model.api.response.UpdateUserInfoResponse;
import com.example.fooddelivery.data.model.pref.UserInfo;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SetLocationViewModel extends BaseViewModel<SetLocationNavigator> {
    public ObservableField<String> address = new ObservableField<>("");

    public SetLocationViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setCurrentAddress(String address){
        getDataManager().setCurrentAddress(address);
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

    public void saveAddress(){
        getNavigator().saveAddress();
    }
}
