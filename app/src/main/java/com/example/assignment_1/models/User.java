package com.example.assignment_1.models;

public class User {
    public int userid;
    public String email;
    public String password;
    private static int nextId = 0;

    public User(String email, String password) {
        this(nextId,email,password);
        nextId++;
    }

    public User(int userid, String email, String password) {
        this.userid = userid;
        this.email = email;
        this.password = password;
    }
}
