package com.example.demo.chapter17;

public class CelsiusMain {
    public static void main(String[] args) {
        var subscriber = new TemperatureSubscriber();
        var subscription = new TemperatureSubscription(subscriber, "New York");
        var processor = new TemperatureProcessor();
        processor.subscribe(subscriber);
        processor.onSubscribe(subscription);
    }
}
