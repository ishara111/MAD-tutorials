package com.example.assignment_1.checkout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.AddToBasket_fragment;
import com.example.assignment_1.Checkout;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class CheckoutViewHolder extends RecyclerView.ViewHolder{
    ImageView itemImg;
    TextView itemName;
    TextView itemAmount;
    TextView itemTotal;
    TextView restaurant;
    Button delButton;
    Checkout checkoutItem;
    ArrayList<Checkout> checkoutList;
    public CheckoutViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImg = itemView.findViewById(R.id.checkout_itemImg);
        itemName = itemView.findViewById(R.id.checkout_itemName);
        itemTotal = itemView.findViewById(R.id.checkout_item_total);
        itemAmount = itemView.findViewById(R.id.checkout_itemAmount);
        restaurant = itemView.findViewById(R.id.checkout_restaurant);
        delButton = itemView.findViewById(R.id.checkout_delBtn);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddToBasket_fragment addtoBasketFrag = new AddToBasket_fragment();
                Bundle args = new Bundle();
                args.putString("title","Update Basket");
                args.putString("id",String.valueOf(checkoutItem.checkId));
                args.putString("amount",String.valueOf(checkoutItem.itemAmount));
                args.putString("name",checkoutItem.itemName);
                args.putString("price",checkoutItem.itemPrice.toString());
                args.putString("totalPrice",checkoutItem.totalPrice.toString());
                args.putString("img",String.valueOf(checkoutItem.itemImg));
                args.putString("res",checkoutItem.restaurant);
                args.putString("update","true");
                addtoBasketFrag.setArguments(args);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,addtoBasketFrag).addToBackStack(null).commit();
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkoutList.remove(checkoutItem);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment frag = null;
                frag = activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                activity.getSupportFragmentManager().beginTransaction().remove(frag).commit();
                activity.getSupportFragmentManager().popBackStack();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Checkout_fragment(checkoutList)).addToBackStack(null).commit();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Checkout_fragment(checkoutList))
                       // .addToBackStack(null).commit();
            }
        });
    }
}
