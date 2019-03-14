package com.intuit.day02;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name="statements")
public class Statements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="account_number")
    private int accountNum;
    @Column(name="amount")
    private int amount;
    @Column(name="type")
    private String type;

    public Statements(){}

    public Statements(int accountNum, int amount, String type) {
        this.accountNum = accountNum;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
