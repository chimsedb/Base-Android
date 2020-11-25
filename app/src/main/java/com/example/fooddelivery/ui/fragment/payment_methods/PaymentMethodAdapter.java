package com.example.fooddelivery.ui.fragment.payment_methods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.data.model.api.response.FoodByNameResponse;
import com.example.fooddelivery.data.model.api.response.UserCardResponse;
import com.example.fooddelivery.databinding.ItemPaymentMethodBinding;
import com.example.fooddelivery.ui.activity.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {
    private List<UserCardResponse> list;
    private Context context;
    private ViewHolder holder;
    private PaymentMethodViewModel viewModel;

    public PaymentMethodAdapter() {
        list = new ArrayList<>();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentMethodBinding binding = ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
        this.holder = holder;
    }

    public void setItems(List<UserCardResponse> list) {
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public void setViewModel(PaymentMethodViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private ItemPaymentMethodBinding binding;
        private PaymentMethodItemViewModel itemViewModel;

        public ViewHolder(ItemPaymentMethodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            itemViewModel = new PaymentMethodItemViewModel(context,viewModel,list.get(position));
            binding.setItemViewModel(itemViewModel);
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemViewModel.showActiveCard();
        }

        public PaymentMethodItemViewModel getItemViewModel() {
            return itemViewModel;
        }
    }
}
