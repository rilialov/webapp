package com.test.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Man {

    public Student() {
    }

    public Student(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

}
