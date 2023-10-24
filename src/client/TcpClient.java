package client;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public void startClient() {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server. Type a message (or 'exit' to quit):");
            String userInput;
            while (true) {
                userInput = stdIn.readLine();
                out.println(userInput);

                String serverResponse = in.readLine();
                System.out.println("Server responds: " + serverResponse);

                if ("exit".equals(userInput.trim()) || "Goodbye!".equals(serverResponse.trim())) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}