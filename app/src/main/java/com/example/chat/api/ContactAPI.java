package com.example.chat.api;

import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;
import com.example.chat.activity.MyApplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactAPI {
    //    private MutableLiveData<List<Contact>> postListData;
    Retrofit retrofit;
    WebServiceAPI webServiceAPI;

    public ContactAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void get() {
        Call<List<Contact>> call = webServiceAPI.getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> contacts = response.body();
                int a =5;
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {}
        });
    }
}