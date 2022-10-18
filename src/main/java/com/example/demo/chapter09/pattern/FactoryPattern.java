package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
public class FactoryPattern {
    private static final Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static void main(String[] args) {
        Supplier<Product> loanSupplier = Loan::new;
        var product1 = loanSupplier.get();
        log.info("Product1: {}", product1.getClass().getSimpleName());

        var product2 = ProductFactory.createProduct("loan");
        log.info("Product2: {}", product2.getClass().getSimpleName());
    }

    public interface Product {
    }

    public static class ProductFactory {
        public static Product createProduct(String name) {
            var product = map.get(name);
            if (product != null) {
                return product.get();
            }
            throw new RuntimeException("No such product " + name);
        }
    }

    public static class Loan implements Product {
    }

    public static class Stock implements Product {
    }

    public static class Bond implements Product {
    }
}
