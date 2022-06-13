package com.example.chat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Message {
    //the key
    @PrimaryKey(autoGenerate=true)
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message( String content) {

        this.content = content;
    }

    public Message() {
    }
//convert the post to string (the adapter can get only post format)

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
