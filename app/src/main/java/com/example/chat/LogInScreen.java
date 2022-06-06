package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class LogInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
        Button btnSubmit = findViewById(R.id.buttonSubmitReg);
        btnSubmit.setOnClickListener(v -> {
            //moving to screen contacts list
            Intent i = new Intent(this, Contacts.class);
            startActivity(i);
        });


        Log.i("LogInScreen", "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LogInScreen","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LogInScreen","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LogInScreen","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LogInScreen","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LogInScreen","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogInScreen","onDestroy");
    }

}