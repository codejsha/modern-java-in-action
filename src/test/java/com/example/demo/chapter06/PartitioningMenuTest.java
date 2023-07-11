package com.example.demo.chapter06;

import com.example.demo.data.DishData;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class PartitioningMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishData.DISHES;
    }

    @Test
    void testPartitionByVegetarian() {
        final var result = PartitioningMenu.partitionByVegetarian(menu);
        assertNotNull(result);
        assertEquals(4, result.get(true).size());
        assertEquals(5, result.get(false).size());
        log.info("Dishes partitioned by vegetarian: {}", result);
    }

    @Test
    void testVegetarianDishesByType() {
        final var result = PartitioningMenu.vegetarianDishesByType(menu);
        assertNotNull(result);
        assertEquals(4, result.get(true).get(Dish.Type.OTHER).size());
        assertEquals(2, result.get(false).get(Dish.Type.FISH).size());
        assertEquals(3, result.get(false).get(Dish.Type.MEAT).size());
        log.info("Vegetarian dishes by type: {}", result);
    }

    @Test
    void testMostCaloricPartitionedByVegetarian() {
        final var result = PartitioningMenu.mostCaloricPartitionedByVegetarian(menu);
        assertNotNull(result);
        assertEquals("pizza", result.get(true).name());
        assertEquals("pork", result.get(false).name());
        log.info("Most caloric partitioned by vegetarian: {}", result);
    }
}
