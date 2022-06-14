package com.example.chat.activity;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagesService extends FirebaseMessagingService {
    public MessagesService() {
    }

    @Override
    //when we get a message through firebase
    public void onMessageReceived(@NonNull RemoteMessage message) {

    }
}