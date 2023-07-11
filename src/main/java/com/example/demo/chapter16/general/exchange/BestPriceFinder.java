package com.example.demo.chapter16.general.exchange;

import com.example.demo.chapter16.general.Shop;
import com.example.demo.chapter16.general.exchange.ExchangeService.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    public List<String> findPricesInUSD(String product) {
        final var priceFutures = new ArrayList<CompletableFuture<Double>>();
        for (var shop : shops) {
            final var futurePriceInUSD = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD))
                                    .completeOnTimeout(ExchangeService.DEFAULT_RATE, 1, TimeUnit.SECONDS),
                            (price, rate) -> price * rate
                    )
                    .orTimeout(3, TimeUnit.SECONDS);
            priceFutures.add(futurePriceInUSD);
        }
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .map(price -> /*shop.getName() +*/ " price is " + price)
                .toList();
    }

    public List<String> findPricesInUSD2(String product) {
        final List<CompletableFuture<String>> priceFutures = new ArrayList<>();
        for (var shop : shops) {
            final var futurePriceInUSD = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)),
                            (price, rate) -> price * rate
                    ).thenApply(price -> shop.getName() + " price is " + price);
            priceFutures.add(futurePriceInUSD);
        }
        return priceFutures
                .stream()
                .map(CompletableFuture::join)
                .toList();
    }

    public List<String> findPricesInUSD3(String product) {
        final var priceFuturesStream = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)),
                                (price, rate) -> price * rate)
                        .thenApply(price -> shop.getName() + " price is " + price));
        final var priceFutures = priceFuturesStream.toList();
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }
}
