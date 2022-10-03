package com.example.demo.chapter05;

import com.example.demo.record.Dish;
import com.example.demo.enumeration.DishType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class FilteringMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 400, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH)
        );
    }

    @Test
    void vegetarianDishes() {
        var result = FilteringMenu.filterVegetarianDishes(menu);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        result.forEach(dish -> assertTrue(dish.vegetarian()));

        log.info("Vegetarian dishes: {}", result);
    }
}
