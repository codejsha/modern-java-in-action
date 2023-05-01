package com.example.demo.chapter16.shop.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class ShopMain {
    public static void main(String[] args) {
        var shop = new Shop("BestShop");
        var start = System.nanoTime();
        var futurePrice = shop.getPriceAsync("my favorite product");
        var invocationTime = ((System.nanoTime() - start) / 1_000_000);
        log.info("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            double price = futurePrice.get();
            log.info("Price is " + String.format("%.2f", price));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        var retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        log.info("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        log.info("Doing something else...");
    }
}
