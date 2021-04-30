package ru.netology.pyas;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final int PORT = 8081;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        final boolean AUTOFLUSH = true;

        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), AUTOFLUSH)
        ) {
            writer.println("Hello, server!");
        } catch (IOException e) {
            System.err.printf("Error connecting to %s:%d: %s%n", HOST, PORT, e.getMessage());
        }

    }
}

