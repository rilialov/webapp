package com.test.webapp.servlets.delete;

import com.test.webapp.data.DBController;
import com.test.webapp.data.TrainersDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteTrainer", value = "/managers/deleteTrainer")
public class DeleteTrainer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
        TrainersDAOImpl trainersDAOImpl = db.getTrainersDAO();
        trainersDAOImpl.delete(db.getDbConnector(), trainer_id);

        response.sendRedirect("/managers/trainersList");
    }

}