package hw_03;

public class B03_06 {
    public static void classifyQuadrilaterals(Quadrilateral[] quads) {
        int squares = 0, rectangles = 0, arbitrary = 0;

        for (Quadrilateral quad : quads) {
            if (quad.isSquare()) {
                squares++;
            } else if (quad.isRectangle()) {
                rectangles++;
            } else {
                arbitrary++;
            }
        }

        System.out.println("Кількість квадратів: " + squares);
        System.out.println("Кількість прямокутників: " + rectangles);
        System.out.println("Кількість довільних чотирикутників: " + arbitrary);
    }

    public static Quadrilateral findLargestPerimeter(Quadrilateral[] quads) {
        Quadrilateral maxQuad = quads[0];
        double maxPerimeter = quads[0].getPerimeter();

        for (Quadrilateral quad : quads) {
            double perimeter = quad.getPerimeter();
            if (perimeter > maxPerimeter) {
                maxPerimeter = perimeter;
                maxQuad = quad;
            }
        }

        return maxQuad;
    }

    public static void main(String[] args) {
        Quadrilateral[] quads = {
                new Quadrilateral(new Point(0, 0), new Point(4, 0), new Point(4, 3), new Point(0, 3)),
                new Quadrilateral(new Point(0, 0), new Point(2, 0), new Point(2, 2), new Point(0, 2)),
                new Quadrilateral(new Point(0, 0), new Point(5, 1), new Point(4, 5), new Point(1, 3))
        };


        classifyQuadrilaterals(quads);
        Quadrilateral largest = findLargestPerimeter(quads);
        System.out.println("Чотирикутник з найбільшим периметром має периметр: " + largest.getPerimeter());
    }
}

