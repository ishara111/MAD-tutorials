package com.example.assignment_1.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.Checkout;
import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;
import com.example.assignment_1.res_items.ResItemsViewHolder;

import java.util.ArrayList;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutViewHolder>{
    ArrayList<Checkout> checkoutList;

    public CheckoutAdapter(ArrayList<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
    }
    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        CheckoutViewHolder checkoutViewHolder = new CheckoutViewHolder(view);
        return checkoutViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        //holder.item = checkoutList.get(position);
        //holder.itemImg.setImageResource(checkoutList.get(position).item);
        //holder.itemImg.setTag(checkoutList.get(position).img);
        holder.itemName.setText(checkoutList.get(position).itemName);
        holder.itemPrice.setText("$"+String.valueOf(checkoutList.get(position).itemPrice));
        holder.addButton.setText("Test");
    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }
}
