package com.example.fooddelivery.ui.fragment.suggestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.data.model.api.response.FavoriteFoodResponse;
import com.example.fooddelivery.data.model.api.response.FoodResponse;
import com.example.fooddelivery.databinding.ItemFoodSuggestionBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;
import com.example.fooddelivery.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.fooddelivery.utils.AppConstants.RESTAURANT_ID;

public class SuggestionAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private MainActivity activity;

    private List<FavoriteFoodResponse> list;

    public SuggestionAdapter() {
        list = new ArrayList();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodSuggestionBinding binding = ItemFoodSuggestionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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

    public void addItems(List<FavoriteFoodResponse> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setItems(List<FavoriteFoodResponse> responses) {
        this.list.clear();
        this.list.addAll(responses);
        notifyDataSetChanged();
    }


    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private ItemFoodSuggestionBinding binding;

        public ViewHolder(@NonNull ItemFoodSuggestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onBind(int position) {
            binding.setItemViewModel(new SuggestionItemViewModel(list.get(position)));
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(RESTAURANT_ID,list.get(getAdapterPosition()).getRes_id());
            activity.navigateFragment(R.id.action_suggestionFragment_to_menuFragment,bundle);
        }
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
