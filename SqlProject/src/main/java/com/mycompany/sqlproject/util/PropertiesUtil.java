package com.mycompany.sqlproject.util;

import java.util.Properties;


public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();
    
    static {
        loadProperties();
    }
    
    private PropertiesUtil(){}
    
    private static void loadProperties() {
        try(var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")){
            PROPERTIES.load(inputStream);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
    
    public static void set(String key, String value){
        PROPERTIES.setProperty(key, value);
    }
}
