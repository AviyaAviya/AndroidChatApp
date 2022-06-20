package com.example.chat.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chat.entitys.Contact;

import java.util.List;

//using room
@Dao
public interface ContactDao {
    //return all the contacts of the user from db
    @Query("SELECT * FROM contact")
    List<Contact> index();

    //return a specific contact
    @Query("SELECT * FROM Contact WHERE id = :id")
    Contact get(int id);

    //adding new contact
    @Insert
    void insert(Contact... Contacts);

    //updating a post
    @Update
    void update(Contact... Contacts);

    //deleting a contact
    @Delete
    void delete(Contact... Contacts);
    @Query("DELETE FROM contact")
    void nukeTable();

}
