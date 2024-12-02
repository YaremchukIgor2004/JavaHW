package project;

import javax.swing.JTextPane;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас для підсвічування синтаксису у текстовій області.
 *
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class SyntaxHighlighter {

    /**
     * Завантажує правила підсвічування синтаксису з файлу.
     *
     * @param rulesFile файл, який містить правила (ключ:колір).
     * @return Map, де ключ — це ключове слово, а значення — колір.
     */
    public static Map<String, Color> loadSyntaxRules(File rulesFile) {
        Map<String, Color> syntaxRules = new HashMap<>(); // Ініціалізація Map для збереження правил.
        try {
            // Читаємо файл правил та розділяємо на рядки.
            String[] rules = FileHandler.readFile(rulesFile).split("\n");
            for (String rule : rules) {
                String[] parts = rule.split(":"); // Розділяємо ключове слово та колір.
                if (parts.length == 2) { // Перевіряємо коректність формату.
                    String keyword = parts[0].trim(); // Видаляємо зайві пробіли.
                    Color color = Color.decode(parts[1].trim()); // Перетворюємо колір у форматі HEX.
                    syntaxRules.put(keyword, color); // Додаємо правило у Map.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading syntax rules: " + e.getMessage());
        }
        return syntaxRules; // Повертаємо зчитані правила.
    }

    /**
     * Застосовує підсвічування синтаксису до текстової панелі.
     *
     * @param textPane текстова панель, до якої застосовуються правила.
     * @param rulesFile файл із правилами підсвічування.
     */
    public static void applySyntaxHighlighting(JTextPane textPane, File rulesFile) {
        String text = textPane.getText(); // Отримуємо текст із текстової панелі.
        StyledDocument doc = textPane.getStyledDocument(); // Отримуємо документ для стилізації.

        // Скидаємо попереднє форматування.
        doc.setCharacterAttributes(0, text.length(), new SimpleAttributeSet(), true);

        // Завантажуємо правила підсвічування.
        Map<String, Color> syntaxRules = loadSyntaxRules(rulesFile);

        // Перебираємо кожне правило.
        for (Map.Entry<String, Color> entry : syntaxRules.entrySet()) {
            String keyword = entry.getKey(); // Ключове слово.
            Color color = entry.getValue(); // Колір підсвічування.

            // Створюємо регулярний вираз для точного збігу ключового слова.
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b");
            Matcher matcher = pattern.matcher(text);

            // Встановлюємо колір для знайденого слова.
            SimpleAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setForeground(attr, color);

            // Застосовуємо підсвічування до кожного збігу.
            while (matcher.find()) {
                int start = matcher.start(); // Початкова позиція збігу.
                int length = matcher.end() - start; // Довжина збігу.
                doc.setCharacterAttributes(start, length, attr, false); // Підсвічуємо текст.
            }
        }
    }
}

