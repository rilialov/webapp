package com.test.webapp.servlets.delete;

import com.test.webapp.dao.TrainersDAOImpl;
import com.test.webapp.entity.Trainer;

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
        TrainersDAOImpl trainersDAOImpl = new TrainersDAOImpl();
        Trainer trainer = trainersDAOImpl.getById(Long.valueOf(request.getParameter("trainer_id")));
        trainersDAOImpl.delete(trainer);

        response.sendRedirect("/managers/trainersList");
    }

}