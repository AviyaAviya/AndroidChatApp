package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//contact
@Entity
public class Contact {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

//    public String getLastDate() {
//        return LastDate;
//    }
//
//    public void setLastDate(String lastDate) {
//        LastDate = lastDate;
//    }

    @PrimaryKey
    private int id;
    //user name of contact

    private String contactName;
    //user name belong to
    private  String userName;
    //nickname
    private String nickName;
    private String server;


    public Contact(String ContactName,int Id,String Last,String LastDate,String NickName,String Server, String UserName) {
        this.id = Id;
        this.contactName = ContactName;
        this.userName = UserName;
        this.nickName = NickName;
        this.server = Server;
        this.last = Last;
        this.LastDate = LastDate;
    }

    //last message
    //can be null
    private String last;
    //can be null
    private String LastDate;
    public Contact( String ContactName, String NickName, String Server){

        this.contactName = ContactName;
        this.nickName =NickName;
        this.server =Server;
    }






}
