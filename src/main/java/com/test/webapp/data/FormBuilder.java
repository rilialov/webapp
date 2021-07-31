package com.test.webapp.data;

import com.test.webapp.model.Form;
import com.test.webapp.model.Course;
import com.test.webapp.model.Trainer;
import com.test.webapp.model.Student;

public class FormBuilder {
    private final DBController db;
    private final Form form;
    private Course course;
    private Trainer trainer;
    private Student student;
    private final String date;

    public FormBuilder(int formID, DBController db) {
        this.db = db;
        int[] ids = db.getFormData(formID);
        date = db.getFormDate(formID);
        form = new Form(ids[0], ids[1], ids[2]);
        setForm();
    }

    private void setForm() {
        setCourse(form.getCourse_id());
        setTrainer(form.getTrainer_id());
        setStudent(form.getStudent_id());
    }

    private void setCourse(int id) {
        course = CoursesDAO.getCourse(db.getDbConnector(), id);
    }

    private void setTrainer(int id) {
        trainer = TrainersDAO.getTrainer(db.getDbConnector(), id);
    }

    private void setStudent(int id) {
        StudentsDAO studentsDAO = new StudentsDAO();
        student = studentsDAO.get(db.getDbConnector(), id);
    }

    public String[] getData () {
        String[] array = new String[5];
        array[0] = course.getCourseCode() + " - " + course.getCourseName();
        array[1] = trainer.getFirstName() + " " + trainer.getLastName();
        array[2] = student.getFirstName();
        array[3] = student.getLastName();
        array[4] = date;
        return array;
    }

    public Form getForm() {
        return form;
    }
}