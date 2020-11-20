package com.example.fooddelivery.ui.fragment.search.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.RestaurantByNameResponse;
import com.example.fooddelivery.databinding.ItemRestaurantSearchBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;
import com.example.fooddelivery.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.fooddelivery.utils.AppConstants.RESTAURANT_ID;

public class RestaurantAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<RestaurantByNameResponse> list;
    private MainActivity activity;

    public RestaurantAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRestaurantSearchBinding binding = ItemRestaurantSearchBinding.inflate(inflater, parent, false);
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

    public void addItems(List<RestaurantByNameResponse> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setItems(List<RestaurantByNameResponse> list) {
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private ItemRestaurantSearchBinding binding;

        public ViewHolder(@NonNull ItemRestaurantSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new RestaurantItemViewModel(list.get(position)));
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(RESTAURANT_ID,list.get(getAdapterPosition()).getId());
            activity.navigateFragment(R.id.action_searchFragment_to_menuFragment,bundle);
        }
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
