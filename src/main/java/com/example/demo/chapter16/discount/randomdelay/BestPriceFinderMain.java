package com.example.demo.chapter16.discount.randomdelay;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class BestPriceFinderMain {
    private static final BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        var product = "myPhone27S";
        long start = System.nanoTime();
        var futures = bestPriceFinder.findPricesStream(product)
                .map(f -> f.thenAccept(s -> log.info("{} (done in {} msecs)", s, ((System.nanoTime() - start) / 1_000_000))))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        log.info("All shops have now responded in {} msecs", ((System.nanoTime() - start) / 1_000_000));
    }
}
