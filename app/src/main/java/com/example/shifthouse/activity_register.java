package com.example.shifthouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_register extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail,editTextPassword;
    EditText name,mo,add,nid;
    Button register;
    TextView loginInTextview;
    ProgressBar progressBar;
   // DatabaseReference databaseReference;
  //  FirebaseUser firebaseUser;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

     //   databaseReference= FirebaseDatabase.getInstance().getReference("");


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
                    String nam = name.getText().toString().trim();
                    String email = editTextEmail.getText().toString().trim();
                    String mob = mo.getText().toString().trim();
                    String ad = add.getText().toString().trim();
                    String n = nid.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();

                    User user = new User(nam,userid,email,mob,ad,n,password);


                  DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");

                    databaseReference.child(userid).setValue(user);

                    firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(activity_register.this, "Verification Email has been sent", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(activity_register.this, " Email not sent"+ e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });





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