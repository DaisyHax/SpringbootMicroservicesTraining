package com.intuit.day01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SampleController {

    @GetMapping("/")
    public String Index(){
        return "start";
    }

    @PostMapping("/process")
    public String processName(@RequestParam("firstname") String firstName, HttpSession session) {
        String message = "Hi "+firstName+"!";
        session.setAttribute("msg", message);
        return "result";
    }
}

