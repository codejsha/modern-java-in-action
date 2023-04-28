package com.example.demo.chapter07;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx4G"})
@Slf4j
public class ParallelProcessing {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    /**
     * Sum by sequential stream
     *
     * @param config config
     * @return sum
     */
    @Benchmark
    public static long sequentialSum(Config config) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(config.number)
                .reduce(0L, Long::sum);
    }

    /**
     * Sum by parallel stream
     *
     * @param config config
     * @return sum
     */
    @Benchmark
    public static long parallelSum(Config config) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(config.number)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /**
     * Sum of range by sequential stream
     *
     * @param config config
     * @return sum
     */
    @Benchmark
    public static long rangedSum(Config config) {
        return LongStream.rangeClosed(1, config.number)
                .reduce(0L, Long::sum);
    }

    /**
     * Sum of range by parallel stream
     *
     * @param config config
     * @return sum
     */
    @Benchmark
    public static long parallelRangedSum(Config config) {
        return LongStream.rangeClosed(1, config.number)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /**
     * Config class
     */
    @State(Scope.Benchmark)
    public static class Config {
        @Param({"100000000"})
        long number;

        @TearDown(Level.Invocation)
        public void tearDown() {
            System.gc();
        }
    }
}
