package com.test.webapp.servlets.creation;

import com.test.webapp.data.DBController;
import com.test.webapp.data.TrainersDAO;
import com.test.webapp.model.Trainer;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createTrainer", value = "/createTrainer")
public class CreateTrainer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/creation/createTrainer.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[2];
        array[0] = request.getParameter("firstname");
        array[1] = request.getParameter("lastname");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        TrainersDAO trainersDAO = new TrainersDAO();
        trainersDAO.create(db.getDbConnector(), array);

        List<Trainer> list = trainersDAO.getAll(db.getDbConnector());
        request.setAttribute("trainersList", list);
        getServletContext().getRequestDispatcher("/views/lists/trainersList.jsp").forward(request, response);
    }
}