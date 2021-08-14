package com.test.webapp.servlets.lists;

import com.test.webapp.data.DBController;
import com.test.webapp.data.VendorsDAO;
import com.test.webapp.model.Vendor;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "vendorsList", value = "/managers/vendorsList")
public class VendorsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        VendorsDAO vendorsDAO = db.getVendorsDAO();
        List<Vendor> list = vendorsDAO.getAll(db.getDbConnector());
        request.setAttribute("vendorsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/vendorsList.jsp").forward(request, response);
    }

}
