package com.example.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resign);
        Button btnSubmit = findViewById(R.id.buttonSubmitReg);
        if (registerUser()){
            btnSubmit.setOnClickListener(v -> {
                //moving to screen contacts list
                Intent i = new Intent(this, ContactActivity.class);
                startActivity(i);
            });
            Log.i("LogInScreen", "onCreate");

        }

    }

    private boolean validateFullName() {
        TextView fullName = findViewById(R.id.fullName);
        String val = fullName.toString();
        if (val.isEmpty()) {
            fullName.setError("Sorry buddy, it cannot be empty");
            return false;
        } else {
            fullName.setError(null);
            //userName.setErrorEnabled(false):
            return true;
        }

    }

    private boolean validateNickName() {
        TextView nickName = findViewById(R.id.userName);
        String val = nickName.toString();
        if (val.isEmpty()) {
            nickName.setError("Sorry buddy, it cannot be empty");
            return false;
        } else {
            nickName.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {
        TextView password = findViewById(R.id.password);
        String val = password.toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-zA-Z])" +
             //   +"/^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&^_-]+$/"+//no special characters
                "(?=\\S+$)" +           //no white spaces
                ".{1,}" +               //at least 1 characters
                "$";
        if (val.isEmpty()) {
            password.setError("Ooops, its empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            password.setError("Your password does not gonna make it! try again");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }

    private boolean validateEnsurePa() {
        TextView ensurePassword = findViewById(R.id.ensurePassword);
        String val = ensurePassword.toString();
        TextView password = findViewById(R.id.password);
        String val2 = password.toString();
        if (val.isEmpty()) {
            ensurePassword.setError("Sorry buddy, it cannot be empty");
            return false;
        } else if (val!=val2) {
            ensurePassword.setError("Hmmmm, its seems they are not a perfect match");
            return false;
        } else {
            ensurePassword.setError(null);
            return true;
        }

    }

    //regit a user and check if valid
    public boolean registerUser() {
        if (!validateFullName() | !validateNickName() | !validatePassword() | !validateEnsurePa()) {
            return false;
        }
        return  true;


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LogInScreen", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LogInScreen", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LogInScreen", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LogInScreen", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LogInScreen", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogInScreen", "onDestroy");
    }

}