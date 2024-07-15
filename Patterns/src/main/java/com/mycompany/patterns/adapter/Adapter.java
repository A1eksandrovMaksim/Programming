package com.mycompany.patterns.adapter;

import java.io.IOException;
import java.io.OutputStream;



public class Adapter {
    
    private final OutputStream out;
    
    public Adapter(OutputStream out){
        this.out = out;
    }
    
    public void write(String[] strings){
        
        try{
            for(var string : strings){
                
                out.write(string.getBytes());
                
            }
        }catch(IOException ex){
            System.out.println("Adapter: Ошибка при записи!");
        }
    }
    
}
