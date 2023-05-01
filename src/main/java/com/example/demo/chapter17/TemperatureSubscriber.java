package com.example.demo.chapter17;

import java.util.concurrent.Flow;

public class TemperatureSubscriber implements Flow.Subscriber<TemperatureInfo> {
    public Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TemperatureInfo item) {
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }
}
