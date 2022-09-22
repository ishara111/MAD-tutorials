package com.example.assignment_1.order_history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.History;
import com.example.assignment_1.Order;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryViewHolder>{
    ArrayList<History> historyList;

    public OrderHistoryAdapter(ArrayList<History> historyList)
    {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_list,parent,false);
        OrderHistoryViewHolder orderHistoryAdapter = new OrderHistoryViewHolder(view);
        return orderHistoryAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        holder.orderNum.setText(String.valueOf(historyList.get(position).id));
        //holder.orderPrice.setText(String.valueOf(orderList.get(position).itemPrice));

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
