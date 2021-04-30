package ru.netology.pyas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 8081;

    public static void main(String[] args) {
        System.out.println("Server starting...");
        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            InputStreamReader socketReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(socketReader)
        ) {
            String message = reader.readLine();
            System.out.printf("Got message \"%s\" from port %d%n", message, socket.getPort());
        } catch (IOException e) {
            System.err.printf("Error reading message: %s%n", e.getMessage());
        }

    }
}
