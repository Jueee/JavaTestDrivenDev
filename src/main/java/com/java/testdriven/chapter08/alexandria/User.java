package com.java.testdriven.chapter08.alexandria;

public class User {
    private final String name;
    private int id;

    public User(String name) {

        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
