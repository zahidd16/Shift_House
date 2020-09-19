package com.example.shifthouse;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shifthouse.Order;
import com.example.shifthouse.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class assignPeopleAndVehicle extends AppCompatActivity {

    TextView orderID,datea,desta,dista,sourcea,cargoa,vana,trucka,electra,plua,pnta,totta,veha,serva,namea;
    EditText drname2,drid2,oname2,oid2,dcont2,ocont2,etim2;
    DatabaseReference databaseReference;
    Button asn,vw;
    String orderid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_people_and_vehicle);
        datea=findViewById(R.id.datet);
        desta=findViewById(R.id.destt);
        dista=findViewById(R.id.distt);
        sourcea=findViewById(R.id.sourcet);
        cargoa=findViewById(R.id.cargot);
        vana=findViewById(R.id.vant);
        trucka=findViewById(R.id.truckt);
        electra=findViewById(R.id.elect);
        plua=findViewById(R.id.plumt);
        pnta=findViewById(R.id.paintt);
        totta=findViewById(R.id.tott);
        veha=findViewById(R.id.veht);
        serva=findViewById(R.id.servt);
        namea=findViewById(R.id.namet);
        drname2=findViewById(R.id.dname);
        drid2=findViewById(R.id.did);
        oname2=findViewById(R.id.sname);
        oid2=findViewById(R.id.sid);
        dcont2=findViewById(R.id.dn);
        ocont2=findViewById(R.id.addn);
        etim2=findViewById(R.id.etime);
        asn=findViewById(R.id.assigned);
        vw=findViewById(R.id.view);
        Intent intent = getIntent();
        orderid = intent.getStringExtra("orderid");
        asn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    String n=oname2.getText().toString();
                String i=oid2.getText().toString();
                String dnm=drname2.getText().toString();
                String di=drid2.getText().toString();
                String on=oname2.getText().toString();
                String oi=oid2.getText().toString();
               */
                databaseReference= FirebaseDatabase.getInstance().getReference("Orders").child(orderid);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Order order=dataSnapshot.getValue(Order.class);
                        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Orders");
                        Order assignedOrder= new Order(order.getUserName(),order.getID(),order.getVehicleCost(),order.getServiceCost(),order.getTotalCost(),
                                order.getStartLocation(),order.getDestination(),order.getDistance(),order.getDate(),order.getnCargo(),order.getnVan(),order.getnTruck(),
                                order.getnElectricians(),order.getnPlumbers(),order.getnPainters(),drname2.getText().toString(),drid2.getText().toString(),
                               oname2.getText().toString(),oid2.getText().toString(),dcont2.getText().toString(),ocont2.getText().toString(),
                                etim2.getText().toString());
                        reff.child(orderid).setValue(assignedOrder);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }



        });
        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(assignPeopleAndVehicle.this,showOrderActivity.class);
                i.putExtra("orderid",orderid);
                startActivity(i);

            }
        });


        databaseReference= FirebaseDatabase.getInstance().getReference("Orders").child(orderid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Order order=dataSnapshot.getValue(Order.class);
                datea.setText(order.getDate());
                desta.setText(order.getDestination());
                dista.setText(order.getDistance()+" KM");
                sourcea.setText(order.getStartLocation());
                cargoa.setText(order.getnCargo());
                vana.setText(order.getnVan());
                trucka.setText(order.getnTruck());
                electra.setText(order.getnElectricians());
                plua.setText(order.getnPlumbers());
                pnta.setText(order.getnPainters());
                totta.setText(order.getTotalCost()+" tk");
                veha.setText(order.getVehicleCost()+" tk");
                serva.setText(order.getServiceCost()+" tk");
                namea.setText(order.getUserName());
                // orderID.setText(order.getID());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
