package com.servlets;

import com.alldaos.EmployeeDAO;
import com.alldaos.ReimbursementTicketDAO;
import com.models.ReimbursementTicket;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class ManagerServlet extends HttpServlet {
    ReimbursementTicketDAO reimbursementTicketDAO = new ReimbursementTicketDAO();

    EmployeeDAO employeeDAO = new EmployeeDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String employee = employeeDAO.reading(String.valueOf(req.getParameter("username_input_sign_in")));

        if(employee.equals("Manager")){
            req.getRequestDispatcher("managerPage.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.html").forward(req,resp);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String URI = req.getRequestURI().replace("/RevatureProject1/", "");
       // System.out.println(URI);

       // switch (URI){
            //case "managerPage":
                Integer ticket_id = Integer.valueOf(req.getParameter("ticket_id_input"));
                String status = String.valueOf(req.getParameter("status"));
                ReimbursementTicket updateTicket = new ReimbursementTicket(status,ticket_id);
                reimbursementTicketDAO.update(updateTicket);
                System.out.println(status);

                System.out.println("This is coming from the managerPage action - (html form)");
                req.getRequestDispatcher("reimbursement.html").forward(req,resp);

                //break;


        }




    }



