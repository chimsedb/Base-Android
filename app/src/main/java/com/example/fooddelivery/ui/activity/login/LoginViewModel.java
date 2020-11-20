package com.example.fooddelivery.ui.activity.login;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

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
