package hw_03;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}

class Quadrilateral {
    Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getPerimeter() {
        double ab = Point.distance(a, b);
        double bc = Point.distance(b, c);
        double cd = Point.distance(c, d);
        double da = Point.distance(d, a);
        return ab + bc + cd + da;
    }

    public boolean isSquare() {
        double ab = Point.distance(a, b);
        double bc = Point.distance(b, c);
        double cd = Point.distance(c, d);
        double da = Point.distance(d, a);
        return ab == bc && bc == cd && cd == da && isRectangle();
    }

    public boolean isRectangle() {
        double ab = Point.distance(a, b);
        double bc = Point.distance(b, c);
        double cd = Point.distance(c, d);
        double da = Point.distance(d, a);
        return ab == cd && bc == da;
    }
}