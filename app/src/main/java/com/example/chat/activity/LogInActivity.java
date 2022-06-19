package com.example.chat.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.chat.api.UsersAPI;
import com.example.chat.entitys.Login;

public class LogInActivity extends AppCompatActivity {
    //color of app
    SharedPreferences sharedPreferences;
    //for the DB

    Login login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeOfApp();
        setContentView(R.layout.activity_login);
        //the button of the log in
        Button btnLogin = findViewById(R.id.buttonLogIn);



            //taking input
            TextView usernameTV = findViewById(R.id.userNameLogIn);
            TextView passwordTV = findViewById(R.id.passwordLogIn);
        btnLogin.setOnClickListener(v -> {

            //need to save user
            login = new Login(usernameTV.getText().toString(), passwordTV.getText().toString());
            //connect to server
            UsersAPI userApi1 = new UsersAPI();
//send the user info(name and password)
            userApi1.sighin(login, this);
    });

//                }
//                else{
//                    passwordTV.setError("nop,that's not it");
//                }
//
//
//            }
//            else{
//                usernameTV.setError("are you invisible? we cant see you in our app ");
//            }


        //to the log cat print where am i
        Log.i("LogInActivity", "onCreate");
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



    private void setThemeOfApp() {
        //set color of app
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sharedPreferences.getString("color", "TEAL").equals("TEAL")) {
            setTheme(R.style.teal);
        } else {
            setTheme(R.style.turqiz);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LogInActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LogInActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LogInActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LogInActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LogInActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogInActivity", "onDestroy");
    }
}