package com.example.fooddelivery.ui.fragment.home.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.databinding.ItemFavoriteFoodBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.fragment.home.item_view_model.FavoriteFoodItemViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.fooddelivery.utils.AppConstants.FOOD_ID;

public class FavoriteFoodAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<FavoriteFoodResponse> list;

    public FavoriteFoodAdapter() {
        this.list = new ArrayList<>();
    }

    private MainActivity mainActivity;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFavoriteFoodBinding binding = ItemFavoriteFoodBinding.inflate(inflater, parent, false);

        ViewGroup.LayoutParams params = binding.getRoot().getLayoutParams();
        params.width = (int) (parent.getMeasuredWidth() * 2 / 5);
        binding.getRoot().setLayoutParams(params);
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
        ItemFavoriteFoodBinding binding;

        public ViewHolder(@NonNull ItemFavoriteFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(FOOD_ID, list.get(getAdapterPosition()).getId());
            mainActivity.navigateFragment(R.id.action_homeFragment_to_suggestionFragment,bundle);
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new FavoriteFoodItemViewModel(list.get(position)));
        }
    }

    public void addItems(List<FavoriteFoodResponse> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setItems(List<FavoriteFoodResponse> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setActivity(MainActivity activity) {
        this.mainActivity = activity;
    }
}
