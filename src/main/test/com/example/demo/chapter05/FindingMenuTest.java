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
class FindingMenuTest {
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
    void anyVegetarianDish() {
        var result = FindingMenu.anyVegetarianDish(menu);

        assertTrue(result);

        log.info("Any vegetarian dish: {}", result);
    }

    @Test
    void allVegetarianDishes() {
        var result = FindingMenu.allVegetarianDishes(menu);

        assertFalse(result);

        log.info("All vegetarian dishes: {}", result);
    }

    @Test
    void noVegetarianDishes() {
        var result = FindingMenu.noVegetarianDishes(menu);

        assertFalse(result);

        log.info("No vegetarian dishes: {}", result);
    }

    @Test
    void findAnyVegetarianDish() {
        var result = FindingMenu.findAnyVegetarianDish(menu);

        assertTrue(result.isPresent());
        assertTrue(result.get().vegetarian());

        log.info("Any vegetarian dish: {}", result);
    }

    @Test
    void findFirstVegetarianDish() {
        var result = FindingMenu.findFirstVegetarianDish(menu);

        assertTrue(result.isPresent());
        assertTrue(result.get().vegetarian());

        log.info("First vegetarian dish: {}", result);
    }
}
