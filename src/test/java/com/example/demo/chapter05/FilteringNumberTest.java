package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringNumberTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 1, 3, 3, 2, 4);
    }

    @Test
    void testUniqueEvenNumbers() {
        final var result = FilteringNumber.uniqueEvenNumbers(numbers);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(number -> assertEquals(0, number % 2));
        log.info("Even numbers: {}", result);
    }

    @Test
    void testFilterEvenNumbers() {
        final var result = FilteringNumber.filterNumbers(numbers, number -> number % 2 == 0);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(number -> assertEquals(0, number % 2));
        log.info("Even numbers: {}", result);
    }

    @Test
    void testFilterOddNumbers() {
        final var result = FilteringNumber.filterNumbers(numbers, number -> number % 2 != 0);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(number -> assertNotEquals(0, number % 2));
        log.info("Odd numbers: {}", result);
    }

    @Test
    void testFilterNumbersSmallerThan3() {
        final var result = FilteringNumber.filterNumbers(numbers, number -> number < 3);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(number -> assertTrue(number < 3));
        log.info("Numbers smaller than 3: {}", result);
    }
}
