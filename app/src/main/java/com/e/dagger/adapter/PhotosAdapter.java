package com.e.dagger.adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.e.dagger.databinding.PhotosViewBinding;
import com.e.dagger.model.Photos;

import javax.inject.Inject;

public class PhotosAdapter extends ListAdapter<Photos, PhotosAdapter.PhotosVH> {

    @Inject
    public PhotosAdapter() {
        super(itemCallback);
    }

    @NonNull
    @Override
    public PhotosVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PhotosViewBinding userViewBinding = PhotosViewBinding.inflate(layoutInflater, parent, false);
        return new PhotosVH(userViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosVH holder, int position) {
        holder.photosViewBinding.setPhotos(getItem(position));
    }

    public class PhotosVH extends RecyclerView.ViewHolder {
        PhotosViewBinding photosViewBinding;

        public PhotosVH(@NonNull PhotosViewBinding userViewBinding) {
            super(userViewBinding.getRoot());
            this.photosViewBinding = userViewBinding;
        }
    }


    public static DiffUtil.ItemCallback<Photos> itemCallback = new DiffUtil.ItemCallback<Photos>() {
        @Override
        public boolean areItemsTheSame(@NonNull Photos oldItem, @NonNull Photos newItem) {
            return oldItem.getId().equals(newItem.getId());

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Photos oldItem, @NonNull Photos newItem) {
            return oldItem.equals(newItem);
        }
    };
}