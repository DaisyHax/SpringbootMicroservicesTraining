package com.intuit.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private StatementsRepository statementsRepository;

    public String getBalanceByAccNum(int accountNumber){
        Accounts accounts = accountsRepository.findByAccountNum(accountNumber);
        int balance = accounts.getBalance();
        String balanceString = " "+ balance;
        return balanceString;
    }

    public String getBalanceByAccNumAndOwner(int accountNumber,String owner){
        Accounts accounts = accountsRepository.findByAccountNumAndOwner(accountNumber, owner);
        int balance = accounts.getBalance();
        String balanceString = " "+ balance;
        return balanceString;
    }


    public String deposit(int accountNumber,int amount, String type) {
        // update balance in accounts table
        Accounts accounts = accountsRepository.findByAccountNum(accountNumber);
        int oldBalance = accounts.getBalance();
        int newBalance = oldBalance + amount;
        accounts.setBalance(newBalance);
        accountsRepository.save(accounts);

        // insert into statements table and type will be either “Withdraw” or “Deposit” or “Interest” or "Fees" depending on the operation.
        Statements statements = new Statements(accountNumber,amount,type);
        statementsRepository.save(statements);

        return "Amount Deposited is: "+amount+". New Balance is Rs."+newBalance;
    }

    public String withdraw(int accountNumber,int amount, String type) {
        // update balance in accounts table
        Accounts accounts = accountsRepository.findByAccountNum(accountNumber);
        int oldBalance = accounts.getBalance();
        int newBalance = oldBalance - amount;
        if(newBalance<0){
            return "Sorry! You have low balance so you cannot withdraw Rs."+ amount+". Check your balance again.";
        }
        else{
            accounts.setBalance(newBalance);
            accountsRepository.save(accounts);

            // insert into statements table and type will be either “Withdraw” or “Deposit” or “Interest” or "Fees" depending on the operation.
            Statements statements = new Statements(accountNumber,amount,type);
            statementsRepository.save(statements);
        }
        return "Amount Withdrawn: Rs."+amount+". New Balance is Rs."+newBalance;
    }
}
