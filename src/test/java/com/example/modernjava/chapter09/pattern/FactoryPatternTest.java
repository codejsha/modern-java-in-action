package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class FactoryPatternTest {
    private static final Map<String, Supplier<FactoryPattern.Product>> MAP = new HashMap<>();

    @BeforeEach
    void setUp() {
        MAP.put("loan", FactoryPattern.Loan::new);
        MAP.put("stock", FactoryPattern.Stock::new);
        MAP.put("bond", FactoryPattern.Bond::new);
    }

    @Test
    void testCreateProduct() {
        final var product = FactoryPattern.ProductFactory.createProduct("loan");
        assertNotNull(product);
        assertEquals("Loan", product.getClass().getSimpleName());
        log.info("Product: {}", product.getClass().getSimpleName());
    }
}
