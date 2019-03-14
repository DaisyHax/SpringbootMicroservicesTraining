package com.intuit.day01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // It doesen't give a response body unless specified with a responseBody annotation
@RestController // Here we dont need to write ResponseBody Annotation for every method as it will always give a response body for what is returned.
@RequestMapping("/calc") //By adding a request mapping on class we made sure that all methods have to have /calc before their mapping request url
public class CalculatorController {

    //Instance of Component calculator is created and then injected into controller using this autowired annotation
    @Autowired
    private Calculator calculator;

    @Autowired
    private List<String> calcOps;

    @GetMapping("/add2/{number1}/{number2}")
    public MathResult add2(@PathVariable int number1, @PathVariable int number2) {
        MathResult mathResult = new MathResult();
        mathResult.setNumber1(number1);
        mathResult.setNumber2(number2);
        mathResult.setOperation("Addition");
        mathResult.setResult(calculator.add(number1, number2));
        return mathResult;
    }

    @GetMapping("/ops")
    public List<String> getCalcOps(){
        return calcOps;
    }

    @GetMapping("/add/{x}/{y}")
    public String add(@PathVariable("x") int x,@PathVariable("y") int y){
        return calculator.add(x,y);
    }

    @GetMapping("/square/{x}")
    public String square(@PathVariable("x") int x){
        return calculator.square(x);
    }

    @PutMapping("/subtract/{x}/{y}")
    public String subtract(@PathVariable("x")int x, @PathVariable("y")int y){
        return calculator.subtract(x,y);
    }

    @PostMapping("/product")
    public String product(@RequestParam("x") int x,@RequestParam("y") int y){
        return calculator.product(x,y);
    }

    @GetMapping("/divide/{x}/{y}")
    public String divide(@PathVariable("x") double x,@PathVariable("y") double y){
        return calculator.divide(x,y);
    }
}
