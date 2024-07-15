package com.mycompany.sqlproject.DAOs;

import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.exceptions.WrongNumberOfArgumentsException;
import com.mycompany.sqlproject.util.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressesDAO implements ObjectDAO{

    @Override
    public void selectAllAndInsertIntoTable(DatabaseTableModel dtm) throws Exception {
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("""
                                          select    city    as  Город,
                                                    district    as Район,
                                                    home_number as Номер_дома,
                                                    street  as Улица,
                                                    registration_number as Регистрационный_номер_дома
                                          from address
                                          """)){
            
            dtm.setDataSource(rs);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }catch(Exception ex){
            throw new Exception("Ошибка при выводе данных в таблицу!\n"+ex.getMessage());
        }
    }

    @Override
    public int insert(Object[] src) throws WrongNumberOfArgumentsException, Exception {
        if(src.length != 5)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            return statement.executeUpdate("insert into address values"
                    + "(" + src[0] + ", "
                    + "" + src[1] + ", "
                    + "" + src[2] + ", "
                    + "" + src[3] + ", "
                    + "" + src[4] + ")");
            
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }
    }

    @Override
    public int update(Object[] src, Object[] dst) throws WrongNumberOfArgumentsException, Exception {
        if(src.length != 5 || dst.length != 5)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            String str = "update address set "
                    + "city = " + dst[0] + ", "
                    + "district = " + dst[1] + ", "
                    + "home_number = " + dst[2] + ", "
                    + "street = " + dst[3] + ", "
                    + "registration_number = " + dst[4] + " "
                    + "where "
                    + "city = " + src[0] + " and "
                    + "district = " + src[1] + " and "
                    + "home_number = " + src[2] + " and "
                    + "street = " + src[3] + " and "
                    + "registration_number = " + src[4] + "";
            
            return statement.executeUpdate(str);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }
    }

    @Override
    public int delete(Object[] src) throws WrongNumberOfArgumentsException, Exception {
        if(src.length != 5)
            throw new WrongNumberOfArgumentsException("Неверное число аргументов");
        
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()){
            
            String str = "delete from address where "
                    + "city = " + src[0] + " and "
                    + "district = " + src[1] + " and "
                    + "home_number = " + src[2] + " and "
                    + "street = " + src[3] + " and "
                    + "registration_number = " + src[4] + "";
            
            return statement.executeUpdate(str);
        }catch(SQLException ex){
            throw new Exception("Ошибка при обращении к базе данных!\n"+ex.getMessage());
        } 
    }
    
    
    
    
    
}
