package com.e.dagger.module;

import android.app.Application;

import androidx.room.Room;

import com.e.dagger.Api;
import com.e.dagger.AppContext;
import com.e.dagger.common.AppUrl;
import com.e.dagger.parent.Parent;
import com.e.dagger.room.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ParentModule {
    String name;
    String age;
    String gender;

    public ParentModule(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @Singleton
    @Provides
    public AppDatabase provideAppDatabase() {
        return Room.databaseBuilder(AppContext.context, AppDatabase.class, "user_table")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1);

        httpClient.addInterceptor(logging);
        httpClient.dispatcher(dispatcher);
        return httpClient;
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient.Builder builder) {
        return new Retrofit.Builder()
                .baseUrl(AppUrl.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    @Singleton
    @Provides
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    public Parent provideParentModule() {
        return new Parent(name, age, gender);
    }
}
