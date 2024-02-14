package com.example.modernjava.chapter05;

import com.example.modernjava.data.DishTestData;
import com.example.modernjava.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MappingSpecialMenuTest {
    private List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishTestData.SPECIAL_DISHES;
    }

    @Test
    void testDishNames() {
        final var result = MappingSpecialMenu.dishNames(menu);
        assertNotNull(result);
        assertEquals(5, result.size());
        result.forEach(name -> assertTrue(name.length() > 0));
        log.info("Dish names: {}", result);
    }

    @Test
    void testDishNameLengths() {
        final var result = MappingSpecialMenu.dishNameLengths(menu);
        assertNotNull(result);
        assertEquals(5, result.size());
        result.forEach(length -> assertTrue(length > 0));
        log.info("Dish name lengths: {}", result);
    }

    @Test
    void testUniqueDishNameCharacters() {
        final var result = MappingSpecialMenu.uniqueDishNameCharacters(menu);
        assertNotNull(result);
        assertEquals(15, result.size());
        result.forEach(character -> assertEquals(1, character.length()));
        log.info("Unique dish name characters: {}", result);
    }
}
