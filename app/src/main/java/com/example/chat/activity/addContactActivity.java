package com.example.chat.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.room.Room;

import com.example.chat.api.ContactsAPI;
import com.example.chat.entitys.Contact;
import com.example.chat.room.AppDB;
import com.example.chat.room.ContactDao;

public class addContactActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private AppDB db;
    private ContactDao contactDao;
    //the inpute from user
    private EditText nickNameContent;
    //the inpute from user

    private EditText userNameContent;
    //the inpute from user

    private EditText server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_add_contact);
//using room
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        contactDao = db.contactDao();

//layout component
        Button btnSave = findViewById(R.id.btnSave);
        nickNameContent = findViewById(R.id.nickNameContact);
        userNameContent = findViewById(R.id.userNameContact);
        server = findViewById(R.id.server);
//create contact
        btnSave.setOnClickListener(v -> {

            SharedPreferences prefs;
            prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
            String token = prefs.getString("token", "");

            Contact c = new Contact(userNameContent.getText().toString(), nickNameContent.getText().toString(), server.getText().toString());
            ContactsAPI api = new ContactsAPI(contactDao);
            //upadting api
            api.CreateContact(token, c);
            //updating room
            contactDao.insert(c);

            finish();
        });
    }

    //for the settings- choose color of app
    private void setThemeOfApp() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sharedPreferences.getString("color", "TEAL").equals("TEAL")) {
            //the default
            setTheme(R.style.teal);
        } else {
            setTheme(R.style.turqiz);
        }
    }
}