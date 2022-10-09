package com.example.assignment_2_part_a.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2_part_a.R;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder>{
    ArrayList<Post> posts;

    public PostsAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_list,parent,false);
        PostsViewHolder postsViewHolder = new PostsViewHolder(view);
        return postsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.title.setText(posts.get(position).title);
        holder.body.setText(posts.get(position).body);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
