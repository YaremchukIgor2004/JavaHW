package hw_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class B08_04 {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
            new Point(1, 2),
            new Point(3, 4),
            new Point(0, 5),
            new Point(1, 1)
        );

        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(Point::distance));
        queue.addAll(points);
        System.out.println("Точки у порядку зростання відстані до центру координат:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}