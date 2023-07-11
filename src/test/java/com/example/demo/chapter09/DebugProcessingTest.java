package com.example.demo.chapter09;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DebugProcessingTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testFilterNumbers() {
        final var numbers = List.of(2, 3, 4, 5);
        final var result = DebugProcessing.filterNumbers(numbers);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(20));
        assertTrue(result.contains(22));
        log.info("Filtering numbers: {}", result);
    }
}
