package com.test.webapp.dao;

public interface UsersDAO<T> extends DAO<T> {
    T getByLogin(String login);
}
