package com.example.demo.chapter15.flow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleCellExample {
    public static void main(String[] args) {
        var c1 = new SimpleCell("C1");
        var c2 = new SimpleCell("C2");
        var c3 = new SimpleCell("C3");

        c1.subscribe(c3);
        c1.onNext(10);
        c2.onNext(20);
    }
}
