package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    private String UserName ;
    private String NickName;
    private String Password ;
    private String Server ;



    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setServer(String server) {
        Server = server;
    }


    public String getUserName() {
        return UserName;
    }

    public String getNickName() {
        return NickName;
    }

    public String getPassword() {
        return Password;
    }

    public String getServer() {
        return Server;
    }

    public User( String userName, String nickName, String password, String server) {

        UserName = userName;
        NickName = nickName;
        Password = password;
        Server = server;
    }

}
