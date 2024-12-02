package project;

import java.util.*;

/**
 * Клас для аналізу тексту: підрахунок гласних, спеціальних символів та частотної гістограми.
 * 
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class TextAnalyzer {

    /**
     * Генерує звіт про текстовий аналіз.
     * 
     * @param text текст для аналізу.
     * @return рядок зі звітом.
     */
    public static String generateAnalysisReport(String text) {
        int vowels = countVowels(text); // Підрахунок кількості голосних.
        int specialChars = countSpecialCharacters(text); // Підрахунок спеціальних символів.
        Map<String, Integer> wordHistogram = generateWordHistogram(text); // Гістограма слів.
        Map<Character, Integer> letterHistogram = generateLetterHistogram(text); // Гістограма літер.

        StringBuilder report = new StringBuilder();
        report.append("Vowels: ").append(vowels).append("\n"); // Додаємо кількість голосних.
        report.append("Special Characters: ").append(specialChars).append("\n\n"); // Додаємо кількість спецсимволів.

        report.append("Word Histogram:\n"); // Додаємо гістограму слів.
        for (Map.Entry<String, Integer> entry : wordHistogram.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        report.append("\nLetter Histogram:\n"); // Додаємо гістограму літер.
        for (Map.Entry<Character, Integer> entry : letterHistogram.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return report.toString(); // Повертаємо сформований звіт.
    }

    /**
     * Підраховує кількість голосних у тексті.
     * 
     * @param text текст для аналізу.
     * @return кількість голосних.
     */
    private static int countVowels(String text) {
        // Фільтруємо символи, які є голосними.
        return (int) text.chars().filter(c -> "AEIOUaeiou".indexOf(c) != -1).count();
    }

    /**
     * Підраховує кількість спеціальних символів у тексті.
     * 
     * @param text текст для аналізу.
     * @return кількість спеціальних символів.
     */
    private static int countSpecialCharacters(String text) {
        // Фільтруємо символи, які не є літерами, цифрами або пробілами.
        return (int) text.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c)).count();
    }

    /**
     * Створює гістограму слів із тексту.
     * 
     * @param text текст для аналізу.
     * @return Map зі словами та їх частотами.
     */
    private static Map<String, Integer> generateWordHistogram(String text) {
        Map<String, Integer> histogram = new HashMap<>();
        String[] words = text.split("\\W+"); // Розбиваємо текст на слова.
        for (String word : words) {
            // Додаємо слова до гістограми або збільшуємо їх кількість.
            histogram.put(word, histogram.getOrDefault(word, 0) + 1);
        }
        return histogram; // Повертаємо сформовану гістограму.
    }

    /**
     * Створює гістограму літер із тексту.
     * 
     * @param text текст для аналізу.
     * @return Map із літерами та їх частотами.
     */
    private static Map<Character, Integer> generateLetterHistogram(String text) {
        Map<Character, Integer> histogram = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) { // Фільтруємо лише літери.
                c = Character.toLowerCase(c); // Перетворюємо на нижній регістр.
                histogram.put(c, histogram.getOrDefault(c, 0) + 1); // Додаємо літеру до гістограми.
            }
        }
        return histogram; // Повертаємо сформовану гістограму.
    }
}
