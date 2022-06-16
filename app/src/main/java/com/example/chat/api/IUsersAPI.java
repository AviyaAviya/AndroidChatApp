package com.example.chat.api;

import com.example.chat.entitys.User;
import com.example.chat.entitys.Login;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUsersAPI {
    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<Void> createUser(@Body User user);

    @POST("users/signin")
    Call<Object> signin(@Body Login login);


    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
