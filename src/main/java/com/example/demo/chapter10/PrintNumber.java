package com.example.demo.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class PrintNumber {
    public static void printNumbersByAnonymousClass(List<String> numbers) {
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String number) {
                log.info("{}", number);
            }
        });
    }

    public static void printNumbersByLambda(List<String> numbers) {
        numbers.forEach(number -> log.info("{}", number));
    }

    public static void printNumbersByMethodReference(List<String> numbers) {
        numbers.forEach(System.out::println);
    }
}
