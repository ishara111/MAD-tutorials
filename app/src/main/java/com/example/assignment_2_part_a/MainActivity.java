/**
 * Name: Ishara Gomes
 * ID: 20534521
 * Assignment 2 Part A
 * **/
package com.example.assignment_2_part_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.assignment_2_part_a.posts.Post;
import com.example.assignment_2_part_a.posts.PostsFragment;
import com.example.assignment_2_part_a.users.User;
import com.example.assignment_2_part_a.users.UsersFragment;
import com.example.assignment_2_part_a.users.UsersTaskHandler;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    public ArrayList<User> users;
    public ArrayList<Post> posts;
    public ExecutorService executorService = Executors.newSingleThreadExecutor();
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        users = new ArrayList<User>();
        posts = new ArrayList<Post>();

        UsersTaskHandler usersTaskHandler = new UsersTaskHandler(this,MainActivity.this,users,progressBar);
        executorService.execute(usersTaskHandler);



    }

    public void startUsersFrag()
    {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,new UsersFragment(users)).commit();
    }

    public void startPostsFrag()
    {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,new PostsFragment(posts)).addToBackStack(null).commit();
    }
}