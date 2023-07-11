package com.example.demo.chapter05;

import com.example.demo.data.TraderTestData;
import com.example.demo.data.TransactionTestData;
import com.example.demo.record.Trader;
import com.example.demo.record.Transaction;
import com.google.common.collect.Comparators;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PracticeTest {
    private List<Trader> traders;
    private List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        traders = TraderTestData.TRADERS;
        transactions = TransactionTestData.TRANSACTIONS;
    }

    @Test
    void testExercise1() {
        final var result = Practice.exercise1(transactions);
        assertNotNull(result);
        assertEquals(2, result.size());
        result.forEach(tx -> assertEquals(2011, tx.year()));
        assertTrue(Comparators.isInOrder(result, Comparator.comparingInt(Transaction::value)));
        log.info("exercise1 | all transactions in 2011 and sort by value: {}", result);
    }

    @Test
    void testExercise2() {
        final var result = Practice.exercise2(traders);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Cambridge"));
        assertTrue(result.contains("Milan"));
        log.info("exercise2 | unique cities where traders work: {}", result);
    }

    @Test
    void testExercise3() {
        final var result = Practice.exercise3(transactions);
        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(trader -> assertEquals("Cambridge", trader.city()));
        assertTrue(Comparators.isInOrder(result, Comparator.comparing(Trader::name)));
        log.info("exercise3 | all traders from Cambridge and sort by name: {}", result);
    }

    @Test
    void testExercise4() {
        final var result = Practice.exercise4(traders);
        assertNotNull(result);
        assertTrue(result.contains("Alan"));
        assertTrue(result.contains("Brian"));
        assertTrue(result.contains("Mario"));
        assertTrue(result.contains("Raoul"));
        log.info("exercise4 | all traders' names sorted alphabetically: {}", result);
    }

    @Test
    void testExercise5() {
        final var result = Practice.exercise5(traders);
        assertTrue(result);
        log.info("exercise5 | are any traders based in Milan?: {}", result);
    }

    @Test
    void testExercise6() {
        final var result = Practice.exercise6(transactions);
        assertNotNull(result);
        assertEquals(4, result.size());
        log.info("exercise6 | print all transactions' values from the traders living in Cambridge: {}", result);
    }

    @Test
    void testExercise7() {
        final var result = Practice.exercise7(transactions);
        assertEquals(1000, result);
        log.info("exercise7 | highest value of all the transactions: {}", result);
    }

    @Test
    void testExercise8() {
        final var result = Practice.exercise8(transactions);
        assertEquals(300, result);
        log.info("exercise8 | smallest transaction: {}", result);
    }
}
