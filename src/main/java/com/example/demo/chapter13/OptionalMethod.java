package com.example.demo.chapter13;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalMethod {
    public static void main(String[] args) {
        var tiger = new Tiger();
        tiger.run();
    }

    public interface Animal {
        void eat();

        default void sleep() {
            log.info("Animal sleep");
        }

        default void run() {
            log.info("Animal run");
        }

        default void fly() {
            throw new UnsupportedOperationException();
        }
    }

    public static class Tiger implements Animal {
        @Override
        public void eat() {
            log.info("Tiger eat");
        }

        @Override
        public void sleep() {
            log.info("Tiger sleep");
        }

        @Override
        public void run() {
            log.info("Tiger run");
        }
    }
}
