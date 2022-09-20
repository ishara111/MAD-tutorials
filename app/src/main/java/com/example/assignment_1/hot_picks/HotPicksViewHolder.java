package com.example.assignment_1.hot_picks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.AddToBasket_fragment;
import com.example.assignment_1.R;

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
        addButton = itemView.findViewById(R.id.itemButton);

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(null,"clicked");
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddToBasket_fragment()).commit();
//            }
//        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddToBasket_fragment addtoBasketFrag = new AddToBasket_fragment();
                Bundle args = new Bundle();
                args.putString("name",itemName.getText().toString());
                args.putString("price",itemPrice.getText().toString());
                addtoBasketFrag.setArguments(args);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,addtoBasketFrag).addToBackStack(null).commit();
            }
        });
    }
}
