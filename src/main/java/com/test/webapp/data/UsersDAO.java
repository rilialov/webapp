package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

public interface UsersDAO<T> extends DAO<T>{
    T getByLogin(DBConnector dbConnector, String login);

    void createWithSaltHash(DBConnector dbConnector, String[] array, byte[] salt, byte[] hash);

    void setHashSalt(DBConnector dbConnector, int id, byte[] salt, byte[] hash);
}