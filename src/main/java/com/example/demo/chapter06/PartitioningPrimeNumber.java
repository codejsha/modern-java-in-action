package com.example.demo.chapter06;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

@Slf4j
public class PartitioningPrimeNumber {
    public static void main(String[] args) {
        log.info("Numbers partitioned in prime and non-prime: {}",
                PartitioningPrimeNumber.partitionPrimes(100));
        log.info("Numbers partitioned in prime and non-prime: {}",
                PartitioningPrimeNumber.partitionPrimesWithCustomCollector(100));

    }

    /**
     * Numbers partitioned in prime and non-prime
     *
     * @param n number
     * @return numbers partitioned in prime and non-prime
     */
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(PartitioningPrimeNumber::isPrime));
    }

    /**
     * Numbers partitioned in prime and non-prime
     *
     * @param n number
     * @return numbers partitioned in prime and non-prime
     */
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumbersCollector());
    }

    /**
     * Check if a candidate number is prime
     *
     * @param candidate candidate number
     * @return true if candidate number is prime
     */
    private static boolean isPrime(int candidate) {
        final var candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    /**
     * Check if a candidate number is prime
     *
     * @param candidate candidate number
     * @return true if candidate number is prime
     */
    private static boolean isPrime(List<Integer> primes, int candidate) {
        final var candidateRoot = (int) Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    /**
     * Prime numbers custom collector
     */
    public static class PrimeNumbersCollector
            implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<>() {{
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                acc.get(isPrime(acc.get(true), candidate))
                        .add(candidate);
            };
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return null;
            // return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            //     map1.get(true).addAll(map2.get(true));
            //     map1.get(false).addAll(map2.get(false));
            //     return map1;
            // };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
        }
    }
}
