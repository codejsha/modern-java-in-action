package com.example.demo.chapter02;

import com.example.demo.record.Apple;
import com.example.demo.enumeration.Color;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringAppleAdvancedTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
    }

    @Test
    void filterHeavyApples() {
        var apples = FilteringAppleAdvanced.filterApples(inventory,
                (Apple apple) -> apple.weight() > 150);
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertTrue(apple.weight() > 150));

        log.info("Heavy apples: {}", apples);
    }

    @Test
    void filterGreenApples() {
        var apples = FilteringAppleAdvanced.filterApples(inventory,
                (Apple apple) -> Color.GREEN.equals(apple.color()));
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.GREEN, apple.color()));

        log.info("Green apples: {}", apples);
    }

    @Test
    void filterRedApples() {
        var apples = FilteringAppleAdvanced.filterApples(inventory,
                (Apple apple) -> Color.RED.equals(apple.color()));
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.RED, apple.color()));

        log.info("Red apples: {}", apples);
    }

    @Test
    void filterRedAndHeavyApples() {
        var apples = FilteringAppleAdvanced.filterApples(inventory,
                (Apple apple) -> Color.RED.equals(apple.color()) && apple.weight() > 150);
        assertNotNull(apples);
        assertEquals(0, apples.size());
        // apples.forEach(apple -> {
        //     assertEquals(Color.RED, apple.color());
        //     assertTrue(apple.weight() > 150);
        // });

        log.info("Red and heavy apples: {}", apples);
    }
}
