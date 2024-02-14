package com.example.modernjava.chapter01;

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
        final var apples = FilteringApple.filterGreenApples(inventory);
        assertGreenApples(apples);
    }

    @Test
    void testFilterGreenApples2() {
        final var apples = FilteringApple.filterGreenApples2(inventory);
        assertGreenApples(apples);
    }

    @Test
    void testFilterHeavyApples() {
        final var apples = FilteringApple.filterHeavyApples(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void testFilterHeavyApples2() {
        final var apples = FilteringApple.filterHeavyApples2(inventory);
        assertHeavyApples(apples);
    }

    @Test
    void testFilterWeirdApples() {
        final var apples = FilteringApple.filterWeirdApples(inventory);
        assertNotNull(apples);
        assertEquals(0, apples.size());
        apples.forEach(apple -> assertTrue(apple.weight() < 80 || Color.BROWN.equals(apple.color())));
        log.info("Weird apples: {}", apples);
    }
}
