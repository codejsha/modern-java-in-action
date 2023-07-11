package com.example.demo.chapter05;

import com.example.demo.data.DishTestData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class FindingMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void testAnyVegetarianDish() {
        final var result = FindingMenu.anyVegetarianDish(menu);
        assertTrue(result);
        log.info("Any vegetarian dish: {}", result);
    }

    @Test
    void testAllVegetarianDishes() {
        final var result = FindingMenu.allVegetarianDishes(menu);
        assertFalse(result);
        log.info("All vegetarian dishes: {}", result);
    }

    @Test
    void testNoVegetarianDishes() {
        final var result = FindingMenu.noVegetarianDishes(menu);
        assertFalse(result);
        log.info("No vegetarian dishes: {}", result);
    }

    @Test
    void testFindAnyVegetarianDish() {
        final var result = FindingMenu.findAnyVegetarianDish(menu);
        assertTrue(result.isPresent());
        assertTrue(result.get().vegetarian());
        log.info("Any vegetarian dish: {}", result);
    }

    @Test
    void testFindFirstVegetarianDish() {
        final var result = FindingMenu.findFirstVegetarianDish(menu);
        assertTrue(result.isPresent());
        assertTrue(result.get().vegetarian());
        log.info("First vegetarian dish: {}", result);
    }
}
