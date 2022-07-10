package com.servlets;

import com.alldaos.ReimbursementTicketDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerServlet extends HttpServlet {
    ReimbursementTicketDAO reimbursementTicketDAO = new ReimbursementTicketDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("managerPage.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //Integer employee_id = reimbursementTicketDAO.IdforTicket(req.getParameter("username_input"));
        //String status = String.valueOf(req.getParameter("status"));

    }
}
