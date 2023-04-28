package ru.palyanaff.mireapr_1.data.database;

import android.content.Context;
import android.text.style.IconMarginSpan;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.palyanaff.mireapr_1.data.entity.User;
import ru.palyanaff.mireapr_1.data.entity.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract  UserDao userDao();
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

