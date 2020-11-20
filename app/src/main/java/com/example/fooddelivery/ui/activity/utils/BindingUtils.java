package com.example.fooddelivery.ui.activity.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingUtils {
    @BindingAdapter({"imgUrl"})
    public static void setProfilePicture(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }
}
