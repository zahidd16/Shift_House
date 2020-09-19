package com.example.shifthouse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showOrderActivity extends AppCompatActivity {

    TextView orderID,datea,desta,dista,sourcea,cargoa,vana,trucka,electra,plua,pnta,totta,veha,serva,namea,drname,drid,oname,oid,dcont,ocont,etim;
    DatabaseReference databaseReference;

    String orderid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
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
        drname=findViewById(R.id.dname);
        drid=findViewById(R.id.did);
        oname=findViewById(R.id.sname);
        oid=findViewById(R.id.sid);
        dcont=findViewById(R.id.dn);
        ocont=findViewById(R.id.addn);
        etim=findViewById(R.id.etime);



       Intent intent = getIntent();
       orderid = intent.getStringExtra("orderid");
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
                drname.setText("Drivers Name: "+order.getDriversName());
                drid.setText("Drivers Id: "+order.getDriversID());
                oname.setText("Other people :"+order.getServiceProvidersName());
                oid.setText("ID: "+order.getGetServiceProvidersID());
                dcont.setText("Drivers No.: "+order.getDriverNum());
                ocont.setText("Additional No.: "+order.getAdditionalNum());
                etim.setText("Time: "+order.geteTime());
               // orderID.setText(order.getID());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
