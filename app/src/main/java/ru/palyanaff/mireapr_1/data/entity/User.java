package ru.palyanaff.mireapr_1.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_address")
    private String userAddress;

    public User(){

    }

    public User(String userName, String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
