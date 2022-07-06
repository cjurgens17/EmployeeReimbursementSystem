package com.models;

public class ReimbursementTicket {

    //fields
    private Integer ticket_number;

    private Float amount;

    private String description;

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
//send information
    public ReimbursementTicket(Integer ticket_number, Float amount, String description) {
        this.ticket_number = ticket_number;
        this.amount = amount;
        this.description = description;
    }

    public ReimbursementTicket(Float amount, String description) {
        this.amount = amount;
        this.description = description;
    }
}
