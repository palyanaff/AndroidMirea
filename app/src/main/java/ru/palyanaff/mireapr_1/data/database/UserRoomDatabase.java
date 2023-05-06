package ru.palyanaff.mireapr_1.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.palyanaff.mireapr_1.data.entity.UserEntity;
import ru.palyanaff.mireapr_1.data.entity.UserDao;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract  UserDao userDao();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile UserRoomDatabase INSTANCE;
    public static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UserRoomDatabase.class, "user_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}

