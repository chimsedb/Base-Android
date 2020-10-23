package com.example.fooddelivery.ui.fragment.more;

import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class MoreViewModel extends BaseViewModel<MoreNavigator> {
    public void manageAddressOpen() {
        getNavigator().manageAddressOpen();
    }

    public void paymentMethodOpen() {
        getNavigator().paymentMethodOpen();
    }
}
