package com.e.dagger.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.e.dagger.common.User;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AppDao getAppDao();

    static AppDatabase appDatabase;

    public static synchronized AppDatabase getDatabase(Application application) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(application, AppDatabase.class, "user_table")
                    .fallbackToDestructiveMigration()
                    //.addCallback(callback)
                    .allowMainThreadQueries()
                    .build();

        return appDatabase;
    }

}
