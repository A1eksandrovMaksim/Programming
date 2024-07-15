package com.mycompany.patterns.singleton;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class Confs {
    
    private static Properties instance;
    
    private Confs(){
    }
    
    public static Properties getInstance(){
        if(instance != null)
            return instance;
        
        instance = new Properties();
        
        try(InputStream is = Confs.class.getClassLoader().getResourceAsStream("config.properties")){
            
            instance.load(is);
            
        }catch(IOException ex){
            System.out.println("Ошибка");
        }
        
        return instance;
    }
    
}
