package com.example.chat.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.chat.activity.ContactActivity;
import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;
import com.example.chat.activity.MyApplication;
import com.example.chat.entitys.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI {
    //    private MutableLiveData<List<Contact>> postListData;
    Retrofit retrofit;
    IContactsAPI webServiceAPI;

    public ContactsAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(IContactsAPI.class);
    }

    public void getContact(String token) {
        Call<List<Contact>> call = webServiceAPI.getContacts("Bearer " + token);
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> contacts = response.body();
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {}
        });
    }

    public void CreateContact(String token, Contact contact){
        Call<Object> call = webServiceAPI.createContact(token,contact);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()){
                }
                else{
                }

            }
            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                int a = 1;

            }
        });
    }




}