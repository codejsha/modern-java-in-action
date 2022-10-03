package com.example.demo.chapter05;

import com.example.demo.enumeration.DishType;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PrimitiveStreamTest {
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
    void sumOfCalories() {
        var result = PrimitiveStream.sumOfCalories(menu);

        assertEquals(4300, result);

        log.info("Sum of calories: {}", result);
    }

    @Test
    void maxOfCalories() {
        var result = PrimitiveStream.maxOfCalories(menu);

        assertEquals(800, result);

        log.info("Max of calories: {}", result);
    }
}
