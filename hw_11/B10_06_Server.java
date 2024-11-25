package hw_11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class B10_06_Server {
    public static void main(String[] args) throws IOException {
        int port = 10010;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server runs on " + server.getLocalSocketAddress());

            while (true) {
                Socket conn = server.accept();
                System.out.println("Connected from " + conn.getRemoteSocketAddress());

                var reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
                var writer = new PrintStream(conn.getOutputStream(), true, "UTF8");

                try {
                    int divisor = Integer.parseInt(reader.readLine());
                    System.out.println("Received divisor: " + divisor);

                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Received line: " + line);

                        String[] numbers = line.split("\\s+");
                        int count = 0;

                        for (String num : numbers) {
                            try {
                                if (Integer.parseInt(num) % divisor == 0) {
                                    count++;
                                }
                            } catch (NumberFormatException e) {}
                        }

                        writer.println(count);
                        System.out.println("Sent count: " + count);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input received, closing connection.");
                } finally {
                    conn.close();
                    System.out.println("Disconnected from " + conn.getRemoteSocketAddress());
                }
            }
        }
    }
}
