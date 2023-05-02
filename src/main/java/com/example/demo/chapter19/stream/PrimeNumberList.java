package com.example.demo.chapter19.stream;

import java.util.stream.IntStream;

public class PrimeNumberList {
    /**
     * Generate a stream of numbers starting from 2.
     *
     * @return the stream of numbers
     */
    public static IntStream numbers() {
        return IntStream.iterate(2, i -> i + 1);
    }

    /**
     * Get the head of the stream.
     *
     * @param numbers the stream of numbers
     * @return the head of the stream
     */
    public static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    /**
     * Get the tail of the stream.
     *
     * @param numbers the stream of numbers
     * @return the tail of the stream
     */
    public static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    /**
     * Generate a stream of prime numbers. The algorithm is based on the Sieve of Eratosthenes.
     * This method occurs a IllegalStateException: stream has already been operated upon or closed
     *
     * @param numbers the stream of numbers
     * @return the stream of prime numbers
     */
    public static IntStream primes(IntStream numbers) {
        return IntStream.concat(
                IntStream.of(head(numbers)),
                primes(tail(numbers).filter(n -> n % head(numbers) != 0)));
    }
}
