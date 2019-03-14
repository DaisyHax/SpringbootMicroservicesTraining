package com.intuit.day02sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    ArrayList<String> stockSymbols = new ArrayList<>();
    ArrayList<String> stockValues = new ArrayList<>();

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/stock/{symbol}")
    public String getStockSymbol(@PathVariable("symbol") String stockSymbol){
        jmsTemplate.convertAndSend("StockQueue",stockSymbol);
        stockSymbols.add(stockSymbol);
        return stockSymbols.get(stockSymbols.size()-1) + " = "+ stockValues.get(stockValues.size()-1);
    }

    @GetMapping("/stock/list")
    public List<String> getStocks(){
        ArrayList<String> stocks = new ArrayList<>();
        for (int i=0; i <stockSymbols.size();i++)
            stocks.add(stockSymbols.get(i)+" : "+stockValues.get(i));
        return stocks;
    }

    @JmsListener(destination = "StockValue", containerFactory = "stockFactory")
    public void receiveStockValue(String value) {
        System.out.println("Value " + value );
        stockValues.add(value);
    }

}
