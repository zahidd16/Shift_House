package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class employee_management extends AppCompatActivity implements View.OnClickListener{

    String[] empCategory;
    private Spinner spinner;
    Button backToControlPanel, gotoEmployeeDetails, employeeUpdateBtn;
    private EditText editEmployeeId, editEmployeeName, editEmployeeContact, editEmployeeAddress,
    editEmployeeSalary;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_management);
        this.setTitle("Employee management");

        empCategory = getResources().getStringArray(R.array.emp_category);   //getting Array from the dropdown list
        editEmployeeId = findViewById(R.id.editEmpId);
        editEmployeeName = findViewById(R.id.editEmpName);
        editEmployeeContact = findViewById(R.id.editEmpContact);
        editEmployeeAddress = findViewById(R.id.editEmpAddress);
        editEmployeeSalary = findViewById(R.id.editEmpSalary);
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
            employeeManage();
            Intent i= new Intent(employee_management.this, employee_details.class);
            startActivity(i);
        }
    }

    private void employeeManage() {


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("employees");

        String eId = editEmployeeId.getText().toString().trim();
        String eName = editEmployeeName.getText().toString().trim();
        String eContact = editEmployeeContact.getText().toString().trim();
        String eAddress = editEmployeeAddress.getText().toString().trim();
        String eSalary = editEmployeeSalary.getText().toString().trim();
        String spinnerItem = spinner.getSelectedItem().toString().trim();

        if(eId.isEmpty()){
            editEmployeeId.setError("Enter a ID");
            editEmployeeId.requestFocus();
            return;
        }
        if(eName.isEmpty()){
            editEmployeeName.setError("Enter a name");
            editEmployeeName.requestFocus();
            return;
        }
        if(eContact.isEmpty()){
            editEmployeeContact.setError("Enter contact Info");
            editEmployeeContact.requestFocus();
            return;
        }
        if(eAddress.isEmpty()){
            editEmployeeAddress.setError("Enter salary Info");
            editEmployeeAddress.requestFocus();
            return;
        }
        if(eSalary.isEmpty()){
            editEmployeeSalary.setError("Enter contact Info");
            editEmployeeSalary.requestFocus();
            return;
        }


        databaseHelper helper = new databaseHelper(eId, eName, eContact, eAddress, eSalary, spinnerItem);
        reference.child(eId).setValue(helper);

    }
}