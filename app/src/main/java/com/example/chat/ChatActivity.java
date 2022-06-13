package com.example.chat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity  {
    //the data base
    private AppDB db;
    //using room
    private MessageDao messageDao;
    //the contact data
    private List<Message> messages;
    //to adapt the list view
    private MessagesListAdapter adapter;
    //the input from user
    private EditText contentOfMessage;
    //a message
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //building db
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "MessagesDB").allowMainThreadQueries().build();

        messageDao= db.messageDao();
        //list of contacts
        RecyclerView lvMessages = findViewById(R.id.lvMessages);
        messages = new ArrayList<>();
        contentOfMessage = findViewById(R.id.message_text);
        messages.add(new Message(contentOfMessage.getText().toString()));

        final MessagesListAdapter adapter = new MessagesListAdapter(this);
        //list of contacts
        lvMessages.setAdapter(adapter);
        lvMessages.setLayoutManager(new LinearLayoutManager(this));
        adapter.setMessages(messages);



        //check if really we have info to add
        //TODO im not sure we really need it here
        if(getIntent().getExtras()!=null){
            //the key of message
            int id = getIntent().getExtras().getInt("id");
            message = messageDao.get(id);
            contentOfMessage.setText(message.getContent());
        }


        Button btnSend= findViewById(R.id.btnSend);
        btnSend.setOnClickListener(v-> {
            contentOfMessage = findViewById(R.id.message_text);
            message = new Message( contentOfMessage.getText().toString());
            messageDao.insert(message);

        });





    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ChatActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ChatActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ChatActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ChatActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ChatActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ChatActivity", "onDestroy");
    }

}