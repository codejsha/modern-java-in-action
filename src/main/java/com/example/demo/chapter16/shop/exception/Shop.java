package com.example.demo.chapter16.shop.exception;

import com.example.demo.util.ThreadUtil;

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
        var futurePrice = new CompletableFuture<Double>();
        new Thread(() -> {
            try {
                var price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;

        // return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        ThreadUtil.delay();
        throw new RuntimeException("product not available");

        // return ThreadUtil.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
