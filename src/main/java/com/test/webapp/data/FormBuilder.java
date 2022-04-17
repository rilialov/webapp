package com.test.webapp.data;

import com.test.webapp.model.Form;
import com.test.webapp.model.Course;
import com.test.webapp.model.Student;

import java.time.LocalDate;

public class FormBuilder {
    private final DBConnector dbConnector;
    private final CoursesDAOImpl coursesDAOImpl;

    private final StudentsDAOImpl studentsDAOImpl;
    private final Form form;
    private Course course;

    private Student student;
    private final LocalDate date;

    public FormBuilder(long formID, DBController db) {
        dbConnector = db.getDbConnector();
        coursesDAOImpl = db.getCoursesDAO();

        studentsDAOImpl = db.getStudentsDAO();
        FormsDAOImpl formsDAOImpl = db.getFormsDAO();
        form = formsDAOImpl.get(dbConnector, formID);
        date = form.getDate();
        setForm();
    }

    private void setForm() {
        setCourse(form.getCourse());

        setStudent(form.getStudent());
    }

    private void setCourse(long id) {
        course = coursesDAOImpl.get(dbConnector, id);
    }



    private void setStudent(long id) {
        student = studentsDAOImpl.get(dbConnector, id);
    }

    public String[] getData () {
        String[] array = new String[5];
        array[0] = course.getCourseCode() + " - " + course.getCourseName();
//        array[1] = trainer.getFirstName() + " " + trainer.getLastName();
        array[2] = student.getFirstName();
        array[3] = student.getLastName();
        array[4] = String.valueOf(date);
        return array;
    }

    public Form getForm() {
        return form;
    }
}