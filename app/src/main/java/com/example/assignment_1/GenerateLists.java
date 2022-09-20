package com.example.assignment_1;

import java.util.ArrayList;

public class GenerateLists {
    ArrayList<FoodItem> items;
    ArrayList<Restaurant> restaurants;

    public GenerateLists(ArrayList<FoodItem> items, ArrayList<Restaurant> restaurants) {
        this.items = items;
        this.restaurants = restaurants;

        generateItems();
        generateRestaurants();
    }

    private void generateItems(){
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC Donald's",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"KFC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC Donald's",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
        items.add(new FoodItem("milk",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("kiri",R.drawable.kfc,"MC",200));
        items.add(new FoodItem("biscut",R.drawable.kfc,"MC",600));
    }

    private void generateRestaurants(){

        restaurants.add(new Restaurant("KFC",R.drawable.kfc,getItemsForRes("KFC")));
        restaurants.add(new Restaurant("MC Donald's",R.drawable.kfc,getItemsForRes("MC Donald's")));

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
