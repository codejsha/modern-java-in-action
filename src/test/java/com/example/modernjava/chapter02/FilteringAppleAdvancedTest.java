package com.example.modernjava.chapter02;

import com.example.modernjava.constant.Color;
import com.example.modernjava.data.AppleTestData;
import com.example.modernjava.record.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringAppleAdvancedTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = AppleTestData.APPLE_LIST;
    }

    @Test
    void testFilterHeavyApples() {
        final var apples = FilteringAppleAdvanced.filterApples(inventory,
                apple -> apple.weight() > 150);
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertTrue(apple.weight() > 150));
        log.info("Heavy apples: {}", apples);
    }

    @Test
    void testFilterGreenApples() {
        final var apples = FilteringAppleAdvanced.filterApples(inventory,
                apple -> Color.GREEN.equals(apple.color()));
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.GREEN, apple.color()));
        log.info("Green apples: {}", apples);
    }

    @Test
    void testFilterRedApples() {
        final var apples = FilteringAppleAdvanced.filterApples(inventory,
                apple -> Color.RED.equals(apple.color()));
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.RED, apple.color()));
        log.info("Red apples: {}", apples);
    }

    @Test
    void testFilterRedAndHeavyApples() {
        final var apples = FilteringAppleAdvanced.filterApples(inventory,
                apple -> Color.RED.equals(apple.color()) && apple.weight() > 150);
        assertNotNull(apples);
        assertEquals(0, apples.size());
        // apples.forEach(apple -> {
        //     assertEquals(Color.RED, apple.color());
        //     assertTrue(apple.weight() > 150);
        // });
        log.info("Red and heavy apples: {}", apples);
    }
}
