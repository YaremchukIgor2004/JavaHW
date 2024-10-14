package hw_06;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class B05_08 {
    public static void main(String[] args) {
        String inputFile = "B05_08__cubes.txt";
        String outputA = "B05_08__outputA.txt";
        String outputB = "B05_08__outputB.txt";

        Size(inputFile, outputA, 5);
        Color(inputFile, outputB);
    }

    public static void Size(String inputFile, String outputFile, int size) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            List<String> result = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(" ");
                int cubeSize = Integer.parseInt(parts[0]);
                if (cubeSize == size) {
                    result.add(line);
                }
            }

            Files.write(Paths.get(outputFile), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Color(String inputFile, String outputFile) {
        Map<String, Integer> colorCount = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            for (String line : lines) {
                String[] parts = line.split(" ");
                String color = parts[1];
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }

            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
                result.add(entry.getKey() + ": " + entry.getValue());
            }

            Files.write(Paths.get(outputFile), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}