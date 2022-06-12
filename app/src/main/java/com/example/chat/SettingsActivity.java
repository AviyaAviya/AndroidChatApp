package com.example.chat;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


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