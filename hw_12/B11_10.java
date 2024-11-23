package hw_12;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B11_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть назву міста (англійською): ");
        String city = in.nextLine().trim().toLowerCase();
        
        String url = "https://www.timeanddate.com/weather/ukraine/" + city;
        String html = getHtml(url);

        if (html.isEmpty()) {
            System.out.println("Не вдалося отримати дані. Будь ласка, перевірте назву міста або підключення.");
            return;
        }
        
        displayWeather(html);
        in.close();
    }

    public static void displayWeather(String html) {
        Pattern tempPattern = Pattern.compile("<tr class=\"wt-hour.*?\">.*?<td class=\"small\">.*?</td>.*?<td>(.*?)</td>.*?<td>(.*?)%</td>", Pattern.DOTALL);
        Matcher matcher = tempPattern.matcher(html);

        System.out.println("Прогноз погоди на наступні 48 годин:");
        int count = 0;

        while (matcher.find() && count < 14) {
            String temperature = matcher.group(1).trim();
            String humidity = matcher.group(2).trim();
            System.out.printf("Година %d: Температура: %s, Вологість: %s%%\n", count + 1, temperature, humidity);
            count++;
        }

        if (count == 0) {
            System.out.println("Немає даних про погоду. Будь ласка, перевірте назву міста.");
        }
    }

    public static String getHtml(String url) {
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("HTTP Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
