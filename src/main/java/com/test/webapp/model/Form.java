package com.test.webapp.model;

import java.time.LocalDate;

public class Form {
    private long id;
    private final long course;
    private final long trainer;
    private final long student;
    private LocalDate date;

    public Form(long course, long trainer, long student) {
        this.course = course;
        this.trainer = trainer;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourse() {
        return course;
    }

    public long getTrainer() {
        return trainer;
    }

    public long getStudent() {
        return student;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}