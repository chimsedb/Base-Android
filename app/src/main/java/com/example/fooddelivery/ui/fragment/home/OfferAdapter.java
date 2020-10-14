package com.example.fooddelivery.ui.fragment.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.ui.activity.main.MainActivity;
import com.example.fooddelivery.ui.fragment.suggestion.SuggestionFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    private List<String> list;

    public OfferAdapter() {
        this.list = new ArrayList<>();
    }

    private MainActivity mainActivity;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sales_home, parent, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = (int) (parent.getMeasuredWidth() / 2.1);
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            mainActivity.replaceFragment(SuggestionFragment.newInstance());
        }
    }

    public void addItems(List<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setActivity(MainActivity activity) {
        this.mainActivity = activity;
    }
}
