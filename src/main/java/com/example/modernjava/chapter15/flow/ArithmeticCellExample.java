package com.example.modernjava.chapter15.flow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArithmeticCellExample {
    public static void main(String[] args) {
        exercise1();
        log.info("------------");
        exercise2();
    }

    public static void exercise1() {
        final var c1 = new SimpleCell("C1");
        final var c2 = new SimpleCell("C2");
        final var c3 = new ArithmeticCell("C3");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
    }

    public static void exercise2() {
        final var c1 = new SimpleCell("C1");
        final var c2 = new SimpleCell("C2");
        final var c3 = new ArithmeticCell("C3");
        final var c4 = new SimpleCell("C4");
        final var c5 = new ArithmeticCell("C5");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c3.subscribe(c5::setLeft);
        c4.subscribe(c5::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
        c4.onNext(1);
        c4.onNext(3);
    }
}
