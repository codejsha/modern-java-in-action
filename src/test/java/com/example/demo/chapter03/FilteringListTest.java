package com.example.demo.chapter03;

import com.example.demo.data.AppleTestData;
import com.example.demo.constant.Color;
import com.example.demo.record.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FilteringListTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = AppleTestData.APPLE_LIST;
    }

    @Test
    void testFilterGreenApples() {
        final var apples = FilteringList.filterGreenApples(inventory);
        assertNotNull(apples);
        assertTrue(apples.size() > 0);
        apples.forEach(apple -> assertEquals(Color.GREEN, apple.color()));
        log.info("Green apples: {}", apples);
    }

    @Test
    void testEachGreenAppleWeight() {
        final var weights = FilteringList.eachGreenAppleWeight(inventory);
        assertNotNull(weights);
        assertTrue(weights.size() > 0);
        weights.forEach(weight -> assertTrue(weight > 0));
        weights.forEach(weight -> log.info("Weight of green apple: {}", weight));
    }
}
