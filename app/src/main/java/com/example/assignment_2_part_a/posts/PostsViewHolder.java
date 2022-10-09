package com.example.assignment_2_part_a.posts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_a.R;

public class PostsViewHolder extends RecyclerView.ViewHolder{
    TextView title,body;
    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
    }
}
