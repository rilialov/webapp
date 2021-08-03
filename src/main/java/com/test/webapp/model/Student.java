package com.test.webapp.model;

public class Student extends Man {
    private int id;
    private String phone;
    private String email;
    private String firstName_ed;
    private String lastName_ed;
    private String phone_ed;
    private String email_ed;

    public Student(String firstName, String lastName) {
        super.firstName = firstName;
        super.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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