package com.example.modernjava.chapter13.draw.v2;

public class Rectangle implements Resizable {
    @Override
    public void Draw() {

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
    public void setRelativeSize(int wFactor, int hFactor) {
        Resizable.super.setRelativeSize(wFactor, hFactor);
    }
}
