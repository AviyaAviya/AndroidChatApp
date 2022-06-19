package com.example.chat.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chat.entitys.Message;

import java.util.List;
//using room
@Dao
public interface MessageDao {
    //return all the messages of the user from db
    @Query("SELECT * FROM message")
    List<Message> index();


    //return a specific message
    @Query("SELECT * FROM message WHERE id = :id")
    Message get(int id);


    //adding new message
    @Insert
    void insert(Message...Message);

    //updating a message
    @Update
    void update(Message...Message);

    //deleting a message
    @Delete
    void delete(Message...Message);
    @Query("DELETE FROM message")
    void nukeTable();
}
