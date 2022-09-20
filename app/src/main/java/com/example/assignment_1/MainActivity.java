package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<FoodItem> items;
    ArrayList<Restaurant> restaurants;

    public MainActivity()
    {
        items = new ArrayList<FoodItem>();
        restaurants = new ArrayList<Restaurant>();
        GenerateLists fil = new GenerateLists(items, restaurants);
        Collections.shuffle(items);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HotPicks_fragment(items)).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment frag = null;
            if (item.getItemId()==R.id.nav_hot_picks){
                frag = new HotPicks_fragment(items);
            }else if (item.getItemId()==R.id.nav_restaurants){
                frag = new Restaurant_fragment(restaurants);
            }else if (item.getItemId()==R.id.nav_order_history){
                frag = new OrderHistory_fragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,frag).commit();
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.checkout_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.checkout_icon_menu)
        {
            Toast.makeText(this,"checjout",Toast.LENGTH_SHORT).show();
        }
//        switch (item.getItemId()){
//            case  R.id.checkout_icon_menu:
//                Toast.makeText(this,"checjout",Toast.LENGTH_SHORT);
//        }
        return super.onOptionsItemSelected(item);
    }
}