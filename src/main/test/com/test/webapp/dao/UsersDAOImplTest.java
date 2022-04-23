package com.test.webapp.dao;

import com.test.webapp.entity.User;
import com.test.webapp.util.Role;
import com.test.webapp.util.SecureUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UsersDAOImplTest {

    private UsersDAOImpl usersDAO;

    @BeforeEach
    void init() {
        usersDAO = new UsersDAOImpl();
    }

    @Test
    void getByLogin() {
        User user = usersDAO.getByLogin("manager");

        Assertions.assertNotNull(user);
    }

    @Test
    void getById() {
        User user = usersDAO.getById(1L);

        Assertions.assertNotNull(user);
    }

    @Test
    void getAll() {
        List<User> users = usersDAO.getAll();

        Assertions.assertNotNull(users);
        Assertions.assertTrue(users.size() > 0);

    }

    @Test
    void create() {
        char[] password = "password".toCharArray();
        byte[] salt = SecureUtils.getSalt(password);
        byte[] hash = SecureUtils.getHash(password, salt);
        User user = new User("user", hash, salt, Role.STUDENT);
        User created = usersDAO.create(user);

        usersDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        char[] password = "password".toCharArray();
        byte[] salt = SecureUtils.getSalt(password);
        byte[] hash = SecureUtils.getHash(password, salt);
        User user = new User("user", hash, salt, Role.STUDENT);
        User created = usersDAO.create(user);

        created.setLogin("changed");
        usersDAO.update(created);

        User updated = usersDAO.getById(created.getId());
        usersDAO.delete(updated);
        Assertions.assertEquals("changed", updated.getLogin());
    }

    @Test
    void delete() {
        char[] password = "password".toCharArray();
        byte[] salt = SecureUtils.getSalt(password);
        byte[] hash = SecureUtils.getHash(password, salt);
        User user = new User("user", hash, salt, Role.STUDENT);
        User created = usersDAO.create(user);

        usersDAO.delete(created);

        User deleted = usersDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}