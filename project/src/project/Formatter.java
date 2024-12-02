package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для форматування та збереження тексту у різних форматах.
 * 
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class Formatter {

    /**
     * Зберігає текст у форматі Markdown.
     * 
     * @param text текст для збереження.
     * @param file файл, у який буде збережено текст.
     */
    public static void saveAsMarkdown(String text, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            // Форматуємо текст у стилі Markdown.
            String markdown = "# Formatted Text\n\n" + text.replaceAll("(?m)^", "- ");
            writer.write(markdown); // Записуємо Markdown у файл.
            System.out.println("Markdown saved successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error while saving Markdown: " + e.getMessage());
        }
    }

    /**
     * Зберігає текст у форматі HTML.
     * 
     * @param text текст для збереження.
     * @param file файл, у який буде збережено текст.
     */
    public static void saveAsHTML(String text, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            // Форматуємо текст у стилі HTML.
            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Formatted Text</title>
                    <style>
                        body { font-family: Arial, sans-serif; margin: 20px; }
                        pre { background: #f4f4f4; padding: 10px; border-radius: 5px; }
                    </style>
                </head>
                <body>
                    <h1>Formatted Text</h1>
                    <pre>%s</pre>
                </body>
                </html>
                """.formatted(text.replace("&", "&amp;") // Замінюємо спеціальні символи.
                                  .replace("<", "&lt;")
                                  .replace(">", "&gt;"));
            writer.write(html); // Записуємо HTML у файл.
            System.out.println("HTML saved successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error while saving HTML: " + e.getMessage());
        }
    }
}
