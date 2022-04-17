package com.test.webapp.data;

public class DBController {
    private final DBConnector dbConnector = new DBConnector();
    private final FormsDAOImpl formsDAOImpl = new FormsDAOImpl();
    private final CoursesDAOImpl coursesDAOImpl = new CoursesDAOImpl();

    private final StudentsDAOImpl studentsDAOImpl = new StudentsDAOImpl();

    private final UsersDAOImpl usersDAOImpl = new UsersDAOImpl();

    public DBController() {
        dbConnector.setConnection();
        dbConnector.setStatement();
    }

    public DBConnector getDbConnector() {
        return dbConnector;
    }

    public FormsDAOImpl getFormsDAO() {
        return formsDAOImpl;
    }

    public CoursesDAOImpl getCoursesDAO() {
        return coursesDAOImpl;
    }



    public StudentsDAOImpl getStudentsDAO() {
        return studentsDAOImpl;
    }



    public UsersDAOImpl getUsersDAO() {
        return usersDAOImpl;
    }

    public void close() {
        dbConnector.close();
    }
}