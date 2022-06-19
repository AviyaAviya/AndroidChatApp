package com.example.chat.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.chat.activity.ContactActivity;
import com.example.chat.activity.MyApplication;
import com.example.chat.activity.R;
import com.example.chat.entitys.Login;
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

    public void post(User user) {
        Call<Void> call = webServiceAPI.createUser(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Void t = response.body();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
        public void sighin(Login login, Activity activity) {
            Call<Object> call = webServiceAPI.signin(login);
            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    Object t = response.body();
                    SharedPreferences prefs;
                    SharedPreferences.Editor edit;
                    prefs=activity.getSharedPreferences("myPrefs",Context.MODE_PRIVATE);
                    edit=prefs.edit();
                    String s = t.toString();
                    s= s.substring(7,s.length()-1);
                    String saveToken=s;

                    edit.putString("token",saveToken);
                    edit.commit();

                    Intent i = new Intent(activity, ContactActivity.class);
                    //sending the user id to the activity
          //          i.putExtra("idUserName",login.getUserId());
                    activity.startActivity(i);

                    prefs=activity.getSharedPreferences("myPrefs2",Context.MODE_PRIVATE);
                    edit=prefs.edit();
                    edit.putString("userName", login.getUserId());
                    edit.commit();

//                    you need to put exstra this => login.getUserId();
//                    String keyIdentifer  = null;
//                    i.putExtra(userName, keyIdentifer );
                    activity.startActivity(i);

                }
                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    int a = 1;

                }
            });

        }






}
