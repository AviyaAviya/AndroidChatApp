package com.example.chat.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.format.DateTimeFormatter;

@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    public int Id;

    public String From;

    public String To;

    public String Type;

    public String Content;
    public DateTimeFormatter Created;

    public boolean Sent;
}
