package com.example.assignment_2_part_b.single_image;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_b.R;

public class SingleImageViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    public SingleImageViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.singleImg);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
