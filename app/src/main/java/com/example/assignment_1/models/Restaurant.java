package com.example.assignment_1.models;

import java.util.ArrayList;

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
