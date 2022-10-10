package com.example.demo.chapter07;

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
    void sequentialSum() {
        config.number = 100L;
        var result1 = ParallelProcessing.sequentialSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        var result2 = ParallelProcessing.sequentialSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void parallelSum() {
        config.number = 100L;
        var result1 = ParallelProcessing.parallelSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        var result2 = ParallelProcessing.parallelSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void rangedSum() {
        config.number = 100L;
        var result1 = ParallelProcessing.rangedSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        var result2 = ParallelProcessing.rangedSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }

    @Test
    void parallelRangedSum() {
        config.number = 100L;
        var result1 = ParallelProcessing.parallelRangedSum(config);
        assertEquals(5050L, result1);
        log.info("Sum of Sequence: {}", result1);

        config.number = 10_000L;
        var result2 = ParallelProcessing.parallelRangedSum(config);
        assertEquals(50005000L, result2);
        log.info("Sum of Sequence: {}", result2);
    }
}
