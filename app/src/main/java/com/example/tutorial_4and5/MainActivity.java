package com.example.tutorial_4and5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager selectFrag = getSupportFragmentManager();
        Selector selector = (Selector) selectFrag.findFragmentById(R.id.selector);
        if (selector == null){
            selector = new Selector();
            selectFrag.beginTransaction().add(R.id.selector, selector).commit();
        }

        FragmentManager mapfrag = getSupportFragmentManager();
        Map map = (Map) mapfrag.findFragmentById(R.id.map);
        if (map == null){
            map = new Map();
            mapfrag.beginTransaction().add(R.id.map, map).commit();
        }


    }
}