package com.test.webapp.model;

public class Trainer extends Man {
    private int id;

    public Trainer(String firstName, String lastName) {
        super.firstName = firstName;
        super.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}