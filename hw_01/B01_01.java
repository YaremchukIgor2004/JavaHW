package hw_01;

import java.util.Scanner;

public class B01_01 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.println("Привіт, " + name + "!");
        scanner.close();

	}

}
