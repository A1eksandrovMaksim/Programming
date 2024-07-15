package com.mycompany.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket);
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    
                    double num1 = Double.parseDouble(in.readLine());
                    double num2 = Double.parseDouble(in.readLine());
                    double result = num1 * num2;
                    
                    out.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}