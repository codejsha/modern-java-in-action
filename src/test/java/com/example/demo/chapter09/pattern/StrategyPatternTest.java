package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class StrategyPatternTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testIsNumeric() {
        var validator = new StrategyPattern.Validator((str) -> str.matches("\\d+"));
        assertFalse(validator.validate("aaaa"));
        log.info("Is numeric: {}", validator.validate("aaaa"));
    }

    @Test
    void testIsAllLowerCase() {
        var validator = new StrategyPattern.Validator((str) -> str.matches("[a-z]+"));
        assertTrue(validator.validate("bbbb"));
        log.info("Is all lowercase: {}", validator.validate("bbbb"));
    }
}
