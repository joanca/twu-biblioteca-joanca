package com.twu.biblioteca.models;

public class User {
    private String name;
    private int userID;

    public User(String name, int ID) {
        this.name = name;
        this.userID = ID;
    }

    public String getName() {
        return this.name;
    }

    public int getUserID() {
        return this.userID;
    }
}
