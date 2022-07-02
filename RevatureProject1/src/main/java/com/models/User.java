package com.models;

public class User {

    private Integer userId;
    //fields
    private String username;

    private String password;

    //getters and setters


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPassword(String p){
        p = password;

    }

    public String getPassword(String password){
        return this.password;
    }

    public void setUsername(String u){
        u = username;
    }

    public String getUsername(String username){
        return this.username;
    }


//Constructors
    public User(){
    }

//retrieveing from the database, we need the specific userId to know which use to get information from.
    public User(Integer userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    //used to send information to the database.
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
