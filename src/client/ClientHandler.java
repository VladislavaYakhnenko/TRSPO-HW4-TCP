package client;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                if ("exit".equals(inputLine.trim())) {
                    out.println("Goodbye!");
                    break;
                }

                out.println("Echo: " + inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}