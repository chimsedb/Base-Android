package com.example.fooddelivery.ui.fragment.add_new_card;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.data.model.api.request.PaymentCardRequest;
import com.example.fooddelivery.data.model.api.response.PaymentCardResponse;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddNewCardViewModel extends BaseViewModel<AddNewCardNavigator> {
    private static Context context;

    public ObservableField<String> cardNumber = new ObservableField<>("");
    public ObservableField<String> dateValid = new ObservableField<>("");
    public ObservableField<String> cvv = new ObservableField<>("");
    public ObservableField<String> cardName = new ObservableField<>("");

    public AddNewCardViewModel(Context context, DataManager dataManager) {
        super(dataManager);
        this.context = context;
    }

    public void openDialogDatePicker() {
        getNavigator().openDialogDatePicker();
    }

    public void confirm() {
        if (TextUtils.isEmpty(cardNumber.get()) || TextUtils.isEmpty(dateValid.get()) ||
                TextUtils.isEmpty(cvv.get()) || TextUtils.isEmpty(cardName.get())) {
            Toast.makeText(context, context.getString(R.string.txt_invalid), Toast.LENGTH_SHORT).show();
        } else {
            sendRequest();
        }
    }

    public View.OnFocusChangeListener onFocusChangeListener = (view, isFocused) -> {
        if (!TextUtils.isEmpty(cardNumber.get())) {
//            cardNumber.set(StringUtils.formatCardPayment(cardNumber.get()));
        }
    };

    private void sendRequest() {
        PaymentCardRequest request = new PaymentCardRequest(
                getDataManager().getUserInfo().getId(),
                cardName.get(),
                dateValid.get(),
                cvv.get(),
                cardNumber.get(),
                0
        );
        getDataManager().postPaymentCard(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PaymentCardResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull PaymentCardResponse paymentCardResponse) {
                        getNavigator().confirm();
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
