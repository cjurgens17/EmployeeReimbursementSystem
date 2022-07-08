package com.alldaos;

import com.models.Employee;
import com.utils.ConnectionControl;
import com.utils.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDAO implements DAOInterface<Employee> {

    Connection connection;


    public EmployeeDAO() {
        connection = ConnectionControl.getConnection();

    }

    @Override
    public Integer create(Employee employee) {

        try {
            String sql = "INSERT INTO employees (employee_id, username, pass_word, employee_type) VALUES (default,?,?,default)";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, employee.getUsername());
            myStmt.setString(2, employee.getPassword());


            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override//this prints out all users' information.
    public Employee read(Integer id) {

        try {    //String sql = "SELECT * FROM users WHERE user_id = ?";
            String sql = "SELECT * FROM employees WHERE employee_id = ?";

            PreparedStatement myStmt = connection.prepareStatement(sql);
             myStmt.setInt(1,id);
            ResultSet rs = myStmt.executeQuery();

            Employee employee = new Employee();


            while (rs.next()) {
                System.out.println(rs.getInt("employee_id"));
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("pass_word"));
                System.out.println(rs.getString("employee_type"));
            }
            return employee;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return null;

    }

    @Override
    public Employee update(Employee employee) {

        try {
            String sql = "UPDATE employees SET username = ? WHERE employee_id = ?";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, employee.getUsername());

            myStmt.setInt(2, employee.getEmployee_Id());

            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            while (rs.next()) {
                employee.setUsername("username");
            }
            return employee;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        try {


            String sql = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement myStmt = connection.prepareStatement(sql);
            myStmt.setInt(1, id);

            return myStmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }


    public void checkLoginInfo(String username) {
        try {
            String sql = "SELECT * FROM employees WHERE username = ?";

            PreparedStatement myStmt = connection.prepareStatement(sql);

            myStmt.setString(1, username);

            ResultSet rs = myStmt.executeQuery();

            while (rs.next()) {
                if (username.equals(rs.getString("username"))){
                    System.out.println("Username is not available");
                    break;

                } else if(!username.equals(rs.getString("username"))){
                    System.out.println("Username is available");
                    break;

                }
            }

        }


        //if (rs.getNString("username").equals(username)) {
        // System.out.println("This username already exists");
        //  } else {
        // System.out.println("Username Availabel");
        // }
    catch(Exception e)

    {


        System.out.println(e.getMessage());
    }
}
}






