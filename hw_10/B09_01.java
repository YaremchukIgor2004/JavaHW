package hw_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class B09_01 {
    public static void main(String[] args) {
        long T1 = 1000;
        long T2 = 2000;
        long T3 = 3000;
        int queueCapacity = 10;
        String inputFile = "F.txt";
        String outputFile1 = "ProcessedByThread1.txt";
        String outputFile2 = "ProcessedByThread2.txt";

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(queueCapacity);

        Thread readerThread = new Thread(() -> readLinesFromFile(T1, inputFile, queue));
        Thread processorThread1 = new Thread(() -> processLinesFromQueue(T2, queue, outputFile1));
        Thread processorThread2 = new Thread(() -> processLinesFromQueue(T3, queue, outputFile2));

        readerThread.start();
        processorThread1.start();
        processorThread2.start();

        try {
            readerThread.join();
            processorThread1.join();
            processorThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void readLinesFromFile(long interval, String inputFile, ArrayBlockingQueue<String> queue) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                queue.put(line);
                Thread.sleep(interval);
            }
            queue.put("");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void processLinesFromQueue(long interval, ArrayBlockingQueue<String> queue, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            while (true) {
                String line = queue.take();
                if (line.equals("")) {
                    queue.put("");
                    break;
                }
                System.out.println("Processing line in " + Thread.currentThread().getName() + ": " + line);
                writer.write(line + "\n");
                writer.flush();
                Thread.sleep(interval);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
