package com.intuit.day01lab022;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

    @GetMapping("/{name}")
    public String isPalindrome(@PathVariable String name){
        int n = name.length();
        for (int i = 0; i < (n/2); ++i) {
            if (name.charAt(i) != name.charAt(n - i - 1)) {
                return name+" is not a Palindrome!";
            }
        }
        return name + " is a Palindrome!";
    }
}
