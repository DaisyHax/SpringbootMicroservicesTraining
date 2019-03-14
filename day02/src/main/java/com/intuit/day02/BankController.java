package com.intuit.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class BankController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    /* ACCOUNT RELATED METHODS */

    @GetMapping("/bank/balance/accnum/{accNum}")
    public String getBalanceByAccNum(@PathVariable("accNum") int accountNumber, HttpSession session){
        String balance = accountService.getBalanceByAccNum(accountNumber);
        session.setAttribute("balance", balance);
        return "index";
    }

    @GetMapping("/bank/balance/accnum/{accNum}/owner/{owner}")
    public String getBalanceByAccNumAndOwner(@PathVariable("accNum") int accountNumber,@PathVariable("owner") String owner, HttpSession session){
        return accountService.getBalanceByAccNumAndOwner(accountNumber, owner);
    }


    /* STATEMENTS RELATED METHODS */

    @PostMapping("/bank/deposit")
    public String deposit(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type, HttpSession session) {
        String message = accountService.deposit(accountNumber,amount, type);
        session.setAttribute("Dmessage", message);
        return "index";
//        return "Deposited: "+amount;
    }
    @PostMapping("/bank/withdraw")
    public String withdraw(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type, HttpSession session) {
        String message = accountService.withdraw(accountNumber,amount,type);
        session.setAttribute("Wmessage", message);
        return "index";
    }
}
