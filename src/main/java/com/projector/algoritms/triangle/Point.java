package com.projector.algoritms.triangle;


import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


@Data
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    public double distance(Point point) {
        return sqrt(pow(point.getX() - this.getX(), 2) + pow(point.getY() - this.getY(), 2));
    }
}
