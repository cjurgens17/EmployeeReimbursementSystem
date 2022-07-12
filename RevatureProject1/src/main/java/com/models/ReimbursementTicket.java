package com.models;

public class ReimbursementTicket {

    //fields
    private Integer ticket_number;

    private Float amount;

    private String description;

    private String status;

    private Integer employee_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }
//getters and setters

    public Integer getTicket_number() {

        return ticket_number;
    }

    public void setTicket_number(Integer ticket_number) {

        this.ticket_number = ticket_number;
    }

    public Float getAmount() {

        return amount;
    }

    public void setAmount(Float amount) {

        this.amount = amount;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    //constructors

    public ReimbursementTicket(){

    }

    public ReimbursementTicket(String status, Integer emloyee_id){
        this.status = status;
        this.employee_id = emloyee_id;
    }

    public ReimbursementTicket(Float amount, String description, Integer employee_id) {
        this.amount = amount;
        this.description = description;
        this.employee_id = employee_id;
    }

    //send information
    public ReimbursementTicket(Integer ticket_number, Float amount, String description, String status, Integer employee_id) {
        this.ticket_number = ticket_number;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.employee_id = employee_id;
    }

    public ReimbursementTicket(Float amount, String description, String status, Integer employee_id) {
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.employee_id = employee_id;
    }
}
