/**Name: Ishara Gomes         *
*Id: 20534521
* Assignment-1
 *******************************/
package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.assignment_1.checkout.Checkout_fragment;
import com.example.assignment_1.database.DatabaseHelper;
import com.example.assignment_1.login.Login_fragment;
import com.example.assignment_1.models.Checkout;
import com.example.assignment_1.models.FoodItem;
import com.example.assignment_1.models.History;
import com.example.assignment_1.models.Restaurant;
import com.example.assignment_1.res_items.ResItems_fragment;
import com.example.assignment_1.order_history.OrderHistory_fragment;
import com.example.assignment_1.restaurants.Restaurant_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<FoodItem> topPicksList;
    ArrayList<FoodItem> items;
    ArrayList<Restaurant> restaurants;
    public ArrayList<Checkout> checkoutList;
    public ArrayList<History> historyList;
    public boolean loggedIn;
    public String loggedUserName;
    SQLiteDatabase db;

    public MainActivity()
    {
        loggedIn = false;
        loggedUserName = "";
        historyList = new ArrayList<History>();
        items = new ArrayList<FoodItem>();
        restaurants = new ArrayList<Restaurant>();
        checkoutList = new ArrayList<Checkout>();
        topPicksList = new ArrayList<FoodItem>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(getApplicationContext()).getWritableDatabase();  //creates all tables and inserts all data to db
        GetListsFromDB fil = new GetListsFromDB(items, restaurants,db);//gets required data from db

        Collections.shuffle(items);
        for (int i = 0; i < 15; i++) {
            topPicksList.add(items.get(i));  //list for the random top picks
        }


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ResItems_fragment(topPicksList,"")).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {  //bottom navigation menu
            Fragment frag = null;
            if (item.getItemId()==R.id.nav_top_picks){
                frag = new ResItems_fragment(topPicksList,"");
            }else if (item.getItemId()==R.id.nav_restaurants){
                frag = new Restaurant_fragment(restaurants);
            }else if (item.getItemId()==R.id.nav_order_history){
                if (loggedIn == false)
                {
                    frag = new Login_fragment(true);
                }
                else{
                    frag = new OrderHistory_fragment(historyList);
                }
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  //action menu
        if (item.getItemId()==R.id.checkout_icon_menu)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Checkout_fragment(checkoutList))
                    .addToBackStack(null).commit();
        }
        else if(item.getItemId()==R.id.login_icon_menu)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Login_fragment(false))
                    .addToBackStack(null).commit();
        }
        else if(item.getItemId()==R.id.logout_icon_menu)
        {
            loggedIn =false;
            loggedUserName = "";
        }
        return super.onOptionsItemSelected(item);
    }
}