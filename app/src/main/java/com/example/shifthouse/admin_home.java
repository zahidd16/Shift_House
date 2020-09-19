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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;






public class admin_home extends AppCompatActivity {
    EditText  adminMail, adminPassword;
    Button adminLogin;
    FirebaseAuth aAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        adminMail =  findViewById(R.id.editTextAdminUser);
        adminPassword =  findViewById(R.id.editTextAdminPassword);
        adminLogin = findViewById(R.id.buttonAdminLogin);
        aAuth=FirebaseAuth.getInstance();

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
                login(adnEmail,adnPassword);

            }
        });
    }
    public void login(String email,String password)
    {

        aAuth.signInWithEmailAndPassword(email , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals("MZKsLugyHRNkfQBOT7UllSfbhOc2")) {
                    Intent adminLoginIntent = new Intent(admin_home.this, control_panel.class);
                    startActivity(adminLoginIntent);
                    Toast toast = Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT);
                    toast.show();

                }
                else{
                    Toast.makeText(admin_home.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }

}