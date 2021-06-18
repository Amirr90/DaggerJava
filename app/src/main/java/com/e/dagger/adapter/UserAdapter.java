package com.e.dagger.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.e.dagger.common.User;
import com.e.dagger.databinding.UserViewBinding;

import javax.inject.Inject;

public class UserAdapter extends ListAdapter<User, UserAdapter.UserVH> {

    @Inject
    public UserAdapter() {
        super(User.itemCallback);
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        UserViewBinding userViewBinding = UserViewBinding.inflate(layoutInflater, parent, false);
        return new UserVH(userViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        holder.userViewBinding.setPerson(getItem(position));
        holder.userViewBinding.setPosition(position + 1);
    }

    public class UserVH extends RecyclerView.ViewHolder {
        UserViewBinding userViewBinding;

        public UserVH(@NonNull UserViewBinding userViewBinding) {
            super(userViewBinding.getRoot());
            this.userViewBinding = userViewBinding;
        }
    }


}
