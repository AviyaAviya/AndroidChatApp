package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
//this is the contacts screen, all your friends are showed here by list
public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Contacts","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Contacts","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Contacts","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Contacts","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Contacts","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Contacts","onDestroy");
    }
}