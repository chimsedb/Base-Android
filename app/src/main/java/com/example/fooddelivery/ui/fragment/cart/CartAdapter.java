package com.example.fooddelivery.ui.fragment.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.data.model.api.response.CartCategoryFoodResponse;
import com.example.fooddelivery.databinding.ItemFoodCartBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<CartCategoryFoodResponse> list;

    public CartAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFoodCartBinding binding = ItemFoodCartBinding.inflate(inflater, parent, false);
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

    public void addItems(List<CartCategoryFoodResponse> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setItems(List<CartCategoryFoodResponse> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {
        private ItemFoodCartBinding binding;

        public ViewHolder(@NonNull ItemFoodCartBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new CartItemViewModel(list.get(position)));
        }
    }
}
