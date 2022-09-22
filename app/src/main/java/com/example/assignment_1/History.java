package com.example.assignment_1;

import java.util.ArrayList;

public class History {
    public int id;
    public ArrayList<Order> orderList;

    public History(int id, ArrayList<Order> orderList) {
        this.id = id;
        this.orderList = orderList;
    }
}
