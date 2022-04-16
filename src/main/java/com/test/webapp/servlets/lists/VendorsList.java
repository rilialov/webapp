package com.test.webapp.servlets.lists;

import com.test.webapp.dao.VendorsDAOImpl;
import com.test.webapp.entity.Vendor;

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
        VendorsDAOImpl vendorsDAOImpl = new VendorsDAOImpl();
        List<Vendor> list = vendorsDAOImpl.getAll();

        request.setAttribute("vendorsList", list);
        getServletContext().getRequestDispatcher("/WEB-INF/views/lists/vendorsList.jsp").forward(request, response);
    }

}
