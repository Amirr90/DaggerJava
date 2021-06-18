package com.e.dagger.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.e.dagger.databinding.AlbumViewBinding;
import com.e.dagger.model.Album;

import javax.inject.Inject;

public class AlbumAdapter extends ListAdapter<Album, AlbumAdapter.AlbumVH> {

    @Inject
    public AlbumAdapter() {
        super(itemCallback);
    }

    @NonNull
    @Override
    public AlbumVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AlbumViewBinding userViewBinding = AlbumViewBinding.inflate(layoutInflater, parent, false);
        return new AlbumVH(userViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumVH holder, int position) {
        holder.albumViewBinding.setAlbum(getItem(position));
    }

    public class AlbumVH extends RecyclerView.ViewHolder {
        AlbumViewBinding albumViewBinding;

        public AlbumVH(@NonNull AlbumViewBinding userViewBinding) {
            super(userViewBinding.getRoot());
            this.albumViewBinding = userViewBinding;
        }
    }


    public static DiffUtil.ItemCallback<Album> itemCallback = new DiffUtil.ItemCallback<Album>() {
        @Override
        public boolean areItemsTheSame(@NonNull Album oldItem, @NonNull Album newItem) {
            return oldItem.getId().equals(newItem.getId());

        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Album oldItem, @NonNull Album newItem) {
            return oldItem.equals(newItem);
        }
    };
}