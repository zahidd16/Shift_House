package com.example.shifthouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import java.util.Calendar;

public class vehicles_update extends AppCompatActivity implements View.OnClickListener{
    String[] veCategory={"pickup van","Truck","Cargo"};
    private Spinner spinner1;
    Button updt,Back,details;
    private static final String TAG = "vehicles_update";
    private TextView mDisplayDate, editVehicleId, editVehiclesDescription;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayAdapter<String> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_update);
        editVehicleId = findViewById(R.id.editVeclId);
        editVehiclesDescription = findViewById(R.id.editVeclDescription);
        mDisplayDate = findViewById(R.id.tvDate);
        updt=findViewById(R.id.UpdateBtn);
        Back=findViewById(R.id.BackBtn);
        details=findViewById(R.id.DetailsBtn);
        updt.setOnClickListener(this);
        Back.setOnClickListener(this);
        details.setOnClickListener(this);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        vehicles_update.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
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
            vehiclesUpdate();
            Intent i =new Intent(vehicles_update.this,vehicles_details.class);
            startActivity(i);
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

    private void vehiclesUpdate() {

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("vehicles");

        String vId = editVehicleId.getText().toString().trim();
        String vDesceiption = editVehiclesDescription.getText().toString().trim();
        String vDate = mDisplayDate.getText().toString().trim();
        String spinnerVec = spinner1.getSelectedItem().toString().trim();

        if(vId.isEmpty()){
            editVehicleId.setError("Enter a Id");
            editVehicleId.requestFocus();
            return;
        }
        if(vDesceiption.isEmpty()){
            editVehiclesDescription.setError("Enter some Description");
            editVehiclesDescription.requestFocus();
            return;
        }


        newHelper dhelp = new newHelper(vId, vDesceiption, vDate, spinnerVec);
        reference.child(vId).setValue(dhelp);

    }
}