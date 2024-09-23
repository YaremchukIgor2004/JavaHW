package hw_03;

import java.util.Scanner;

public class B02_17h {
	public static double arctg(double x, double epsilon) {
        double term = x;
        double sum = term;
        int k = 1;
        while (Math.abs(term) > epsilon) {
            term = -term * x * x * (2 * k - 1) / (2 * k + 1);
            sum += term;
            k++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення x (|x| < 1): ");
        double x = scanner.nextDouble();
        System.out.print("Введіть значення точності epsilon: ");
        double epsilon = scanner.nextDouble();
        if (Math.abs(x) >= 1) {
            System.out.println("Помилка: абсолютне значення x повинно бути менше 1.");
        } else {
            double result = arctg(x, epsilon);
            System.out.println("arctg(" + x + ") = " + result);
        }

        scanner.close();
    }
}
