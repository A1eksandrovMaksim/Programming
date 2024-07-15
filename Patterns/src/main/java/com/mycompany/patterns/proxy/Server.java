package com.mycompany.patterns.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    
    private static ServerSocket server;
    
    public static void main(String[] args) throws IOException{
        
        server = new ServerSocket(5000);
        while(true)
            logic();
    }
    
        
    private static void logic(){
        try(Socket socket = server.accept()){

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            double a = ois.readDouble();
            double b = ois.readDouble();

            oos.writeDouble(a*b);
            oos.flush();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
