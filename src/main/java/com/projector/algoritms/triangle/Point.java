package com.projector.algoritms.triangle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;



public class Point {
    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return sqrt(pow(point.getX() - this.getX(), 2) + pow(point.getY() - this.getY(), 2));
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
