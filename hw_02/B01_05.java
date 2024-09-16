package hw_02;

import java.util.Scanner;

public class B01_05 {
	public static void main(String[] args) {
        int N, M;

        if (args.length == 2) {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть число N:");
            N = scanner.nextInt();
            System.out.println("Введіть число M:");
            M = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int randomNumber = (int) (Math.random() * M);
            System.out.println(randomNumber);
        }
    }
}
