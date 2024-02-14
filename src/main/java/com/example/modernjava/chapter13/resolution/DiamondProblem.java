package com.example.modernjava.chapter13.resolution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiamondProblem {
    interface A {
        default void hello() {
            log.info("Hello from A");
        }
    }

    interface B extends A {
    }

    interface C extends A {
        void hello();
    }

    static class D implements B, C {
        public static void main(String[] args) {
            new D().hello();
        }

        @Override
        public void hello() {

        }
    }
}
