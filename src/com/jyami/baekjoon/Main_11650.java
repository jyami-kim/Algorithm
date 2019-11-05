package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_11650 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(points);

        for (Point p : points) {
            System.out.println(p.toString());
        }
    }
}

class Point implements Comparable<Point> {
    private int x;
    private int y;

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x > o.getX()) {
            return 1;
        } else if (this.x < o.getX()) {
            return -1;
        } else {
            if (this.y > o.getY()) {
                return 1;
            } else if (this.y < o.getY()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}