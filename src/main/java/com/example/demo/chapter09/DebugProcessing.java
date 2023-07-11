package com.example.demo.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DebugProcessing {
    public static void main(String[] args) {
        final var numbers = List.of(2, 3, 4, 5);

        log.info("Filtering numbers: {}", filterNumbers(numbers));
    }

    public static List<Integer> filterNumbers(List<Integer> numbers) {
        return numbers.stream()
                .peek(x -> log.info("from stream: {}", x))
                .map(x -> x + 17)
                .peek(x -> log.info("    after map: {}", x))
                .filter(x -> x % 2 == 0)
                .peek(x -> log.info("        after filter: {}", x))
                .limit(3)
                .peek(x -> log.info("            after limit: {}", x))
                .toList();
    }
}
