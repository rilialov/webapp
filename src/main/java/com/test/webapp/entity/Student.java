package com.test.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")

public class Student extends Man {

    @Column(name = "first_name_ed")
    private String firstName_ed;

    @Column(name = "last_name_ed")
    private String lastName_ed;

    @Column(name = "phone_ed")
    private String phone_ed;

    @Column(name = "email_ed")
    private String email_ed;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public String getFirstName_ed() {
        return firstName_ed;
    }

    public void setFirstName_ed(String firstName_ed) {
        this.firstName_ed = firstName_ed;
    }

    public String getLastName_ed() {
        return lastName_ed;
    }

    public void setLastName_ed(String lastName_ed) {
        this.lastName_ed = lastName_ed;
    }

    public String getPhone_ed() {
        return phone_ed;
    }

    public void setPhone_ed(String phone_ed) {
        this.phone_ed = phone_ed;
    }

    public String getEmail_ed() {
        return email_ed;
    }

    public void setEmail_ed(String email_ed) {
        this.email_ed = email_ed;
    }
}
