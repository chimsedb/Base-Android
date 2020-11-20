package com.example.fooddelivery.ui.fragment.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.data.model.api.response.FoodOfRestaurantResponse;
import com.example.fooddelivery.databinding.ItemFoodMenuBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<FoodOfRestaurantResponse> list;
    private MenuItemViewModel.CallBackToFragment callBackToFragment;

    public void setCallBackToFragment(MenuItemViewModel.CallBackToFragment callBackToFragment) {
        this.callBackToFragment = callBackToFragment;
    }

    public MenuAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFoodMenuBinding binding = ItemFoodMenuBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems(List<FoodOfRestaurantResponse> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setItems(List<FoodOfRestaurantResponse> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private ItemFoodMenuBinding binding;

        public ViewHolder(@NonNull ItemFoodMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new MenuItemViewModel(callBackToFragment,list.get(position)));
            binding.getRoot().setOnClickListener(this);
        }
    }
}
