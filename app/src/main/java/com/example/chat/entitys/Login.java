package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Login {

    public Login(String userName, String password) {
        userId = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PrimaryKey
        private String userId;
        private String password;

}
