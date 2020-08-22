package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class admin_home extends AppCompatActivity {
    EditText  adminMail, adminPassword;
    Button adminLogin;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        adminMail =  findViewById(R.id.editTextAdminUser);
        adminPassword =  findViewById(R.id.editTextAdminPassword);
        adminLogin = findViewById(R.id.buttonAdminLogin);

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adnEmail = adminMail.getText().toString().trim();
                String adnPassword = adminPassword.getText().toString().trim();

                if(TextUtils.isEmpty(adnEmail)){
                    adminMail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(adnPassword)){
                    adminPassword.setError("password is required");
                    return;
                }
                if(adnPassword.length()<5 && adnPassword.length()>5){
                    adminPassword.setError("password must not be greater or less than 5 characters");
                    return;
                }
                if(adnEmail.equals("admin@gmail.com") && adnPassword.equals("admin")){
                    Intent adminLoginIntent = new Intent(admin_home.this, control_panel.class);
                    startActivity(adminLoginIntent);
                    //progressBar.setVisibility(view.VISIBLE);
                    Toast toast = Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}