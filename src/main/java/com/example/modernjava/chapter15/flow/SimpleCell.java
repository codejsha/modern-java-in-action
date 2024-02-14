package com.example.modernjava.chapter15.flow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.Consumer;

@Slf4j
public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
    private final List<Subscriber<? super Integer>> subscribers;
    private final String name;
    private int value;

    public SimpleCell(String name) {
        this.value = 0;
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    public List<Subscriber<? super Integer>> getSubscribers() {
        return subscribers;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(value));
    }

    public void subscribe(Consumer<? super Integer> onNext) {
        subscribers.add(new Flow.Subscriber<>() {
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onNext(Integer val) {
                onNext.accept(val);
            }

            @Override
            public void onSubscribe(Flow.Subscription s) {
            }
        });
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Integer item) {
        value = item;
        log.info(name + ":" + value);
        notifyAllSubscribers();
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
