package com.example.assignment_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotPicksViewHolder extends RecyclerView.ViewHolder{
    ImageView itemImg;
    TextView itemName;
    TextView itemPrice;
    Button addButton;
    public HotPicksViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImg = itemView.findViewById(R.id.itemImg);
        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.itemPrice);
        addButton = itemView.findViewById(R.id.item_add_button);
    }
}
