package com.example.assignment_2_part_b.single_image;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_b.R;

import java.util.ArrayList;

public class SingleImageAdapter extends RecyclerView.Adapter<SingleImageViewHolder>{
    ArrayList<Bitmap> images;

    public SingleImageAdapter(ArrayList<Bitmap> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public SingleImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_list,parent,false);
        SingleImageViewHolder singleImageViewHolder = new SingleImageViewHolder(view);
        return singleImageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleImageViewHolder holder, int position) {
        holder.image.setImageBitmap(images.get(position));
    }

    @Override
    public int getItemCount() {
        if(images.size()>15)
        {
            return 15;
        }
        else
        {
            return images.size();
        }
    }
}
