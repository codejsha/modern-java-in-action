package com.example.modernjava.chapter02;

import com.example.modernjava.chapter02.FilteringApple.AppleGreenColorPredicate;
import com.example.modernjava.chapter02.FilteringApple.AppleHeavyWeightPredicate;
import com.example.modernjava.chapter02.FilteringApple.AppleRedColorAndHeavyWeightPredicate;
import com.example.modernjava.chapter02.FilteringApple.AppleRedColorPredicate;
import com.example.modernjava.constant.Color;
import com.example.modernjava.data.AppleTestData;
import com.example.modernjava.record.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringAppleTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = AppleTestData.APPLE_LIST;
    }

    @Test
    void testFilterHeavyApples() {
        final var apples = FilteringApple.filterApples(inventory, new AppleHeavyWeightPredicate());
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertTrue(apple.weight() > 150));
        log.info("Heavy apples: {}", apples);
    }

    @Test
    void testFilterGreenApples() {
        final var apples = FilteringApple.filterApples(inventory, new AppleGreenColorPredicate());
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.GREEN, apple.color()));
        log.info("Green apples: {}", apples);
    }

    @Test
    void testFilterRedApples() {
        final var apples = FilteringApple.filterApples(inventory, new AppleRedColorPredicate());
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.RED, apple.color()));
        log.info("Red apples: {}", apples);
    }

    @Test
    void testFilterRedAndHeavyApples() {
        final var apples = FilteringApple.filterApples(inventory, new AppleRedColorAndHeavyWeightPredicate());
        assertNotNull(apples);
        assertEquals(0, apples.size());
        // apples.forEach(apple -> {
        //     assertEquals(Color.RED, apple.getColor());
        //     assertTrue(apple.getWeight() > 150);
        // });
        log.info("Red and heavy apples: {}", apples);
    }
}
