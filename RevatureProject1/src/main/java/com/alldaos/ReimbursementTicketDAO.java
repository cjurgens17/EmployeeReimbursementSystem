package com.alldaos;

import com.models.ReimbursementTicket;
import com.utils.ConnectionControl;
import com.utils.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReimbursementTicketDAO implements DAOInterface<ReimbursementTicket> {

    Connection connection;

    //connection constructor

    public ReimbursementTicketDAO(){

        connection = ConnectionControl.getConnection();
    }



    @Override
    public Integer create(ReimbursementTicket reimbursementTicket) {

        try { String sql = "INSERT INTO tickets (ticket_number, amount, description, status, employee_id) VALUES (default,?,?,default,?)";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setFloat(1,reimbursementTicket.getAmount());
            myStmt.setString(2, reimbursementTicket.getDescription());
            myStmt.setInt(3, reimbursementTicket.getEmployee_id());



            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);





        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }


    @Override
    public ReimbursementTicket read(Integer id) {
        return new ReimbursementTicket();

    }

    @Override
    public ReimbursementTicket update(ReimbursementTicket reimbursementTicket) {

        try{String sql = "UPDATE tickets SET status = ? WHERE employee_id = ?";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, reimbursementTicket.getStatus());
            myStmt.setInt(2,reimbursementTicket.getEmployee_id());

            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            while(rs.next()){
                reimbursementTicket.setStatus("status");
            }

            return reimbursementTicket;






        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        return false;
    }


    public Integer IdforTicket(String username) {

        try{
            String sql = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement myStmt = connection.prepareStatement(sql);
            myStmt.setString(1,username);

            ResultSet rs = myStmt.executeQuery();

            if(rs.next()){
                return rs.getInt("employee_id");
            }



        }catch(Exception e){
            System.out.println("EmployeeDAO " + e.getMessage() );
        }
        return null;

    }
}
