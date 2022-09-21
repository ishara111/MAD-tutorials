package com.example.assignment_1.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.Checkout;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutViewHolder>{
    ArrayList<Checkout> checkoutList;
    double allTotalPrice;

    public CheckoutAdapter(ArrayList<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
        this.allTotalPrice = 0;
    }
    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.checkout_list,parent,false);
        CheckoutViewHolder checkoutViewHolder = new CheckoutViewHolder(view);
        return checkoutViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        //holder.item = checkoutList.get(position);
        //holder.itemImg.setImageResource(checkoutList.get(position).item);
        //holder.itemImg.setTag(checkoutList.get(position).img);
        holder.checkoutList = checkoutList;
        holder.checkoutItem = checkoutList.get(position);
        holder.itemName.setText(checkoutList.get(position).itemName);
        holder.itemTotal.setText("$"+String.valueOf(checkoutList.get(position).totalPrice));
        holder.itemAmount.setText(String.valueOf(checkoutList.get(position).itemAmount)+" X");
        holder.itemImg.setImageResource(checkoutList.get(position).itemImg);
    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }
}
