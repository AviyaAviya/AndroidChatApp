package com.example.chat.api;

import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;
import com.example.chat.activity.MyApplication;
import com.example.chat.entitys.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageAPI {
    //    private MutableLiveData<List<Contact>> postListData;
    Retrofit retrofit;
    IMessagesAPI webServiceAPI;

    public MessageAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(IMessagesAPI.class);
    }

    public void getMessages(String token, String id) {
        Call<List<Message>> call = webServiceAPI.getMessages("Bearer " + token,id);

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> contacts = response.body();
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {}
        });
    }

    public void CreateMessage(String token, String contactName){
        Call<Object> call = webServiceAPI.createMessage(token,contactName);
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