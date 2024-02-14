package com.example.modernjava.chapter07;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ParallelProcessingTest {
    private ParallelProcessing.Config config;

    @BeforeEach
    void setUp() {
        config = new ParallelProcessing.Config();
    }

    @AfterEach
    void tearDown() {
        System.gc();
    }

    @Test
    void testSequentialSum() {
        config.number = 100L;
        final var result1 = ParallelProcessing.sequentialSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        final var result2 = ParallelProcessing.sequentialSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void testParallelSum() {
        config.number = 100L;
        final var result1 = ParallelProcessing.parallelSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        final var result2 = ParallelProcessing.parallelSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void testRangedSum() {
        config.number = 100L;
        final var result1 = ParallelProcessing.rangedSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        final var result2 = ParallelProcessing.rangedSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void testParallelRangedSum() {
        config.number = 100L;
        final var result1 = ParallelProcessing.parallelRangedSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        final var result2 = ParallelProcessing.parallelRangedSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }
}
