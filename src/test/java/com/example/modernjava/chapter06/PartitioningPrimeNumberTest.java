package com.example.modernjava.chapter06;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class PartitioningPrimeNumberTest {
    private Integer upperBoundNumber;

    @BeforeEach
    void setUp() {
        upperBoundNumber = 100;
    }

    @Test
    void testPartitionPrimes() {
        final var result = PartitioningPrimeNumber.partitionPrimes(upperBoundNumber);
        assertNotNull(result);
        assertEquals(25, result.get(true).size());
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97),
                result.get(true));
        assertEquals(74, result.get(false).size());
        log.info("Numbers partitioned in prime and non-prime: {}", result);
    }

    @Test
    void testPartitionPrimesWithCustomCollector() {
        final var result = PartitioningPrimeNumber.partitionPrimesWithCustomCollector(upperBoundNumber);
        assertNotNull(result);
        assertEquals(25, result.get(true).size());
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97),
                result.get(true));
        assertEquals(74, result.get(false).size());
        log.info("Numbers partitioned in prime and non-prime: {}", result);
    }
}
