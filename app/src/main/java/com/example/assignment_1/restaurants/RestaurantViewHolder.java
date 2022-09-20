package com.example.assignment_1.restaurants;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.R;

public class RestaurantViewHolder extends RecyclerView.ViewHolder{
    ImageView resImg;
    TextView resName;
    TextView no_text;
    Button viewButton;
    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);
        resImg = itemView.findViewById(R.id.itemImg);
        resName = itemView.findViewById(R.id.itemName);
        no_text = itemView.findViewById(R.id.itemPrice);
        viewButton = itemView.findViewById(R.id.itemButton);
    }
}
