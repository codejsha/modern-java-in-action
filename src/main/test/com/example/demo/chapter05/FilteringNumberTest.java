package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringNumberTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    }

    @Test
    void uniqueEvenNumbers() {
        var result = FilteringNumber.uniqueEvenNumbers(numbers);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(number -> assertEquals(0, number % 2));

        log.info("Even numbers: {}", result);
    }
}
