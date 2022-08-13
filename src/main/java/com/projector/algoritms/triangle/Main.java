package com.projector.algoritms.triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();

        List<Point> points = inputPoints();
        int size = points.size();

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                for (int k = j; k < size; k++) {
                    try {
                        Triangle triangle = new Triangle(points.get(i), points.get(j), points.get(k));
                        triangles.add(triangle);
                    } catch (IllegalArgumentException ignored){
                    }
                }
            }
        }
        Collections.sort(triangles);
        System.out.println(triangles.get(0).perimeter());
    }


    public static List<Point> inputPoints() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input count of points: ");
        int pointCount = sc.nextInt();

        List<Point> points = new ArrayList<>();
        System.out.println("x y");
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
