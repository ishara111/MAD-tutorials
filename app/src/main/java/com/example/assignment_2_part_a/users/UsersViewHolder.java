package com.example.assignment_2_part_a.users;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_a.R;

public class UsersViewHolder extends RecyclerView.ViewHolder{
    TextView username;
    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
