package com.example.modernjava.chapter06;

import com.example.modernjava.data.DishTestData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class SummarizingMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.DISHES;
    }

    @Test
    void testSumTotalCalories() {
        final var result = SummarizingMenu.sumTotalCalories(menu);
        assertEquals(4300, result);
        log.info("Total calories in menu: {}", result);
    }

    @Test
    void testCalculateAverageCalories() {
        final var result = SummarizingMenu.calculateAverageCalories(menu);
        assertEquals(477.78, result);
        log.info("Average calories in menu: {}", result);
    }

    @Test
    void testReduceMinCalories() {
        final var result = SummarizingMenu.reduceMinCalories(menu);
        assertEquals(120, result);
        log.info("Min calories in menu: {}", result);
    }

    @Test
    void testReduceMaxCalories() {
        final var result = SummarizingMenu.reduceMaxCalories(menu);
        assertEquals(800, result);
        log.info("Max calories in menu: {}", result);
    }

    @Test
    void testSummarizeDishes() {
        final var result = SummarizingMenu.summarizeDishes(menu);
        assertEquals(9, result.getCount());
        assertEquals(4300, result.getSum());
        assertEquals(120, result.getMin());
        assertEquals(477.77777777777777, result.getAverage());
        assertEquals(800, result.getMax());
        log.info("Summarize calories in menu: {}", result);
    }

    @Test
    void testJoiningMenu() {
        final var result = SummarizingMenu.joiningMenu(menu);
        assertNotNull(result);
        assertEquals("pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon", result);
        log.info("Joining menu: {}", result);
    }
}
