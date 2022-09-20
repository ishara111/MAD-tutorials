package com.example.assignment_1;

public class FoodItem {
    public String name;
    public int img;
    public String restaurant;
    public String priceWithSign;
    public double price;


    public FoodItem(String name, int img, String restaurant, double price) {
        this.name = name;
        this.img = img;
        this.restaurant = restaurant;
        this.priceWithSign = "$"+price;
        this.price = price;
    }
}
