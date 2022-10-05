package com.example.demo.chapter07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

@Slf4j
public class ForkJoinProcessing {
    public static void main(String[] args) {
        var result = ForkJoinSumCalculator.forkJoinSum(1_000_000L);
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
            long[] numbers = LongStream.rangeClosed(1, number).toArray();
            ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
            return new ForkJoinPool().invoke(task);
        }

        @Override
        protected Long compute() {
            int length = end - start;
            if (length <= THRESHOLD) {
                return computeSequentially();
            }
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
            leftTask.fork();
            ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
            Long rightResult = rightTask.compute();
            Long leftResult = leftTask.join();
            return leftResult + rightResult;
        }

        private long computeSequentially() {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }
}
