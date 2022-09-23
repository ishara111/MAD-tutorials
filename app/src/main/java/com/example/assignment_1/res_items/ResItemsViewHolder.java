package com.example.assignment_1.res_items;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.AddToBasket_fragment;
import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;

public class ResItemsViewHolder extends RecyclerView.ViewHolder{
    ImageView itemImg;
    TextView itemName;
    TextView itemPrice;
    Button addButton;
    FoodItem item;
    public ResItemsViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImg = itemView.findViewById(R.id.itemImg);
        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.itemPrice);
        addButton = itemView.findViewById(R.id.itemButton);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddToBasket_fragment addtoBasketFrag = new AddToBasket_fragment();
                Bundle args = new Bundle();
                args.putString("title","Add To Basket");
                args.putString("amount","1");
                args.putString("name",itemName.getText().toString());
                args.putString("price",itemPrice.getText().toString());
                args.putString("totalPrice",String.valueOf(item.totPrice));
                args.putString("img",itemImg.getTag().toString());
                args.putString("res",item.restaurant);
                args.putString("update","false");
                addtoBasketFrag.setArguments(args);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,addtoBasketFrag).addToBackStack(null).commit();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}
