package com.example.chat.api;

import com.example.chat.entitys.Contact;
import com.example.chat.entitys.Login;
import com.example.chat.entitys.Message;
import com.example.chat.entitys.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IMessagesAPI {
@GET("contacts/{id}/messages")
    Call<List<Message>> getMessages(@Header("Authorization") String jwt,@Path("id") String id);

@POST("contacts/{id}/messages")
Call<Object> createMessage(@Header("Authorization") String jwt, @Path("id") String id, @Body Message message);

@POST("users/signin")
    Call<Object> signin(@Body Login login);


@DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
