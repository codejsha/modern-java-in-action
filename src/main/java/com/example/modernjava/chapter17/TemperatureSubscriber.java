package com.example.modernjava.chapter17;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Flow;

@Slf4j
public class TemperatureSubscriber implements Flow.Subscriber<TemperatureInfo> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TemperatureInfo item) {
        log.info(item.toString());
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("Done!");
    }
}
