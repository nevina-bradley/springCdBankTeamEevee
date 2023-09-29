package com.codedifferently.cdbankapi.domain.withdrawal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

/**
 * This class represents our Withdrawal Model/Entity for our database
 *
 * @Entity - Marked as a JPA entity, meaning it should be a
 *          data object and mapped to a database table
 *
 * id - Long, primary key aka unique identifier for the withdrawal entity, autoMAGICally generated
 *      in the database (@Id, @GeneratedValue)
 * type - String, represents the type of withdrawal (online transfer, check withdrawal, etc.)
 * date - Date, representing the date of the transaction
 * status -  String, representing the status of the (pending, completed, failed).
 * payee - String, representing the source of the withdrawal amount aka who is making the withdrawal
 * medium - String, representing the medium of which the withdrawal came through (cash, check, online, mobile, etc.)
 * amount - float, the amount of money withdrawn
 * description - String, whatever the customer wants to say for the withdrawal
 *
 */
@Entity
public class Withdrawal {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Date date;
    private String status;
    private String payee;
    private String medium;
    private float amount;
    private String description;

    // Constructors
    public Withdrawal() {
    }

    public Withdrawal(String type, Date date, String status, String payee, String medium, float amount, String description) {
        this.type = type;
        this.date = date;
        this.status = status;
        this.payee = payee;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}