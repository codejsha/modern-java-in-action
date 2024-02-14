package com.example.modernjava.chapter05;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class BuildingStream {
    public static void main(String[] args) {
        log.info("Streams of values: {}", streamsOfValues().toList());
        log.info("Stream from nullable: {}", streamFromNullable().toList());
        log.info("Streams of arrays: {}", streamsFromArrays().toList());
        log.info("Unique word count from file: {}", streamsFromFiles());
        log.info("Streams of even numbers: {}", streamsOfEvenNumbers().toList());
        log.info("Streams of even numbers: {}", streamsOfEvenNumbers2().toList());
        log.info("Streams of even numbers: {}", streamsOfMultipleOfFour().toList());
        log.info("Streams of random numbers: {}", streamsOfRandomValues().toList());
        log.info("Streams of Fibonacci numbers: {}", streamsOfFibonacciSequence().toList());
    }

    /**
     * streams of values
     *
     * @return stream
     */
    public static Stream<String> streamsOfValues() {
        return Stream.of("Modern", "Java", "In", "Action")
                .map(String::toUpperCase);
    }

    /**
     * stream from nullable
     *
     * @return stream
     */
    public static Stream<String> streamFromNullable() {
        return Stream.of("ALPHA", "BETA", "GAMMA")
                .flatMap(key -> Stream.ofNullable(System.getenv(key)));
    }

    /**
     * streams of arrays
     *
     * @return stream
     */
    public static Stream<String> streamsFromArrays() {
        return Arrays.stream(new String[]{"Modern", "Java", "In", "Action"})
                .map(String::toUpperCase);
    }

    /**
     * unique word count from files
     *
     * @return unique word count
     */
    public static Integer streamsFromFiles() {
        try (final var lines = Files.lines(Paths.get("LICENSE"), StandardCharsets.UTF_8)) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> word.length() > 0)
                    .map(String::toLowerCase)
                    .map(word -> word.replaceAll("[^a-zA-Z0-9]", ""))
                    .distinct()
                    .reduce(0, (count, word) -> count + 1, Integer::sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * streams from functions
     * streams of even numbers
     *
     * @return stream
     */
    public static Stream<Integer> streamsOfEvenNumbers() {
        return Stream.iterate(0, n -> n + 2)
                .limit(10);
    }

    /**
     * streams from functions
     * streams of even numbers
     *
     * @return stream
     */
    public static Stream<Integer> streamsOfEvenNumbers2() {
        return Stream.iterate(0, n -> n < 100, n -> n + 2);
    }

    /**
     * streams from functions
     * streams of even numbers
     *
     * @return stream
     */
    public static Stream<Integer> streamsOfMultipleOfFour() {
        return Stream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100);
    }

    /**
     * streams from functions
     * streams of random numbers
     *
     * @return stream
     */
    public static Stream<Double> streamsOfRandomValues() {
        return Stream.generate(Math::random)
                .limit(10);
    }

    /**
     * streams from functions
     * streams of Fibonacci numbers
     *
     * @return stream
     */
    public static Stream<Integer> streamsOfFibonacciSequence() {
        return IntStream.generate(new FibonacciSupplier())
                .limit(10)
                .boxed();
    }

    /**
     * fibonacci supplier
     */
    private static class FibonacciSupplier implements IntSupplier {
        private int previous = 0;
        private int current = 1;

        @Override
        public int getAsInt() {
            final var previousValue = this.previous;
            final var nextValue = this.previous + this.current;
            this.previous = this.current;
            this.current = nextValue;
            return previousValue;
        }
    }
}
