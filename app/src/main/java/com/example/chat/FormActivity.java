package com.example.chat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class FormActivity extends AppCompatActivity {
    private  AppDB db;
    private ContactDao contactDao;
    //the inpute from user
    private EditText content;
    //the input from user
//    private ImageView pic;
    //a contact
    private Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        db= Room.databaseBuilder(getApplicationContext(),AppDB.class, "PostsDB").allowMainThreadQueries().build();
        contactDao= db.contactDao();
        //the name of contact
        //content = findViewById(R.id.nickName);
        //check if really we have info to add
        if(getIntent().getExtras()!=null){
            //the key of contact
            int id = getIntent().getExtras().getInt("id");
            contact = contactDao.get(id);
            content.setText(contact.getContent());
        }


        Button btnSave= findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v->{
             content = findViewById(R.id.nickName);
             //if its an update to already exist post
            if (contact!=null){
                contact.setContent(content.getText().toString());
                contactDao.update(contact);
            }
            //if its an add a new post completly
            else{
                contact = new Contact("hello",R.drawable.person_ic);
                contactDao.insert(contact);


            }
            //exit the form back to activity contacts once clicked on save btn
            finish();
        });
    }
}