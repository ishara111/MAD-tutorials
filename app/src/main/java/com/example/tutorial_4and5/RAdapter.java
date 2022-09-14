package com.example.tutorial_4and5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RAdapter extends RecyclerView.Adapter<RviewHolder>{
    StructureData sd;

    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_selection,parent,false);
        RviewHolder rviewHolder = new RviewHolder(view);
        return rviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RviewHolder holder, int position) {
        holder.selectIcon.setImageResource(sd.get().get(position).getDrawableId());

        holder.selectText.setText(sd.get().get(position).getLabel());

    }

    @Override
    public int getItemCount() {
        return sd.get().size();
    }
}
