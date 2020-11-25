package com.example.fooddelivery.ui.fragment.more;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.DataManager;
import com.example.fooddelivery.ui.activity.base.BaseViewModel;

public class MoreViewModel extends BaseViewModel<MoreNavigator> {
    public ObservableField<String> id = new ObservableField<>();
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> avatar = new ObservableField<>();

    public MoreViewModel(DataManager dataManager) {
        super(dataManager);
        id.set(getDataManager().getUserInfo().getId());
        userName.set(getDataManager().getUserInfo().getName());
        avatar.set(getDataManager().getUserInfo().getAvatar());
    }

    public void manageAddressOpen() {
        getNavigator().manageAddressOpen();
    }

    public void paymentMethodOpen() {
        getNavigator().paymentMethodOpen();
    }

    public void logout() {
        getNavigator().logout();
    }
}
