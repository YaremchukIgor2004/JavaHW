package hw_06;

import java.util.Stack;

public class B05_01 {
    public static boolean valid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static String remove(String str) {
        if (!valid(str)) {
            throw new IllegalArgumentException("Дужки розставлені неправильно.");
        }

        StringBuilder result = new StringBuilder();
        boolean insideBrackets = false;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                insideBrackets = true;
            } else if (ch == ')') {
                insideBrackets = false;
            } else if (!insideBrackets) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Це тестовий рядок (видалити цей текст) з дужками.";
        try {
            String result = remove(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
