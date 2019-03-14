package com.intuit.day03ui_palin_anagram.web;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.day03ui_palin_anagram.service.AnagramService;
import com.intuit.day03ui_palin_anagram.service.PalindromeService;

@Controller
public class WordController {

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private AnagramService anagramService;


    @PostMapping("/palindromecheck")
    public String checkForPalindrome(@RequestParam("word") String word, Model model) {
        if(word!=""){
            boolean result = palindromeService.isPalindrome(word);
            if(result) {
                model.addAttribute("palindromemessage", word + " is a palindrome");
            }
            else {
                model.addAttribute("palindromemessage", word + " is not a palindrome");
            }
        }
        else{
            model.addAttribute("message", "Please Enter a word to check. You cannot check palindrome for an empty string!");
        }
        return "index";
    }

    @PostMapping("/getanagram")
    public String getAnagram(@RequestParam("word") String word, Model model) {
        if(word!=""){
            String result = anagramService.getJumbledWord(word);
            model.addAttribute("anagrammessage", result);
        }
        else {
            model.addAttribute("message", "Please Enter a word to check. You cannot check anagram for an empty string!");
        }
        return "index";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

*/