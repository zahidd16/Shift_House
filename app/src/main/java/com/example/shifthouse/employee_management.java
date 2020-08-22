package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class employee_management extends AppCompatActivity implements View.OnClickListener{

    String[] empCategory;
    private Spinner spinner;
    Button backToControlPanel, gotoEmployeeDetails, employeeUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_management);
        empCategory = getResources().getStringArray(R.array.emp_category);   //getting Array from the dropdown list
        spinner = findViewById(R.id.spinnerId);
        backToControlPanel = findViewById(R.id.backToPanelBtn);
        gotoEmployeeDetails = findViewById((R.id.empDetailsBtn));
        employeeUpdateBtn = findViewById(R.id.empUpdateBtn);
        backToControlPanel.setOnClickListener(this);
        gotoEmployeeDetails.setOnClickListener(this);
        employeeUpdateBtn.setOnClickListener(this);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, R.layout.dropdown_view, R.id.textViewSampleId, empCategory);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onClick(View view){
        if(view == backToControlPanel){
            Intent i= new Intent(employee_management.this, control_panel.class);
            startActivity(i);
        }
        if(view == gotoEmployeeDetails){
            Intent i= new Intent(employee_management.this, employee_details.class);
            startActivity(i);
        }
        if(view == employeeUpdateBtn){
            //action for update vehicles
        }
    }

}