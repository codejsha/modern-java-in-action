package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.javatuples.Triplet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class NumberStreamTest {
    private final int START = 1;
    private final int END = 100;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateEvenNumbers() {
        var result = NumberStream.generateEvenNumbers(START, END);
        assertNotNull(result);
        assertEquals(50, result.size());
        result.forEach(number -> assertEquals(0, number % 2));
        log.info("Even numbers: {}", result);
    }

    @Test
    void pythagoreanTriple1() {
        var result = NumberStream.pythagoreanTriple1(START, END);
        assertNotNull(result);
        assertEquals(5, result.size());
        result.forEach(triple -> {
            var a = triple.getValue0();
            var b = triple.getValue1();
            var c = triple.getValue2();
            assertEquals(c * c, a * a + b * b);
        });
        log.info("Pythagorean triples: {}", result);
    }

    @Test
    void pythagoreanTriple2() {
        var result = NumberStream.pythagoreanTriple2(START, END);
        assertNotNull(result);
        assertEquals(5, result.size());
        result.forEach(triple -> {
            var a = triple.getValue0();
            var b = triple.getValue1();
            var c = triple.getValue2();
            assertEquals(c * c, a * a + b * b);
        });
        result.forEach(triple -> assertNotEquals(new Triplet<>(3, 4, 5), triple));
        result.forEach(triple -> assertNotEquals(new Triplet<>(5, 12, 13), triple));
        result.forEach(triple -> assertNotEquals(new Triplet<>(6, 8, 10), triple));
        result.forEach(triple -> assertNotEquals(new Triplet<>(7, 24, 25), triple));
        result.forEach(triple -> assertNotEquals(new Triplet<>(8, 15, 17), triple));
        log.info("Pythagorean triples: {}", result);
    }
}
