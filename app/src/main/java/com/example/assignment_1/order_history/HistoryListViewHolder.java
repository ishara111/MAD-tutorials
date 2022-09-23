package com.example.assignment_1.order_history;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.R;

public class HistoryListViewHolder extends RecyclerView.ViewHolder{
    TextView restaurant;
    ImageView itemImg;
    TextView itemName;
    TextView itemAmount;
    TextView itemTotal;
    public HistoryListViewHolder(@NonNull View itemView) {
        super(itemView);
//        title = itemView.findViewById(R.id.history_text);
//        total = itemView.findViewById(R.id.history_all_total);
        itemImg = itemView.findViewById(R.id.history_itemImg);
        itemName = itemView.findViewById(R.id.history_itemName);
        itemTotal = itemView.findViewById(R.id.history_item_total);
        itemAmount = itemView.findViewById(R.id.history_itemAmount);
        restaurant = itemView.findViewById(R.id.history_restaurant);
    }
}
