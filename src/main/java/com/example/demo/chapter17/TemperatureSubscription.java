package com.example.demo.chapter17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

public class TemperatureSubscription implements Flow.Subscription {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final Flow.Subscriber<? super TemperatureInfo> subscriber;
    private final String town;

    public TemperatureSubscription(Flow.Subscriber<? super TemperatureInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (var i = 0L; i < n; i++) {
                try {
                    subscriber.onNext(TemperatureInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
