package com.example.fooddelivery.ui.fragment.payment_methods;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.UserCardResponse;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

public class PaymentMethodItemViewModel {
    private final Context context;
    private UserCardResponse userCardResponse;
    private PaymentMethodViewModel viewModel;

    public ObservableField<String> cardNumber = new ObservableField<>("");
    public ObservableField<String> cvv = new ObservableField<>("");
    public ObservableField<Boolean> isActive = new ObservableField<>(false);
    public ObservableField<Boolean> isShowActive = new ObservableField<>(false);

    public PaymentMethodItemViewModel(Context context, PaymentMethodViewModel viewModel,
                                      UserCardResponse userCardResponse) {
        this.context = context;
        this.userCardResponse = userCardResponse;
        this.viewModel = viewModel;
        cardNumber.set(StringUtils.formatCardPayment(userCardResponse.getCard_number()));
        if (userCardResponse.getActive() == 1) {
            isActive.set(true);
        }
    }

    public void showActiveCard() {
        isShowActive.set(!isShowActive.get());
    }

    public void activeCard() {
        if (!TextUtils.isEmpty(cvv.get())) {
            isActive.set(true);
            isShowActive.set(!isShowActive.get());
            viewModel.updateActiveUserCard(1, userCardResponse.getId());
        } else {
            isActive.set(false);
            isShowActive.set(!isShowActive.get());
            viewModel.updateActiveUserCard(0, userCardResponse.getId());
            Toast.makeText(context, context.getString(R.string.txt_cvv_invalid), Toast.LENGTH_SHORT).show();
        }
    }
}
