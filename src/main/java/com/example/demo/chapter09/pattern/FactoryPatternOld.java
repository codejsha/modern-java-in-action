package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryPatternOld {
    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");
        log.info("Product: {}", product.getClass().getSimpleName());
    }

    public interface Product {
    }

    public static class ProductFactory {
        public static Product createProduct(String name) {
            switch (name) {
                case "loan":
                    return new Loan();
                case "stock":
                    return new Stock();
                case "bond":
                    return new Bond();
                default:
                    throw new RuntimeException("No such product " + name);
            }
        }
    }

    public static class Loan implements Product {
    }

    public static class Stock implements Product {
    }

    public static class Bond implements Product {
    }
}
