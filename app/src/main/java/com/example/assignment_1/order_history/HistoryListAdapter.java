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
import java.util.Locale;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListViewHolder>{
    ArrayList<Order> orderList;

    public HistoryListAdapter(ArrayList<Order> orderList)
    {
        this.orderList = orderList;
    }
    @NonNull
    @Override
    public HistoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.history_list,parent,false);
        HistoryListViewHolder historyListViewHolder = new HistoryListViewHolder(view);
        return historyListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryListViewHolder holder, int position) {
        holder.itemAmount.setText(String.valueOf(orderList.get(position).itemAmount)+"X");
        holder.itemImg.setImageResource(orderList.get(position).itemImg);
        holder.itemName.setText(orderList.get(position).itemName);
        holder.itemTotal.setText("$"+String.valueOf(orderList.get(position).itemTotalPrice));
        holder.restaurant.setText(orderList.get(position).restaurant);

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
