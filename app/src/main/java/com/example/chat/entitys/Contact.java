package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.chat.activity.R;

import java.time.format.DateTimeFormatter;

//contact
@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    //user name of contact
    public String ContactName;
    //user name belong to
    public  String UserName;
    //nickname
    public String NickName;
    public String Server;

    //last message
    //can be null
    public String Last;
    //can be null

    public DateTimeFormatter LastDate;





}
