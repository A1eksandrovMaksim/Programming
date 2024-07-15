package com.mycompany.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        double num1 = 3.5;
        double num2 = 2.0;

        double result = multiply(num1, num2);
        System.out.println("Result of multiplication: " + result);
    }

    public static double multiply(double num1, double num2) {
        try {
            double result;
            try (Socket socket = new Socket("localhost", 5000)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(num1);
                out.println(num2);
                result = Double.parseDouble(in.readLine());
            }
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
