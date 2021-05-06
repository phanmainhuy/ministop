package com.example.ministop;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//        ColorDrawable colorDrawable
//                = new ColorDrawable(Color.parseColor("#fdcc32"));
//        // Set BackgroundDrawable
//        actionBar.setBackgroundDrawable(colorDrawable);
        ////title
        //actionBar.setTitle("Welcome to Ministop");
        //String title = actionBar.getTitle().toString();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        },3500);

    }
}