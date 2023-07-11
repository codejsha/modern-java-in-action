package com.example.demo.chapter19.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberUtils {
    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i + 1)
                .filter(PrimeNumberUtils::isPrime)
                .limit(n);
    }

    private static boolean isPrime(Integer num) {
        final var candidateRoot = (int) Math.sqrt((double) num);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> num % i == 0);
    }
}
