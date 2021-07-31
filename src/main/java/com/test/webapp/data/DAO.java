package com.test.webapp.data;

import java.util.List;

public interface DAO<T> {

    T get(DBConnector dbConnector, int id);

    List<T> getAll(DBConnector dbConnector);

    void create(DBConnector dbConnector, String[] array);

    void update(DBConnector dbConnector, String[] array);

}
