package com.servlets;

import com.alldaos.EmployeeDAO;
import com.alldaos.ReimbursementTicketDAO;
import com.models.ReimbursementTicket;
import com.utils.CurrentUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementTicketServlet extends HttpServlet {

    ReimbursementTicketDAO reimbursementTicketDAO = new ReimbursementTicketDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reimbursement.html").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Float amount = Float.valueOf(req.getParameter("amount_input"));
        String description = String.valueOf(req.getParameter("description_input"));
        Integer employee_id = reimbursementTicketDAO.IdforTicket(req.getParameter("username_input"));
        System.out.println(employee_id);
        ReimbursementTicket reimbursementTicket = new ReimbursementTicket(amount,description, employee_id);
        reimbursementTicketDAO.create(reimbursementTicket);
        req.getRequestDispatcher("employeePage.html").forward(req,resp);
    }
}
