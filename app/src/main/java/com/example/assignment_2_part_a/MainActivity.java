package com.example.assignment_2_part_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.assignment_2_part_a.users.User;
import com.example.assignment_2_part_a.users.UsersFragment;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        users = new ArrayList<User>();

        TaskHandler taskHandler = new TaskHandler(this,MainActivity.this,users,progressBar);
        executorService.execute(taskHandler);



    }

    public void startUsersFrag()
    {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,new UsersFragment(users)).commit();
    }
}