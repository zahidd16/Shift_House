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
    private FirebaseUser fuser;
    private DatabaseReference reff;
    TextView n, phn, id, add, em;
    String phone,name,nid,address;
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
        fuser = firebaseAuth.getCurrentUser();
        String userId = fuser.getUid();

        // String key=user.getProviderId();
        reff = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user=dataSnapshot.getValue(User.class);
                phone=user.getMob();
                name=user.getNam();
                nid=user.getId();
                address=user.getAd();
                phn.setText(phone);
                n.setText(name);
                id.setText(nid);
                add.setText(address);
                em.setText(fuser.getEmail());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}