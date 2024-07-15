package com.mycompany.patterns.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Proxy {
    
    public static double mul(double a, double b){
        
        double result = 0;
        
        try(Socket socket = new Socket("localhost", 5000)){
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
            oos.writeDouble(a);
            oos.writeDouble(b);
            oos.flush();
            
            result = ois.readDouble();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
