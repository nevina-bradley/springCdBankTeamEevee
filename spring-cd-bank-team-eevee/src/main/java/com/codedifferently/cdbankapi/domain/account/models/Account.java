package com.codedifferently.cdbankapi.domain.account.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents our Account Model/Entity for our database
 *
 * @Entity - Marked as a JPA entity, meaning it should be a
 *          data object and mapped to a database table
 *
 * id - primary key aka unique identifier for the account entity, autoMAGICally generated
 *      in the database (@Id, @GeneratedValue)
 * type - represents the type of the account (savings, checking, etc.)
 * nickname - optional nickname/label for the account
 * rewards - indicates whether this account is eligible for rewards or not
 * balance - represents the balance for the account
 *
 */
@Entity
public class Account {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String nickname;
    private Boolean rewards;
    private float balance;

    // Constructors
    public Account() {
    }

    public Account(String type, String nickname, Boolean rewards, float balance) {
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getRewards() {
        return rewards;
    }

    public void setRewards(Boolean rewards) {
        this.rewards = rewards;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    // other methods

    @Override
    public String toString(){
        return String.format("%d\n%s\n%s\n%b\n%.2f\n", id, type, nickname, rewards, balance);
    }
}
