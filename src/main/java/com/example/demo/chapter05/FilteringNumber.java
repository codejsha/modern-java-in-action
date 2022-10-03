package com.example.demo.chapter05;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringNumber {
    public static void main(String[] args) {
        var numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        // filtering unique even numbers
        log.info("Even numbers: {}", uniqueEvenNumbers(numbers));
    }

    /**
     * filtering unique even numbers
     * @param numbers number list
     * @return filtered number list
     */
    public static List<Integer> uniqueEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }
}
