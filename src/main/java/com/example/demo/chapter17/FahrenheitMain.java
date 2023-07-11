package com.example.demo.chapter17;

public class FahrenheitMain {
    public static void main(String[] args) {
        final var subscriber = new TemperatureSubscriber();
        final var subscription = new TemperatureSubscription(subscriber, "New York");
        subscriber.onSubscribe(subscription);
    }
}
