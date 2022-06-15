
package com.example.chat.api;

import com.example.chat.entitys.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IContactsAPI {
    @GET("contacts")
    Call<List<Contact>> getContacts(@Header("Authorization") String jwt);

    @POST("contacts")
    Call<Object> createContact(@Header("Authorization") String jwt, @Body Contact contact);

    @DELETE("contacts/{id}")
    Call<Void> deleteContact(@Header("Authorization") String jwt,@Path("id") int id);
}