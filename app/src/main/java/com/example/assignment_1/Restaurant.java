package com.example.assignment_1;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    public int img;
    public ArrayList<FoodItem> items;

    public Restaurant(String name, int img, ArrayList<FoodItem> items) {
        this.name = name;
        this.img = img;
        this.items = items;
    }
}

//ADD LOGIN FRAGMENT , FOOD ITEM LIST FRAGMENT , ADD TO CART(WILL HAVE BUTTON TO CONT BROWSING AND + - BUTTON ALSO) FRAGMENT
// CHECKOUT WILL BE FRAGMENT OR ACTIVITY DEPENDING ON ACTIVITY AMOUNT
