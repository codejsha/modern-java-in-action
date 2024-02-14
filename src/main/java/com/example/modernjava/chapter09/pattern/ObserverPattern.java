package com.example.modernjava.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ObserverPattern {
    public static void main(String[] args) {
        final var feed = new Feed();

        feed.registerObserver((tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                log.info("Breaking news in NY! {}", tweet);
            }
        });
        feed.registerObserver((tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                log.info("Yet another news in London... {}", tweet);
            }
        });

        feed.notifyObservers("Money money money, give me money!");
    }

    public interface Observer {
        void inform(String tweet);
    }

    public interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    public static class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.inform(tweet));
        }
    }
}
