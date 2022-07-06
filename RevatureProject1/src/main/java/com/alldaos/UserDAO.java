package com.alldaos;

import com.models.User;
import com.utils.ConnectionControl;
import com.utils.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO implements DAOInterface<User> {

    Connection connection;


    public UserDAO() {
        connection = ConnectionControl.getConnection();

    }

    @Override
    public Integer create(User user) {

        try {
            String sql = "INSERT INTO users (user_id, username, pass_word) VALUES (default,?,?)";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, user.getUsername());
            myStmt.setString(2, user.getPassword());

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
    public void read(Integer id) {

        try {    //String sql = "SELECT * FROM users WHERE user_id = ?";
            String sql = "SELECT * FROM users";

            PreparedStatement myStmt = connection.prepareStatement(sql);
            // myStmt.setInt(1,id);
            ResultSet rs = myStmt.executeQuery();


            while (rs.next()) {
                System.out.println(rs.getInt("user_id"));
                System.out.println(rs.getString("pass_word"));
                System.out.println(rs.getString("username"));
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public User update(User user) {

        try {
            String sql = "UPDATE users SET username = ? WHERE user_id = ?";

            PreparedStatement myStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, user.getUsername());

            myStmt.setInt(2, user.getUserId());

            myStmt.executeUpdate();

            ResultSet rs = myStmt.getGeneratedKeys();

            while (rs.next()) {
                user.setUsername("username");
            }
            return user;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        try {


            String sql = "DELETE FROM users WHERE user_id = ?";
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
            String sql = "SELECT * FROM users WHERE username = ?";

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
    catch(
    Exception e)

    {


        System.out.println(e.getMessage());
    }
}
}






