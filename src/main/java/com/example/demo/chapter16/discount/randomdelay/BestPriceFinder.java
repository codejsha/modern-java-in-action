package com.example.demo.chapter16.discount.randomdelay;

import com.example.demo.chapter16.discount.Discount;
import com.example.demo.chapter16.discount.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class BestPriceFinder {
    private final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), (Runnable r) -> {
        var t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    private final Executor customExecutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), (Runnable r) -> {
        var t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }
}
