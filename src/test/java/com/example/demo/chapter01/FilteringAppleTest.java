package com.example.demo.chapter01;

import com.example.demo.data.AppleTestData;
import com.example.demo.enumeration.Color;
import com.example.demo.record.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringAppleTest {
    private FilteringApple filteringApple;
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        filteringApple = new FilteringApple();
        inventory = AppleTestData.APPLE_LIST;
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
    void testFilterGreenApples() {
        var apples = filteringApple.filterGreenApples(inventory);
        assertGreenApples(apples);
    }

    @Test
    void testFilterGreenApples2() {
        var apples = filteringApple.filterGreenApples2(inventory);
        assertGreenApples(apples);
    }

    @Test
    void testFilterHeavyApples() {
        var apples = filteringApple.filterHeavyApples(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void testFilterHeavyApples2() {
        var apples = filteringApple.filterHeavyApples2(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void testFilterWeirdApples() {
        var apples = filteringApple.filterWeirdApples(inventory);
        assertNotNull(apples);
        assertEquals(0, apples.size());
        // apples.forEach(apple -> assertTrue(apple.getWeight() < 80 || Color.BROWN.equals(apple.getColor())));
        log.info("Weird apples: {}", apples);
    }
}
