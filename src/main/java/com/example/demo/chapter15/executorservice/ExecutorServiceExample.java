package com.example.demo.chapter15.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Slf4j
public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var x = 1337;

        var executorService = Executors.newFixedThreadPool(2);
        var y = executorService.submit(() -> f(x));
        var z = executorService.submit(() -> g(x));
        log.info("y + z = {}", y.get() + z.get());

        executorService.shutdown();
    }

    private static int f(int x) {
        return x + 1;
    }

    private static int g(int x) {
        return x * 2;
    }
}
