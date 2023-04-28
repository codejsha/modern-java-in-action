package com.example.demo.chapter15.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        var scheduledExecutorService = Executors.newScheduledThreadPool(10);
        work1();
        scheduledExecutorService.schedule(ScheduledExecutorServiceExample::work2, 10, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

    public static void work1() {
        log.info("Hello from Work1!");
    }

    public static void work2() {
        log.info("Hello from Work2!");
    }
}
