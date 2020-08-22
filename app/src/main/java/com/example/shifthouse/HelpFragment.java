package com.example.shifthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class HelpFragment extends AppCompatActivity {

    String[] options = { "Instructions", "Pricing", "Others"};
    String[] msg={"1.Select your location & destination\n2.Select required vehicles\n3.Press Confirm","1.For pickup van, driver cost 500tk, fare 150tk/KM\n" +
            "2.For pickup truck, driver cost 600tk fare  250tk/KM\n3.For cargo driver cost 800tk, fare 450tk/KM" ,  "For any other query , contact us through messages or " +
            "call us at 017xxxxxxx"};
    ArrayAdapter<String> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_fragment);
        Spinner spin = (Spinner) findViewById(R.id.spinner);


        a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        spin.setAdapter(a);
       spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               TextView tv = findViewById(R.id.msgs);
               switch (position){
                   case 0:tv.setText(""+msg[position]);
                       break;
                   case 1:tv.setText(""+msg[position]);
                       break;
                   case 2:tv.setText(""+msg[position]);
                       break;

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }



}