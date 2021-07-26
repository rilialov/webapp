package com.test.webapp.model;

public class Student extends Man {
    private long phone;
    private String email;
    private String firstName_ed;
    private String lastName_ed;
    private long phone_ed;
    private String email_ed;

    public Student(String firstName, String lastName) {
        super.firstName = firstName;
        super.lastName = lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    public long getPhone_ed() {
        return phone_ed;
    }

    public void setPhone_ed(long phone_ed) {
        this.phone_ed = phone_ed;
    }

    public String getEmail_ed() {
        return email_ed;
    }

    public void setEmail_ed(String email_ed) {
        this.email_ed = email_ed;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", firstName_ed='" + firstName_ed + '\'' +
                ", lastName_ed='" + lastName_ed + '\'' +
                ", phone_ed=" + phone_ed +
                ", email_ed='" + email_ed + '\'' +
                '}';
    }
}