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

    public void setUserId(Integer id) {

        userId = id;
    }

    public void setPassword(String p){
        password = p;

    }

    public String getPassword(){

        return this.password;
    }

    public void setUsername(String u){

        username = u;
    }

    public String getUsername(){

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
