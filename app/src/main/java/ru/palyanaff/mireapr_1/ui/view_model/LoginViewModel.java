package ru.palyanaff.mireapr_1.ui.view_model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import ru.palyanaff.mireapr_1.data.datasource.LoginSource;
import ru.palyanaff.mireapr_1.data.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";
    public LiveData<String> address;
    private final UserRepository userRepository = new UserRepository();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setAddress(Context context, String filename, String fileContent) {
        userRepository.setAddress(context, filename, fileContent);
    }

    public void setAddressToDb(String n, String add) {
        userRepository.setAddressToDb(n, add);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

}
