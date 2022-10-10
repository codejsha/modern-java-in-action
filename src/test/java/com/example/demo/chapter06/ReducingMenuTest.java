package com.example.demo.chapter06;

import com.example.demo.data.DishTestData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ReducingMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void calculateTotalCalories() {
        var result = ReducingMenu.calculateTotalCalories(menu);
        assertEquals(4300, result);
        log.info("Total calories in menu: {}", result);

    }

    @Test
    void calculateTotalCaloriesWithMethodReference() {
        var result = ReducingMenu.calculateTotalCaloriesWithMethodReference(menu);
        assertEquals(4300, result);
        log.info("Total calories in menu: {}", result);
    }

    @Test
    void calculateTotalCaloriesWithCollectors() {
        var result = ReducingMenu.calculateTotalCaloriesWithCollectors(menu);
        assertEquals(4300, result);
        log.info("Total calories in menu: {}", result);
    }

    @Test
    void calculateTotalCaloriesUsingSum() {
        var result = ReducingMenu.calculateTotalCaloriesUsingSum(menu);
        assertEquals(4300, result);
        log.info("Total calories in menu: {}", result);
    }
}
