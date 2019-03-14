package com.intuit.day01;

import org.springframework.stereotype.Component;

//This component has the functionality that the controller will implement. To make an injection using autowired we need component annotation.
@Component
public class Calculator {

    public String add(int x, int y){
        int sum = x+y;
        return "SUM : "+ sum;
    }

    public String square(int x){
        int square= x*x;
        return "SQUARE: "+ square;
    }


    public String subtract(int x, int y){
        int difference = x-y;
        return "DIFFERENCE: "+difference;
    }


    public String product(int x, int y){
        int product = x*y;
        return "PRODUCT: "+product;
    }

    public String divide(double x, double y){
        double quotient = x/y;
        double remainder = x%y;
        return "Quotient: "+quotient+" Remainder: "+remainder;
    }
}
