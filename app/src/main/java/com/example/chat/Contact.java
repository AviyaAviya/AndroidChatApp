package com.example.chat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//contact
@Entity
public class Contact {
    //the key is from 0....
    @PrimaryKey(autoGenerate = true)
    //key
    private int id;
    // the name of contact
    private String content;
    //the pic of the contact
    private int pic;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public Contact(String content, int pic) {
        this.content = content;
        this.pic = pic;
    }

    public Contact() {
        this.pic = R.drawable.person_ic;
    }


}
