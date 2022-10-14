package com.example.demo.chapter15;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntConsumer;

@Slf4j
public class CallbackStyleExample {
    public static void main(String[] args) {
        var x = 1337;
        var result = new Result();

        f(x, y -> {
            result.left = y;
            log.info(String.valueOf(result.left + result.right));
        });

        g(x, z -> {
            result.right = z;
            log.info(String.valueOf(result.left + result.right));
        });

    }

    private static void f(int x, IntConsumer dealWithResult) {
        dealWithResult.accept(foo(x));
    }

    private static void g(int x, IntConsumer dealWithResult) {
        dealWithResult.accept(bar(x));
    }

    private static int foo(int x) {
        return x + 1;
    }

    private static int bar(int x) {
        return x * 2;
    }

    private static class Result {
        private int left;
        private int right;
    }
}
