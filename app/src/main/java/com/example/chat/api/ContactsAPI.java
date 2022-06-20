package com.example.chat.api;

import com.example.chat.activity.MyApplication;
import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;
import com.example.chat.room.ContactDao;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI {
    Retrofit retrofit;
    IContactsAPI webServiceAPI;
    ContactDao contactDao;


    public ContactsAPI(ContactDao dao) {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(IContactsAPI.class);
        contactDao = dao;
    }


    public void getContacts(String token) {
        Call<List<Contact>> call = webServiceAPI.getContacts("Bearer " + token);
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
//               updating room
//                for (Contact c : response.body())
//                {
//                    contactDao.insert(c);
//                }

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
            }
        });
    }

    public void CreateContact(String token, Contact contact) {
        Call<Object> call = webServiceAPI.createContact("Bearer " + token, contact);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                } else {
                }

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                int a = 1;

            }
        });
    }


}