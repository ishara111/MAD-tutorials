package com.example.assignment_2_part_b.multiple_images;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_b.R;

public class MultipleImageViewHolder extends RecyclerView.ViewHolder{
    ImageView image1,image2;
    public MultipleImageViewHolder(@NonNull View itemView) {
        super(itemView);
        image1 = itemView.findViewById(R.id.multiImg1);
        image2 = itemView.findViewById(R.id.multiImg2);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
