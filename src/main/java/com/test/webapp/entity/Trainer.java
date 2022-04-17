package com.test.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainer extends Man {

    public Trainer() {
    }

    public Trainer(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

}