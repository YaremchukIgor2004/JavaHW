package hw_06;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class B05_02 {
    public static void main(String[] args) {
        processFile("B05_02__input.txt");
    }

    public static void processFile(String inputFile) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            for (String line : lines) {
                System.out.println("Рядок: " + line);
                System.out.println("Умова A: " + (A(line) ? "виконується" : "не виконується"));
                System.out.println("Умова B: " + (B(line) ? "виконується" : "не виконується"));
                System.out.println("Умова C: " + (C(line) ? "виконується" : "не виконується"));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean A(String input) {
        if (input.length() == 0 || !Character.isDigit(input.charAt(0)) || input.charAt(0) == '0') {
            return false;
        }
        int digit = Character.getNumericValue(input.charAt(0));
        String letters = input.substring(1);
        return letters.length() == digit;
    }


    public static boolean B(String input) {
        int digitCount = 0;
        int digitValue = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                digitValue = Character.getNumericValue(c);
            }
        }
        return digitCount == 1 && digitValue == input.length();
    }

    public static boolean C(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum == input.length();
    }
}
