package com.example.assignment_1.restaurants;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.R;
import com.example.assignment_1.Restaurant;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder>{

    ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(view);
        return restaurantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {

        holder.items = restaurants.get(position).items;
        holder.resImg.setImageResource(restaurants.get(position).img);
        holder.resName.setText(restaurants.get(position).name);
        holder.no_text.setText("");
        holder.viewButton.setText("View");
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
