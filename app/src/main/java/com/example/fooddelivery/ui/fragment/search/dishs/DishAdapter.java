package com.example.fooddelivery.ui.fragment.search.dishs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.databinding.ItemDishSearchBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;
import com.example.fooddelivery.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.fooddelivery.utils.AppConstants.RESTAURANT_ID;

public class DishAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<FoodByNameResponse> list;
    private DisItemViewModel.CallBackToFragment callBackToFragment;
    private MainActivity activity;

    public void setCallBackToFragment(DisItemViewModel.CallBackToFragment callBackToFragment) {
        this.callBackToFragment = callBackToFragment;
    }

    public DishAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDishSearchBinding binding = ItemDishSearchBinding.inflate(inflater, parent, false);
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

    public void addItems(List<FoodByNameResponse> list) {
        this.list.addAll(list);
    }

    public void setItems(List<FoodByNameResponse> list) {
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener{
        private ItemDishSearchBinding binding;

        public ViewHolder(@NonNull ItemDishSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new DisItemViewModel(callBackToFragment, list.get(position)));
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(RESTAURANT_ID,list.get(getAdapterPosition()).getRes_id());
            activity.navigateFragment(R.id.action_searchFragment_to_menuFragment,bundle);
        }
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
