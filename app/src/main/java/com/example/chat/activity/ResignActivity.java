package com.example.chat.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class ResignActivity extends AppCompatActivity {
    //for color of app
    SharedPreferences sharedPreferences;
    //to send for DB
    private String fullName;
    private String nickName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set color of app
        setThemeOfApp();
        //show the lay out
        setContentView(R.layout.activity_resign);
        //fitcher
        Button btn = findViewById(R.id.buttonSurpise);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });


        Button btnSubmit = findViewById(R.id.buttonSubmitReg);

        btnSubmit.setOnClickListener(v -> {
            if (registerUser()) {
//TODO MAKE FUNC THAT TAKES THE INPUT AND SEND TO DB TO CREATE A USER
                //moving to screen contacts list
                Intent i = new Intent(this, LogInActivity.class);
                startActivity(i);
            }
        });
        Log.i("LogInScreen", "onCreate");


    }
    //show messgage on screen when you cilck a btn, that a fitcheer for the settings
    void showToast() {
        Toast toast = new Toast(this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sharedPreferences.getBoolean("surpise_visibilty",true)) {
            toast.setDuration(Toast.LENGTH_SHORT);
            View toastView = getLayoutInflater().inflate(R.layout.costum_toast, (ViewGroup) findViewById(R.id.toastLayout));
            toast.setView(toastView);
            toast.setGravity(Gravity.CENTER | Gravity.FILL_HORIZONTAL, 0, 0);
            toast.show();
        }
    }

//check validation of name
    private boolean validateFullName() {
        TextView fullNameTV = findViewById(R.id.fullName);
        //String val = fullName.toString();
        if (fullNameTV.length() == 0) {
            fullNameTV.setError("Sorry buddy, it cannot be empty");
            return false;
        } else {
            //fullName.setError(null);
            //userName.setErrorEnabled(false):
            fullName = fullNameTV.getText().toString();
            return true;
        }

    }
//check validation of nick name
    private boolean validateNickName() {
        TextView nickNameTV = findViewById(R.id.userName);
        //String val = nickName.toString();
        if (nickNameTV.length() == 0) {
            nickNameTV.setError("Sorry buddy, it cannot be empty");
            return false;
        } else {
            nickName = nickNameTV.getText().toString();
            return true;
        }

    }
//check validation of password
    private boolean validatePassword() {
        TextView passwordTV = findViewById(R.id.password);
        //String val = password.toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                //   "(?=.*[a-zA-Z])" +
                //   +"/^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&^_-]+$/"+//no special characters
                "(?=\\S+$)" +           //no white spaces
                ".{1,}" +               //at least 1 characters
                "$";
        if (passwordTV.length() == 0) {
            passwordTV.setError("Ooops, its empty");
            return false;
        }
        else if (!passwordTV.getText().toString().matches(passwordVal)) {
            passwordTV.setError("Your password does not gonna make it! try again");
            return false;
        }
        else {
            password = passwordTV.getText().toString();
            return true;
        }

    }
//check validation of password if it match to the another one
    private boolean validateEnsurePa() {
        EditText ensurePassword = findViewById(R.id.ensurePassword);
        //String val = ensurePassword.toString();
        EditText password = findViewById(R.id.password);
        //String val2 = password.toString();
        if (ensurePassword.length() == 0) {
            ensurePassword.setError("Sorry buddy, it cannot be empty");
            return false;
        }
        else if (!ensurePassword.getText().toString().equals(password.getText().toString())) {
            ensurePassword.setError("Hmmmm, its seems they are not a perfect match");
            return false;
        } else {
            //ensurePassword.setError(null);
            return true;
        }

    }

    //regit a user and check if valid
    public boolean registerUser() {
        if (!validateFullName() | !validateNickName() | !validatePassword() | !validateEnsurePa()) {
            return false;
        }
        return true;


    }
//settings change color
    private void setThemeOfApp() {
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