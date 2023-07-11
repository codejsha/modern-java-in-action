package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class FilteringNumber {
    public static void main(String[] args) {
        final var numbers = List.of(1, 2, 1, 3, 3, 2, 4);

        // filtering unique even numbers
        log.info("Even numbers: {}", uniqueEvenNumbers(numbers));
        // filtering unique even numbers
        log.info("Even numbers: {}", filterNumbers(numbers, number -> number % 2 == 0));
        // filtering unique odd numbers
        log.info("Odd numbers: {}", filterNumbers(numbers, number -> number % 2 != 0));
        // filtering numbers smaller than 3
        log.info("Numbers smaller than 3: {}", filterNumbers(numbers, number -> number < 3));
    }

    /**
     * filtering unique even numbers
     *
     * @param numbers number list
     * @return filtered number list
     */
    public static List<Integer> uniqueEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * filtering numbers
     *
     * @param numbers   number list
     * @param predicate predicate
     * @return filtered number list
     */
    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .distinct()
                .collect(Collectors.toList());
    }
}
