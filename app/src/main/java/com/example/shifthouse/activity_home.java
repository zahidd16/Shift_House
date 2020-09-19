package com.example.shifthouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.text.InputType;
import android.view.*;

import android.content.*;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class activity_home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    DrawerLayout drawerLayout;
    double distance;
    TextView d,e,t,f,dcost,npt,nc,npv,des;
    Button source,dest,vanP,truckP,cargoP,vanM,truckM,cargoM,confirm;
    EditText loc;
    int driverCost=0,nTruck=0,nVan=0,nCargo=0;
    String s="1";
    String startLoc="Source to ",endLoc="destination";
    double total=0,fare=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loc=findViewById(R.id.location);
        des=findViewById(R.id.destination);
        Intent i = getIntent();
        s=i.getStringExtra("total distance");
        if(s==null)
            s="1";
        startLoc=i.getStringExtra("start");
        endLoc=i.getStringExtra("destination");
        if(startLoc==null)
            startLoc="Select Location ";
        if(endLoc==null)
            endLoc="Destination: ";
        loc.setText(startLoc+"  ");
        des.setText(endLoc+" ");
        distance = Double.parseDouble(s);
        d = findViewById(R.id.distances);
        d.setText(String.format("%.2f",distance)+" KM");
        vanP=findViewById(R.id.pva);
        vanM=findViewById(R.id.pvm);
        truckP=findViewById(R.id.pta);
        truckM=findViewById(R.id.ptm);
        cargoP=findViewById(R.id.ca);
        cargoM=findViewById(R.id.cm);
        vanP.setOnClickListener(this);
        vanM.setOnClickListener(this);
        truckP.setOnClickListener(this);
        truckM.setOnClickListener(this);
        cargoP.setOnClickListener(this);
        cargoM.setOnClickListener(this);
        t=findViewById(R.id.tot);
        dcost=findViewById(R.id.dc);
        f=findViewById(R.id.fr);
        npv=findViewById(R.id.pv);
        npt=findViewById(R.id.pt);
        nc=findViewById(R.id.co);
        confirm=findViewById(R.id.con);



        loc.setInputType(InputType.TYPE_NULL);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_home.this,MapsActivity.class));

            }
        });





        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i=   new Intent(activity_home.this,order_activity.class);
             i.putExtra("vehicleCost",total+"");
             i.putExtra("start",startLoc+"");
             i.putExtra("destination",endLoc+"");
             i.putExtra("distance",distance+"");
             i.putExtra("nCargo",nCargo+"");
             i.putExtra("nVan",nVan+"");
             i.putExtra("nTruck",nTruck+"");
             startActivity(i);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onClick(View v) {
        if(v==vanP) {
            nVan++;
            npv.setText(nVan+"");
        }
        if(v==vanM && nVan>0) {
            nVan--;
            npv.setText(nVan+"");
        }
        if(v==truckP) {
            nTruck++;
            npt.setText(nTruck+"");
        }
        if(v==truckM && nTruck>0) {
            nTruck--;
            npt.setText(nTruck+"");

        }
        if(v==cargoP) {
            nCargo++;
            nc.setText(nCargo+"");
        }
        if(v==cargoM && nCargo>0) {
            nCargo--;
            nc.setText(nCargo+"");
        }
        driverCost=(nVan*500+nTruck*600+nCargo*800);
        fare=(distance*150*nVan+distance*250*nTruck+distance*450*nCargo);
        total=fare+driverCost;
        dcost.setText(driverCost+"");
        f.setText(String.format("%.2f",fare));
        t.setText(String.format("%.2f",total));

    }




    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.nav_profile:
                intent = new Intent(this,activity_profile.class);
                startActivity(intent);
                break;
            case R.id.nav_message:
                intent = new Intent(this, UserChatOrder.class);
                startActivity(intent);
                break;
            case R.id.nav_signout:
                FirebaseAuth.getInstance().signOut();
                finish();
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_help:
                intent = new Intent(this,HelpFragment.class);
                startActivity(intent);
                break;
            case R.id.nav_contact:
                intent = new Intent(this,ContactActivity.class);
                startActivity(intent);
                break;
            case R.id.aboutus:
                intent = new Intent(this,activity_aboutus.class);
                startActivity(intent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}