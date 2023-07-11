package com.example.demo.chapter16.discount;

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

    public String getPrice(String product) {
        final var price = calculatePrice(product);
        final var code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        ThreadUtils.delay();
        return ThreadUtils.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
