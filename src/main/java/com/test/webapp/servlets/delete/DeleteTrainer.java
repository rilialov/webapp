package com.test.webapp.servlets.delete;

import com.test.webapp.data.CoursesDAO;
import com.test.webapp.data.DBController;
import com.test.webapp.data.TrainersDAO;
import com.test.webapp.model.Course;
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

@WebServlet(name = "deleteTrainer", value = "/deleteTrainer")
public class DeleteTrainer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
        TrainersDAO trainersDAO = new TrainersDAO();
        trainersDAO.delete(db.getDbConnector(), trainer_id);

        List<Trainer> list = trainersDAO.getAll(db.getDbConnector());
        request.setAttribute("trainersList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/trainersList.jsp").forward(request, response);
    }

}