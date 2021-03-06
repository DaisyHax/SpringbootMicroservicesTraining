package com.intuit.day03anagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
@EnableConfigurationProperties
public class AnagramController {

    @Autowired
    private Anagram anagram;

    //    added for config server
    @Value("${welcome}")
    private String welcome;
    //    added for config server
    @GetMapping("/")
    public String index() {
        return welcome;
    }

    @GetMapping("/{word}")
    public String getJumbledWord(@PathVariable String word) {
        return anagram.getJumbledWord(word);
    }

}