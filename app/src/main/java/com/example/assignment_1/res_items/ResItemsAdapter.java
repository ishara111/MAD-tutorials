package com.example.assignment_1.res_items;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class ResItemsAdapter extends RecyclerView.Adapter<ResItemsViewHolder>{
    ArrayList<FoodItem> items;

    public ResItemsAdapter(ArrayList<FoodItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ResItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        ResItemsViewHolder hotPicksViewHolder = new ResItemsViewHolder(view);
        return hotPicksViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResItemsViewHolder holder, int position) {

        holder.item = items.get(position);
        holder.itemImg.setImageResource(items.get(position).img);
        holder.itemImg.setTag(items.get(position).img);
        holder.itemName.setText(items.get(position).name);
        holder.itemPrice.setText("$"+String.valueOf(items.get(position).price));
        holder.addButton.setText("Add");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
