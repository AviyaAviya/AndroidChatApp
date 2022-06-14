package com.example.chat.api;

import com.example.chat.activity.MyApplication;
import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;
import com.example.chat.entitys.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersAPI {
    //    private MutableLiveData<List<Contact>> postListData;
    Retrofit retrofit;
    IUsersAPI webServiceAPI;

    public UsersAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(IUsersAPI.class);
    }

    public void get() {
        Call<List<User>> call = webServiceAPI.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {}
        });
    }



}
