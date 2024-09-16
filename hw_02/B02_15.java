package hw_02;

import java.util.Scanner;

public class B02_15 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть двобайтове ціле число (-32768 <-> 32767):");
        short number = scanner.nextShort();
        int zeroBitsCount = 0;
        int bitCount = 16;
        for (int i = 0; i < bitCount; i++) {
            if ((number & (1 << i)) == 0) {
                zeroBitsCount++;
            }
        }
        System.out.println("Кількість нульових бітів: " + zeroBitsCount);
    }
}
