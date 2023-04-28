package com.example.demo.chapter15.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executorService = Executors.newFixedThreadPool(10);
        var x = 1337;

        var a = new CompletableFuture<Integer>();
        var b = new CompletableFuture<Integer>();
        var c = a.thenCombine(b, Integer::sum);
        executorService.submit(() -> a.complete(f(x)));
        executorService.submit(() -> b.complete(g(x)));

        log.info(String.valueOf(c.get()));
        executorService.shutdown();
    }

    private static int f(int x) {
        return x + 1;
    }

    private static int g(int x) {
        return x * 2;
    }
}
