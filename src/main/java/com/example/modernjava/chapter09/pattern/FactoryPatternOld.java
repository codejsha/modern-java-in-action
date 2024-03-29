package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryPatternOld {
    public static void main(String[] args) {
        final var product = ProductFactory.createProduct("loan");
        log.info("Product: {}", product.getClass().getSimpleName());
    }

    public interface Product {
    }

    public static class ProductFactory {
        public static Product createProduct(String name) {
            return switch (name) {
                case "loan" -> new Loan();
                case "stock" -> new Stock();
                case "bond" -> new Bond();
                default -> throw new RuntimeException("No such product " + name);
            };
        }
    }

    public static class Loan implements Product {
    }

    public static class Stock implements Product {
    }

    public static class Bond implements Product {
    }
}
