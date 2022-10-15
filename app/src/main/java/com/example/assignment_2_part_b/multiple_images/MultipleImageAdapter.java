package com.example.assignment_2_part_b.multiple_images;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_b.R;
import com.example.assignment_2_part_b.single_image.SingleImageViewHolder;

import java.util.ArrayList;

public class MultipleImageAdapter extends RecyclerView.Adapter<MultipleImageViewHolder>{
    ArrayList<Bitmap> images;

    public MultipleImageAdapter(ArrayList<Bitmap> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public MultipleImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.multi_list,parent,false);
        MultipleImageViewHolder multipleImageViewHolder = new MultipleImageViewHolder(view);
        return multipleImageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleImageViewHolder holder, int position) {
        if(position==0)
        {
            holder.image1.setImageBitmap(images.get(position));
            holder.image2.setImageBitmap(images.get(position+1));
        }
        else
        {
            holder.image1.setImageBitmap(images.get(position+1));
            holder.image2.setImageBitmap(images.get(position+2));
        }
    }

    @Override
    public int getItemCount() {
        if(images.size()% 2 == 0)
        {
            if(images.size()>15)
            {
                return 7;
            }
            else
            {
                return images.size()/2;
            }
        }
        else
        {
            if(images.size()-1 >14)
            {
                return 7;
            }
            else
            {
                return images.size() - 1 /2;
            }
        }

    }
}
