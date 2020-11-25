package com.example.fooddelivery.ui.fragment.cart;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.ui.activity.utils.StringUtils;
import com.example.fooddelivery.ui.fragment.menu.MenuItemViewModel;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import okhttp3.Interceptor;

public class CartItemViewModel {
    public ObservableField<String> thumbnail = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> price = new ObservableField<>("");
    public ObservableField<String> total = new ObservableField<>("");

    private CallBackToFragment callBackToFragment;
    private long totalItem = 1;
    private int priceItem;
    private CartCategoryFoodResponse response;

    public CartItemViewModel(CallBackToFragment callBackToFragment, CartCategoryFoodResponse response, List<CartModel> cartModelList) {
        this.response = response;
        this.callBackToFragment = callBackToFragment;
        thumbnail.set(response.getThumbnail());
        name.set(response.getFood_name());
        priceItem = Integer.parseInt(response.getPrice());
        totalItem = cartModelList.stream().filter(item -> item.getId() == response.getId()).collect(Collectors.toList()).get(0).getCount();
        price.set(StringUtils.getPriceVND((int) (priceItem * totalItem)));
        total.set(String.valueOf(totalItem));
    }

    public void subtract() {
        totalItem -= 1;
        if (totalItem <= 0) {
            totalItem = 0;
            return;
        }
        callBackToFragment.removeFoodToCard(response.getId());
        total.set(String.valueOf(totalItem));
        price.set(StringUtils.getPriceVND((int) (priceItem * totalItem)));
    }

    public void add() {
        callBackToFragment.addFoodToCard(response.getId());
        totalItem += 1;
        total.set(String.valueOf(totalItem));
        price.set(StringUtils.getPriceVND((int) (priceItem * totalItem)));
    }

    public interface CallBackToFragment {
        void addFoodToCard(int id);

        void removeFoodToCard(int id);
    }
}
