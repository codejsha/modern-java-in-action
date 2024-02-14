package com.example.modernjava.chapter15.executorservice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        final var x = 1337;
        final var result = new Result();

        final var t1 = new Thread(() -> {
            result.left = f(x);
        });
        final var t2 = new Thread(() -> {
            result.right = g(x);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("Result: {}", result.left + result.right);
    }

    private static int f(int x) {
        return x + 1;
    }

    private static int g(int x) {
        return x * 2;
    }

    private static class Result {
        private int left;
        private int right;
    }
}
