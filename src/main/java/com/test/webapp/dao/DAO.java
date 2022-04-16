package com.test.webapp.dao;

import java.util.List;

public interface DAO<T> {
    T getById(Long id);

    List<T> getAll();

    T create(T t);

    T update(T t);

    void delete(T t);
}
