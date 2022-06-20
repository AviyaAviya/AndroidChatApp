package com.example.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.chat.adapter.ContactsListAdapter;
import com.example.chat.api.ContactsAPI;
import com.example.chat.entitys.Contact;
import com.example.chat.room.AppDB;
import com.example.chat.room.ContactDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


//this is the contacts screen, all your friends are showed here by list
public class ContactActivity extends AppCompatActivity implements ContactsListAdapter.ListenerOnClick {
    SharedPreferences sharedPreferences;
    //the data base
    private AppDB db;
    //using room
    private ContactDao contactDao;
    //the contact data
    private List<Contact> contacts;
    private ContactsListAdapter adapter;
    private ContactsAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_contacts);

        //any time we want the token- of the user
        SharedPreferences prefs;
        prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String token = prefs.getString("token", "");


        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();


        contactDao = db.contactDao();
        contactDao.nukeTable();
        api = new ContactsAPI(contactDao);


        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        //when click on btn, go to page adding new contact
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, addContactActivity.class);
            startActivity(i);
        });

        RecyclerView lstContacts = findViewById(R.id.lstContacts);
        api.getContacts(token);
        contacts = contactDao.index();


        adapter = new ContactsListAdapter(this, this);
        lstContacts.setAdapter(adapter);
        lstContacts.setLayoutManager(new LinearLayoutManager(this));

        adapter.setContacts(contacts);


    }

//settings- color of app
    private void setThemeOfApp() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sharedPreferences.getString("color", "TEAL").equals("TEAL")) {
            setTheme(R.style.teal);
        } else {
            setTheme(R.style.turqiz);
        }
    }

    @Override
    //make the changes seen in run time
    protected void onResume() {
        super.onResume();
        contacts.clear();
        SharedPreferences prefs;
        prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String token = prefs.getString("token", "");
        api.getContacts(token);
        contacts.addAll(contactDao.index());
        adapter.notifyDataSetChanged();
        Log.i("Contacts", "onResume");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Contacts", "onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Contacts", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Contacts", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Contacts", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Contacts", "onDestroy");
    }


    @Override
    public void onItemClick(View v, int position) {
        Contact contact = contacts.get(position);
        Intent i = new Intent(this, ChatActivity.class);
        //so we would know which chat history to get
        i.putExtra("contactID", contact.getContactName());
        startActivity(i);
    }
}