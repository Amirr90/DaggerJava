package com.e.dagger.common;


import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.e.dagger.Api;
import com.e.dagger.AppContext;
import com.e.dagger.room.AppDao;
import com.e.dagger.room.AppDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class ApiRepository {
    private static final String TAG = "ApiRepository";
    Api api;
    AppDao appDao;
    LiveData<List<User>> userList;


    @Inject
    public ApiRepository(Api api) {
        this.api = api;
        appDao = AppDatabase.getDatabase(AppContext.context).getAppDao();
        userList = appDao.getAllUsers();
    }

    public LiveData<List<User>> getUserList() {
        initGetUserApi();
        return userList;
    }

    private void initGetUserApi() {
        new InsertDataInToUserTable(api, appDao).execute();
    }

    /*  public MutableLiveData<List<User>> users() {
        MutableLiveData<List<User>> data = new MutableLiveData<>();
        api.getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
        return data;
    }

    public LiveData<List<Album>> albums() {
        MutableLiveData<List<Album>> data = new MutableLiveData<>();
        api.getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NotNull Call<List<Album>> call, @NotNull Response<List<Album>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Album>> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
        return data;
    }

    public MutableLiveData<List<Photos>> photos() {
        MutableLiveData<List<Photos>> data = new MutableLiveData<>();
        api.getPhotos().enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(@NotNull Call<List<Photos>> call, @NotNull Response<List<Photos>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Photos>> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
        return data;
    }*/

    public static class InsertDataInToUserTable extends AsyncTask<Void, Void, Void> {

        Api api;
        AppDao appDao;

        public InsertDataInToUserTable(Api api, AppDao appDao) {
            this.api = api;
            this.appDao = appDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            api.getUser().enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        appDao.deleteAllUser();
                        for (int a = 0; a < response.body().size(); a++) {
                            appDao.addUser(response.body().get(a));
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                }
            });

            return null;
        }
    }


}
