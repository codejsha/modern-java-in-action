package com.example.modernjava.chapter07;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ForkJoinProcessingTest {
    @Nested
    class ForkJoinSumCalculatorTest {
        @BeforeEach
        void setUp() {
        }

        @Test
        void testForkJoinSum() {
            final var result1 = ForkJoinProcessing.ForkJoinSumCalculator.forkJoinSum(100L);
            assertEquals(5050L, result1);
            log.info("Sum of Sequence: {}", result1);

            final var result2 = ForkJoinProcessing.ForkJoinSumCalculator.forkJoinSum(10_000L);
            assertEquals(50005000L, result2);
            log.info("Sum of Sequence: {}", result2);

            final var result3 = ForkJoinProcessing.ForkJoinSumCalculator.forkJoinSum(100_000L);
            assertEquals(5000050000L, result3);
            log.info("Sum of Sequence: {}", result3);
        }
    }
}
