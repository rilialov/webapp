package com.test.webapp.model;

public class Form {
    private int id;
    private final int course_id;
    private final int trainer_id;
    private final int student_id;
    private String date;

    public Form(int course_id, int trainer_id, int student_id) {
        this.course_id = course_id;
        this.trainer_id = trainer_id;
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}