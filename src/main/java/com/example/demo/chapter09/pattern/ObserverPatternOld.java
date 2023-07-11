package com.example.demo.chapter09.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ObserverPatternOld {
    public static void main(String[] args) {
        final var feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The queen said her favourite book is Java 8 & 9 in Action!");
    }

    public interface Observer {
        void inform(String tweet);
    }

    public interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    public static class NYTimes implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                log.info("Breaking news in NY! {}", tweet);
            }
        }
    }

    public static class Guardian implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                log.info("Yet another news in London... {}", tweet);
            }
        }
    }

    public static class LeMonde implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                log.info("Today cheese, wine and news! {}", tweet);
            }
        }
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
