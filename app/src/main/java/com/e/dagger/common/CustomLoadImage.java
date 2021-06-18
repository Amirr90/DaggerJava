package com.e.dagger.common;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.e.dagger.AppContext;
import com.e.dagger.R;

public class CustomLoadImage {

    private static final String TAG = "CustomLoadImage";

    @BindingAdapter("android:bindImage")
    public static void bindImage(ImageView imageView, String imagePath) {
        if (null != imagePath && !imagePath.isEmpty()) {
            try {
                Glide.with(AppContext.context)
                        .load(imagePath)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(imageView);

            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "loadImage: " + e.getLocalizedMessage());
            }
        }

    }

}
