package com.test.webapp.data;

public class DBController {
    private final DBConnector dbConnector = new DBConnector();
    private final FormsDAO formsDAO = new FormsDAO();
    private final CoursesDAO coursesDAO = new CoursesDAO();
    private final TrainersDAO trainersDAO = new TrainersDAO();
    private final StudentsDAO studentsDAO = new StudentsDAO();
    private final VendorsDAO vendorsDAO = new VendorsDAO();
    private final UsersDAO usersDAO = new UsersDAO();

    public DBController() {
        dbConnector.setConnection();
        dbConnector.setStatement();
    }

    public DBConnector getDbConnector() {
        return dbConnector;
    }

    public FormsDAO getFormsDAO() {
        return formsDAO;
    }

    public CoursesDAO getCoursesDAO() {
        return coursesDAO;
    }

    public TrainersDAO getTrainersDAO() {
        return trainersDAO;
    }

    public StudentsDAO getStudentsDAO() {
        return studentsDAO;
    }

    public VendorsDAO getVendorsDAO() {
        return vendorsDAO;
    }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public void close() {
        dbConnector.close();
    }
}