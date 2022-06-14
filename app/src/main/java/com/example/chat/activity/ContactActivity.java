package com.example.chat.activity;

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

//import com.example.chat.R;
import com.example.chat.adapter.ContactsListAdapter;
import com.example.chat.api.ContactAPI;
import com.example.chat.entitys.Contact;
import com.example.chat.room.AppDB;
import com.example.chat.room.ContactDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_contacts);

        ContactAPI api = new ContactAPI();
        api.get();

//building db
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().build();

        contactDao = db.contactDao();

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        //when click on btn, go to page adding new contact
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, addContactActivity.class);
            startActivity(i);
        });
        RecyclerView lstContacts = findViewById(R.id.lstContacts);

        contacts = new ArrayList<>();
        contacts.add(new Contact("example for contact", R.drawable.person_ic));

        adapter = new ContactsListAdapter(this);
        //list of contacts
        lstContacts.setAdapter(adapter);
        lstContacts.setLayoutManager(new LinearLayoutManager(this));
        //posts.add(new Post("hello",R.drawable.person_ic));
        adapter.setContacts(contacts);
//        contacts.clear();
//        contacts.addAll(contactDao.index());
//        adapter.notifyDataSetChanged();


    }
    //on short click , go to chat

    @Override
    public void onItemClick(View v, int position) {
        Contact contact = contacts.get(position);
        Intent i = new Intent(this, ChatActivity.class);
        //so we would know which chat history to get
        i.putExtra("contactID", contact.getId());
        startActivity(i);
    }
    private void setThemeOfApp(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.getString("color","TEAL").equals("TEAL")){
            setTheme(R.style.teal);
        }
        else {
            setTheme(R.style.turqiz);
        }
    }

    @Override
    //make the changes seen in run time
    protected void onResume() {
        super.onResume();

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


}