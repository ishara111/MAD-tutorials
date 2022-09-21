package com.example.assignment_1;

public class Checkout {
    public String itemName;
    public Double itemPrice;
    public int itemAmount;
    public Double totalPrice;
    public String Restaurant;

    public Checkout(String itemName, Double itemPrice, int itemAmount, Double totalPrice, String restaurant) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
        this.totalPrice = totalPrice;
        Restaurant = restaurant;
    }
}
