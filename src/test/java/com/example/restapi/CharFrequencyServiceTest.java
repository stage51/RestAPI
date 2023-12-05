package com.example.restapi;

import com.example.restapi.services.CharFrequencyService;
import com.example.restapi.services.impl.CharFrequencyServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CharFrequencyServiceTest {
    private CharFrequencyService charFrequencyService;
    private Map<Character, Integer> map;

    @Before
    public void init() {
        charFrequencyService = new CharFrequencyServiceImpl();
        map = new LinkedHashMap<>();
    }

    @Test
    public void testCalculateFrequency() {
        map.put('a', 5);
        map.put('c', 4);
        map.put('b', 1);
        assertEquals(map, charFrequencyService.calculateFrequency("aaaaabcccc"));
    }
}
