package com.example.modernjava.chapter13.draw.v2;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        final var resizableShapes = List.of(
                new Square(),
                new Rectangle(),
                new Ellipse()
        );
        Utils.paint(resizableShapes);
    }
}
