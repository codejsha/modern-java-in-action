package com.example.modernjava.chapter13.behavior;

public class Monster implements Movable, Rotatable, Resizable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int rotationAngle;

    public Monster(int x, int y, int width, int height, int rotationAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
    public int getWidth() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }
}
