package com.projector.algoritms.triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Point> points = inputPoints();
        int size = points.size();

        double maxPerimeter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1 ; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    try {
                        Triangle triangle = new Triangle(points.get(i), points.get(j), points.get(k));
                        if (maxPerimeter < triangle.perimeter())
                            maxPerimeter = triangle.perimeter();
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            }
        }
        System.out.println(maxPerimeter);
    }


    public static List<Point> inputPoints() {
        Scanner sc = new Scanner(System.in);
        int pointCount = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            Scanner ss = new Scanner(System.in);
            String s = ss.nextLine();
            String[] point = s.split(" ");
            Point pointObject = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
            points.add(pointObject);
        }
        return points;
    }
}
