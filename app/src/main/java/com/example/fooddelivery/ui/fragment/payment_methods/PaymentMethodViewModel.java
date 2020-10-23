package com.example.fooddelivery.ui.fragment.payment_methods;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class PaymentMethodViewModel extends BaseViewModel<PaymentMethodNavigator> {
    public void addNewCard(){
        getNavigator().addNewCard();
    }
}
