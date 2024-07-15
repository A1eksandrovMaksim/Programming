package com.mycompany.patterns;

import com.mycompany.patterns.Vehicle;
import com.mycompany.patterns.factorymethod.CarFactory;
import com.mycompany.patterns.factorymethod.VehicleFactory;



public class VehicleStaticMethodsContainer {
    
    private static VehicleFactory factory = new CarFactory();
    
    public static void setVehicleFactory(VehicleFactory factory){
        VehicleStaticMethodsContainer.factory = factory;
    }
    
    public static Vehicle createInstance(String mark, int quantityModels){
        return VehicleStaticMethodsContainer.factory.createInstance(mark, quantityModels);
    }
    
    public static double avr(Vehicle vehicle){
        
        double sumPrices = 0;
        for(double price : vehicle.getPrices())
            sumPrices += price;
        
        return sumPrices / vehicle.countModels();
    }
    
    public static void printConsoleModels(Vehicle vehicle){
        
        for(String name : vehicle.getModels())
            System.out.println(name);
    }
    
    public static void printConsolePrices(Vehicle vehicle){
        
        for(double price : vehicle.getPrices())
            System.out.println(price);
    }
    
    
    
}
