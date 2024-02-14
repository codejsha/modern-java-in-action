package com.example.modernjava.chapter13.resolution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MostSpecific {
    public interface A {
        default void hello() {
            log.info("Hello from A");
        }
    }

    public interface B extends A {
        default void hello() {
            log.info("Hello from B");
        }
    }

    public static class C extends D implements B, A {
        public static void main(String[] args) {
            new C().hello();
        }
    }

    public static class D implements A {
    }
}
