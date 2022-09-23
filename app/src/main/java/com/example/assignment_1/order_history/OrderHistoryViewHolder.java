package com.example.assignment_1.order_history;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.Order;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class OrderHistoryViewHolder extends RecyclerView.ViewHolder{
    TextView orderNum,orderPrice;
    ArrayList<Order> orderList;
    String id;
    String total;
    public OrderHistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        orderNum = itemView.findViewById(R.id.order_item_name);
        orderPrice = itemView.findViewById(R.id.order_item_price);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HistoryList_fragment(orderList,id,total)).addToBackStack(null).commit();
            }
        });
    }
}
