package com.example.fooddelivery.ui.fragment.home.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.RestaurantNearYouResponse;
import com.example.fooddelivery.databinding.ItemRestaurantHomeBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.fragment.home.item_view_model.RestaurantItemViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.fooddelivery.utils.AppConstants.RESTAURANT_ID;

public class RestaurantNearYouAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<RestaurantNearYouResponse> list;
    private MainActivity mainActivity;

    public RestaurantNearYouAdapter() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RestaurantNearYouAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRestaurantHomeBinding binding = ItemRestaurantHomeBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
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

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        ItemRestaurantHomeBinding binding;
        public ViewHolder(@NonNull ItemRestaurantHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new RestaurantItemViewModel(list.get(position)));
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(RESTAURANT_ID,list.get(getAdapterPosition()).getId());
            mainActivity.navigateFragment(R.id.action_homeFragment_to_menuFragment,bundle);
        }
    }

    public void addItems(List<RestaurantNearYouResponse> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setList(List<RestaurantNearYouResponse> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setActivity(MainActivity activity) {
        this.mainActivity = activity;
    }
}
