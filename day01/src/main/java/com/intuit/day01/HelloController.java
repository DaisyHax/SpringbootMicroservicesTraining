package com.intuit.day01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//http://localhost:8080/hello/Sam -> HI SAM
//http://localhost:8080/hello/Ram -> HI RAM


//http://localhost:8080/bye?name=Joe -> Bye Joe


@Controller
public class HelloController {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String greet(@PathVariable("name") String name){
        return "HI "+name;
    }

    @PostMapping("/bye")
    @ResponseBody
    public String bye(@RequestParam("name") String name){
        return "Bye "+name;
    }
}
