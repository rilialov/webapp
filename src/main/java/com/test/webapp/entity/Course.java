package com.test.webapp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "course_code", nullable = false)
    private String courseCode;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    @Column(name = "duration")
    private int duration;

    @ManyToOne
    @JoinColumn(name="vendor")
    private Vendor vendor;

    public Course() {
    }

    public Course(String courseCode, String courseName, Vendor vendor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.vendor = vendor;
    }

    public Long getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return duration == course.duration && id.equals(course.id) && courseCode.equals(course.courseCode) && courseName.equals(course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseCode, courseName, duration);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
