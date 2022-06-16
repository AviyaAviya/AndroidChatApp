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


//    public void getContacts(String token) {
//        Call<String> call = webServiceAPI.getContacts("Bearer " + token);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String contacts = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {}
//        });
//    }


    public void getContacts(String token) {
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
        Call<Object> call = webServiceAPI.createContact("Bearer " + token,contact);
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