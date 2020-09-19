package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class startActivity extends AppCompatActivity implements View.OnClickListener {

    Button user,admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        user = findViewById(R.id.UserLogin);
        admin = findViewById(R.id.AdminLogin);
        user.setOnClickListener(this);
        admin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view== user)
        {
            Intent i= new Intent(startActivity.this, MainActivity.class);
            startActivity(i);
        }
        if(view == admin)
        {
            Intent i= new Intent(startActivity.this,admin_home.class);
            startActivity(i);
        }
    }
}