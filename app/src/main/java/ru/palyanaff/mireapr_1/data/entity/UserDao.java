package ru.palyanaff.mireapr_1.data.entity;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserEntity userEntity);

    @Query("DELETE FROM UserEntity")
    void deleteAll();

    @Query("SELECT * FROM UserEntity ORDER BY user_name ASC")
    LiveData<List<UserEntity>> getAllUsers();
}

