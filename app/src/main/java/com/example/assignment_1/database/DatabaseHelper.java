package com.example.assignment_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.GenerateLists;
import com.example.assignment_1.R;
import com.example.assignment_1.ResDB;
import com.example.assignment_1.Restaurant;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "flash_delivery.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.ItemTable.NAME+"("+ DatabaseSchema.ItemTable.Cols.NAME+" TEXT, "
                + DatabaseSchema.ItemTable.Cols.IMAGE+" INTEGER, "
                + DatabaseSchema.ItemTable.Cols.RESTAURANT+" TEXT, "
                + DatabaseSchema.ItemTable.Cols.PRICE+" DOUBLE);");

        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.RestaurantTable.NAME+"("+ DatabaseSchema.RestaurantTable.Cols.NAME+" TEXT, "
                + DatabaseSchema.RestaurantTable.Cols.IMAGE+" INTEGER);");


        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.UsersTable.NAME+"("+ DatabaseSchema.UsersTable.Cols.ID+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.EMAIL+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.PASSWORD+" TEXT);");

        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.OrdersTable.NAME+"("+ DatabaseSchema.OrdersTable.Cols.ITEM_ID+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_NAME+" TEXT, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_PRICE+" DOUBLE, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_TOTAL_PRICE+" DOUBLE,"
                + DatabaseSchema.OrdersTable.Cols.ITEM_AMOUNT+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_IMG+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_RESTAURANT+" TEXT, "
                + DatabaseSchema.OrdersTable.Cols.USERNAME+" TEXT);");

        addItemsDB(sqLiteDatabase);
        addRestaurantsDB(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addItemsDB(SQLiteDatabase db)
    {
        ArrayList<FoodItem> genItems = new ArrayList<FoodItem>();
        genItems.add(new FoodItem("Fries", R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        genItems.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        genItems.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));
        genItems.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        genItems.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        genItems.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));
        genItems.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        genItems.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        genItems.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));
        genItems.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        genItems.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        genItems.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        genItems.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));


        for (FoodItem f:genItems) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.ItemTable.Cols.NAME, f.name);
            cv.put(DatabaseSchema.ItemTable.Cols.IMAGE, f.img);
            cv.put(DatabaseSchema.ItemTable.Cols.RESTAURANT, f.restaurant);
            cv.put(DatabaseSchema.ItemTable.Cols.PRICE, f.price);
            db.insert(DatabaseSchema.ItemTable.NAME, null, cv);
        }
    }

    public void addRestaurantsDB(SQLiteDatabase db)
    {
        ArrayList<ResDB> genRestaurants = new ArrayList<ResDB>();
        genRestaurants.add(new ResDB("KFC",R.drawable.kfc));
        genRestaurants.add(new ResDB("MC Donald's",R.drawable.mcdonalds));
        genRestaurants.add(new ResDB("Pizza Hut",R.drawable.pizzahut));
        genRestaurants.add(new ResDB("Burger King",R.drawable.burgerking));
        genRestaurants.add(new ResDB("Taco Bell",R.drawable.burgerking));

        for (ResDB r:genRestaurants) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.RestaurantTable.Cols.NAME, r.name);
            cv.put(DatabaseSchema.RestaurantTable.Cols.IMAGE, r.img);
            db.insert(DatabaseSchema.RestaurantTable.NAME, null, cv);
        }
    }

}
