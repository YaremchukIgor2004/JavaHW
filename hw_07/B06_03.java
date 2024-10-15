package hw_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_03 {

    public static void main(String[] args) {
        String PATTERN = "^\\s*[+-]?\\s*\\d+\\s*([+\\-*/]\\s*[+-]?\\s*\\d+\\s*)*$";

        String[] s = {
                "+2 - 57 * 33 + 25 / -4",     // Правильний
                "2 + 2",                      // Правильний
                "2 * - 3 / 4 + 5",            // Правильний
                "5 - * 6",                    // Неправильний
                "7 + - 2 * 4 / +3"            // Правильний
        };

        Pattern p = Pattern.compile(PATTERN);
        for (String expr : s) {
            Matcher m = p.matcher(expr);
            if (m.matches()) {
                System.out.println(expr + " правильний.");
            } else {
                System.out.println(expr + " неправильний.");
            }
        }
    }
}

