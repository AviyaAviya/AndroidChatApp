package com.example.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

//this is the contacts screen, all your friends are showed here by list
public class ContactActivity extends AppCompatActivity {

    //the data base
    private AppDB db;
    //using room
    private ContactDao contactDao;
    //the contact data
    private List<Contact> contacts;
    //   private PostsListAdapter adapter;
    //to adapt the list view
    // private ArrayAdapter<Post> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
//building db
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB").allowMainThreadQueries().build();

        contactDao = db.contactDao();

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        //when click on btn, go to page adding new contact
        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, FormActivity.class);
            startActivity(i);
        });
        RecyclerView lstContacts = findViewById(R.id.lstContacts);

        contacts = new ArrayList<>();
        contacts.add(new Contact("hello", R.drawable.person_ic));

        final ContactsListAdapter adapter = new ContactsListAdapter(this);
        //list of contacts
        lstContacts.setAdapter(adapter);
        lstContacts.setLayoutManager(new LinearLayoutManager(this));
        //posts.add(new Post("hello",R.drawable.person_ic));
        adapter.setContacts(contacts);

//when click long in btn, remove contact from list
        //TODO add method of remove in adapter(the content string and the pic
//        lstPosts.addOnItemTouchListener((adapterView, v, i, l) -> {
//            Post post = posts.remove(i);
//            //remove it from the db too
//            postDao.delete(post);
//            //notify the adapter on changes
//            adapter.notifyDataSetChanged();
//            return true;
//        });

        //on short click , go to page of adding new contact but with extra info as the post(contact)
        //we want to edit
//        lstPosts.setOnItemClickListener((adapterView, v, i, l) -> {
//            Intent intent = new Intent(this, FormActivity.class);
//            //sending the id of the needed update contact
//            intent.putExtra("id", posts.get(i).getId());
//            startActivity(intent);
//
//        });

        //on short click , go to chat
//                lstPosts.addOnItemTouchListener((adapterView, v, i, l) -> {
//            Post post = posts.remove(i);
//                    Intent intent = new Intent(this, ChatActivity.class);
//                    startActivity(intent);
//                    //remove it from the db too
//                    postDao.delete(post);
//                    //notify the adapter on changes
//                    adapter.notifyDataSetChanged();
//                    return true;
//                });

    }

    // @Override
    //make the changes seen in run time
//    protected void onResume() {
//        super.onResume();
//        posts.clear();
//        posts.addAll(postDao.index());
//        adapter.notifyDataSetChanged();
//        Log.i("Contacts", "onResume");
//    }


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