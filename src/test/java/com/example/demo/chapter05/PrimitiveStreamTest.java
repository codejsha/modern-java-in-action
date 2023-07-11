package com.example.demo.chapter05;

import com.example.demo.data.DishTestData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PrimitiveStreamTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void testSumOfCalories() {
        final var result = PrimitiveStream.sumOfCalories(menu);
        assertEquals(4300, result);
        log.info("Sum of calories: {}", result);
    }

    @Test
    void testMaxOfCalories() {
        final var result = PrimitiveStream.maxOfCalories(menu);
        assertEquals(800, result);
        log.info("Max of calories: {}", result);
    }
}
