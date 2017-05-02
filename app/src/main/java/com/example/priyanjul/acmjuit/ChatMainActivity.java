package com.example.priyanjul.acmjuit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChatMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        //getActionBar().setTitle("Chatroom");
        getSupportActionBar().setTitle("Chatroom");
    }
}
