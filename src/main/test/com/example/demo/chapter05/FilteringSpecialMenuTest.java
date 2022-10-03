package com.example.demo.chapter05;

import com.example.demo.enumeration.DishType;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringSpecialMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = Arrays.asList(
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER)
        );
    }

    @Test
    void lowCalorieDishes() {
        var result = FilteringSpecialMenu.lowCalorieDishes(menu);

        assertNotNull(result);
        assertEquals(2, result.size());
        result.forEach(dish -> assertTrue(dish.calories() < 320));

        log.info("Low calorie dishes: {}", result);
    }

    @Test
    void lowCalorieDishes2() {
        var result = FilteringSpecialMenu.lowCalorieDishes2(menu);

        assertNotNull(result);
        assertEquals(2, result.size());
        result.forEach(dish -> assertTrue(dish.calories() < 320));

        log.info("Low calorie dishes: {}", result);
    }

    @Test
    void highCalorieDishes() {
        var result = FilteringSpecialMenu.highCalorieDishes(menu);

        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));

        log.info("High calorie dishes: {}", result);
    }

    @Test
    void threeHighCalorieDishes() {
        var result = FilteringSpecialMenu.threeHighCalorieDishes(menu);

        assertNotNull(result);
        assertEquals(3, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));

        log.info("Three high calorie dishes: {}", result);
    }

    @Test
    void otherHighCalorieDishes() {
        var result = FilteringSpecialMenu.otherHighCalorieDishes(menu);

        assertNotNull(result);
        assertEquals(1, result.size());
        result.forEach(dish -> assertTrue(dish.calories() > 300));

        log.info("Other high calorie dishes: {}", result);
    }
}
