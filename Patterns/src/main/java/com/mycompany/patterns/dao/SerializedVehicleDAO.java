package com.mycompany.patterns.dao;

import com.mycompany.patterns.Vehicle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SerializedVehicleDAO implements VehicleDAO{

    @Override
    public void write(Vehicle vehicle, String filePath) {
    
        try(ObjectOutputStream oos 
                = new ObjectOutputStream(
                        new FileOutputStream(filePath))){
            
            oos.writeObject(vehicle);
            
        }catch(IOException ex){
            System.out.println("Ошибка при сериализации мотоцикла в файл.");
        } 
        
    }

    @Override
    public Vehicle read(String filePath) {
        
        try(ObjectInputStream ois 
                = new ObjectInputStream(
                        new FileInputStream(filePath))){
            
            return (Vehicle)ois.readObject();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
    
}
