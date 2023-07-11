package com.example.demo.chapter16;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class LongComputation {
    public static void main(String[] args) {
        asyncComputation();
    }

    public static void asyncComputation() {
        final var executorService = Executors.newCachedThreadPool();

        // anonymous class
        // var future = executorService.submit(new Callable<Double>() {
        //     @Override
        //     public Double call() throws Exception {
        //         return doSomeLongComputation();
        //     }
        // });

        // lambda
        // var future = executorService.submit(() -> doSomeLongComputation());

        // method reference
        final var future = executorService.submit(LongComputation::doSomeLongComputation);

        doSomethingElse();

        try {
            final var result = future.get(1, TimeUnit.SECONDS);
            log.info("Result: {}", result);
        } catch (ExecutionException e) {
            log.error("Computation error", e);
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
        } catch (TimeoutException e) {
            log.error("Timeout", e);
        } catch (Exception e) {
            log.error("Error", e);
        }
    }

    private static Double doSomeLongComputation() {
        log.info("doSomeLongComputation");
        return 2.0;
    }

    private static void doSomethingElse() {
        log.info("doSomethingElse");
    }
}
