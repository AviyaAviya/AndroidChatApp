package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Login {

    public Login(String userName, String password) {
        UserId = userName;
        Password = password;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @PrimaryKey
        private String UserId;
        private String Password ;

}
