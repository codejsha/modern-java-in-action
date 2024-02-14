package com.example.modernjava.chapter16.shop.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class ShopMain {
    public static void main(String[] args) {
        final var shop = new Shop("BestShop");
        final var start = System.nanoTime();
        final var futurePrice = shop.getPriceAsync("my favorite product");
        final var invocationTime = ((System.nanoTime() - start) / 1_000_000);
        log.info("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            final double price = futurePrice.get();
            log.info("Price is " + String.format("%.2f", price));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        final var retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        log.info("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        log.info("Doing something else...");
    }
}
