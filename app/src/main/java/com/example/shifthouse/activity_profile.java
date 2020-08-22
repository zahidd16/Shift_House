package com.example.shifthouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

public class activity_profile extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser user;
    private DatabaseReference reff;
    TextView n, phn, id, add, em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        n = (TextView) findViewById(R.id.name);
        phn = (TextView) findViewById(R.id.mobile);
        id = (TextView) findViewById(R.id.nid);
        add = (TextView) findViewById(R.id.address);
        em = (TextView) findViewById(R.id.email);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        String key=user.getProviderId();
        reff = firebaseDatabase.getReference();




     reff.orderByChild("email").equalTo(user.getEmail().trim()).addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for(DataSnapshot datas :dataSnapshot.getChildren())
             {
                 String name = datas.child("nam").getValue().toString();
                 String phone = datas.child("mob").getValue().toString();
                 String nid = datas.child("n").getValue().toString();
                 String address = datas.child("ad").getValue().toString();

                 phn.setText(phone);
                 n.setText(name);
                 id.setText(nid);
                 add.setText(address);
                 em.setText(user.getEmail());
             }

         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });

    }
}