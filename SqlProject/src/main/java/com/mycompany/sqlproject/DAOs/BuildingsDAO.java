package com.mycompany.sqlproject.DAOs;

import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.exceptions.WrongNumberOfArgumentsException;
import com.mycompany.sqlproject.util.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildingsDAO implements ObjectDAO{

    @Override
    public void selectAllAndInsertIntoTable(DatabaseTableModel dtm) throws Exception {
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("""
                                          select    registration_number    as  Регистрационный_номер,
                                                    place    as Площадь,
                                                    number_of_floors as Количество_этажей,
                                                    date_of_construction  as Дата_постройки
                                          from building
                                          """))
        {
            dtm.setDataSource(rs);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }catch(Exception ex){
            throw new Exception("Ошибка при выводе данных в таблицу!\n"+ex.getMessage());
        }
    }

    @Override
    public int insert(Object[] src) throws WrongNumberOfArgumentsException, Exception {
        if(src.length < 4)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            return statement.executeUpdate("insert into building values"
                    + "(" + src[0] + ", "
                    + "" + src[1] + ", "
                    + "" + src[2] + ", "
                    + "'" + ((java.sql.Date)src[3]).toString() + "')");
            
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
            
            String str = "update building set "
                    + "registration_number = " + dst[0] + ", "
                    + "place = " + dst[1] + ", "
                    + "number_of_floors = " + dst[2] + ", "
                    + "date_of_construction = '" + ((java.sql.Date)dst[3]).toString() + "' "
                    + "where "
                    + "registration_number = " + src[0] + " and "
                    + "place = " + src[1] + " and "
                    + "number_of_floors = " + src[2] + " and "
                    + "date_of_construction = '" + src[3] + "'";
            
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
            
            String str = "delete from building where "
                    + "registration_number = " + src[0] + " and "
                    + "place = " + src[1] + " and "
                    + "number_of_floors = " + src[2] + " and "
                    + "date_of_construction = '" + src[3] + "' ";
            
            return statement.executeUpdate(str);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }
    
    public String[] getRegistrationNumbers() throws Exception{
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            ResultSet rs = statement.executeQuery("select registration_number from building");
            ArrayList<String> registrationNumbersArrayList = new ArrayList<String>();
            while(rs.next())
                registrationNumbersArrayList.add(rs.getBigDecimal(0).toString());
            String[] registrationNumbersStrings = new String[registrationNumbersArrayList.size()];
            registrationNumbersArrayList.toArray(registrationNumbersStrings);
            return registrationNumbersStrings;
            
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }
    
}
