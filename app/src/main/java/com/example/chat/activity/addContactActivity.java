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
//import com.example.chat.room.AppDB;
//import com.example.chat.room.ContactDao;

public class addContactActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private AppDB db;
    private ContactDao contactDao;
    //the inpute from user
    private EditText nickNameContent;
    private EditText userNameContent;
    private EditText server;
    //private List<Contact> contacts;
    //private ContactsListAdapter adapter;
    //the input from user
    //  private ImageView pic;
    //a contact
    //  private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_add_contact);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        contactDao = db.contactDao();

        //check if really we have info to add
//        if(getIntent().getExtras()!=null){
//            //the key of contact
//            int id = getIntent().getExtras().getInt("id");
//            contact = contactDao.get(id);
//            content.setText(contact.getContent());
//        }


        Button btnSave = findViewById(R.id.btnSave);
        nickNameContent = findViewById(R.id.nickNameContact);
        userNameContent = findViewById(R.id.userNameContact);
        server = findViewById(R.id.server);
        //add new contact
        //   Intent i =getIntent();
        //  contacts = (List<Contact>)i.getSerializableExtra("listContacts");
        btnSave.setOnClickListener(v -> {
//TODO send the data to API to create contact
//            Contact contact = new Contact();
//            contactDao.insert(contact);
            SharedPreferences prefs;
            SharedPreferences.Editor edit;
            prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
            String token = prefs.getString("token", "");
            //

            //userName with pref
            prefs = this.getSharedPreferences("myPrefs2", Context.MODE_PRIVATE);
            String userName = prefs.getString("userName", "");
            Contact c = new Contact(userNameContent.getText().toString(), nickNameContent.getText().toString(), server.getText().toString());
            ContactsAPI api = new ContactsAPI();
            //c.setUserName(userName);
            api.CreateContact(token, c);


            finish();
        });
    }

    private void setThemeOfApp() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sharedPreferences.getString("color", "TEAL").equals("TEAL")) {
            setTheme(R.style.teal);
        } else {
            setTheme(R.style.turqiz);
        }
    }
}