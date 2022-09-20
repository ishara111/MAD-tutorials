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
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        items.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        items.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        items.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Chicken",R.drawable.kfc,"KFC",5.99));
        items.add(new FoodItem("Wings",R.drawable.kfcwings,"KFC",8.22));
        items.add(new FoodItem("Fries",R.drawable.mcfries,"MC Donald's",2));
        items.add(new FoodItem("Ice Cream",R.drawable.icecream,"MC Donald's",1.99));


    }

    private void generateRestaurants(){

        restaurants.add(new Restaurant("KFC",R.drawable.kfc,getItemsForRes("KFC")));
        restaurants.add(new Restaurant("MC Donald's",R.drawable.mcdonalds,getItemsForRes("MC Donald's")));
        restaurants.add(new Restaurant("Pizza Hut",R.drawable.pizzahut,getItemsForRes("Pizza Hut")));
        restaurants.add(new Restaurant("Burger King",R.drawable.burgerking,getItemsForRes("Burger King")));
        restaurants.add(new Restaurant("Taco Bell",R.drawable.burgerking,getItemsForRes("Taco Bell")));

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
