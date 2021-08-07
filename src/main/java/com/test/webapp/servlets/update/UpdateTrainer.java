package com.test.webapp.servlets.update;

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

@WebServlet(name = "updateTrainer", value = "/updateTrainer")
public class UpdateTrainer extends HttpServlet {
    private int trainer_id;
    private TrainersDAO trainersDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        trainersDAO = db.getTrainersDAO();

        trainer_id = Integer.parseInt(request.getParameter("trainer_id"));
        Trainer trainer = trainersDAO.get(db.getDbConnector(), trainer_id);

        request.setAttribute("trainer", trainer);
        request.setAttribute("create", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/views/create-update/Trainer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String[] array = new String[3];
        array[0] = String.valueOf(trainer_id);
        array[1] = request.getParameter("firstname");
        array[2] = request.getParameter("lastname");

        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);
        trainersDAO.update(db.getDbConnector(), array);

        List<Trainer> list = trainersDAO.getAll(db.getDbConnector());
        request.setAttribute("trainersList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/trainersList.jsp").forward(request, response);
    }
}