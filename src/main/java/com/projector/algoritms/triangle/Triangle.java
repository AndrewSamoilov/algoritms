package com.projector.algoritms.triangle;

import java.util.Arrays;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        if (!isTriangle(a, b, c)){
            throw new  IllegalArgumentException("Triangle does not exist");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    private static boolean isTriangle(Point a, Point b, Point c) {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ca = c.distance(a);
        double maxDistance = Arrays.stream(new double[]{ab, bc, ca}).max().getAsDouble();
        double r = ab + bc + ca - maxDistance;
        return r > maxDistance;
    }
}
