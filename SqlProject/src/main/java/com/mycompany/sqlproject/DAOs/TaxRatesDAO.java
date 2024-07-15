package com.mycompany.sqlproject.DAOs;

import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.exceptions.WrongArgumentTypeException;
import com.mycompany.sqlproject.exceptions.WrongNumberOfArgumentsException;
import com.mycompany.sqlproject.util.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaxRatesDAO implements ObjectDAO{
    public void selectAllAndInsertIntoTable(DatabaseTableModel dtm) throws Exception{
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("""
                                          select    initial_price as Начальная_цена,
                                                    final_price as Конечная_цена,
                                                    date_of_modification as Последнее_изменение,
                                                    interest_rate as Процентная_ставка
                                          from tax_rates
                                          """)){
            
            dtm.setDataSource(rs);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }catch(Exception ex){
            throw new Exception("Ошибка при выводе данных в таблицу!\n"+ex.getMessage());
        }
    }
    
    @Override
    public int insert(Object[] src)
            throws WrongNumberOfArgumentsException, Exception{
        if(src.length < 4)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            return statement.executeUpdate("insert into tax_rates "
                    + "(initial_price, final_price, date_of_modification, interest_rate) values"
                    + "(" + src[0] + ", "
                    + "" + src[1] + ", "
                    + "'" + ((java.sql.Date)src[2]).toString() + "', "
                    + "" + src[3] + ")");
            
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }

    @Override
    public int update(Object[] src, Object[] dst) throws WrongNumberOfArgumentsException, Exception {
        if(src.length < 4)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            String str = "update tax_rates set "
                    + "initial_price = " + dst[0] + ", "
                    + "final_price = " + dst[1] + ", "
                    + "date_of_modification = '" + ((java.sql.Date)dst[2]).toString() + "', "
                    + "interest_rate = " + dst[3] + " "
                    + "where "
                    + "initial_price = " + src[0] + " and "
                    + "final_price = " + src[1] + " and "
                    + "date_of_modification = '" + src[2] + "' and "
                    + "interest_rate = " + src[3] + " ";
            
            return statement.executeUpdate(str);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }

    @Override
    public int delete(Object[] src) throws WrongNumberOfArgumentsException, Exception {
        if(src.length < 4)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            String str = "delete from tax_rates where "
                    + "initial_price = " + src[0] + " and "
                    + "final_price = " + src[1] + " and "
                    + "date_of_modification = '" + src[2] + "' and "
                    + "interest_rate = " + src[3] + " ";
            
            return statement.executeUpdate(str);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }
    
    
    
}
