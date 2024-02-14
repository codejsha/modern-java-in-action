package com.example.modernjava.chapter05;

import com.example.modernjava.data.DishTestData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class FilteringMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void testVegetarianDishes() {
        final var result = FilteringMenu.filterVegetarianDishes(menu);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(dish -> assertTrue(dish.vegetarian()));
        log.info("Vegetarian dishes: {}", result);
    }
}
