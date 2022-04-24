package com.test.webapp.servlets.users;

import com.test.webapp.dao.FormsDAOImpl;
import com.test.webapp.dao.UsersDAOImpl;
import com.test.webapp.entity.Form;
import com.test.webapp.entity.User;
import com.test.webapp.util.Role;
import com.test.webapp.util.SecureUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateUser", value = "/managers/updateUser")
public class UpdateUser extends HttpServlet {
    private User user;
    private final UsersDAOImpl usersDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = usersDAO.getById(Long.valueOf(request.getParameter("user_id")));

        request.setAttribute("title", "Update");
        request.setAttribute("user", user);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/User.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        FormsDAOImpl formsDAO = new FormsDAOImpl();

        user.setLogin(request.getParameter("login"));
        char[] password = request.getParameter("password").toCharArray();
        if (password.length != 0) {
            byte[] salt = SecureUtils.getSalt(password);
            byte[] hash = SecureUtils.getHash(password, salt);
            user.setSalt(salt);
            user.setHash(hash);
        }

        Role role;
        Form form;
        String manager = request.getParameter("manager");
        if (manager == null) {
            role = Role.STUDENT;
            form = formsDAO.getById(Long.valueOf(request.getParameter("form")));
        } else {
            role = Role.MANAGER;
            form = null;
        }
        if (form != null) {
            user.setForm(form);
        }
        user.setRole(role);
        usersDAO.update(user);

        response.sendRedirect("/managers/usersList");
    }

}