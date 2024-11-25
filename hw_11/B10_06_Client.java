package hw_11;

import java.io.*;
import java.net.Socket;

public class B10_06_Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 10010;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF8"));
            var writer = new PrintStream(socket.getOutputStream(), true, "UTF8");

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a divisor (natural number): ");
            String divisor = consoleInput.readLine();
            writer.println(divisor);

            String line;
            while (true) {
                System.out.print("Enter a line of numbers (or 'exit' to quit): ");
                line = consoleInput.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(line);
                System.out.println("Sent: " + line);

                String response = reader.readLine();
                System.out.println("Received count of divisible numbers: " + response);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
