package com.test.webapp.data;

public class DBController {
    private final DBConnector dbConnector = new DBConnector();
    private final FormsDAOImpl formsDAOImpl = new FormsDAOImpl();
    private final CoursesDAOImpl coursesDAOImpl = new CoursesDAOImpl();
    private final TrainersDAOImpl trainersDAOImpl = new TrainersDAOImpl();
    private final StudentsDAOImpl studentsDAOImpl = new StudentsDAOImpl();
    private final VendorsDAOImpl vendorsDAOImpl = new VendorsDAOImpl();
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

    public TrainersDAOImpl getTrainersDAO() {
        return trainersDAOImpl;
    }

    public StudentsDAOImpl getStudentsDAO() {
        return studentsDAOImpl;
    }

    public VendorsDAOImpl getVendorsDAO() {
        return vendorsDAOImpl;
    }

    public UsersDAOImpl getUsersDAO() {
        return usersDAOImpl;
    }

    public void close() {
        dbConnector.close();
    }
}