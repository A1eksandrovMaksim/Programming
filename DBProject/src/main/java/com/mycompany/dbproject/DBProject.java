package com.mycompany.dbproject;

import com.mycompany.dbproject.util.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBProject {

    public static void main(String[] args) {
        
        
        
        String sql = """
                    create database game;
                     
                     """;
        
        try(Connection connection = ConnectionManager.open();
                var statement = connection.createStatement()){
            var executeResult = statement.execute(sql);
            System.out.println(executeResult);
        }catch(Exception ex){
            System.out.println("Ошибка SQL: " + ex.getMessage());
        }
    }
}
