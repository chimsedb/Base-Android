package com.example.fooddelivery.ui.fragment.filter_sort;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.data.model.api.response.ListFoodTypeResponse;
import com.example.fooddelivery.databinding.ItemBottomSheetFilterBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {
    private List<ListFoodTypeResponse> listResponse;
    private List<FoodTypeModel> foodTypeModels;

    public FilterAdapter() {
        listResponse = new ArrayList<>();
        foodTypeModels = new ArrayList<>();
    }

    public List<FoodTypeModel> getListRequest() {
        return foodTypeModels;
    }

    @NonNull
    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBottomSheetFilterBinding binding = ItemBottomSheetFilterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilterAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listResponse.size();
    }

    public void addItems(List<ListFoodTypeResponse> list) {
        this.listResponse.addAll(list);
        notifyDataSetChanged();
    }

    public void setItems(List<ListFoodTypeResponse> list) {
        this.listResponse.clear();
        this.listResponse.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {
        private ItemBottomSheetFilterBinding binding;

        public ViewHolder(@NonNull ItemBottomSheetFilterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new FilterItemViewModel(listResponse.get(position),foodTypeModels));
        }
    }
}
