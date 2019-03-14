package com.intuit.day02;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Accounts {

    @Id
    @Column(name="account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNum;
    @Column(name="owner")
    private String owner;
    @Column(name="balance")
    private int balance;

    public Accounts(){}

    public Accounts(int accountNum, String owner, int balance) {
        this.accountNum = accountNum;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
