package com.mycompany.lw2;

import com.mycompany.lw2.Errors.NoSuchModelNameException;


public class VehiclePresenter {
    
    private static VehicleFactory factory = new CarFactory();
    
    public static void setVehicleFactory(VehicleFactory vf){
        factory = vf;
    }
    
    public static Vehicle createInstance(String brand, int amount){
        return factory.createInstance(brand, amount);
    }
    
    public static double getAveragePrice(Vehicle vehicle){
        
        double avr = 0;
        int count = 0;
        
        for(double price : vehicle.getModelPrices()){
            count++;
            avr += price;
        }
        
        return avr/count;
    }

    public static void printVehicleModels(Vehicle vehicle){
        
        for(String model : vehicle.getModelTitles()){
            
            System.out.println(vehicle.getBrand()
                    + " - "+ model);
            
        }
    }
    
    public static void printVehiclePrices(Vehicle vehicle){
        
        for(double price : vehicle.getModelPrices()){
            System.out.println(Double.toString(price));
        }
        
    }
    
    public static void printVehicle(Vehicle vehicle){
        
        for(String title : vehicle.getModelTitles()){
            
            try{
            System.out.println(vehicle.getBrand()
                    + "-" + title + " : "
                    + vehicle.getModelPrice(title));
            }
            catch(NoSuchModelNameException ex){
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    public static Vehicle sinchronizedVehicle(Vehicle vehicle){
        return new SynchronizedVehicle(vehicle);
    }
}
