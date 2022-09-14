package com.example.tutorial_4and5;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapViewHolder extends RecyclerView.ViewHolder{
    ImageView t1,t2,t3,t4,tCover;
    public MapViewHolder(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);
        t3 = itemView.findViewById(R.id.t3);
        t4 = itemView.findViewById(R.id.t4);
        tCover = itemView.findViewById(R.id.tCover);
    }
}
