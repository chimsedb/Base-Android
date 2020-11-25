package com.example.fooddelivery.ui.fragment.search.dishs;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.ui.activity.utils.StringUtils;

public class DisItemViewModel {

    public ObservableField<String> image = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();

    private CallBackToFragment callBackToFragment;
    private FoodByNameResponse response;

    public DisItemViewModel(CallBackToFragment callBackToFragment, FoodByNameResponse response) {
        this.callBackToFragment = callBackToFragment;
        this.response = response;
        image.set(response.getThumbnail());
        StringBuilder builderDiscount = new StringBuilder();
        builderDiscount.append(" Giảm ").append(response.getDiscount())
                .append("%");
        name.set(response.getFood_name() + builderDiscount.toString());
        price.set(StringUtils.getPriceVND(response.getPrice()));
    }

    public void addToCard() {
        callBackToFragment.addFoodToCard(response.getId());
    }

    interface CallBackToFragment {
        void addFoodToCard(int id);
    }
}
