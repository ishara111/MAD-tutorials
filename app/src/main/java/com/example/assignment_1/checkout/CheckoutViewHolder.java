package com.example.assignment_1.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;
import com.example.assignment_1.res_items.ResItemsViewHolder;

public class CheckoutViewHolder extends RecyclerView.ViewHolder{
    ImageView itemImg;
    TextView itemName;
    TextView itemPrice;
    Button addButton;
    FoodItem item;
    public CheckoutViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImg = itemView.findViewById(R.id.itemImg);
        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.itemPrice);
        addButton = itemView.findViewById(R.id.itemButton);
    }
}
