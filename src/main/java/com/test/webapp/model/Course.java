package com.test.webapp.model;

public class Course {
    private int vendor_id;
    private final String courseCode;
    private final String courseName;

    public Course(String courseCode, String courseName) {

        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }
}
