package com.example.demo.chapter08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class CollectionFactoryTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateList() {
        final var result = CollectionFactory.createList();
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("List: {}", result);
    }

    @Test
    void testCreateSet() {
        final var result = CollectionFactory.createSet();
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Set: {}", result);
    }

    @Test
    void testCreateMap() {
        final var result = CollectionFactory.createMap();
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Map: {}", result);
    }

    @Test
    void testCreateMap2() {
        final var result = CollectionFactory.createMap2();
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Map: {}", result);
    }
}
