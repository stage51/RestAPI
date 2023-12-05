package com.example.restapi.services;

import java.util.Map;

public interface CharFrequencyService {
    Map<Character, Integer> calculateFrequency(String input);
}
