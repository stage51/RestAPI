package com.example.restapi.services.impl;

import com.example.restapi.services.CharFrequencyService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharFrequencyServiceImpl implements CharFrequencyService{
    @Override
    public Map<Character, Integer> calculateFrequency(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
