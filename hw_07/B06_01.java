package hw_07;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_01 {

    public static void main(String[] args) {
        String DATE_1 = "\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b";
        String DATE_2 = "\\b__\\.__\\.____\\b";
        String PATTERN = DATE_1 + "|" + DATE_2;

        String s = "14.09.2023, __.__.____";
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(s);
        String result = m.replaceAll(currentDate.format(formatter));
        System.out.println(result);
    }
}