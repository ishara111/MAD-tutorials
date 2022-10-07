package com.example.assignment_2_part_a.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignment_2_part_a.R;

import com.example.assignment_2_part_a.User;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>{
    ArrayList<User> users;

    public UsersAdapter(ArrayList<User> users) {
        this.users = users;
    }
    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list,parent,false);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.username.setText(users.get(position).username.toString());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
