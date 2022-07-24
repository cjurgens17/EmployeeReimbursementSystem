package com.models;

public class Employee {

    private Integer employee_Id;
    //fields
    private String username;

    private String password;

    private String employee_type;

    //getters and setters


    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public Integer getEmployee_Id() {

        return employee_Id;
    }

    public void setEmployee_Id(Integer id) {

        employee_Id = id;
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
    public Employee(){
    }

    public Employee(Integer employee_Id, String employee_type){
        this.employee_Id = employee_Id;
        this.employee_type = employee_type;
    }

//retrieving from the database, we need the specific userId to know which use to get information from.
    public Employee(Integer employee_Id, String username, String password, String employee_type){
        this.employee_Id = employee_Id;
        this.username = username;
        this.password = password;
        this.employee_type = employee_type;
    }
    //used to send information to the database.
    public Employee(String username, String password, String employee_type){
        this.username = username;
        this.password = password;
        this.employee_type = employee_type;
    }

    public Employee(String username, String password){
        this.username = username;
        this.password = password;
    }

}
