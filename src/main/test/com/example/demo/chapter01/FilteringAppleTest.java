package com.example.demo.chapter01;

import com.example.demo.record.Apple;
import com.example.demo.enumeration.Color;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringAppleTest {
    private FilteringApple filteringApple;
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        filteringApple = new FilteringApple();
        inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
    }

    void assertGreenApples(List<Apple> apples) {
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.GREEN, apple.color()));

        log.info("Green apples: {}", apples);
    }

    void assertHeavyApples(List<Apple> apples) {
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertTrue(apple.weight() > 150));

        log.info("Heavy apples: {}", apples);
    }

    @Test
    void filterGreenApples() {
        var apples = filteringApple.filterGreenApples(inventory);
        assertGreenApples(apples);
    }

    @Test
    void filterGreenApples2() {
        var apples = filteringApple.filterGreenApples2(inventory);
        assertGreenApples(apples);
    }

    @Test
    void filterHeavyApples() {
        var apples = filteringApple.filterHeavyApples(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void filterHeavyApples2() {
        var apples = filteringApple.filterHeavyApples2(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void filterWeirdApples() {
        var apples = filteringApple.filterWeirdApples(inventory);
        assertNotNull(apples);
        assertEquals(0, apples.size());
        // apples.forEach(apple -> assertTrue(apple.getWeight() < 80 || Color.BROWN.equals(apple.getColor())));

        log.info("Weird apples: {}", apples);
    }
}
