package com.example.fooddelivery.ui.fragment.payment_methods;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.ActiveUserCardRequest;
import com.example.fooddelivery.data.model.api.response.ActiveUserCardResponse;
import com.example.fooddelivery.data.model.api.response.PaymentCardResponse;
import com.example.fooddelivery.data.model.api.response.UserCardResponse;
import com.example.fooddelivery.data.model.api.response.UserCartConfirmResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PaymentMethodViewModel extends BaseViewModel<PaymentMethodNavigator> {
    private PaymentMethodAdapter paymentMethodAdapter;
    private final Context context;
    private boolean fromCartFragment = false;

    public void setFromCartFragment(boolean fromCartFragment) {
        this.fromCartFragment = fromCartFragment;
    }

    public void setPaymentMethodAdapter(PaymentMethodAdapter paymentMethodAdapter) {
        this.paymentMethodAdapter = paymentMethodAdapter;
    }

    public PaymentMethodViewModel(Context context, DataManager dataManager) {
        super(dataManager);
        this.context = context;
    }

    public void addNewCard() {
        getNavigator().addNewCard();
    }

    public void getListUserCard() {
        getDataManager().getListUserCard(getDataManager().getUserInfo().getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserCardResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<UserCardResponse> responses) {
                        boolean checkCardActive = responses.stream().anyMatch(t -> t.getActive() == 1);
                        if (checkCardActive && fromCartFragment) {
                            getNavigator().openOrderPlaceScreen();
                        } else {
                            paymentMethodAdapter.setItems(responses);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void updateActiveUserCard(int active, int id) {
        ActiveUserCardRequest request = new ActiveUserCardRequest(
                active, id, getDataManager().getUserInfo().getId()
        );
        getDataManager().updateActiveUserCard(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ActiveUserCardResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ActiveUserCardResponse activeUserCardResponse) {
                        if (active == 1 && fromCartFragment) {
                            getNavigator().openOrderPlaceScreen();
                        }
                        Toast.makeText(context, context.getString(R.string.txt_change_active_success), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
