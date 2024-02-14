package com.example.modernjava.chapter13.behavior;

public class Sun implements Movable, Rotatable {
    private final int x;
    private final int y;
    private final int rotationAngle;

    public Sun(int x, int y, int rotationAngle) {
        this.x = x;
        this.y = y;
        this.rotationAngle = rotationAngle;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }
}
