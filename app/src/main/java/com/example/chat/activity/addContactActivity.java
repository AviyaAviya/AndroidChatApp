package com.example.chat.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.room.Room;

import com.example.chat.api.ContactsAPI;
import com.example.chat.entitys.Contact;
//import com.example.chat.room.AppDB;
//import com.example.chat.room.ContactDao;

public class addContactActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
//    private AppDB db;
//    private ContactDao contactDao;
    //the inpute from user
    private EditText content;
    //the input from user
    private ImageView pic;
    //a contact
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_add_contact);

//        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostsDB").allowMainThreadQueries().build();
//        contactDao = db.contactDao();

        //check if really we have info to add
//        if(getIntent().getExtras()!=null){
//            //the key of contact
//            int id = getIntent().getExtras().getInt("id");
//            contact = contactDao.get(id);
//            content.setText(contact.getContent());
//        }


        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            content = findViewById(R.id.nickName);


            // ORI CODE!
            //any time we want the token
            SharedPreferences prefs;
            SharedPreferences.Editor edit;
            prefs=this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
            String token = prefs.getString("token","");
            //

            //userName with pref
            prefs=this.getSharedPreferences("myPrefs2",Context.MODE_PRIVATE);
            String userName = prefs.getString("userName","");


            //
                    Contact c = new Contact("ori","ori","aaa");
            ContactsAPI api = new ContactsAPI();
            c.setUserName(userName);
        api.CreateContact(token,c);
        //
            //



            //if its an update to already exist post
            if (contact != null) {
//                contact.setContent(content.getText().toString());
//                contactDao.update(contact);
            }
            //if its an add a new contact completly
            else {
//                contact = new Contact(content.getText().toString(), R.drawable.person_ic);
//                contactDao.insert(contact);


            }
            //exit the current activity back to activity contacts once clicked on save btn
            finish();
        });
    }
    private void setThemeOfApp(){
         sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.getString("color","TEAL").equals("TEAL")){
            setTheme(R.style.teal);
        }
        else {
            setTheme(R.style.turqiz);
        }
    }
}