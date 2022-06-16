package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int id;
    public String userName;
    public String nickName;
    public String password;
    public String server;



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServer(String server) {
        this.server = server;
    }


    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getServer() {
        return server;
    }

    public User(int id, String userName, String nickName, String password, String server) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.server = server;
    }

}
