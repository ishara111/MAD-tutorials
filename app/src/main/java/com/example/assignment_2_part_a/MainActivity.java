package com.example.assignment_2_part_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignment_2_part_a.users.UsersFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<User>();
        users.add(new User("one"));
        users.add(new User("one"));
        users.add(new User("one"));
        users.add(new User("one"));
        users.add(new User("one"));
        users.add(new User("one"));
        users.add(new User("one"));


        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,new UsersFragment(users)).commit();
    }
}