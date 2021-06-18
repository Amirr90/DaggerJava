package com.e.dagger.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.e.dagger.common.User;

import java.util.List;

@Dao
public interface AppDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Query("select * from user_table")
    LiveData<List<User>> getAllUsers();

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("delete from user_table")
    void deleteAllUser();
}
