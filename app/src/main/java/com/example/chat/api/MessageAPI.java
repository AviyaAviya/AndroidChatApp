package com.example.chat.api;

import com.example.chat.activity.MyApplication;
import com.example.chat.activity.R;
import com.example.chat.entitys.Message;
import com.example.chat.room.MessageDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageAPI {
    Retrofit retrofit;
    IMessagesAPI webServiceAPI;
    MessageDao messageDao;


    public MessageAPI(MessageDao dao) {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(IMessagesAPI.class);
        messageDao = dao;
    }

    public void getMessages(String token, String contactName) {
        Call<List<Message>> call = webServiceAPI.getMessages("Bearer " + token, contactName);

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
//updating room
                for (Message m : response.body()) {
                    messageDao.insert(m);
                }

            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
            }
        });
    }

    public void CreateMessage(String token, String contactName, Message message) {
        Call<Object> call = webServiceAPI.createMessage("Bearer " + token, contactName, message);
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