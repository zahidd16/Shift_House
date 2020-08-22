package com.example.shifthouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class vehicles_update extends AppCompatActivity implements View.OnClickListener{
    String[] veCategory={"pickup van","Truck","Cargo"};
    private Spinner spinner1;
    Button updt,Back,details;
    ArrayAdapter<String> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_update);
        updt=findViewById(R.id.UpdateBtn);
        Back=findViewById(R.id.BackBtn);
        details=findViewById(R.id.DetailsBtn);
        updt.setOnClickListener(this);
        Back.setOnClickListener(this);
        details.setOnClickListener(this);
        spinner1 = (Spinner) findViewById(R.id.spinnerVehicleId);
        a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,veCategory);
        spinner1.setAdapter(a);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(vehicles_update.this,"Clicked " +veCategory[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(vehicles_update.this,"Clicked " +veCategory[position],Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(vehicles_update.this,"Clicked " +veCategory[position],Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }

    @Override
    public void onClick(View view) {
        if (view == updt) {

        }
        if(view==Back)
        {
            Intent i =new Intent(vehicles_update.this,control_panel.class);
            startActivity(i);
        }
        if(view==details)
        {
            Intent i =new Intent(vehicles_update.this,vehicles_details.class);
            startActivity(i);
        }
    }
}