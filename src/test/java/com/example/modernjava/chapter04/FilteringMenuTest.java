package com.example.modernjava.chapter04;

import com.example.modernjava.data.DishTestData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class FilteringMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void testThreeHighCalorieDishes() {
        final var dishes = FilteringMenu.threeHighCalorieDishes(menu);
        assertNotNull(dishes);
        assertEquals(3, dishes.size());
        log.info("High calorie dishes: {}", dishes);
    }
}
