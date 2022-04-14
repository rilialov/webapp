package com.test.webapp.servlets.delete;

import com.test.webapp.data.DBController;
import com.test.webapp.data.VendorsDAOImpl;
import com.test.webapp.sessions.UserAccount;
import com.test.webapp.sessions.UsersSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteVendor", value = "/managers/deleteVendor")
public class DeleteVendor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        DBController db = UsersSessions.getDbController(userAccount);

        int vendor_id = Integer.parseInt(request.getParameter("vendor_id"));
        VendorsDAOImpl vendorsDAOImpl = db.getVendorsDAO();
        vendorsDAOImpl.delete(db.getDbConnector(), vendor_id);

        response.sendRedirect("/managers/vendorsList");
    }

}