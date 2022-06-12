package com.example.chat;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//@Database(entities = {Post.class, Message.class}, version = 1)
@Database(entities = {Contact.class, Message.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
    public abstract MessageDao messageDao();

}
