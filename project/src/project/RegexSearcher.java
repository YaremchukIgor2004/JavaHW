package project;

import java.util.regex.*;

/**
 * Клас для пошуку регулярних виразів у тексті.
 * 
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class RegexSearcher {

    /**
     * Знаходить усі збіги у тексті за регулярним виразом.
     * 
     * @param regex регулярний вираз для пошуку.
     * @param text текст, у якому виконувати пошук.
     * @return рядок зі знайденими збігами або повідомлення про їх відсутність.
     */
    public static String findMatches(String regex, String text) {
        StringBuilder matches = new StringBuilder(); // Ініціалізація StringBuilder для результатів.
        Pattern pattern = Pattern.compile(regex); // Створення шаблону регулярного виразу.
        Matcher matcher = pattern.matcher(text); // Пошук збігів у тексті.
        while (matcher.find()) { // Перевірка кожного збігу.
            matches.append(matcher.group()).append("\n"); // Додаємо знайдені результати.
        }
        // Повертаємо результати або повідомлення про відсутність збігів.
        return matches.length() > 0 ? matches.toString() : "No matches found.";
    }
}
