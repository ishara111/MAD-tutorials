package com.example.tutorial_4and5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapAdapter extends RecyclerView.Adapter<MapViewHolder>{
    MapData md;
    @NonNull
    @Override
    public MapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.grid_cell,parent,false);
        MapViewHolder mapViewHolder = new MapViewHolder(view);
        int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = size;
        lp.height = size;
        return mapViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MapViewHolder holder, int position) {
        int row = position % MapData.HEIGHT;
        int col = position / MapData.HEIGHT;
        holder.t1.setImageResource(md.get().get(row,col).getNorthWest());
        holder.t2.setImageResource(md.get().get(row,col).getNorthEast());
        holder.t3.setImageResource(md.get().get(row,col).getSouthWest());
        holder.t4.setImageResource(md.get().get(row,col).getSouthEast());
        //holder.tCover.setImageResource(md.get().get(row,col).getStructure().getDrawableId());
    }

    @Override
    public int getItemCount() {
        return (md.HEIGHT*md.WIDTH);
    }
}
