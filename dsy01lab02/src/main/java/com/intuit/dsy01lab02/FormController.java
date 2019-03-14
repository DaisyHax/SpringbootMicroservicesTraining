package com.intuit.dsy01lab02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class FormController {

    @GetMapping("/")
    public String startPage(){ return "start"; }


    @PostMapping("/info")
    public String isNamePalindrome(@RequestParam("name") String name, HttpSession session) {
        final String uri = "http://localhost:8082/palindrome/"+name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        session.setAttribute("resultPalindrome", result);
        return "resultPalindrome";
    }

    @PostMapping("/process")
    public String process(@RequestParam("name") String firstName, HttpSession session) {
        String message = "Hi " + firstName + "!!!";
        session.setAttribute("message", message);
        return "result";
    }
}
