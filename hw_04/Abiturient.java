package hw_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Abiturient {
    private String fullName;
    private String address;
    private String phone;
    private int[] grades;

    public Abiturient(String fullName, String address, String phone, int[] grades) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int[] getGrades() {
        return grades;
    }

    public int getTotalScore() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Абітурієнт{" +
               "Повний ПІ='" + fullName + '\'' +
               ", Адрес='" + address + '\'' +
               ", Телефон='" + phone + '\'' +
               ", Загальний бал=" + getTotalScore() +
               '}';
    }

    public static List<Abiturient> findAbiturientsWithLowScore(Abiturient[] abiturients, int scoreLimit) {
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getTotalScore() < scoreLimit) {
                result.add(abiturient);
            }
        }
        return result;
    }

    public static List<Abiturient> findTopNAbiturients(Abiturient[] abiturients, int n) {
        return Arrays.stream(abiturients)
                     .sorted(Comparator.comparingInt(Abiturient::getTotalScore).reversed())
                     .limit(n)
                     .toList();
    }
}
