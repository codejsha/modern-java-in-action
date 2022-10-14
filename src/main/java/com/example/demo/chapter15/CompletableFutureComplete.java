package com.example.demo.chapter15;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureComplete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        var a = new CompletableFuture<Integer>();
        executorService.submit(() -> a.complete(f(x)));
        int b = g(x);
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
