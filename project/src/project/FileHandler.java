package project;

import java.io.*;

/**
 * Клас для роботи з файлами (читання та запис).
 * 
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class FileHandler {

    /**
     * Читає вміст файлу.
     * 
     * @param file файл, який потрібно прочитати.
     * @return рядок із вмістом файлу.
     */
    public static String readFile(File file) {
        StringBuilder content = new StringBuilder(); // Ініціалізація StringBuilder для збереження тексту.
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Використання BufferedReader для ефективного читання файлу.
            String line;
            while ((line = reader.readLine()) != null) { // Читаємо файл рядок за рядком.
                content.append(line).append("\n"); // Додаємо рядок до StringBuilder.
            }
        } catch (IOException e) {
            // Обробка винятків у разі проблем із читанням файлу.
            e.printStackTrace();
        }
        return content.toString(); // Повертаємо зчитаний текст.
    }

    /**
     * Записує вміст у файл.
     * 
     * @param file файл, у який потрібно записати.
     * @param content рядок із вмістом для запису.
     */
    public static void writeFile(File file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Використання BufferedWriter для ефективного запису тексту.
            writer.write(content); // Записуємо текст у файл.
        } catch (IOException e) {
            // Обробка винятків у разі проблем із записом файлу.
            e.printStackTrace();
        }
    }
}

