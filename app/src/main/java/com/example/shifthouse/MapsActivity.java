package com.example.shifthouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.math.*;
import java.util.Map;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String Tag;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Boolean pg = false;
    private static final int Location_permission_request_code = 23;
    Button c;
    double lat1,long1,lat2,long2,distance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng dhaka = new LatLng(23.8103, 90.4125);
        mMap.addMarker(new MarkerOptions().position(dhaka).title("Marker in dhaka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dhaka,12F));


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            int c=0;
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions= new MarkerOptions();
                markerOptions.position(latLng);
                if(c==0) {
                    markerOptions.title("Your Location");
                    c++;
                    lat1=latLng.latitude;
                    long1=latLng.longitude;
                }
                else {
                    markerOptions.title("Destination");
                    lat2=latLng.latitude;
                    long2=latLng.longitude;
                   // distance=Math.sqrt((Math.pow((lat1-lat2),2.0))+Math.pow((long1-long2),2.0));
                    double R = 6371; // Radius of the earth in km
                    double dLat = deg2rad(lat2-lat1);  // deg2rad below
                    double dLon = deg2rad(long2-long1);
                    double a =
                            Math.sin(dLat/2) * Math.sin(dLat/2) +
                                    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                            Math.sin(dLon/2) * Math.sin(dLon/2)
                            ;
                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                    distance = R * c; // Distance in km


                }

                   // mMap.clear();
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                    mMap.addMarker(markerOptions);

            }
        });
    }
    public void confirm(View view){
        if(view==findViewById(R.id.c))
        {
            Intent i =new Intent(MapsActivity.this,activity_home.class);
            i.putExtra("total distance",distance+"");
            startActivity(i);
        }
    }



    public  double deg2rad(double x) {
        return x * (Math.PI/180);
    }
}





