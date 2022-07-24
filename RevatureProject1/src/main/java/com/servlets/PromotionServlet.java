package com.servlets;

import com.alldaos.EmployeeDAO;
import com.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PromotionServlet extends HttpServlet {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("employeeStatus.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Integer employee_id = Integer.valueOf(req.getParameter("employee_type_id_input"));
                String employee_type = String.valueOf(req.getParameter("employee_status"));
                Employee employee = new Employee(employee_id, employee_type);
                employeeDAO.update(employee);
        System.out.println("This is coming from the promotion Servlet class");
        req.getRequestDispatcher("managerPage.html").forward(req,resp);


    }
}
