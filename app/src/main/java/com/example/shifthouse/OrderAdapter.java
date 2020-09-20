package com.example.shifthouse;

import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

private Context Context;
private List<Order> orders;

String LastMessage;

public OrderAdapter(Context Context,List<Order> orders){
        this.orders=orders;
        this.Context=Context;

        }

@NonNull
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View view=LayoutInflater.from(Context).inflate(R.layout.order_item,parent,false);
    return new ViewHolder(view);
}


@Override
public void onBindViewHolder(@NonNull ViewHolder holder,int position){

        final Order order=orders.get(position);
        holder.username.setText(order.getUserName());

        holder.orderID.setText(order.getID());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){
        Intent intent=new Intent(Context, showOrderActivity.class);
        intent.putExtra("orderid",order.getID());
        Context.startActivity(intent);
        }
        });
        }

@Override
public int getItemCount(){
        return orders.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView username;
    public TextView orderID ;


    public ViewHolder(View itemView) {
        super(itemView);

        username = itemView.findViewById(R.id.username);
        orderID = itemView.findViewById(R.id.order_id);

    }
}
}

