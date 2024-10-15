package hw_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {

    public static void main(String[] args) {
        String PATTERN1 = "\\+\\d{1,4}[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}";
        String PATTERN2 = "\\(\\d{1,4}\\)[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}";
        String PATTERN3 = "\\d{1,4}[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}[-\\s]?\\d{1,4}";
        String PATTERN = PATTERN1 + "|" + PATTERN2 + "|" + PATTERN3;
        
        String s = "Контакти: +380-67-793-24-16, (067)793-2416, 067 793 2415, (123) 456-7890, 1234567890";

        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}