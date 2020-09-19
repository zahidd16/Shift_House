package com.example.shifthouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class order_activity extends AppCompatActivity implements View.OnClickListener{

    EditText datep;
    Button elecA,elecM,paintA,paintM,plumA,plumM,fin;
    TextView paint,elec,plum,service,total,vehicle;
    int extraCost=0,nE=0,nPl=0,nPt=0;
    String source,dest,dist,nCargo,nTruck,nVan,name;
    double vehicleCost,totalCost;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_activity);
        Intent i=getIntent();
        String s=i.getStringExtra("vehicleCost");
        source=i.getStringExtra("start");
        dest=i.getStringExtra("destination");
        dist=i.getStringExtra("distance");
        nCargo=i.getStringExtra("nCargo");
        nVan=i.getStringExtra("nVan");
        nTruck=i.getStringExtra("nTruck");
        vehicleCost=Double.parseDouble(s);
        datep = findViewById(R.id.date);
        datep.setInputType(InputType.TYPE_NULL);
        datep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(datep);
            }
        });
        elecA=findViewById(R.id.ela);
        elecM=findViewById(R.id.elm);
        paintA=findViewById(R.id.painta);
        paintM=findViewById(R.id.paintm);
        plumA=findViewById(R.id.pa);
        plumM=findViewById(R.id.pm);

        paint=findViewById(R.id.painter);
        elec=findViewById(R.id.el);
        plum=findViewById(R.id.pl);
        elecA.setOnClickListener(this);
        elecM.setOnClickListener(this);
        paintA.setOnClickListener(this);
        paintM.setOnClickListener(this);
        plumA.setOnClickListener(this);
        plumM.setOnClickListener(this);
        fin=findViewById(R.id.finish);
        auth= FirebaseAuth.getInstance();
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOrder();
            }
        });
        service=findViewById(R.id.ext);
        vehicle=findViewById(R.id.previous);
        total=findViewById(R.id.tot);

        vehicle.setText(String.format("Vehicle Cost: %.2f",vehicleCost));

    }
    private void showDateDialog(final EditText datep)
    {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
                datep.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(order_activity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)
        ,calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void saveOrder(){
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        String userID=firebaseUser.getUid();
       DatabaseReference d = FirebaseDatabase.getInstance().getReference("Users").child(userID);
       d.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               User user= dataSnapshot.getValue(User.class);
               name=user.getNam();
               DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Orders");
               Order order=new Order(name,userID,vehicleCost+"",extraCost+"",totalCost+"",source,dest,dist,datep.getText().toString(),nCargo,nVan,nTruck,nE+"",nPl+"",nPt+"","n/a",
                       "n/a", "n/a", "n/a","n/a","n/a","n/a");
               databaseReference.child(userID).setValue(order);
               Toast.makeText(order_activity.this,"Thanks for the order. We will contact you soon. ",Toast.LENGTH_LONG).show();

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

       // startActivity(new Intent(order_activity.this,activity_home.class));
    }

    @Override
    public void onClick(View v) {
        if(v==elecA) {
            nE++;
            elec.setText(nE+"");
        }
        if(v==elecM && nE>0) {
            nE--;
            elec.setText(nE+"");
        }
        if(v==paintA) {
            nPt++;
            paint.setText(nPt+"");
        }
        if(v==paintM && nPt>0) {
            nPt--;
            paint.setText(nPt+"");

        }
        if(v==plumA) {
            nPl++;
            plum.setText(nPl+"");
        }
        if(v==plumM && nPl>0) {
            nPl--;
            plum.setText(nPl+"");
        }

        extraCost=(nE*1200+nPt*1000+nPl*900);
        service.setText("Service cost:  "+extraCost);
        totalCost=extraCost+vehicleCost;
        total.setText(String.format("Total Cost:     %.2f",totalCost));



    }
}