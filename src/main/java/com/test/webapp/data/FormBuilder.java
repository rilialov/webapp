package com.test.webapp.data;

import com.test.webapp.model.Form;
import com.test.webapp.model.Course;
import com.test.webapp.model.Trainer;
import com.test.webapp.model.Student;

import java.time.LocalDate;

public class FormBuilder {
    private final DBConnector dbConnector;
    private final CoursesDAO coursesDAO;
    private final TrainersDAO trainersDAO;
    private final StudentsDAO studentsDAO;
    private final Form form;
    private Course course;
    private Trainer trainer;
    private Student student;
    private final LocalDate date;

    public FormBuilder(int formID, DBController db) {
        dbConnector = db.getDbConnector();
        coursesDAO = db.getCoursesDAO();
        trainersDAO = db.getTrainersDAO();
        studentsDAO = db.getStudentsDAO();
        FormsDAO formsDAO = db.getFormsDAO();
        form = formsDAO.get(dbConnector, formID);
        date = form.getDate();
        setForm();
    }

    private void setForm() {
        setCourse(form.getCourse());
        setTrainer(form.getTrainer());
        setStudent(form.getStudent());
    }

    private void setCourse(long id) {
        course = coursesDAO.get(dbConnector, id);
    }

    private void setTrainer(long id) {
        trainer = trainersDAO.get(dbConnector, id);
    }

    private void setStudent(long id) {
        student = studentsDAO.get(dbConnector, id);
    }

    public String[] getData () {
        String[] array = new String[5];
        array[0] = course.getCourseCode() + " - " + course.getCourseName();
        array[1] = trainer.getFirstName() + " " + trainer.getLastName();
        array[2] = student.getFirstName();
        array[3] = student.getLastName();
        array[4] = String.valueOf(date);
        return array;
    }

    public Form getForm() {
        return form;
    }
}