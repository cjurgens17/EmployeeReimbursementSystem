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

        try { String sql = "INSERT INTO tickets (ticket_id, amount, description) VALUES (default,?,?)";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setFloat(1,reimbursementTicket.getAmount());
            myStmt.setString(2, reimbursementTicket.getDescription());

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
    public void read(Integer id) {

    }

    @Override
    public ReimbursementTicket update(ReimbursementTicket reimbursementTicket) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
