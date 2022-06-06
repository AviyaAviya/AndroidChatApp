package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //the button of the log in
        Button btnLogin = findViewById(R.id.buttonLogIn);
        btnLogin.setOnClickListener(v -> {
            //moving to screen contacts list
            Intent i= new Intent(this, Contacts.class);
            startActivity(i);
        });
        //to the log cat print where am i
        Log.i("MainActivity","onCreate");
        //botton of the register
        Button btnRegite= findViewById(R.id.buttonRegister);
        btnRegite.setOnClickListener(v->{
          //moving to the regiter screen
            Intent i = new Intent(this, LogInScreen.class);
            startActivity(i);

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }
}