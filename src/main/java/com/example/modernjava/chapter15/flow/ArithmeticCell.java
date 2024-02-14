package com.example.modernjava.chapter15.flow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArithmeticCell extends SimpleCell {
    private int left;
    private int right;

    public ArithmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        onNext(left + right);
    }

    public void setRight(int right) {
        this.right = right;
        onNext(right + this.left);
    }
}
