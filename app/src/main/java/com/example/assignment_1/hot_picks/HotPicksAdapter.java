package com.example.assignment_1.hot_picks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.R;

import java.util.ArrayList;

public class HotPicksAdapter extends RecyclerView.Adapter<HotPicksViewHolder>{
    ArrayList<FoodItem> items;

    public HotPicksAdapter(ArrayList<FoodItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HotPicksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        HotPicksViewHolder hotPicksViewHolder = new HotPicksViewHolder(view);
        return hotPicksViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotPicksViewHolder holder, int position) {

        holder.itemImg.setImageResource(items.get(position).img);
        holder.itemName.setText(items.get(position).name);
        holder.itemPrice.setText(String.valueOf(items.get(position).priceWithSign));
        holder.addButton.setText("Add");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
