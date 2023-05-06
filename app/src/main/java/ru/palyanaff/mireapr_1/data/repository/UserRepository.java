package ru.palyanaff.mireapr_1.data.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.palyanaff.mireapr_1.data.database.UserRoomDatabase;
import ru.palyanaff.mireapr_1.data.datasource.LoginSource;
import ru.palyanaff.mireapr_1.data.entity.UserEntity;
import ru.palyanaff.mireapr_1.data.entity.UserDao;
import ru.palyanaff.mireapr_1.data.model.User;

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

    public LiveData<List<User>> getUsers() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Transformations.map(
                    userDao.getAllUsers(),
                    (values) -> values.stream().map(UserEntity::toDomainModel).collect(Collectors.toList())
            );
        }
        return null;
    }

    public void setAddressToDb(String login, String address) {
        userDao.insert(new UserEntity(login, address));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setAddress(Context context, String filename, String fileContent) {
        LoginSource.createFileSpecific(context, filename, fileContent);
    }

}
