package hw_02;

import java.util.Scanner;

public class B01_04 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть перше число:");
        int num1 = scanner.nextInt();
        System.out.println("Введіть друге число:");
        int num2 = scanner.nextInt();
        System.out.println("Введіть третє число:");
        int num3 = scanner.nextInt();
        double geometricMean = Math.cbrt(num1 * num2 * num3);
        System.out.print(geometricMean);
    }
}
