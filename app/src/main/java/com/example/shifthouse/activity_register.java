package com.example.shifthouse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_register extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail,editTextPassword;
    EditText name,mo,add,nid;
    Button register;
    TextView loginInTextview;
    ProgressBar progressBar;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseReference= FirebaseDatabase.getInstance().getReference("");


        editTextEmail = findViewById(R.id.em);
        editTextPassword = findViewById(R.id.pass);

        name = findViewById(R.id.na);
        mo = findViewById(R.id.mo);
        add = findViewById(R.id.ad);
        nid = findViewById(R.id.ni);

        register = findViewById(R.id.buttonSignUp);
        loginInTextview = findViewById(R.id.login);

        progressBar = findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(this);
        loginInTextview.setOnClickListener(this);

    }



    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 5) {
            editTextPassword.setError("Minimum length must be 5");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You are successfully registered", Toast.LENGTH_SHORT).show();

                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


    private void saveData() {
        String nam = name.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String mob = mo.getText().toString().trim();
        String ad = add.getText().toString().trim();
        String n = nid.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        String key = databaseReference.push().getKey();
        customer cus = new customer(nam,email,mob,ad,n,password);

        databaseReference.child(key).setValue(cus);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonSignUp:
                registerUser();
                saveData();
                break;

            case R.id.login:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }
}