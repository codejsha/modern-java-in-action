package com.example.demo.chapter13.behavior;

public interface Rotatable {
    int getRotationAngle();

    void setRotationAngle(int angleInDegrees);

    default void rotateBy(int angleInDegrees) {
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
