package com.example.assignment_1.models;

public class Order {
    public int orderId;
    public String itemName;
    public double itemPrice;
    public double itemTotalPrice;
    public int itemAmount;
    public int itemImg;
    public String restaurant;
    public String username;

    public Order(int orderId, String itemName, double itemPrice, double itemTotalPrice, int itemAmount, int itemImg, String restaurant,String username) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemTotalPrice = itemTotalPrice;
        this.itemAmount = itemAmount;
        this.itemImg = itemImg;
        this.restaurant = restaurant;
        this.username = username;
    }
}
