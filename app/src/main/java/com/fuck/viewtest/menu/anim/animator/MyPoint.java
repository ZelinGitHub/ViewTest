package com.fuck.viewtest.menu.anim.animator;

import org.jetbrains.annotations.NotNull;

public class MyPoint {
    private float x;
    private float y;

    public MyPoint(float pX, float pY) {
        x = pX;
        y = pY;
    }

    public float getX() {
        return x;
    }

    public void setX(float pX) {
        x = pX;
    }

    public float getY() {
        return y;
    }

    public void setY(float pY) {
        y = pY;
    }


    @NotNull
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
