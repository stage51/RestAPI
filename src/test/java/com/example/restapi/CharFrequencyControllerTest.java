package com.example.restapi;

import com.example.restapi.controllers.CharFrequencyController;
import com.example.restapi.exceptions.IllegalInputException;
import com.example.restapi.services.CharFrequencyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class CharFrequencyControllerTest {
    private CharFrequencyController charFrequencyController;
    private CharFrequencyService charFrequencyService;
    private Map<Character, Integer> map;
    @Before
    public void init() {
        charFrequencyService = Mockito.mock(CharFrequencyService.class);
        charFrequencyController = new CharFrequencyController();
        charFrequencyController.setCharFrequencyService(charFrequencyService);
        map = new LinkedHashMap<>();
    }

    @Test
    public void testCalculateFrequency() {
        String input = "aaaaabcccc";
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 5);
        map.put('c', 4);
        map.put('b', 1);
        when(charFrequencyService.calculateFrequency(input)).thenReturn(map);
        assertEquals(map, charFrequencyController.calculateFrequency(input));
    }
    @Test
    public void testCalculateFrequencySeveralLines() {
        assertThrows(IllegalInputException.class, () -> charFrequencyController.calculateFrequency("aaaaabcccc\naaaaabcccc"));
    }
    @Test
    public void testCalculateFrequencyEmptyString() {
        assertThrows(IllegalInputException.class, () -> charFrequencyController.calculateFrequency(""));
    }
    @Test
    public void testCalculateFrequencyNullInput() {
        assertThrows(IllegalInputException.class, () -> charFrequencyController.calculateFrequency(null));
    }
    @Test
    public void testCalculateFrequencyLongInput() {
        String input = "a".repeat(1001);
        assertThrows(IllegalInputException.class, () -> charFrequencyController.calculateFrequency(input));
    }
}
