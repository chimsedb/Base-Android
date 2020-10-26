package com.example.fooddelivery.ui.fragment.payment_methods;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class PaymentMethodViewModel extends BaseViewModel<PaymentMethodNavigator> {
    public PaymentMethodViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void addNewCard() {
        getNavigator().addNewCard();
    }
}
