package com.example.fooddelivery.ui.fragment.filter_sort;

import androidx.databinding.ObservableField;

import com.example.fooddelivery.data.model.api.response.ListFoodTypeResponse;

import java.util.List;

public class FilterItemViewModel {
    public ObservableField<String> type = new ObservableField<>("");
    public ObservableField<Boolean> isChecked = new ObservableField<>(false);

    private List<FoodTypeModel> foodTypeModels;
    private ListFoodTypeResponse response;

    public FilterItemViewModel(ListFoodTypeResponse response, List<FoodTypeModel> listRequest) {
        this.foodTypeModels = listRequest;
        this.response = response;
        type.set(response.getFood_type_name());
    }

    public void onCheckBoxClick() {
        isChecked.set(!isChecked.get());
        if (isChecked.get()) {
            foodTypeModels.add(new FoodTypeModel(response.getFood_type_name()));
        } else {
            FoodTypeModel request = foodTypeModels.stream().filter(t -> t.getFood_type_name().equals(response.getFood_type_name())).findFirst().get();
            foodTypeModels.remove(request);
        }
    }
}
