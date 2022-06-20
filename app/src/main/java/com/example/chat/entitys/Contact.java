package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//contact
@Entity
public class Contact {
    @PrimaryKey(autoGenerate = true)

    private int id;
    //user name of contact
    @Ignore
    private String contactName;
    //user name belong to
    private String userName;
    //nickname
    private String nickName;

    private String server;
    //last message
    //can be null
    @Ignore
    private String last;
    //can be null
    @Ignore
    private String LastDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //to which user the contact belong
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    //the real name of contact, his id

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    //the nickname the user chose to call the contact

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

    //lase message
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }


    public Contact(String ContactName, int Id, String Last, String LastDate, String NickName, String Server, String UserName) {
        this.id = Id;
        this.contactName = ContactName;
        this.userName = UserName;
        this.nickName = NickName;
        this.server = Server;
        this.last = Last;
        this.LastDate = LastDate;
    }


    public Contact(String ContactName, String NickName, String Server) {

        this.contactName = ContactName;
        this.nickName = NickName;
        this.server = Server;
    }

    public Contact() {
    }


}
