package com.example.demo.chapter15;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        var x = 1337;
        var result = new Result();

        var t1 = new Thread(() -> {
            result.left = f(x);
        });
        var t2 = new Thread(() -> {
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
