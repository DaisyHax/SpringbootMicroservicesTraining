package com.intuit.day03ui_palin_anagram.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.day03ui_palin_anagram.service.AnagramService;
import com.intuit.day03ui_palin_anagram.service.PalindromeService;

@Controller
public class WordControllerWithJQuery {
    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private AnagramService anagramService;


    @PostMapping("/palindromecheck")
    @ResponseBody
    @HystrixCommand(fallbackMethod="checkForPalindromeBackup", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="6000")
    })
    public String checkForPalindrome(@RequestParam("word") String word) {
        boolean result = palindromeService.isPalindrome(word);
        String message = "";
        if(result) {
            message = word + " is a palindrome";
        }
        else {
            message = word + " is not a palindrome";
        }
        return message;
    }


    public String checkForPalindromeBackup(String word){
        System.out.println("***IN CHECK PALINDROME BACKUP***");
        return "PalindromeService may be temporarily dow. Try Later.";
    }

    @PostMapping("/getanagram")
    @ResponseBody
    @HystrixCommand(fallbackMethod="checkForAnagramBackup", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="6000")
    })
    public String getAnagram(@RequestParam("word") String word) {
        String result = anagramService.getJumbledWord(word);
        return result;
    }

    public String checkForAnagramBackup(String word){
        System.out.println("***IN CHECK ANAGRAM BACKUP***");
        return "Anagram Service may be temporarily dow. Try Later.";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
