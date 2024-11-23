package hw_12;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B11_01 {

    private static final String URL = "https://www.timeanddate.com/worldclock/ukraine/kyiv";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            Pattern pattern = Pattern.compile("<span id=ct class=h1>(\\d{2}:\\d{2}:\\d{2})</span>");
            Matcher matcher = pattern.matcher(responseBody);
            
            if (matcher.find()) {
                String webTime = matcher.group(1);
                LocalTime exactTime = LocalTime.parse(webTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
                LocalTime localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

              
                System.out.println("Час: " + exactTime);

                if (exactTime.equals(localTime)) {
                    System.out.println("Час на локальному комп'ютері відповідає часу з сайту.");
                } else {
                    System.out.println("Час на локальному комп'ютері НЕ відповідає часу з сайту.");
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error connecting to website: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}