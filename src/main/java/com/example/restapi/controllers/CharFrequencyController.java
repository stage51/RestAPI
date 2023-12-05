package com.example.restapi.controllers;

import com.example.restapi.exceptions.IllegalInputException;
import com.example.restapi.services.CharFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CharFrequencyController {
    private final int MAX_LENGTH = 1000;
    private CharFrequencyService charFrequencyService;

    @Autowired
    public void setCharFrequencyService(CharFrequencyService charFrequencyService) {
        this.charFrequencyService = charFrequencyService;
    }
    @PostMapping("/calculate")
    public Map<Character, Integer> calculateFrequency(@RequestBody String input) {
        if (input == null || input.isEmpty()){
            throw new IllegalInputException("Input can't be empty or null!");
        } else if (input.contains("\n") || input.contains("\r")) {
            throw new IllegalInputException("Input can't be divided into several lines!");
        } else if (input.length() > MAX_LENGTH) {
            throw new IllegalInputException("Input size can't be more than " + MAX_LENGTH + "!");
        }
        return charFrequencyService.calculateFrequency(input);
    }
}
