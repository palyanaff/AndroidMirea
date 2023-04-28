package ru.palyanaff.mireapr_1.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import ru.palyanaff.mireapr_1.data.database.UserRoomDatabase;
import ru.palyanaff.mireapr_1.data.entity.User;
import ru.palyanaff.mireapr_1.data.entity.UserDao;

public class UserRepository {
    public UserDao userDao;

    public UserRepository(Context context){
        UserRoomDatabase database = UserRoomDatabase.getDatabase(context);
        userDao = database.userDao();
    }

    public LiveData<List<User>> getUser(){
        return userDao.getAllUsers();
    }
}
