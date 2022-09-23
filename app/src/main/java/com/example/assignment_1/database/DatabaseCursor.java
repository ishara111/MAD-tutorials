package com.example.assignment_1.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.assignment_1.FoodItem;
import com.example.assignment_1.Order;
import com.example.assignment_1.ResDB;
import com.example.assignment_1.User;

public class DatabaseCursor extends CursorWrapper {
    public DatabaseCursor(Cursor cursor) {
        super(cursor);
    }

    public FoodItem getItem()
    {
        String name = getString(getColumnIndex(DatabaseSchema.ItemTable.Cols.NAME));
        int image = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.ItemTable.Cols.IMAGE)));
        String restaurant = getString(getColumnIndex(DatabaseSchema.ItemTable.Cols.RESTAURANT));
        double price = Double.parseDouble(getString(getColumnIndex(DatabaseSchema.ItemTable.Cols.PRICE)));
        //double totalPrice = Double.parseDouble(getString(getColumnIndex(DatabaseSchema.ItemTable.Cols.TOTPRICE)));

        return new FoodItem(name,image,restaurant,price);
    }

    public ResDB getRestaurant()
    {
        String name = getString(getColumnIndex(DatabaseSchema.RestaurantTable.Cols.NAME));
        int img = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.RestaurantTable.Cols.IMAGE)));

        return new ResDB(name,img);
    }

    public User getUser()
    {
        int userId = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.ID)));
        String email = getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.EMAIL));
        String password = getString(getColumnIndex(DatabaseSchema.UsersTable.Cols.PASSWORD));

        return new User(userId,email,password);
    }

    public Order getOrder()
    {
        int orderId = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_ID)));
        String name = getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_NAME));
        double price = Double.parseDouble(getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_PRICE)));
        double totalPrice = Double.parseDouble(getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_TOTAL_PRICE)));
        int amount = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_AMOUNT)));
        int image = Integer.parseInt(getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_IMG)));
        String restaurant = getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.ITEM_RESTAURANT));
        String username = getString(getColumnIndex(DatabaseSchema.OrdersTable.Cols.USERNAME));

        return new Order(orderId+1,name,price,totalPrice,amount,image,restaurant,username);

    }
}
