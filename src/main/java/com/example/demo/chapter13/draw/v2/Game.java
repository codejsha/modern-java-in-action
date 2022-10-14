package com.example.demo.chapter13.draw.v2;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes = List.of(
                new Square(),
                new Rectangle(),
                new Ellipse()
        );
        Utils.paint(resizableShapes);
    }
}