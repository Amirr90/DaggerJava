package com.e.dagger;

import com.e.dagger.common.User;
import com.e.dagger.model.Album;
import com.e.dagger.model.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/posts")
    Call<List<User>> getUser();

    @GET("/albums")
    Call<List<Album>> getAlbums();

    @GET("/photos")
    Call<List<Photos>> getPhotos();
}
