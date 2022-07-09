package com.servlets;

import com.alldaos.ReimbursementTicketDAO;
import com.models.ReimbursementTicket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementTicketServlet extends HttpServlet {

    ReimbursementTicketDAO reimbursementTicketDAO = new ReimbursementTicketDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reimbursementTicketDAO.create(new ReimbursementTicket(1,200.00f, "Travel expenses", "new",1));

        resp.getWriter().println(new ReimbursementTicket(1,200.00f, "Travel expenses", "new",1));
    }


}
