package com.example.assignment_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment_1.models.FoodItem;
import com.example.assignment_1.R;
import com.example.assignment_1.models.ResDB;

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
        genItems.add(new FoodItem("Big Mac", R.drawable.burger4,"MC Donald's",8.99));
            genItems.add(new FoodItem("McFries", R.drawable.mcfries,"MC Donald's",2.99));
        genItems.add(new FoodItem("McNugget", R.drawable.nuggets2,"MC Donald's",4.99));
        genItems.add(new FoodItem("McWings", R.drawable.wings4,"MC Donald's",3.99));
        genItems.add(new FoodItem("McSpicy", R.drawable.burger10,"MC Donald's",7.99));
        genItems.add(new FoodItem("McWrap", R.drawable.wrap,"MC Donald's",6.99));
        genItems.add(new FoodItem("Veg Burger", R.drawable.burger2,"MC Donald's",5.69));
        genItems.add(new FoodItem("McRice", R.drawable.rice,"MC Donald's",3.49));
        genItems.add(new FoodItem("McFlurry", R.drawable.icecream2,"MC Donald's",4.99));
        genItems.add(new FoodItem("McSmoothie", R.drawable.smoothie,"MC Donald's",7.99));

        genItems.add(new FoodItem("Bucket 8pcs", R.drawable.wings3,"KFC",7.99));
        genItems.add(new FoodItem("Bucket 10pcs", R.drawable.wings3,"KFC",12.99));
        genItems.add(new FoodItem("Bucket 12pcs", R.drawable.wings3,"KFC",16.26));
        genItems.add(new FoodItem("Fries", R.drawable.fries4,"KFC",3.55));
        genItems.add(new FoodItem("Wings", R.drawable.wings1,"KFC",4.99));
        genItems.add(new FoodItem("Nuggets", R.drawable.nuggets,"KFC",7.99));
        genItems.add(new FoodItem("KFC Rice", R.drawable.rice2,"KFC",5.99));

        genItems.add(new FoodItem("Chicken Pizza", R.drawable.pizza1,"Pizza Hut",8.99));
        genItems.add(new FoodItem("Hawaiian Pizza", R.drawable.pizza2,"Pizza Hut",7.99));
        genItems.add(new FoodItem("BBQ Pizza", R.drawable.pizza3,"Pizza Hut",10.99));
        genItems.add(new FoodItem("Cheese Pizza", R.drawable.pizza4,"Pizza Hut",6.99));
        genItems.add(new FoodItem("Tomato Pizza", R.drawable.pizza5,"Pizza Hut",2.99));
        genItems.add(new FoodItem("Sausage Pizza", R.drawable.pizza6,"Pizza Hut",5.99));
        genItems.add(new FoodItem("Bacon Pizza", R.drawable.pizza7,"Pizza Hut",6.99));

        genItems.add(new FoodItem("Chicken Burger", R.drawable.burger1,"Burger King",9.99));
        genItems.add(new FoodItem("Cheese Burger", R.drawable.burger6,"Burger King",8.99));
        genItems.add(new FoodItem("Double Burger", R.drawable.burger9,"Burger King",12.99));
        genItems.add(new FoodItem("Veg Burger", R.drawable.burger2,"Burger King",11.99));
        genItems.add(new FoodItem("Chicken Wings", R.drawable.wings2,"Burger King",4.99));
        genItems.add(new FoodItem("Buffalo Wings", R.drawable.wings1,"Burger King",5.99));
        genItems.add(new FoodItem("Fries", R.drawable.fries3,"Burger King",2.99));

        genItems.add(new FoodItem("Soft Taco", R.drawable.tacos2,"Taco Bell",7.99));
        genItems.add(new FoodItem("Hard Taco", R.drawable.tacos4,"Taco Bell",6.99));
        genItems.add(new FoodItem("Crispy Taco", R.drawable.tacos3,"Taco Bell",5.99));
        genItems.add(new FoodItem("Burrito", R.drawable.burrito,"Taco Bell",12.99));
        genItems.add(new FoodItem("Cheese Nachos", R.drawable.nachos2,"Taco Bell",9.99));
        genItems.add(new FoodItem("Spicy Nachos", R.drawable.nachos1,"Taco Bell",4.99));
        genItems.add(new FoodItem("Quesadillas", R.drawable.quesadilla,"Taco Bell",3.99));

        genItems.add(new FoodItem("Pepperoni Pizza", R.drawable.pizza9,"Dominos pizza",9.99));
        genItems.add(new FoodItem("Stuffed Pizza", R.drawable.pizza10,"Dominos pizza",8.99));
        genItems.add(new FoodItem("Combo Pizza", R.drawable.pizza1,"Dominos pizza",11.99));
        genItems.add(new FoodItem("Meat Pizza", R.drawable.pizza3,"Dominos pizza",14.99));

        genItems.add(new FoodItem("Chicken 2pcs", R.drawable.wings3,"Pop Eyes",3.99));
        genItems.add(new FoodItem("Chicken 4pcs", R.drawable.wings3,"Pop Eyes",5.99));
        genItems.add(new FoodItem("Chicken 6pcs", R.drawable.wings3,"Pop Eyes",7.99));
        genItems.add(new FoodItem("Chicken 8pcs", R.drawable.wings3,"Pop Eyes",9.99));
        genItems.add(new FoodItem("Chicken 10pcs", R.drawable.wings3,"Pop Eyes",14.99));

        genItems.add(new FoodItem("Chicken Burger", R.drawable.burger5,"In N Out",7.99));
        genItems.add(new FoodItem("Cheese Burger", R.drawable.burger3,"In N Out",9.99));
        genItems.add(new FoodItem("Beef Burger", R.drawable.burger7,"In N Out",8.99));
        genItems.add(new FoodItem("Double Burger", R.drawable.burger11,"In N Out",12.99));
        genItems.add(new FoodItem("Combo Burger", R.drawable.burger8,"In N Out",16.99));

        genItems.add(new FoodItem("Submarine 1ft", R.drawable.submarine1,"Subway",4.99));
        genItems.add(new FoodItem("Submarine 2ft", R.drawable.submarine2,"Subway",9.99));
        genItems.add(new FoodItem("Fries", R.drawable.fries2,"Subway",3.99));
        genItems.add(new FoodItem("Ice Cream", R.drawable.icecream,"Subway",2.99));

        genItems.add(new FoodItem("Ice Cone", R.drawable.icecream,"Baskin Robins",2.99));
        genItems.add(new FoodItem("Ice cream Mix", R.drawable.icecream3,"Baskin Robins",3.99));
        genItems.add(new FoodItem("Sundae", R.drawable.icecream4,"Baskin Robins",6.99));
        genItems.add(new FoodItem("Ice Combo", R.drawable.icecream5,"Baskin Robins",9.99));

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
        genRestaurants.add(new ResDB("MC Donald's",R.drawable.mcdonalds));
        genRestaurants.add(new ResDB("KFC",R.drawable.kfc));
        genRestaurants.add(new ResDB("Pizza Hut",R.drawable.pizzahut));
        genRestaurants.add(new ResDB("Burger King",R.drawable.burgerking));
        genRestaurants.add(new ResDB("Taco Bell",R.drawable.tacos1));
        genRestaurants.add(new ResDB("Dominos pizza",R.drawable.dominos));
        genRestaurants.add(new ResDB("Pop Eyes",R.drawable.burgerking));
        genRestaurants.add(new ResDB("In N Out",R.drawable.in_n_out));
        genRestaurants.add(new ResDB("Subway",R.drawable.subway));
        genRestaurants.add(new ResDB("Baskin Robins",R.drawable.baskinrobins));

        for (ResDB r:genRestaurants) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.RestaurantTable.Cols.NAME, r.name);
            cv.put(DatabaseSchema.RestaurantTable.Cols.IMAGE, r.img);
            db.insert(DatabaseSchema.RestaurantTable.NAME, null, cv);
        }
    }

}
