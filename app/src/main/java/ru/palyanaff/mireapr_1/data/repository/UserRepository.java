package ru.palyanaff.mireapr_1.data.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.palyanaff.mireapr_1.data.database.UserRoomDatabase;
import ru.palyanaff.mireapr_1.data.datasource.LoginSource;
import ru.palyanaff.mireapr_1.data.entity.User;
import ru.palyanaff.mireapr_1.data.entity.UserDao;

public class UserRepository {
    public UserDao userDao;
    public LoginSource userSource;
    private Context context;

    public UserRepository(){
        userSource = new LoginSource();
    }

    public UserRepository(Context context){
        this.context = context;
        UserRoomDatabase database = UserRoomDatabase.getDatabase(context);
        userDao = database.userDao();
    }

    public LiveData<List<User>> getUser(){
        return userDao.getAllUsers();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setAddress(Context context, String filename, String fileContent) {
        LoginSource.createFileSpecific(context, filename, fileContent);
    }

}
