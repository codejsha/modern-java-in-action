package com.example.demo.chapter16.general;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class BestPriceFinderMain {
    private static final BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        final long start = System.nanoTime();
        log.info("{}", s.get());
        final long duration = (System.nanoTime() - start) / 1_000_000;
        log.info("{} done in {} msecs", msg, duration);
    }
}
