package com.example.tutorial_4and5;

import androidx.appcompat.app.AppCompatActivity;
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
        recycView = (RecyclerView) findViewById(R.id.mapRecyclerView);
        recycView.setLayoutManager(new GridLayoutManager(
                getActivity(),
                MapData.HEIGHT,
                GridLayoutManager.HORIZONTAL,
                false));

        //int row = position % MapData.HEIGHT;
        //int col = position / MapData.HEIGHT;

    }

    private Activity getActivity() {
        return null;
    }
}