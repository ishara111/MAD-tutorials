package com.example.tutorial_4and5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectorAdapter extends RecyclerView.Adapter<SelectorViewHolder>{
    StructureData sd;

    @NonNull
    @Override
    public SelectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_selection,parent,false);
        SelectorViewHolder selectorViewHolder = new SelectorViewHolder(view);
        return selectorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectorViewHolder holder, int position) {
        holder.selectIcon.setImageResource(sd.get().get(position).getDrawableId());

        holder.selectText.setText(sd.get().get(position).getLabel());

    }

    @Override
    public int getItemCount() {
        return sd.get().size();
    }
}
