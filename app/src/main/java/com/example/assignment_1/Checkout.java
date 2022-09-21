package com.example.assignment_1;

public class Checkout {
    public int checkId;
    public String itemName;
    public Double itemPrice;
    public int itemAmount;
    public Double totalPrice;
    public String restaurant;
    public int itemImg;
    private static int nextId = 0;

    public Checkout(String itemName, Double itemPrice, int itemAmount, Double totalPrice, String restaurant,int itemImg) {

        this(nextId,itemName,itemPrice,itemAmount,totalPrice,restaurant,itemImg);
        nextId++;
    }
    public Checkout(int checkId,String itemName, Double itemPrice, int itemAmount, Double totalPrice, String restaurant,int itemImg) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
        this.totalPrice = totalPrice;
        this.restaurant = restaurant;
        this.itemImg = itemImg;
        this.checkId = checkId;
    }

}
