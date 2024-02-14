package com.example.modernjava.chapter07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

@Slf4j
public class ForkJoinProcessing {
    public static void main(String[] args) {
        final var result = ForkJoinSumCalculator.forkJoinSum(1_000_000L);
        log.info("Sum of Sequence: {}", result);
    }

    public static class ForkJoinSumCalculator extends RecursiveTask<Long> {
        public static final long THRESHOLD = 10_000;
        private final long[] numbers;
        private final int start;
        private final int end;

        public ForkJoinSumCalculator(long[] numbers) {
            this(numbers, 0, numbers.length);
        }

        private ForkJoinSumCalculator(long[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        public static long forkJoinSum(long number) {
            final var numbers = LongStream.rangeClosed(1, number).toArray();
            final var task = new ForkJoinSumCalculator(numbers);
            return new ForkJoinPool().invoke(task);
        }

        @Override
        protected Long compute() {
            final var length = end - start;
            if (length <= THRESHOLD) {
                return computeSequentially();
            }
            final var leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
            leftTask.fork();
            final var rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
            final var rightResult = rightTask.compute();
            final var leftResult = leftTask.join();
            return leftResult + rightResult;
        }

        private long computeSequentially() {
            var sum = 0;
            for (var i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }
}
