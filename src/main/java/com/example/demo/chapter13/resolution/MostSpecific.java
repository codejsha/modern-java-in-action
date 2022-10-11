package com.example.demo.chapter13.resolution;

public class MostSpecific {
    public interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    public interface B extends A {
        default void hello() {
            System.out.println("Hello from B");
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
