package com.example.chat.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.room.Room;

import com.example.chat.entitys.Contact;
import com.example.chat.room.AppDB;
import com.example.chat.room.ContactDao;

public class addContactActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private AppDB db;
    private ContactDao contactDao;
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

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostsDB").allowMainThreadQueries().build();
        contactDao = db.contactDao();

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
            //if its an update to already exist post
            if (contact != null) {
                contact.setContent(content.getText().toString());
                contactDao.update(contact);
            }
            //if its an add a new contact completly
            else {
                contact = new Contact(content.getText().toString(), R.drawable.person_ic);
                contactDao.insert(contact);


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