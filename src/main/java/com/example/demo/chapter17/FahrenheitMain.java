package com.example.demo.chapter17;

public class FahrenheitMain {
    public static void main(String[] args) {
        var subscriber = new TemperatureSubscriber();
        var subscription = new TemperatureSubscription(subscriber, "New York");
        subscriber.onSubscribe(subscription);
    }
}
