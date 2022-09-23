package com.example.assignment_1.restaurants;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;
import com.example.assignment_1.res_items.ResItems_fragment;

import java.util.ArrayList;

public class RestaurantViewHolder extends RecyclerView.ViewHolder{
    ImageView resImg;
    TextView resName;
    TextView no_text;
    ArrayList<FoodItem> items;
    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);
        resImg = itemView.findViewById(R.id.itemImg);
        resName = itemView.findViewById(R.id.itemName);
        no_text = itemView.findViewById(R.id.itemPrice);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ResItems_fragment(items,resName.getText().toString()))
                        .addToBackStack(null).commit();
            }
        });
    }
}
