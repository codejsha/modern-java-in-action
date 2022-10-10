package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BuildingStreamTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testStreamsOfValues() {
        var result = BuildingStream.streamsOfValues().toList();
        assertNotNull(result);
        assertEquals(4, result.size());
        result.forEach(value -> assertEquals(value.toUpperCase(), value));
        log.info("Streams of values: {}", result);
    }

    @Test
    void testStreamFromNullable() {
        var result = BuildingStream.streamFromNullable().toList();
        assertNotNull(result);
        assertEquals(0, result.size());
        log.info("Stream from nullable: {}", result);
    }

    @Test
    void testStreamsFromArrays() {
        var result = BuildingStream.streamsFromArrays().toList();
        assertNotNull(result);
        assertEquals(4, result.size());
        result.forEach(value -> assertEquals(value.toUpperCase(), value));
        log.info("Streams of arrays: {}", result);
    }

    @Test
    void testStreamsFromFiles() {
        var result = BuildingStream.streamsFromFiles();
        assertNotNull(result);
        assertEquals(450, result);
        log.info("Unique word count from file: {}", result);
    }

    @Test
    void testStreamsOfEvenNumbers() {
        var result = BuildingStream.streamsOfEvenNumbers().toList();
        assertNotNull(result);
        assertEquals(10, result.size());
        result.forEach(value -> assertEquals(0, value % 2));
        log.info("Streams of even numbers: {}", result);
    }

    @Test
    void testStreamsOfEvenNumbers2() {
        var result = BuildingStream.streamsOfEvenNumbers2().toList();
        assertNotNull(result);
        assertEquals(50, result.size());
        result.forEach(value -> assertEquals(0, value % 2));
        log.info("Streams of even numbers: {}", result);
    }

    @Test
    void testStreamsOfMultipleOfFour() {
        var result = BuildingStream.streamsOfMultipleOfFour().toList();
        assertNotNull(result);
        assertEquals(25, result.size());
        result.forEach(value -> assertEquals(0, value % 4));
        log.info("Streams of even numbers: {}", result);
    }

    @Test
    void testStreamsOfRandomValues() {
        var result = BuildingStream.streamsOfRandomValues().toList();
        assertNotNull(result);
        assertEquals(10, result.size());
        result.forEach(value -> assertTrue(value >= 0.0 && value < 1.0));
        log.info("Streams of random numbers: {}", result);
    }

    @Test
    void testStreamsOfFibonacciNumbers() {
        var result = BuildingStream.streamsOfFibonacciSequence().toList();
        assertNotNull(result);
        assertEquals(10, result.size());
        result.forEach(value -> assertTrue(value >= 0));
        log.info("Streams of Fibonacci numbers: {}", result);
    }
}
