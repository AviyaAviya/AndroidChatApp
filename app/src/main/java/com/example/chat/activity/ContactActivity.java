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
import com.example.chat.api.UsersAPI;
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
    private  ContactsListAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_contacts);


        //any time we want the token
        SharedPreferences prefs;
        SharedPreferences.Editor edit;
        prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String token = prefs.getString("token", "");
        //

        //userName with pref
        prefs = this.getSharedPreferences("myPrefs2", Context.MODE_PRIVATE);
        String userName = prefs.getString("userName", "");


        UsersAPI m1 = new UsersAPI();
        m1.get();

        ContactsAPI api = new ContactsAPI();
        api.getContacts(token);




//        Contact c = new Contact("ori","ori","aaa");
//
//        api.CreateContact(token,c);


//        api.CreateContact(token,new Contact());

//        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//        editor.putString("name", "Elena");
//        editor.putInt("idName", 12);
//        editor.apply();

//building db
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();


        contactDao = db.contactDao();
        //clearTableContact
        //contactDao.nukeTable();
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        //when click on btn, go to page adding new contact
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, addContactActivity.class);
            //passing the list to update new contact in adapter
           // i.putExtra("listContacts",(Serializable) contacts);
            startActivity(i);
        });

        RecyclerView lstContacts = findViewById(R.id.lstContacts);
        //delete data from table complettly
        contactDao.nukeTable();
        //passing data from server to local storage
        api.getContacts(token);
        //passing data from storage to server
        contacts = contactDao.index();
        //contacts = new ArrayList<>();


        adapter = new ContactsListAdapter(this, this);
        //list of contacts
        lstContacts.setAdapter(adapter);
        lstContacts.setLayoutManager(new LinearLayoutManager(this));
        //posts.add(new Post("hello",R.drawable.person_ic));

        adapter.setContacts(contacts);



    }



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
        Intent i = new Intent( this,ChatActivity.class);
        //so we would know which chat history to get
        i.putExtra("contactID", contact.getContactName());
        startActivity(i);
    }
}