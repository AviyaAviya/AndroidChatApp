package com.example.chat;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    //the data base
//    private AppDB db;
//    //using room
//    private MessageDao messageDao;
//    //the contact data
//    private List<Message> messages;
//    //to adapt the list view
//    private ArrayAdapter<Message> adapterOfChat;
//    //the input from user
//    private EditText contentOfMessages;
//    //a message
//    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //building db
//        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "MessagesDB").allowMainThreadQueries().build();
//
//        messageDao= db.messageDao();
//        //list of contacts
//        messages = new ArrayList<>();
//        ListView lvMessages = findViewById(R.id.lvMessages);
//        adapterOfChat = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
//
//
//        lvMessages.setAdapter(adapterOfChat);
//
//
//        //check if really we have info to add
//        //TODO im not sure we really need it here
//        if(getIntent().getExtras()!=null){
//            //the key of message
//            int id = getIntent().getExtras().getInt("id");
//            message = messageDao.get(id);
//            contentOfMessages.setText(message.getContent());
//        }
//
//
//        Button btnSend= findViewById(R.id.btnSend);
//        btnSend.setOnClickListener(v-> {
//            contentOfMessages = findViewById(R.id.message_text);
//            message = new Message(0, contentOfMessages.getText().toString());
//            messageDao.insert(message);
//
//        });
//
//



    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ChatActivity", "onStart");
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        messages.clear();
//        messages.addAll(messageDao.index());
//        adapterOfChat.notifyDataSetChanged();
//        Log.i("ChatActivity", "onResume");
//    }

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