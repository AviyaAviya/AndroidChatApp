package com.example.chat.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class LogInActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_login);
        //the button of the log in
        Button btnLogin = findViewById(R.id.buttonLogIn);
        btnLogin.setOnClickListener(v -> {
            //moving to screen contacts list
            Intent i = new Intent(this, ContactActivity.class);
            startActivity(i);
        });
        //to the log cat print where am i
        Log.i("MainActivity", "onCreate");
        //botton of the register
        Button btnRegite = findViewById(R.id.buttonRegister);
        btnRegite.setOnClickListener(v -> {
            //moving to the register screen
            Intent i = new Intent(this, ResignActivity.class);
            startActivity(i);

        });
        ImageButton btnSetting = findViewById(R.id.setting_buttom);
        btnSetting.setOnClickListener(v -> {
            //moving to the setting screen
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);

        });


    }
    private void setThemeOfApp(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.getString("color","TEAL").equals("TEAL")){
            setTheme(R.style.teal);
        }
        else {
            setTheme(R.style.turqiz);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }
}