package com.example.demo.chapter17;

public class CelsiusMain {
    public static void main(String[] args) {
        final var subscriber = new TemperatureSubscriber();
        final var subscription = new TemperatureSubscription(subscriber, "New York");
        final var processor = new TemperatureProcessor();
        processor.subscribe(subscriber);
        processor.onSubscribe(subscription);
    }
}
