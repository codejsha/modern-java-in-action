package com.example.demo.chapter16.shop.async;

import com.example.demo.util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        this.random = new Random((long) name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName() {
        return name;
    }

    public Random getRandom() {
        return random;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        final var futurePrice = new CompletableFuture<Double>();
        new Thread(() -> {
            final var price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    private double calculatePrice(String product) {
        ThreadUtils.delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
