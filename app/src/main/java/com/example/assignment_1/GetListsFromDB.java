/**gets all the data from db and puts it into item or restauarnt list*/
package com.example.assignment_1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment_1.database.DatabaseCursor;
import com.example.assignment_1.database.DatabaseSchema;
import com.example.assignment_1.models.FoodItem;
import com.example.assignment_1.models.ResDB;
import com.example.assignment_1.models.Restaurant;

import java.util.ArrayList;

public class GetListsFromDB {
    ArrayList<FoodItem> items;
    ArrayList<Restaurant> restaurants;
    SQLiteDatabase db;

    public GetListsFromDB(ArrayList<FoodItem> items, ArrayList<Restaurant> restaurants, SQLiteDatabase db) {
        this.items = items;
        this.restaurants = restaurants;
        this.db = db;


        getItemsFromDB();
        getRestaurantsFromDB();
    }



    private void getItemsFromDB(){

        //ArrayList<Order> tmp = new ArrayList<Order>();
        Cursor cursor = db.query(DatabaseSchema.ItemTable.NAME,null,null,null,null,null,null);
        DatabaseCursor databaseCursor = new DatabaseCursor(cursor);

        try{
            databaseCursor.moveToFirst();
            while(!databaseCursor.isAfterLast()){
                items.add(databaseCursor.getItem());
                databaseCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

    }

    private void getRestaurantsFromDB(){
        ArrayList<ResDB> res= new ArrayList<ResDB>();
        Cursor cursor = db.query(DatabaseSchema.RestaurantTable.NAME,null,null,null,null,null,null);
        DatabaseCursor databaseCursor = new DatabaseCursor(cursor);

        try{
            databaseCursor.moveToFirst();
            while(!databaseCursor.isAfterLast()){
                res.add(databaseCursor.getRestaurant());
                databaseCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        for (ResDB r: res) {
            restaurants.add(new Restaurant(r.name,r.img,getItemsForRes(r.name)));
        }

    }

    private ArrayList<FoodItem> getItemsForRes(String name){
        ArrayList<FoodItem> resFoodList = new ArrayList<FoodItem>();
        for (FoodItem f : items) {
            if(f.restaurant.equals(name)){
                resFoodList.add(f);
            }
        }
        return resFoodList;
    }
}
