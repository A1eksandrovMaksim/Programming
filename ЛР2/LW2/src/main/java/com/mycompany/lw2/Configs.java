package com.mycompany.lw2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configs {
    
    private static Properties instance;
    
    private Configs(){}
    
    public synchronized static Properties getInstance(){
        
        if (instance == null){
            
            
            try(InputStream input = Configs.class.getClassLoader().getResourceAsStream("config.properties")){
                
                instance = new Properties();
                
                if (input == null) {
                    System.out.println("Sorry, unable to find config.properties");
                    return null;
                }
                
                System.out.println("Loading configs ...");
                
                instance.load(input);
                
                return instance;
            }
            catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
            
        }
        
        System.out.println("The configs have been uploaded");
        return instance;
    }
}
