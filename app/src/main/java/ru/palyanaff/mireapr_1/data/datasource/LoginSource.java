package ru.palyanaff.mireapr_1.data.datasource;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginSource {
    private static final String TAG = "LoginSource";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void createFileSpecific (Context context, String filename, String fileContent) {
        try (FileOutputStream fileOutputStream = context.openFileOutput(
                filename + ".txt", Context.MODE_PRIVATE)) {
            fileOutputStream.write(fileContent.getBytes(StandardCharsets.UTF_8));
            Log.i(TAG, "File path: " + context.getDataDir());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void createFileExternalStorage (Activity activity, String fileName, String fileContent) {
        Context context = activity.getApplicationContext();
        if (context.getApplicationContext().checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File downloadFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(downloadFile, fileName + ".txt");
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(fileContent.getBytes());
                fileOutputStream.close();
                Log.i(TAG, "File path: " + downloadFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createFileSharedPreferences(Context context, String fileName, String fileContent){
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserLogin", fileContent);
        editor.apply();
        Log.i(TAG, "File path: " + sharedPreferences + fileName);
    }
}
