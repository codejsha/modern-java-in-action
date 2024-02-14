package com.example.modernjava.chapter15.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureComplete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final var executorService = Executors.newFixedThreadPool(10);
        final var x = 1337;

        final var a = new CompletableFuture<Integer>();
        executorService.submit(() -> a.complete(f(x)));
        final var b = g(x);
        log.info(String.valueOf(a.get() + b));

        executorService.shutdown();
    }

    private static int f(int x) {
        return x + 1;
    }

    private static int g(int x) {
        return x * 2;
    }
}
