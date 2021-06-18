package com.e.dagger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.e.dagger.common.ApiRepository;
import com.e.dagger.common.User;
import com.e.dagger.model.Album;
import com.e.dagger.model.Photos;

import java.util.List;

import javax.inject.Inject;

public class AppViewModel extends ViewModel {

    @Inject
    ApiRepository apiRepository;

    @Inject
    public AppViewModel(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public LiveData<List<User>> userList() {
        return apiRepository.getUserList();
    }
/*
    public LiveData<List<Album>> albumList() {
        return apiRepository.albums();
    }

    public MutableLiveData<List<Photos>> photos() {
        return apiRepository.photos();
    }*/

}
