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
import com.example.chat.entitys.User;

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
        btnLogin.setOnClickListener(v -> {



            //taking input
            TextView usernameTV = findViewById(R.id.userNameLogIn);
            TextView passwordTV = findViewById(R.id.passwordLogIn);
            //moving to screen contacts list
//            //TODO CHECK IF USER EXIST IN DB
//            if(true){
//                //TODO CHECK IF PASSWORD CORRECT
//                if(true){
                    //need to save user
                    login = new Login(usernameTV.getText().toString(),passwordTV.getText().toString());
                    UsersAPI userApi1 = new UsersAPI();

                    userApi1.sighin(login,this);

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