package com.mycompany.sqlproject.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    
    static {
        loadDriver();
    }
    
    private ConnectionManager(){}
    
    public static Connection open(){
        try {
            return DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USERNAME_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static Connection open(String username, String password)
            throws Exception
    {
        
        try {
            return DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                username,
                password);
        } catch (Exception ex) {
            throw new Exception("Ошибка при подключении к базе данных!\n"+ex.getMessage());
        }
    }
    
    public static void setUsername(String username){
        PropertiesUtil.set(USERNAME_KEY, username);
    }
    
    public static void setPassword(String password){
        PropertiesUtil.set(USERNAME_KEY, password);
    }
    
    private static void loadDriver(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
