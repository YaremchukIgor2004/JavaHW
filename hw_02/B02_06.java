package hw_02;

import java.util.Scanner;

public class B02_06 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість елементів масиву:");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Кількість елементів масиву має бути додатним числом.");
            return;
        }

        double[] numbers = new double[n];
        System.out.println("Введіть " + n + " дійсних чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] != 0) {
                sum += 1.0 / numbers[i];
            } else {
                System.out.println("Елемент масиву не може дорівнювати нулю.");
                return;
            }
        }
        
        double harmonicMean = n / sum;
        System.out.println("Середнє гармонічне: " + harmonicMean);
    }
}
