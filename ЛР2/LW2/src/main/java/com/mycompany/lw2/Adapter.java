package com.mycompany.lw2;

import java.io.IOException;
import java.io.OutputStream;

public class Adapter {
    private OutputStream outputStream = null;
    
    public Adapter(OutputStream os){
        outputStream = os;
    }
    
    public void adapt(String[] strings){
        try{
            
            for(String string : strings){
                outputStream.write(string.getBytes());
            }
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
