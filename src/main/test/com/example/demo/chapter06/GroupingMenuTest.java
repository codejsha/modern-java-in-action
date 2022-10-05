package com.example.demo.chapter06;

import com.example.demo.data.DishData;
import com.example.demo.enumeration.CaloricLevel;
import com.example.demo.record.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class GroupingMenuTest {
    private List<Dish> menu;
    private Map<String, List<String>> dishTags;

    @BeforeEach
    void setUp() {
        menu = DishData.DISH_LIST;
        dishTags = DishData.DISH_TAGS;
    }

    @Test
    void groupDishesByType() {
        var result = GroupingMenu.groupDishesByType(menu);

        assertNotNull(result);
        assertEquals(2, result.get(Dish.Type.FISH).size());
        assertEquals(3, result.get(Dish.Type.MEAT).size());
        assertEquals(4, result.get(Dish.Type.OTHER).size());

        log.info("Dishes grouped by type: {}", result);
    }

    @Test
    void groupDishesByCaloricLevel() {
        var result = GroupingMenu.groupDishesByCaloricLevel(menu);

        assertNotNull(result);
        assertEquals(4, result.get(CaloricLevel.DIET).size());
        assertEquals(4, result.get(CaloricLevel.NORMAL).size());
        assertEquals(1, result.get(CaloricLevel.FAT).size());

        log.info("Dishes grouped by caloric level: {}", result);
    }

    @Test
    void groupCaloricDishesByType() {
        var result = GroupingMenu.groupCaloricDishesByType(menu);

        assertNotNull(result);
        assertNull(result.get(Dish.Type.FISH));
        assertEquals(2, result.get(Dish.Type.MEAT).size());
        assertEquals(2, result.get(Dish.Type.OTHER).size());

        log.info("Caloric dishes grouped by type: {}", result);
    }

    @Test
    void groupDishNamesByType() {
        var result = GroupingMenu.groupDishNamesByType(menu);

        assertNotNull(result);
        // fish
        assertEquals(2, result.get(Dish.Type.FISH).size());
        assertEquals(List.of("prawns", "salmon"),
                result.get(Dish.Type.FISH));
        // meat
        assertEquals(3, result.get(Dish.Type.MEAT).size());
        assertEquals(List.of("pork", "beef", "chicken"),
                result.get(Dish.Type.MEAT));
        // other
        assertEquals(4, result.get(Dish.Type.OTHER).size());
        assertEquals(List.of("french fries", "rice", "season fruit", "pizza"),
                result.get(Dish.Type.OTHER));

        log.info("Dish names grouped by type: {}", result);
    }

    @Test
    void groupDishTagsByType() {
        var result = GroupingMenu.groupDishTagsByType(menu, dishTags);

        assertNotNull(result);
        // fish
        assertEquals(4, result.get(Dish.Type.FISH).size());
        assertEquals(Set.of("roasted", "tasty", "fresh", "delicious"),
                result.get(Dish.Type.FISH));
        // meat
        assertEquals(5, result.get(Dish.Type.MEAT).size());
        assertEquals(Set.of("salty", "greasy", "roasted", "fried", "crisp"),
                result.get(Dish.Type.MEAT));
        // other
        assertEquals(7, result.get(Dish.Type.OTHER).size());
        assertEquals(Set.of("salty", "greasy", "natural", "light", "tasty", "fresh", "fried"),
                result.get(Dish.Type.OTHER));

        log.info("Dish tags grouped by type: {}", result);
    }

    @Test
    void groupDishesByTypeAndCaloricLevel() {
        var result = GroupingMenu.groupDishesByTypeAndCaloricLevel(menu);

        assertNotNull(result);
        // fish
        assertEquals(1, result.get(Dish.Type.FISH).get(CaloricLevel.DIET).size());
        assertEquals(1, result.get(Dish.Type.FISH).get(CaloricLevel.NORMAL).size());
        assertNull(result.get(Dish.Type.FISH).get(CaloricLevel.FAT));
        // meat
        assertEquals(1, result.get(Dish.Type.MEAT).get(CaloricLevel.DIET).size());
        assertEquals(1, result.get(Dish.Type.MEAT).get(CaloricLevel.NORMAL).size());
        assertEquals(1, result.get(Dish.Type.MEAT).get(CaloricLevel.FAT).size());
        // other
        assertEquals(2, result.get(Dish.Type.OTHER).get(CaloricLevel.DIET).size());
        assertEquals(2, result.get(Dish.Type.OTHER).get(CaloricLevel.NORMAL).size());
        assertNull(result.get(Dish.Type.OTHER).get(CaloricLevel.FAT));

        log.info("Dishes grouped by type and caloric level: {}", result);
    }

    @Test
    void countDishesInGroups() {
        var result = GroupingMenu.countDishesInGroups(menu);

        assertNotNull(result);
        assertEquals(2, result.get(Dish.Type.FISH));
        assertEquals(3, result.get(Dish.Type.MEAT));
        assertEquals(4, result.get(Dish.Type.OTHER));

        log.info("Number of dishes in groups: {}", result);
    }

    @Test
    void mostCaloricDishesByType() {
        var result = GroupingMenu.mostCaloricDishesByType(menu);

        assertNotNull(result);
        result.get(Dish.Type.FISH).ifPresent(dish -> assertEquals("salmon", dish.name()));
        result.get(Dish.Type.MEAT).ifPresent(dish -> assertEquals("pork", dish.name()));
        result.get(Dish.Type.OTHER).ifPresent(dish -> assertEquals("pizza", dish.name()));

        log.info("Most caloric dishes by type: {}", result);
    }

    @Test
    void mostCaloricDishesByTypeWithoutOptional() {
        var result = GroupingMenu.mostCaloricDishesByTypeWithoutOptional(menu);

        assertNotNull(result);
        assertEquals("salmon", result.get(Dish.Type.FISH).name());
        assertEquals("pork", result.get(Dish.Type.MEAT).name());
        assertEquals("pizza", result.get(Dish.Type.OTHER).name());

        log.info("Most caloric dishes by type: {}", result);
    }

    @Test
    void mostCaloricDishesByTypeWithToMap() {
        var result = GroupingMenu.mostCaloricDishesByTypeWithToMap(menu);

        assertNotNull(result);
        assertEquals("salmon", result.get(Dish.Type.FISH).name());
        assertEquals("pork", result.get(Dish.Type.MEAT).name());
        assertEquals("pizza", result.get(Dish.Type.OTHER).name());

        log.info("Most caloric dishes by type: {}", result);
    }

    @Test
    void sumCaloriesByType() {
        var result = GroupingMenu.sumCaloriesByType(menu);

        assertNotNull(result);
        assertEquals(850, result.get(Dish.Type.FISH));
        assertEquals(1900, result.get(Dish.Type.MEAT));
        assertEquals(1550, result.get(Dish.Type.OTHER));

        log.info("Total calories by type: {}", result);
    }

    @Test
    void caloricLevelsByType() {
        var result = GroupingMenu.caloricLevelsByType(menu);

        assertNotNull(result);
        assertEquals(2, result.get(Dish.Type.FISH).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL),
                result.get(Dish.Type.FISH));
        assertEquals(3, result.get(Dish.Type.MEAT).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL, CaloricLevel.FAT),
                result.get(Dish.Type.MEAT));
        assertEquals(2, result.get(Dish.Type.OTHER).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL),
                result.get(Dish.Type.OTHER));

        log.info("Caloric levels by type: {}", result);
    }

    @Test
    void caloricLevelsByTypeHashSet() {
        var result = GroupingMenu.caloricLevelsByTypeHashSet(menu);

        assertNotNull(result);
        assertEquals(2, result.get(Dish.Type.FISH).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL),
                result.get(Dish.Type.FISH));
        assertEquals(3, result.get(Dish.Type.MEAT).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL, CaloricLevel.FAT),
                result.get(Dish.Type.MEAT));
        assertEquals(2, result.get(Dish.Type.OTHER).size());
        assertEquals(Set.of(CaloricLevel.DIET, CaloricLevel.NORMAL),
                result.get(Dish.Type.OTHER));

        log.info("Caloric levels by type: {}", result);
    }
}
