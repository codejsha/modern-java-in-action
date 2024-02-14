package com.example.modernjava.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.javatuples.Triplet;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class NumberStream {
    public static void main(String[] args) {
        final var start = 1;
        final var end = 100;

        log.info("Even numbers: {}", generateEvenNumbers(start, end));
        log.info("Pythagorean triples: {}", pythagoreanTriple1(start, end));
        log.info("Pythagorean triples: {}", pythagoreanTriple2(start, end));
    }

    /**
     * generate even numbers
     *
     * @param start start bound
     * @param end   end bound
     * @return even number list
     */
    public static List<Integer> generateEvenNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
    }

    /**
     * generate pythagorean triple
     *
     * @param start start bound
     * @param end   end bound
     * @return pythagorean triples
     */
    public static List<Triplet<Integer, Integer, Integer>> pythagoreanTriple1(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, end)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .boxed()
                        .map(b -> Triplet.with(a, b, (int) Math.sqrt(a * a + b * b))))
                .limit(5)
                .toList();
    }

    /**
     * generate pythagorean triple
     *
     * @param start start bound
     * @param end   end bound
     * @return pythagorean triples
     */
    public static List<Triplet<Integer, Integer, Integer>> pythagoreanTriple2(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, end)
                        .mapToObj(b -> Triplet.with(a, b, Math.sqrt(a * a + b * b)))
                        .filter(t -> t.getValue2() % 1 == 0))
                .map(t -> Triplet.with(t.getValue0(), t.getValue1(), t.getValue2().intValue()))
                .skip(5)
                .limit(5)
                .toList();
    }
}
