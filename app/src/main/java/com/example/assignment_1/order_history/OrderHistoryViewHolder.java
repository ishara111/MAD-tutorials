package com.example.assignment_1.order_history;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.R;

public class OrderHistoryViewHolder extends RecyclerView.ViewHolder{
    TextView orderNum,orderPrice;
    public OrderHistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        orderNum = itemView.findViewById(R.id.order_item_name);
        orderNum = itemView.findViewById(R.id.order_item_price);
    }
}
