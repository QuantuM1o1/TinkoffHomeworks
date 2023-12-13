package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final Socket client;

    public Client(int port) {
        try {
            client = new Socket(InetAddress.getByName("localhost"), port);
        } catch (IOException e) {
            throw new RuntimeException("Client couldn't connect to server");
        }
    }

    public String sendMessage(String message) {
        String input;
        try {
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println(message);
            input = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
            client.close();
        } catch (IOException e) {
            throw new RuntimeException("Client couldn't read from server");
        }
        return input;
    }
}
