package com.example.shifthouse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ContactActivity extends AppCompatActivity {
    int num = 1234;
    int MY_PERMISSIONS_REQUEST_CALL_PHONE=123;
    Button call;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        call=findViewById(R.id.c);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s="tel:"+num;
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                if (ContextCompat.checkSelfPermission(ContactActivity.this,
                        android.Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ContactActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);

                } else {
                    try {
                        startActivity(intent);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        }

}
