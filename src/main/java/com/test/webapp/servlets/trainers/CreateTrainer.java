package com.test.webapp.servlets.trainers;

import com.test.webapp.dao.TrainersDAOImpl;
import com.test.webapp.entity.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createTrainer", value = "/managers/createTrainer")
public class CreateTrainer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create");
        request.setAttribute("create", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Trainer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Trainer trainer = new Trainer(request.getParameter("firstname"), request.getParameter("lastname"));

        TrainersDAOImpl trainersDAOImpl = new TrainersDAOImpl();
        trainersDAOImpl.create(trainer);

        response.sendRedirect("/managers/trainersList");
    }

}