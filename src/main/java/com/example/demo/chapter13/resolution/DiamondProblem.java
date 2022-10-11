package com.example.demo.chapter13.resolution;

public class DiamondProblem {
    interface A {
        default void hello() {
            System.out.println("Hello from A");
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
