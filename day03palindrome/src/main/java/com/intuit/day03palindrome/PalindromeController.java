package com.intuit.day03palindrome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palindrome")
@EnableConfigurationProperties
public class PalindromeController {

    @Autowired
    private Palindrome palindrome;

    //    added for config server
    @Value("${welcome}")
    private String welcome;
    //    added for config server
    @GetMapping("/")
    public String index() {
        return welcome;
    }

    @GetMapping("/{word}")
    public boolean check(@PathVariable String word) {
        return palindrome.check(word);
    }
}