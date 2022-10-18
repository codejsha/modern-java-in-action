package com.example.demo.chapter13.draw.v1;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        var resizableShapes = List.of(
                new Square(),
                new Rectangle(),
                new Ellipse()
        );
        Utils.paint(resizableShapes);
    }
}
