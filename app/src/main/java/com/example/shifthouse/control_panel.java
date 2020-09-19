package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class control_panel extends AppCompatActivity implements View.OnClickListener {
    Button adminLogout, vehicleListBtn, employeeListBtn, msgCheckBtn,order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_panel);
        adminLogout = findViewById(R.id.adminLogoutBtn);
        vehicleListBtn = findViewById(R.id.accessVehicleListBtn);
        employeeListBtn = findViewById(R.id.accessEmployyeListBtn);
        msgCheckBtn = findViewById(R.id.accessMsgCheckBtn);
        order=findViewById(R.id.orders);
        order.setOnClickListener(this);
        adminLogout.setOnClickListener(this);
        vehicleListBtn.setOnClickListener(this);
        employeeListBtn.setOnClickListener(this);
        msgCheckBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if(view ==order) {
            Intent i= new Intent(control_panel.this, AdminChatOrders.class);
            startActivity(i);

        }
        if(view == adminLogout){
            Intent i= new Intent(control_panel.this, admin_home.class);
            startActivity(i);
            Toast toast = Toast.makeText(getApplicationContext(), "logout successfully", Toast.LENGTH_SHORT);
            toast.show();
        }
        if(view == vehicleListBtn){
            Intent i= new Intent(control_panel.this, vehicles_update.class);
            startActivity(i);
        }
        if(view == employeeListBtn){
            Intent i= new Intent(control_panel.this, employee_management.class);
            startActivity(i);
        }
        if(view == msgCheckBtn){
            Intent i= new Intent(control_panel.this, AdminChatOrders.class);
            startActivity(i);
        }
    }

}