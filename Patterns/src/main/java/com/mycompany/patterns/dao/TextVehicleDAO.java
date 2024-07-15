package com.mycompany.patterns.dao;

import com.mycompany.patterns.Vehicle;
import com.mycompany.patterns.VehicleStaticMethodsContainer;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;



public class TextVehicleDAO implements VehicleDAO{

    @Override
    public void write(Vehicle vehicle, String filePath) {
        try(FileWriter fw = new FileWriter(filePath)){
            fw.write(vehicle.getMark()+"\n");
            fw.write(vehicle.getPrices().length + "\n");
            for(String title : vehicle.getModels()){
                fw.write(title + "\n");
                fw.write(Double.toString(vehicle.getModelPrice(title)) + "\n");
            }
        }catch(Exception ex){
            System.out.println("Ошибка при записи транспорта в файл.");
        }
    }

    @Override
    public Vehicle read(String filePath) {
        try(Scanner s = new Scanner(new FileReader(filePath))){
            Vehicle v = VehicleStaticMethodsContainer.createInstance(s.nextLine(), 0);
            int q = Integer.valueOf(s.nextLine());
            for(;q>0;q--){
                var s1 = s.nextLine();
                var s2 = s.nextLine();
                v.addModel(s1, Double.valueOf(s2));
            }
            return v;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
}
