package com.example.modernjava.chapter05;

import com.example.modernjava.data.DishTestData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringSpecialMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.SPECIAL_DISHES;
    }

    @Test
    void testLowCalorieDishes() {
        final var result = FilteringSpecialMenu.lowCalorieDishes(menu);
        assertNotNull(result);
        assertEquals(2, result.size());
        result.forEach(dish -> assertTrue(dish.calories() < 320));
        log.info("Low calorie dishes: {}", result);
    }

    @Test
    void testLowCalorieDishes2() {
        final var result = FilteringSpecialMenu.lowCalorieDishes2(menu);
        assertNotNull(result);
        assertEquals(2, result.size());
        result.forEach(dish -> assertTrue(dish.calories() < 320));
        log.info("Low calorie dishes: {}", result);
    }

    @Test
    void testHighCalorieDishes() {
        final var result = FilteringSpecialMenu.highCalorieDishes(menu);
        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));
        log.info("High calorie dishes: {}", result);
    }

    @Test
    void threeHighCalorieDishes() {
        final var result = FilteringSpecialMenu.threeHighCalorieDishes(menu);
        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));
        log.info("Three high calorie dishes: {}", result);
    }

    @Test
    void testOtherHighCalorieDishes() {
        final var result = FilteringSpecialMenu.otherHighCalorieDishes(menu);
        assertNotNull(result);
        assertEquals(1, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));
        log.info("Other high calorie dishes: {}", result);
    }
}
